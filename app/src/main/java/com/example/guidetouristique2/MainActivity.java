package com.example.guidetouristique2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";  // Log tag for debugging

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(Language.setLocale(newBase, Language.getLanguage(newBase)));
        Log.d(TAG, "attachBaseContext: Locale applied: " + Language.getLanguage(newBase));  // Log the language applied
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Logging for debugging
        Log.d(TAG, "onCreate: Locale before any action: " + Language.getLanguage(this));

        // Button to navigate to the features page
        Button discoverButton = findViewById(R.id.btn_discover);
        discoverButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FeaturesActivity.class);
            startActivity(intent);
        });

        // Language change buttons
        Button btnFr = findViewById(R.id.btn_fr);
        Button btnEn = findViewById(R.id.btn_en);

        // Set the listeners for language buttons
        btnFr.setOnClickListener(v -> changeLanguage("fr"));
        btnEn.setOnClickListener(v -> changeLanguage("en"));
    }

    // Method to change the language
    private void changeLanguage(String langCode) {
        // Log language change attempt
        Log.d(TAG, "changeLanguage: Attempting to change language to: " + langCode);

        // Apply the new language and restart the activity
        Language.setLocale(this, langCode);

        // Restart the activity using an Intent
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
        finish(); // Close the current activity
    }
}
