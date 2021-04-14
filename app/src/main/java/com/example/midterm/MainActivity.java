package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper Mydb;
    EditText edit1, edit2, edit3;
    Button buttoninsert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = (EditText)findViewById(R.id.id);
        edit2 = (EditText)findViewById(R.id.Name);
        edit3 = (EditText)findViewById(R.id.Email);


        Mydb = new DatabaseHelper(this);


        buttoninsert = (Button)findViewById(R.id.buttonInsert);


        buttoninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mydb.AddEmployee(edit1.getText().toString(),
                        edit2.getText().toString(),
                        Integer.parseInt(edit3.getText().toString()));
                Toast.makeText(MainActivity.this, "Successful Add", Toast.LENGTH_LONG).show();
                edit1.getText().clear();
                edit2.getText().clear();
                edit3.getText().clear(); }

        });

        Button gotoactivity2=findViewById(R.id.goto2);
        Button go3=findViewById(R.id.goto3);

        gotoactivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Activity2.class));
            }
        });
        gotoactivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Activity3.class));
            }
        });

    }
}