package android.joaovictorguedes.questao05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class PizzaSizeActivity extends AppCompatActivity {
    String taste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.pizza_size_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pizzaSizeActivityXML), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupTaste();
    }

    public void routeToResume(View view) {
        Intent intent = new Intent(this, PizzaResumeActivity.class);

        intent.putExtra("tasteChoosed", taste);
        intent.putExtra("paymentMethod", getPaymentMethod());
        intent.putExtra("price", getPizzaPrice());

        startActivity(intent);
    }

    private void setupTaste() {
        Intent intent = getIntent();

        taste = intent.getStringExtra("tasteChoosed");
    }

    private int getPizzaPrice() {
        RadioGroup radioGroupSize = findViewById(R.id.radioGroup);
        int radioButtonId = radioGroupSize.getCheckedRadioButtonId();
        MaterialRadioButton radioButtonSizeSelected = findViewById(radioButtonId);

        if (radioButtonSizeSelected == null) { return 0; }

        if (radioButtonId == R.id.pizza35RadioButton) {
            return 50;
        } else if (radioButtonId == R.id.pizza30RadioButton) {
            return 40;
        } else if (radioButtonId == R.id.pizza25RadioButton) {
            return 35;
        }

        return 0;
    }

    private String getPaymentMethod() {
        RadioGroup radioGroupPayment = findViewById(R.id.radioGroup2);
        int radioButtonId = radioGroupPayment.getCheckedRadioButtonId();
        MaterialRadioButton radioButtonPaymentSelected = findViewById(radioButtonId);

        if (radioButtonPaymentSelected == null) { return ""; }

        return radioButtonPaymentSelected.getText().toString();
    }
}
