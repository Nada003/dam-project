package com.example.guidetouristique2;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up discover button
        Button discoverButton = findViewById(R.id.btn_discover);
        discoverButton.setOnClickListener(v -> {
            // Navigate to Features Activity
            Intent intent = new Intent(MainActivity.this, FeaturesActivity.class);
            startActivity(intent);
        });
    }
}
