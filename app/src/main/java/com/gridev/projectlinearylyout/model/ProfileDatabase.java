package com.gridev.projectlinearylyout.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Profile.class}, version = 1, exportSchema = false)
public abstract class ProfileDatabase extends RoomDatabase {
    private static ProfileDatabase INSTANCE = null;

    // Create Instance of Database
    public static synchronized ProfileDatabase getDatabaseInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder (
                        context.getApplicationContext(),
                        ProfileDatabase.class,
                        "profile_database"
                    )
                    .build();
        }
        return INSTANCE;
    }

    public ProfileDao profileDao;
}
