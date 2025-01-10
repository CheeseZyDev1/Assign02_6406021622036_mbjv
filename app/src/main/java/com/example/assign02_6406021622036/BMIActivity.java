package com.example.assign02_6406021622036;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BMIActivity extends AppCompatActivity {

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        // เชื่อมโยง UI กับ Java
        EditText etWeight = findViewById(R.id.etWeight);
        EditText etHeight = findViewById(R.id.etHeight);
        Button btnCalculateBMI = findViewById(R.id.btnCalculateBMI);
        TextView tvWeight = findViewById(R.id.tvWeight);
        TextView tvHeight = findViewById(R.id.tvHeight);
        TextView tvBMI = findViewById(R.id.tvBMI);
        Button btnBack = findViewById(R.id.btnBack);

        // การคำนวณ BMI
        btnCalculateBMI.setOnClickListener(v -> {
            String weightText = etWeight.getText().toString().trim();
            String heightText = etHeight.getText().toString().trim();

            if (weightText.isEmpty() || heightText.isEmpty()) {
                Toast.makeText(BMIActivity.this, "Please enter weight and height!", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double weight = Double.parseDouble(weightText);
                double height = Double.parseDouble(heightText) / 100; // แปลงจากเซนติเมตรเป็นเมตร
                double bmi = weight / (height * height);

                tvWeight.setText(String.format("Weight : %.2f กิโลกรัม", weight));
                tvHeight.setText(String.format("Height : %.2f เซนติเมตร", height * 100));
                tvBMI.setText(String.format("BMI : %.2f", bmi));
            } catch (NumberFormatException e) {
                Toast.makeText(BMIActivity.this, "Invalid input! Please enter valid numbers.", Toast.LENGTH_SHORT).show();
            }
        });

        // ปุ่มย้อนกลับไปหน้าหลัก
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(BMIActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
