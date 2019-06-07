package com.example.hashmapdatabase;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    EditText et1;
    SQLiteDatabase sq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //sq=openOrCreateDatabase("student_database", Context.MODE_PRIVATE,null);
        //sq.execSQL("CREATE TABLE IF NOT EXISTS student_details(ID INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(300),place VARCHAR(300))");
        btn1=findViewById(R.id.btn1);
        et1=findViewById(R.id.et1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et1.getText().toString();
                if(!TextUtils.isEmpty(name))
                {
                    //sq.execSQL("Insert into student_details(name)VALUES('"+ name +"');");
                    //et1.setText("");
                    Intent i=new Intent(MainActivity.this,Main2Activity.class);
                    i.putExtra("name",name);
                    startActivity(i);
                    et1.setText("");
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Please enter name",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
