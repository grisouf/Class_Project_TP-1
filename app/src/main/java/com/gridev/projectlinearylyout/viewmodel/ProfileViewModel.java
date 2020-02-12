package com.gridev.projectlinearylyout.viewmodel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.gridev.projectlinearylyout.model.Profile;
import com.gridev.projectlinearylyout.model.ProfileDao;
import com.gridev.projectlinearylyout.model.ProfileDatabase;

import java.util.List;

public class ProfileViewModel extends AndroidViewModel {
    private ProfileDao dao;
    private LiveData<List<Profile>> profileList;

    // Generate  Getter with 'Alt + insert'
    public LiveData<List<Profile>> getProfileList() {
        return profileList;
    }

    // genrer Avec Alt Enter : Create Cunstructor match super
    public ProfileViewModel(@NonNull Application application) {
        super(application);

        dao = ProfileDatabase
                .getDatabaseInstance(application)
                .profileDao();

        profileList = dao.selectAll();
    }

    public void add(Profile profile) {
        new ProfileAsyncTask(dao).execute(profile);
    }

    static class ProfileAsyncTask extends AsyncTask<Profile, Void, Void> {
        private ProfileDao dao;

        ProfileAsyncTask(ProfileDao dao) {
            this.dao = dao;
        }

        // Implement With 'Alt + Enter'
        @Override
        protected Void doInBackground(Profile... profiles) {
            dao.insert(profiles[0]);

            return null;
        }
    }
}
