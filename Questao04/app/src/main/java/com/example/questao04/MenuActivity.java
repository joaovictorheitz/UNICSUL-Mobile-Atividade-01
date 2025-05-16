package com.example.questao04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.radiobutton.MaterialRadioButton;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menu_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.menuActivityXML), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void routeToResume(View view) {
        TextInputEditText textField = findViewById(R.id.clientNameInput);
        String clientName = textField.getText().toString();

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        MaterialRadioButton radioButtonSelected = findViewById(radioButtonId);

        if (radioButtonSelected != null) {
            String order = radioButtonSelected.toString();

            Intent intent = new Intent(MenuActivity.this, ResumeActivity.class);
            intent.putExtra("clientName", clientName);
            intent.putExtra("order", order);

            startActivity(intent);
        }
    }
}
