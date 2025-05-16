package android.joaovictorguedes.questao05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class PizzaResumeActivity extends AppCompatActivity {
    String taste, paymentMethod;
    int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.pizza_resume_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pizzaResumeActivityXML), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupExtras();
        setupResume();
    }

    private void setupExtras() {
        Intent intent = getIntent();

        taste = intent.getStringExtra("tasteChoosed");
        paymentMethod = intent.getStringExtra("paymentMethod");
        price = intent.getIntExtra("price", 0);
    }

    private void setupResume() {
        TextView tasteTextView = findViewById(R.id.tasteTextView);
        TextView sizeTextView = findViewById(R.id.sizeTextView);
        TextView paymentMethodTextView = findViewById(R.id.paymentMethodTextView);
        TextView priceTextView = findViewById(R.id.priceTextView);

        tasteTextView.setText("Pizza sabor: " + taste);
        sizeTextView.setText("Pizza tamanho: " + getStringSize());
        paymentMethodTextView.setText("Forma de pagamento: " + paymentMethod);
        priceTextView.setText("Preço: R$" + price);
    }

    private String getStringSize() {
        switch (price) {
            case 50:
                return "35cm";
            case 40:
                return "30cm";
            case 35:
                return "25cm";
            default:
                return "";
        }
    }
}
