package com.example.normaldatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SubActivity extends AppCompatActivity {
    EditText et2;
    Button btn2;
    DatabaseReference reff1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        et2=findViewById(R.id.et2);
        btn2=findViewById(R.id.btn2);
        String id=getIntent().getStringExtra("id");
        reff1 = FirebaseDatabase.getInstance().getReference("Identity").child(id);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }
    public void save()
    {
        String place=et2.getText().toString();
        if(!TextUtils.isEmpty(place))
        {
            reff1.child("place").setValue(place);
            et2.setText("");
        }
        else
        {
            Toast.makeText(SubActivity.this,"Please enter place",Toast.LENGTH_SHORT).show();
        }
    }
}
