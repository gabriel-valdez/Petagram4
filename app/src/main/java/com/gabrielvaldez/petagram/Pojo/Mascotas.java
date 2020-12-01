package com.gabrielvaldez.petagram.Pojo;

public class Mascotas {

    private int id;
    private int Foto;
    private String Nombre;
    private int Raiting;

    public Mascotas(int foto, String nombre, int raiting) {
        Foto = foto;
        Nombre = nombre;
        Raiting = raiting;
    }

    public Mascotas() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getRaiting() {
        return Raiting;
    }

    public void setRaiting(int raiting) {
        Raiting = raiting;
    }
}
