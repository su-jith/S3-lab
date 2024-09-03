package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button login;
    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pwd);
        login = (Button) findViewById(R.id.loginbutton);
        login.setOnClickListener(this);

    }
    public void onClick(View view)
    {
        if(view.getId()==R.id.loginbutton)
        {
            String a = username.getText().toString();
            String b = password.getText().toString();
            if (a.equals("74518") && b.equals("sujith818"))
                Toast.makeText(this, "Login successful", Toast.LENGTH_LONG).show();

            else
                Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
        }
    }
}