package com.example.blogapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class blogpage extends AppCompatActivity {
    AppCompatButton bt1,bt2,bt3,bt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_blogpage);
        bt1=(AppCompatButton) findViewById(R.id.add);
        bt2=(AppCompatButton) findViewById(R.id.search);
        bt3=(AppCompatButton) findViewById(R.id.delete);
        bt4=(AppCompatButton) findViewById(R.id.goback);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), add.class);
                startActivity(i);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(getApplicationContext(), search.class);
                startActivity(j);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(getApplicationContext(), delete.class);
                startActivity(k);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preference=getSharedPreferences("BLOG_APP",MODE_PRIVATE);
                String username=preference.getString("user",null);
                SharedPreferences.Editor editor= preference.edit();
                editor.clear();
                editor.apply();
                Intent l =new Intent(getApplicationContext(), MainActivity.class);
                startActivity(l);
            }
        });
    }
}