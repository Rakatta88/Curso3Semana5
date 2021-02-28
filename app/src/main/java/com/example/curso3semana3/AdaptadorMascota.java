package com.example.curso3semana3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorMascota extends RecyclerView.Adapter<AdaptadorMascota.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;

    public AdaptadorMascota(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    //inflate the layout and pass to ViewHolder to obtain the views
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    //asociate each element of the list with each view
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        Mascota mascota = mascotas.get(position);
        mascotaViewHolder.ivFotoMascota.setImageResource(mascota.getPetFoto());
        mascotaViewHolder.tvNombreMascota.setText(mascota.getPetName());

        //TODO Validate if this works with INT or text
        mascotaViewHolder.tvLikesMascota.setText(mascota.getPetLikes());

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivFotoMascota;
        private TextView tvNombreMascota, tvLikesMascota;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFotoMascota   = (ImageView) itemView.findViewById(R.id.ivFotoMascota);
            tvNombreMascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvLikesMascota  = (TextView) itemView.findViewById(R.id.tvLikesMascota);

        }
    }



}
