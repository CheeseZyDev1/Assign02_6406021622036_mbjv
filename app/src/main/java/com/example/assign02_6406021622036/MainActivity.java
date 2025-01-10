package com.example.assign02_6406021622036;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find buttons by ID
        Button btnAppGrade = findViewById(R.id.btnAppGrade);
        Button btnAppVat = findViewById(R.id.btnAppVat);
        Button btnAppBMI = findViewById(R.id.btnAppBMI);
        Button btnExitApp = findViewById(R.id.btnExitApp);

        // Set click listeners for each button
        btnAppGrade.setOnClickListener(v -> {
            // Navigate to Grade Activity
            Intent intent = new Intent(MainActivity.this, GradeActivity.class);
            startActivity(intent);
        });

        btnAppVat.setOnClickListener(v -> {
            // Navigate to VAT Activity
            Intent intent = new Intent(MainActivity.this, VatActivity.class);
            startActivity(intent);
        });

        btnAppBMI.setOnClickListener(v -> {
            // Navigate to BMI Activity
            Intent intent = new Intent(MainActivity.this, BMIActivity.class);
            startActivity(intent);
        });

        btnExitApp.setOnClickListener(v -> {
            // Exit the application
            finish();
        });
    }
}
