package com.example.assign02_6406021622036;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class GradeActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        // เชื่อมโยง UI กับ Java
        EditText etScore = findViewById(R.id.etScore);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        TextView tvYourScore = findViewById(R.id.tvYourScore);
        TextView tvYourGrade = findViewById(R.id.tvYourGrade);
        Button btnBack = findViewById(R.id.btnBack);

        // การคำนวณเกรด
        btnCalculate.setOnClickListener(v -> {
            String scoreText = etScore.getText().toString().trim();

            if (scoreText.isEmpty()) {
                Toast.makeText(GradeActivity.this, "Please enter a score!", Toast.LENGTH_SHORT).show();
                return;
            }

            int score = Integer.parseInt(scoreText);
            String grade = getGrade(score);

            tvYourScore.setText("Your Score: " + score);
            tvYourGrade.setText("Your Grade: " + grade);
        });

        // ปุ่มย้อนกลับไปหน้าหลัก
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(GradeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private static @NonNull String getGrade(int score) {
        String grade;

        if (score >= 80) {
            grade = "A";
        } else if (score >= 75) {
            grade = "B+";
        } else if (score >= 70) {
            grade = "B";
        } else if (score >= 65) {
            grade = "C+";
        } else if (score >= 60) {
            grade = "C";
        } else if (score >= 55) {
            grade = "D+";
        } else if (score >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }
        return grade;
    }
}
