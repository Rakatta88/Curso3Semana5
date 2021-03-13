package com.example.curso3semana3.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.curso3semana3.R;
import com.example.curso3semana3.pojo.Mascota;

import java.util.ArrayList;

public class AdaptadorPerfil extends RecyclerView.Adapter<AdaptadorPerfil.PerfilViewHolder>{

    ArrayList<Mascota> perfiles;

    //Constructor
    public AdaptadorPerfil(ArrayList<Mascota> perfiles){
        this.perfiles = perfiles;
    }

    //Inlate layout and pass to ViewHolder to obtain the different views
    @NonNull
    @Override
    public PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_profile, parent, false);
        return new PerfilViewHolder(v);
    }

    //Associate each item of our list to each view
    @Override
    public void onBindViewHolder(@NonNull PerfilViewHolder perfilViewHolder, int position) {
        Mascota mascota = perfiles.get(position);
        perfilViewHolder.iv_profilefoto.setImageResource(mascota.getPetFoto());
        perfilViewHolder.tv_profilefotolikes.setText(mascota.getPetLikes());
    }

    @Override
    public int getItemCount() { //cantidad the elementos que tiene el ArrayList "perfiles"
        return perfiles.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv_profilefoto;
        private TextView tv_profilefotolikes;

        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_profilefoto      = (ImageView) itemView.findViewById(R.id.iv_profilefoto);
            tv_profilefotolikes = (TextView) itemView.findViewById(R.id.tv_profilefotolikes);

        }
    }
}
