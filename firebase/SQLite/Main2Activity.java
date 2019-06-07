package com.example.hashmapdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button btn2;
    TextView et2;
    SQLiteDatabase sq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sq=openOrCreateDatabase("student_database", Context.MODE_PRIVATE,null);
        sq.execSQL("CREATE TABLE IF NOT EXISTS student_details_new(ID INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(300),place VARCHAR(300))");
        btn2=findViewById(R.id.btn2);
        et2=findViewById(R.id.et2);
        final String name1= getIntent().getStringExtra("name");
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String place=et2.getText().toString();
                //String name= getIntent().getStringExtra("name");
                if(!TextUtils.isEmpty(place))
                {
                    sq.execSQL("Insert into student_details_new(name,place)VALUES('"+ name1 +"','"+ place +"');");
                    et2.setText("");

                }
                else
                {
                    Toast.makeText(Main2Activity.this,"Please enter place",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}