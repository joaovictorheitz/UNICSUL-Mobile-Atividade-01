package com.joaovictorguedes.questao01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {
    CheckBox riceCheckBox, milkCheckBox, meatCheckBox, beanCheckBox, sodaCheckBox;
    TextView resultText;
    Button resultButton;

    Double ricePrice = 2.69;
    Double milkPrice = 2.7;
    Double meatPrice = 16.7;
    Double beanPrice = 3.38;
    Double sodaPrice = 3.0;
    Double totalResult = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupComponents();
    }

    private void setupComponents() {
        riceCheckBox = findViewById(R.id.riceCheckBox);
        milkCheckBox = findViewById(R.id.milkCheckBox);
        meatCheckBox = findViewById(R.id.meatCheckBox);
        beanCheckBox = findViewById(R.id.beanCheckBox);
        sodaCheckBox = findViewById(R.id.sodaCheckBox);

        resultText = findViewById(R.id.resultText);

        resultButton = findViewById(R.id.resultButton);
    }

    public void onClickResultButton(View view) {
        resetTotalPrice();

        if (riceCheckBox.isChecked()) { totalResult += ricePrice; }
        if (milkCheckBox.isChecked()) { totalResult += milkPrice; }
        if (meatCheckBox.isChecked()) { totalResult += meatPrice; }
        if (beanCheckBox.isChecked()) { totalResult += beanPrice; }
        if (sodaCheckBox.isChecked()) { totalResult += sodaPrice; }

        resultText.setText(String.format("R$ %.2f", totalResult).replace(".", ","));
    }

    private void resetTotalPrice() {
        totalResult = 0.0;
    }
}