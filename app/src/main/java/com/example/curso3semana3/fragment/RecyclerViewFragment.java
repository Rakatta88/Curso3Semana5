package com.example.curso3semana3.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.curso3semana3.R;
import com.example.curso3semana3.adapter.AdaptadorMascota;
import com.example.curso3semana3.db.ConstructorMascotas;
import com.example.curso3semana3.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private ConstructorMascotas constructorMascotas;
    private Context context;
    //private ArrayList<Mascota> almascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascota);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        //Initialize Mascot list
        //Commentar para usar ConstructorMascotas y no ArrayList createPets


        createPets();
        Log.i("DEBUGGING", "RecyclerViewFragment - Before obtenerMascotasBaseDatos");

        //obtenerMascotasBaseDatos();

        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador (){
        AdaptadorMascota adaptador = new AdaptadorMascota(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void obtenerMascotasBaseDatos(){
        constructorMascotas = new ConstructorMascotas(getContext());
        mascotas = constructorMascotas.obtenerDatos();
    }

    public void createPets (){
        mascotas = new ArrayList<Mascota>();
        mascotas.add (new Mascota ("King Kong", R.drawable.petfaces06, 3));
        mascotas.add (new Mascota ("KungFu Panda", R.drawable.petfaces03, 4));
        mascotas.add(new Mascota("Natascha", R.drawable.petfaces05, 5));
        mascotas.add (new Mascota ("Simba", R.drawable.petfaces07, 2));
        mascotas.add (new Mascota ("Ottifant", R.drawable.petfaces02, 5));
        mascotas.add (new Mascota ("Määh", R.drawable.petfaces04, 1));
    }

}
