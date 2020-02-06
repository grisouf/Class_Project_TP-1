package com.gridev.projectlinearylyout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Views
    private EditText poids;
    private EditText taille;
    private EditText age;

    private RadioButton femme;
    private RadioButton homme;

    private Button calcule;
    private TextView result;
    private ImageView image;

    // properties
    private double poidsValue = 0;
    private double tailleValue = 0;
    private double ageValue = 0;
    private int checkedValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       init();



       calcule.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               getValues();

              Toast.makeText(MainActivity.this, String.valueOf(calucleMG()), Toast.LENGTH_SHORT).show();
           }
       });


    }

    private void init () {
        poids = findViewById(R.id.poids);
        taille = findViewById(R.id.taille);
        age = findViewById(R.id.age);

        femme = findViewById(R.id.femme);
        homme = findViewById(R.id.homme);

        calcule = findViewById(R.id.calcule);
        result = findViewById(R.id.result);
        image = findViewById(R.id.image);
    }

    private void getValues() {
        poidsValue = Double.valueOf(poids.getText().toString());
        tailleValue = Double.valueOf(taille.getText().toString());
        ageValue = Double.valueOf(age.getText().toString());
        if (femme.isChecked()) {
            checkedValue = 0;
        }
        else {
            checkedValue = 1;
        }
    }

    private double calucleMG() {
        return (1.2 * poidsValue / (tailleValue * tailleValue)) + (0.23 * ageValue) - (10.83 * checkedValue) - 5.4;
    }
}
