package com.gabrielvaldez.petagram.Pojo;

public class MiMascota {

    private int FotoMiMascota;
    private String RaitingMiMascota;

    public MiMascota(int fotoMiMascota, String raitingMiMascota) {
        FotoMiMascota = fotoMiMascota;
        RaitingMiMascota = raitingMiMascota;
    }

    public int getFotoMiMascota() {
        return FotoMiMascota;
    }

    public void setFotoMiMascota(int fotoMiMascota) {
        FotoMiMascota = fotoMiMascota;
    }

    public String getRaitingMiMascota() {
        return RaitingMiMascota;
    }

    public void setRaitingMiMascota(String raitingMiMascota) {
        RaitingMiMascota = raitingMiMascota;
    }
}
