package com.gridev.projectlinearylyout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.gridev.projectlinearylyout.adapter.ProfileHistoryAdapter;
import com.gridev.projectlinearylyout.model.Profile;

import java.util.ArrayList;

import static com.gridev.projectlinearylyout.HomeActivity.sentText;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        recycler = findViewById(R.id.history_recycler);

        ProfileHistoryAdapter adapter = new ProfileHistoryAdapter();

        recycler.setLayoutManager(new LinearLayoutManager(this));// preciser la facon d afficher les items
        recycler.setAdapter(adapter);
        recycler.setHasFixedSize(true);

        ArrayList<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile(60, 1.45, 22, (byte)0));
        profiles.add(new Profile(80, 1.82, 30, (byte)1));
        profiles.add(new Profile(60, 1.75, 27, (byte)1));
        profiles.add(new Profile(40, 1.45, 22, (byte)0));

        adapter.setProfileList(profiles);

        /** How to get Value from Other activity */

        //String getText = getIntent().getStringExtra(sentText).toString();
        //TextView text = findViewById(R.id.textviewhistory);
        //text.setTextSize(22);
        //text.setText("Welcome " + getText);
    }
}
