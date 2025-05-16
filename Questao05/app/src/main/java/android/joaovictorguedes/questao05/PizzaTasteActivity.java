package android.joaovictorguedes.questao05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class PizzaTasteActivity extends AppCompatActivity {

    String tasteChoosed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.pizza_taste_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void routeToSizeActivity(View view) {
        Intent intent = new Intent(this, PizzaSizeActivity.class);

        intent.putExtra("tasteChoosed", getTasteChoosed());

        startActivity(intent);
    }

    private String getTasteChoosed() {
        CheckBox calabresaCheckBox = findViewById(R.id.calabresaCheckBox);
        CheckBox mussarelaCheckBox = findViewById(R.id.mussarelaCheckBox);
        CheckBox margueritaCheckBox = findViewById(R.id.margueritaCheckBox);
        CheckBox[] checkBoxes = { calabresaCheckBox, mussarelaCheckBox, margueritaCheckBox };
        String result = "";

        for (int i = 0; i < checkBoxes.length; i++) {
            CheckBox item = checkBoxes[i];
            String taste = item.getText().toString();

            if (item.isChecked()) {
                result += (i > 0 ? ", " : "") + taste;
            }
        }

        return result;
    }
}