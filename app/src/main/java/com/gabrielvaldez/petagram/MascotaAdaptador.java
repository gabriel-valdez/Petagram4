package com.gabrielvaldez.petagram;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascotas> mascotas;

    public MascotaAdaptador(ArrayList<Mascotas> mascotas){
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        Mascotas mascota = mascotas.get(position);
        holder.FotoMascota.setImageResource(mascota.getFoto());
        holder.NombreMascota.setText(mascota.getNombre());
        holder.NumeroRaiting.setText(mascota.getRaiting());
        holder.HuesoAmarillo.setImageResource(mascota.getFotoHuesoAmarillo());
        holder.HuesoBlanco.setImageResource(mascota.getFotoHuesoBlanco());
    }

    @Override
    public int getItemCount() {     //cantidad de elementos que contiene mi lista de mascotas
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private final ImageView FotoMascota;
        private final TextView NombreMascota;
        private final TextView NumeroRaiting;
        private final ImageView HuesoBlanco;
        private final ImageView HuesoAmarillo;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            FotoMascota = (ImageView) itemView.findViewById(R.id.FotoMascota);
            NombreMascota = (TextView) itemView.findViewById(R.id.NombreMascota);
            NumeroRaiting = (TextView) itemView.findViewById(R.id.NumeroRaiting);
            HuesoBlanco = (ImageView) itemView.findViewById(R.id.HuesoBlanco);
            HuesoAmarillo = (ImageView) itemView.findViewById(R.id.HuesoAmarillo);
        }
    }
}
