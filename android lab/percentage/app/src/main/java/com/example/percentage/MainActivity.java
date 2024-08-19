package com.example.percentage;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener {
    EditText edit1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1=(EditText)findViewById(R.id.edit1);
        edit1.addTextChangedListener(this);



    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable edit) {
        float num=0;
        String s = edit1.toString();
        if(s!=null && !s.isEmpty())
        {
            num = Float.parseFloat(edit.toString());
        }
        if(num > 100)
        {
            edit.replace(0,edit.length(),"100");
        }

    }

    @Override
    public void onClick(View view) {


    }
}