package com.gridev.projectlinearylyout.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.gridev.projectlinearylyout.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String sentText = "sentText";

    private ImageButton claculateMG;
    private ImageButton historyMG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        claculateMG = findViewById(R.id.claculate_mg);
        claculateMG.setOnClickListener(this);

        historyMG = findViewById(R.id.histroy_mg);
        historyMG.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.claculate_mg :
                intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.histroy_mg :
                intent = new Intent(HomeActivity.this, HistoryActivity.class);

                //intent.putExtra(sentText, "Grini Soufyane");

                startActivity(intent);
                break;

        }
    }
}


