package com.example.midterm;

public class Activity3 extends AppCompatActivity {
    Button print, delete;
    EditText p;
    DatabaseHelper Mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        print = (Button)findViewById(R.id.print);
        delete = (Button)findViewById(R.id.delete);
        p = (EditText)findViewById(R.id.editText);
        Mydb = new DatabaseHelper(this);
        printbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = Mydb.ViewUsers();
                StringBuffer buffer = new StringBuffer();
                Toast.makeText(Activity3.this, "Successful View", Toast.LENGTH_LONG).show();
                while (cursor.moveToNext()) {

                    buffer.append("id: " + cursor.getString(0) + "\n");
                    buffer.append("name: " + cursor.getString(1) + "\n");
                    buffer.append("salary: " + cursor.getString(2) + "\n\n");
                }


                AlertDialog.Builder builder = new AlertDialog.Builder(Activity3.this);
                builder.setCancelable(true);
                builder.setTitle("All Employees");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });


        Button gotoactivity1=(Button)findViewById(R.id.goto1);

        gotoactivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity3.this,MainActivity.class));
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mydb.DeleteUsers(p.getText().toString());
                Toast.makeText(Activity3.this,"Successfully deleted entry",Toast.LENGTH_SHORT).show();
            }
        });

    }
}