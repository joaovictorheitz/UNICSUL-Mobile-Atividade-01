package com.example.questao04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResumeActivity extends AppCompatActivity {
    String clientName, order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.resume_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.resumeActivityXML), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getExtraIntent();
        setupText();
    }

    private void setupText() {
        TextView finalText = findViewById(R.id.textView2);

        finalText.setText(clientName + ", você pediu um " + order);
    }

    private void getExtraIntent() {
        Intent intent = getIntent();

        clientName = intent.getStringExtra("clientName");
        order = intent.getStringExtra("order");
    }

    public void routeToWelcomePage(View view) {
        startActivity(new Intent(ResumeActivity.this, WelcomeActivity.class));
    }
}
