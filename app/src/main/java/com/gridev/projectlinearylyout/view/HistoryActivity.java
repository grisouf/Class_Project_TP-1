package com.gridev.projectlinearylyout.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.gridev.projectlinearylyout.R;
import com.gridev.projectlinearylyout.view.adapter.ProfileHistoryAdapter;
import com.gridev.projectlinearylyout.model.Profile;
import com.gridev.projectlinearylyout.viewmodel.ProfileViewModel;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private ProfileViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        recycler = findViewById(R.id.history_recycler);

        final ProfileHistoryAdapter adapter = new ProfileHistoryAdapter();

        recycler.setLayoutManager(new LinearLayoutManager(this));// preciser la facon d afficher les items
        recycler.setAdapter(adapter);
        recycler.setHasFixedSize(true);
        /*
        ArrayList<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile(60, 1.45, 22, (byte)0));
        profiles.add(new Profile(80, 1.82, 30, (byte)1));
        profiles.add(new Profile(60, 1.75, 27, (byte)1));
        profiles.add(new Profile(40, 1.45, 22, (byte)0));

        adapter.setProfileList(profiles);
         */

        model = new ViewModelProvider
                .AndroidViewModelFactory(this.getApplication())
                .create(ProfileViewModel.class);

        model.getProfileList().observe(this, new Observer<List<Profile>>() {
            @Override
            public void onChanged(List<Profile> profiles) {
                adapter.setProfileList(profiles);
            }
        });

        /** How to get Value from Other activity */

        //String getText = getIntent().getStringExtra(sentText).toString();
        //TextView text = findViewById(R.id.textviewhistory);
        //text.setTextSize(22);
        //text.setText("Welcome " + getText);
    }
}
