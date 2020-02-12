package com.gridev.projectlinearylyout.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

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
    // This Method Should be Abstract Method or will not work
    public abstract ProfileDao profileDao();

    /**
     *  for Insert Values to Tables in Creation of the database
     *  create a static AsyncTask subclass That Take 3 Voids
     *  and Add Dao Property and create Constructor that takes your RoomDatabase SubClass
     *  in doInBackground method insert values that you want to insert using dao.insert(Object)
     *
     *  after that create instance RoomDatabase.Callback()
     *  in onCreate method add new instance AsyncTask that you have created early
     *
     *  See The Example Bellow
     *  Add Four Rows To Profile Table
     */
    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            new InsertProfileAsyncTask(INSTANCE).execute();
        }
    };


    static class InsertProfileAsyncTask extends AsyncTask<Void, Void, Void> {
        ProfileDao dao;

        InsertProfileAsyncTask(ProfileDatabase db) {
            this.dao = db.profileDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.insert(new Profile(60, 1.45, 22, (byte)0));
            dao.insert(new Profile(60, 1.75, 27, (byte)1));
            dao.insert(new Profile(80, 1.82, 30, (byte)1));
            dao.insert(new Profile(40, 1.45, 22, (byte)0));
            return null;
        }
    }
}
