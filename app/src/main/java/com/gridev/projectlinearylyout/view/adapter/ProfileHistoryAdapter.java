package com.gridev.projectlinearylyout.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;//generé automatiquement

import com.gridev.projectlinearylyout.R;
import com.gridev.projectlinearylyout.model.Profile;

import java.util.ArrayList;
import java.util.List;

//extends (choisir androidx.recyclerview.widget.RecyclerView  puis .Adapter

//une fois l inner  class est cree ( en bas) ajouter type d adapter entre <> ProfileHistoryViewHolder
// alt entree  implementer ttes les methodes onCreateViewHolder...
public class ProfileHistoryAdapter extends RecyclerView.Adapter<ProfileHistoryAdapter.ProfileHistoryViewHolder> {

    // Properties
    // Ajouter import java.util.List; pour travailler avc l interface List
    private List<Profile> profileList = new ArrayList<>();//son setter genere en bas

    @NonNull
    @Override
    public ProfileHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_profile, parent, false);

        return new ProfileHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileHistoryViewHolder holder, int position) {
        Profile profile = profileList.get(position);

        holder.poids.setText(String.valueOf(profile.getPoids()));
        holder.taille.setText(String.valueOf(profile.getTaille()));
        holder.age.setText(String.valueOf(profile.getAge()));
        if (profile.getGender() == 0) {
            holder.gender.setText("Femme");
        }
        else
        {
            holder.gender.setText("Homme");
        }
    }

    @Override
    public int getItemCount() {
     //profileList declare
        return profileList.size();//pr savoir le nbre de fois a appeler la methode onBindViewHolder qui affiche les items
    }


    //alt insert pr generer cette methode choisir setter
    public void setProfileList(List<Profile> profileList) {
        this.profileList = profileList;
    }

    // inner class( classe ds une classe ) pr creer un viewHolder
    //alt entree pr generer le constructeur matching super
    //extends RecyclerView.ViewHolder
     class ProfileHistoryViewHolder extends RecyclerView.ViewHolder {

        TextView poids;
        TextView taille;
        TextView age;
        TextView gender;

        //genere avc alt entree
        ProfileHistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            // on peut pâs app directement findViewById ds une viewHolder comme le cas d une activite
            poids = itemView.findViewById(R.id.item_poids);
            taille = itemView.findViewById(R.id.item_taille);
            age = itemView.findViewById(R.id.item_age);
            gender = itemView.findViewById(R.id.item_gender);
        }
    }
}
