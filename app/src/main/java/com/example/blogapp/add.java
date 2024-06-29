package com.example.blogapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class add extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    AppCompatButton bt1,bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);
        ed1=(EditText) findViewById(R.id.name);
        ed2=(EditText) findViewById(R.id.des);
        ed3=(EditText) findViewById(R.id.written);
        bt1=(AppCompatButton) findViewById(R.id.submit);
        bt2=(AppCompatButton) findViewById(R.id.goback);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getName=ed1.getText().toString();
                String getDescription=ed2.getText().toString();
                String getWritten =ed3.getText().toString();
                Toast.makeText(getApplicationContext(), getName,Toast.LENGTH_LONG).show();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }
}