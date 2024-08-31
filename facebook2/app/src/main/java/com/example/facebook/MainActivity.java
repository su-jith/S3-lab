package com.example.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateLogin();
            }
        });
    }

    private void validateLogin() {
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Simple validation
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "Enter a valid username", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Enter a valid password", Toast.LENGTH_SHORT).show();
            return;
        }

        // Dummy credentials for demonstration
        if (username.equals("user") && password.equals("password")) {
            // Successful login
            showCustomToast("Login successful", R.drawable.login_success);
            // Navigate to another activity
            Intent intent = new Intent(MainActivity.this, MainActivity.class); // Replace with your desired activity
            startActivity(intent);
            finish();
        } else {
            // Failed login
            showCustomToast("Invalid username or password", R.drawable.login_failed);
        }
    }

    private void showCustomToast(String message, int iconResId) {
        // Inflate custom layout
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,
                (ViewGroup) findViewById(R.id.toast));

        // Set the icon and message
        ImageView icon1 = layout.findViewById(R.id.login_success_icon);
        icon1.setImageResource(iconResId);
        ImageView icon2 = layout.findViewById(R.id.login_failed_icon);
        icon2.setImageResource(iconResId);
        TextView text = layout.findViewById(R.id.toast_text);
        text.setText(message);

        // Create and show the Toast
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}
