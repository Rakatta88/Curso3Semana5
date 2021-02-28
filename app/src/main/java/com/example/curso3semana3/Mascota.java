package com.example.curso3semana3;

import android.widget.ImageView;

public class Mascota {

    String petName;
    int petFoto;
    String petLikes;

    public Mascota(String petName, int petFoto, String petLikes) {
        this.petName = petName;
        this.petFoto = petFoto;
        this.petLikes = petLikes;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getPetFoto() {
        return petFoto;
    }

    public void setPetFoto(int petFoto) {
        this.petFoto = petFoto;
    }

    public String getPetLikes() {
        return petLikes;
    }

    public void setPetLikes(String petLikes) {
        this.petLikes = petLikes;
    }

}
