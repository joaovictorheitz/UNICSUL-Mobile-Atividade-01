package com.joaovictorguedes.questao02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    RadioButton rb40Percent, rb45Percent, rb50Percent;
    TextView resultText;
    TextInputEditText salaryTextField;
    Button resultButton;
    Double result;

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

        setupViews();
    }

    private void setupViews() {
        rb40Percent = findViewById(R.id.rb40Percent);
        rb45Percent = findViewById(R.id.rb45Percent);
        rb50Percent = findViewById(R.id.rb50Percent);

        resultText = findViewById(R.id.resultText);

        salaryTextField = findViewById(R.id.salaryTextField);

        resultButton = findViewById(R.id.resultButton);
    }

    public void onResultButtonClick(View view) {
        resetResult();

        Double salary = Double.parseDouble(salaryTextField.getText().toString());
        Double multiplier = 0.0;

        if (rb40Percent.isChecked()) { multiplier = 0.4; };
        if (rb45Percent.isChecked()) { multiplier = 0.45; };
        if (rb50Percent.isChecked()) { multiplier = 0.5; };

        result = salary + (salary * multiplier);
        resultText.setText(String.format("R$ %.2f", result).replace(".", ","));
    }

    private void resetResult() {
        result = 0.0;
    }
}