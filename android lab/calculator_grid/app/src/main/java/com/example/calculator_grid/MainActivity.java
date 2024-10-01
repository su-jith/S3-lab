package com.example.calculator_grid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator_grid.R;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String currentInput = "";
    private double result = 0;
    private String currentOperator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        // Assign click listeners to the buttons
        int[] buttonIds = {
                R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4,
                R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9,
                R.id.btn_add, R.id.btn_subtract, R.id.btn_multiply, R.id.btn_divide,
                R.id.btn_clear, R.id.btn_equals
        };

        for (int id : buttonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(this::onButtonClick);
        }
    }

    private void onButtonClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        switch (buttonText) {
            case "C":
                clear();
                break;
            case "=":
                calculateResult();
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                applyOperator(buttonText);
                break;
            default:
                appendNumber(buttonText);
                break;
        }
    }

    private void appendNumber(String number) {
        currentInput += number;
        display.setText(currentInput);
    }

    private void applyOperator(String operator) {
        if (!currentInput.isEmpty()) {
            calculateResult();
        }
        currentOperator = operator;
        result = Double.parseDouble(currentInput);
        currentInput = "";
    }

    private void calculateResult() {
        if (currentOperator.isEmpty() || currentInput.isEmpty()) return;

        double currentNumber = Double.parseDouble(currentInput);

        switch (currentOperator) {
            case "+":
                result += currentNumber;
                break;
            case "-":
                result -= currentNumber;
                break;
            case "*":
                result *= currentNumber;
                break;
            case "/":
                result /= currentNumber;
                break;
        }

        display.setText(String.valueOf(result));
        currentInput = String.valueOf(result);
        currentOperator = "";
    }

    private void clear() {
        currentInput = "";
        result = 0;
        currentOperator = "";
        display.setText("0");
    }
}