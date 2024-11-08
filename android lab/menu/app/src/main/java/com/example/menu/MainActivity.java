package com.example.menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.MenuCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

   public boolean onCreateOptionsMenu(Menu menu)
   {
       MenuInflater inflater = getMenuInflater();
       ((MenuInflater) inflater).inflate(R.menu.options, menu);
       MenuCompat.setGroupDividerEnabled(menu, true);
       return true;

   }
}