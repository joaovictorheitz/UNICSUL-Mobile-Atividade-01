package com.example.questao03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfirmSignUpActivity extends AppCompatActivity {
    TextView welcomeText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.confirm_sign_up_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.confirmSignUpXML), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setWelcomeText();
        setupLabel();
    }

    private void setWelcomeText() {
        welcomeText = findViewById(R.id.welcomeText);
    }

    private void setupLabel() {
        String clientName = getIntent().getStringExtra("clientName");

        welcomeText.setText("Seja bem vindo, " + clientName + "!");
    }

    public void routeToWelcomeActivity(View view) {
        startActivity(new Intent(ConfirmSignUpActivity.this, WelcomeActivity.class));
    }
}
