package com.example.curso3semana3.adapter;

import android.app.Activity;
import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.curso3semana3.MainActivity;
import com.example.curso3semana3.db.ConstructorMascotas;
import com.example.curso3semana3.pojo.Mascota;
import com.example.curso3semana3.R;

import java.util.ArrayList;

public class AdaptadorMascota extends RecyclerView.Adapter<AdaptadorMascota.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public AdaptadorMascota(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
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

        //TODO Switch back to use PetLikes
        //mascotaViewHolder.tvLikesMascota.setText(mascota.getPetLikes());
        mascotaViewHolder.tvLikesMascota.setText(String.valueOf(mascota.getLikes()));

        mascotaViewHolder.ivLikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + mascota.getPetName(), Toast.LENGTH_SHORT).show();
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                mascotaViewHolder.tvLikesMascota.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascota)));
            }
        });
    }



    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivFotoMascota, ivLikes;
        private TextView tvNombreMascota, tvLikesMascota;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFotoMascota   = (ImageView) itemView.findViewById(R.id.ivFotoMascota);
            tvNombreMascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvLikesMascota  = (TextView) itemView.findViewById(R.id.tvLikesMascota);
            ivLikes = (ImageView) itemView.findViewById(R.id.ivWhiteBone);
        }
    }



}
