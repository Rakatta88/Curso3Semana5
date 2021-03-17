package com.example.curso3semana3.pojo;

import android.widget.ImageView;

public class Mascota {

    int id;
    String petName;
    int petFoto;
    String petLikes;
    int likes;

    //Empty Constructor for the database methods to work
    public Mascota() {

    }

    public Mascota(String petName, int petFoto, int likes) {
        this.petName = petName;
        this.petFoto = petFoto;
//        this.petLikes = petLikes;
        this.likes = likes;
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

//    public String getPetLikes() { return petLikes; }

 //   public void setPetLikes(String petLikes) {this.petLikes = petLikes; }

    public int getLikes() { return likes; }

    public void setLikes(int likes) { this.likes = likes; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

}
