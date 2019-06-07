package com.example.normaldatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    TextView et1;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reff= FirebaseDatabase.getInstance().getReference("Identity");
        btn1=findViewById(R.id.btn1);
        et1=findViewById(R.id.et1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
                //Intent i=new Intent(MainActivity.this,SubActivity.class);
                //startActivity(i);
            }
        });
    }
    public void addData()
    {
        String name=et1.getText().toString();
        if(!TextUtils.isEmpty(name))
        {
            String id=reff.push().getKey();
            Students students=new Students(id,name);
            reff.child(id).setValue(students);
            et1.setText("");
            Intent i=new Intent(MainActivity.this,SubActivity.class);
            i.putExtra("id",id);
            startActivity(i);

        }
        else
        {
            Toast.makeText(MainActivity.this,"enter name,don't leave it empty",Toast.LENGTH_SHORT).show();
        }
    }
}
