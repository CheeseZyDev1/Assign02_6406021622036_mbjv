package com.example.assign02_6406021622036;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VatActivity extends AppCompatActivity {

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vat);

        // เชื่อมโยง UI กับ Java
        EditText etPrice = findViewById(R.id.etPrice);
        Button btnCalculateVat = findViewById(R.id.btnCalculateVat);
        TextView tvPrice = findViewById(R.id.tvPrice);
        TextView tvVat = findViewById(R.id.tvVat);
        TextView tvTotal = findViewById(R.id.tvTotal);
        Button btnBack = findViewById(R.id.btnBack);

        // การคำนวณ VAT
        btnCalculateVat.setOnClickListener(v -> {
            String priceText = etPrice.getText().toString().trim();

            if (priceText.isEmpty()) {
                Toast.makeText(VatActivity.this, "Please enter a price!", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double price = Double.parseDouble(priceText);
                double vat = price * 0.07; // คำนวณ VAT 7%
                double total = price + vat;

                tvPrice.setText(String.format("Price : %.2f", price));
                tvVat.setText(String.format("Vat : %.2f", vat));
                tvTotal.setText(String.format("Total : %.2f", total));
            } catch (NumberFormatException e) {
                Toast.makeText(VatActivity.this, "Invalid input! Please enter a valid number.", Toast.LENGTH_SHORT).show();
            }
        });

        // ปุ่มย้อนกลับไปหน้าหลัก
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(VatActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
