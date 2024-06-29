package com.example.blogapp;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    AppCompatButton bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        SharedPreferences preference=getSharedPreferences("BLOG_APP",MODE_PRIVATE);
        String username=preference.getString("user",null);
        if(username !=null)
        {
            Intent i=new Intent(getApplicationContext(), blogpage.class);
            startActivity(i);
        }
        ed1=(EditText) findViewById(R.id.name);
        ed2=(EditText) findViewById(R.id.pass);
        bt1=(AppCompatButton) findViewById(R.id.login);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String getName = ed1.getText().toString();
                    String getPass = ed2.getText().toString();
                    if (getName.equals("admin") && getPass.equals("123456"))
                    {
                        SharedPreferences preference=getSharedPreferences("BLOG_APP",MODE_PRIVATE);
                        SharedPreferences.Editor editor= preference.edit();
                        editor.putString("user","admin");
                        editor.apply();
                        Intent i = new Intent(getApplicationContext(), blogpage.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "invalid entry", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "invalid", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}