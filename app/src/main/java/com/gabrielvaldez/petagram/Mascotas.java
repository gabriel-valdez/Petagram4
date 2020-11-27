package com.gabrielvaldez.petagram;

public class Mascotas {

    private int Foto;
    private int FotoHuesoBlanco;
    private int FotoHuesoAmarillo;
    private String Nombre;
    private String Raiting;

    public Mascotas(int foto,int fotoHuesoBlanco,int fotoHuesoAmarillo, String nombre, String raiting) {
        Foto = foto;
        FotoHuesoBlanco = fotoHuesoBlanco;
        FotoHuesoAmarillo = fotoHuesoAmarillo;
        Nombre = nombre;
        Raiting = raiting;
    }

    public int getFotoHuesoBlanco() {
        return FotoHuesoBlanco;
    }

    public void setFotoHuesoBlanco(int fotoHuesoBlanco) {
        FotoHuesoBlanco = fotoHuesoBlanco;
    }

    public int getFotoHuesoAmarillo() {
        return FotoHuesoAmarillo;
    }

    public void setFotoHuesoAmarillo(int fotoHuesoAmarillo) {
        FotoHuesoAmarillo = fotoHuesoAmarillo;
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

    public String getRaiting() {
        return Raiting;
    }

    public void setRaiting(String raiting) {
        Raiting = raiting;
    }
}
