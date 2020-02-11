package com.gridev.projectlinearylyout.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_profile")
public class Profile {
    // Generer le constructeur avc alt + insert
    public Profile(double poids, double taille, int age, byte gender) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.gender = gender;
    }

    // Proprietes
    @PrimaryKey(autoGenerate = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //@ColumnInfo(name = "first_name")
    private double poids;
    private double taille;
    private int age;
    private byte gender;

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public byte getGender() {
        return gender;
    }


    public void setGender(byte gender) {
        if (gender > 1 || gender < 0) throw new IllegalArgumentException("Gender should be 0 or 1");

        this.gender = gender;
    }
}
