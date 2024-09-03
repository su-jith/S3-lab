package com.example.fame;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.example.fame.R;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1;
    private ImageView imageView2;
    public TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        t1 = findViewById(R.id.t1);

        Typeface customFont = Typeface.createFromAsset(getAssets(), "fonts/Peristiwa.otf");
        t1.setTypeface(customFont);

        // Set onClickListener for the first ImageView
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView1.setVisibility(View.GONE);  // Hide the first image
                imageView2.setVisibility(View.VISIBLE);  // Show the second image
            }
        });

        // Set onClickListener for the second ImageView
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView2.setVisibility(View.GONE);  // Hide the second image
                imageView1.setVisibility(View.VISIBLE);  // Show the first image
            }
        });
    }
}
