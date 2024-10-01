
package com.example.calculator;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNumber1, etNumber2;
    private RadioGroup radioGroup;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber1 = findViewById(R.id.number1);
        etNumber2 = findViewById(R.id.number2);
        radioGroup = findViewById(R.id.radioGroup);
        tvResult = findViewById(R.id.tvResult);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                calculateResult(checkedId);
            }
        });
    }

    private void calculateResult(int checkedId) {
        String num1Str = etNumber1.getText().toString();
        String num2Str = etNumber2.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0.0;

        switch (checkedId) {
            case R.id.rbAdd:
                result = num1 + num2;
                break;
            case R.id.rbSubtract:
                result = num1 - num2;
                break;
            case R.id.rbMultiply:
                result = num1 * num2;
                break;
            case R.id.rbDivide:
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
            default:
                return;
        }

        tvResult.setText(String.format("Result: %.2f", result));
    }
}
