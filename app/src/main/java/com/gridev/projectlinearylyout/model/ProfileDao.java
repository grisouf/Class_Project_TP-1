package com.gridev.projectlinearylyout.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProfileDao {
    @Insert
    void insert(Profile profile);
    /*
    @Update
    void update(Profile profile);

    @Delete
    void delete(Profile profile);
    */
    // notification au recycleview pr s actualiser apres l ajt ds une ligne ds  BD
    @Query("SELECT * FROM tb_profile")
    LiveData<List<Profile>> selectAll();
}
