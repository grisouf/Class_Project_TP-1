package com.gridev.projectlinearylyout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import static com.gridev.projectlinearylyout.HomeActivity.sentText;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        /** How to get Value from Other activity */

        //String getText = getIntent().getStringExtra(sentText).toString();
        //TextView text = findViewById(R.id.textviewhistory);
        //text.setTextSize(22);
        //text.setText("Welcome " + getText);
    }
}
