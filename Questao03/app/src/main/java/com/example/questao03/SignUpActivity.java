package com.example.questao03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.signup_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.signUpXML), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private String getName() {
        TextInputEditText nameTextField;
        nameTextField = findViewById(R.id.nameTextField);

        return nameTextField.getText().toString();
    }

    public void routeToConfirmSignUp(View view) {
        String clientName = getName();

        Intent intent = new Intent(SignUpActivity.this, ConfirmSignUpActivity.class);
        intent.putExtra("clientName", clientName);

        startActivity(intent);
    }
}
