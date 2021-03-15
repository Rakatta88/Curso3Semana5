package com.example.curso3semana3.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.curso3semana3.R;
import com.example.curso3semana3.adapter.AdaptadorPerfil;
import com.example.curso3semana3.pojo.Mascota;

import java.util.ArrayList;


public class Perfil extends Fragment {

    ArrayList<Mascota> perfiles;
    private RecyclerView listaPerfiles;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_perfil, container, false);
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaPerfiles = (RecyclerView) v.findViewById(R.id.rvPerfil);

        /*LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);*/

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);

        listaPerfiles.setLayoutManager(glm);

        createProfiles();
        initializeAdaptor();

        return v;

    }

    public void initializeAdaptor(){
        AdaptadorPerfil adaptor = new AdaptadorPerfil(perfiles);
        listaPerfiles.setAdapter(adaptor);
    }

    public void createProfiles (){
        perfiles = new ArrayList<Mascota>();
        perfiles.add (new Mascota ("King Kong", R.drawable.petfaces06, 3));
        perfiles.add (new Mascota ("King Kong", R.drawable.petfaces06, 0));
        perfiles.add (new Mascota ("King Kong", R.drawable.petfaces06, 8));
        perfiles.add (new Mascota ("King Kong", R.drawable.petfaces06, 1));
        perfiles.add (new Mascota ("King Kong", R.drawable.petfaces06, 4));
        perfiles.add (new Mascota ("King Kong", R.drawable.petfaces06, 7));
        perfiles.add (new Mascota ("King Kong", R.drawable.petfaces06, 0));
        perfiles.add (new Mascota ("King Kong", R.drawable.petfaces06, 2));
        perfiles.add (new Mascota ("King Kong", R.drawable.petfaces06, 3));
        perfiles.add (new Mascota ("King Kong", R.drawable.petfaces06, 0));
        perfiles.add (new Mascota ("King Kong", R.drawable.petfaces06, 8));
        perfiles.add (new Mascota ("King Kong", R.drawable.petfaces06, 1));
        perfiles.add (new Mascota ("King Kong", R.drawable.petfaces06, 4));
        perfiles.add (new Mascota ("King Kong", R.drawable.petfaces06, 7));
        perfiles.add (new Mascota ("King Kong", R.drawable.petfaces06, 0));
        perfiles.add (new Mascota ("King Kong", R.drawable.petfaces06, 2));
    }

}