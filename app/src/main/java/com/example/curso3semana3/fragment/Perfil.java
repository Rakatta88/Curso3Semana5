package com.example.curso3semana3.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaPerfiles.setLayoutManager(llm);

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
        perfiles.add (new Mascota ("King Kong", R.drawable.petfaces06, "0"));
        perfiles.add (new Mascota ("KungFu Panda", R.drawable.petfaces03, "4"));
        perfiles.add(new Mascota("Natascha", R.drawable.petfaces05, "5"));
        perfiles.add (new Mascota ("Simba", R.drawable.petfaces07, "2"));
        perfiles.add (new Mascota ("Ottifant", R.drawable.petfaces02, "5"));
        perfiles.add (new Mascota ("Määh", R.drawable.petfaces04, "1"));
    }

}