package com.gabrielvaldez.petagram.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gabrielvaldez.petagram.Pojo.Mascotas;
import com.gabrielvaldez.petagram.R;
import com.gabrielvaldez.petagram.db.ConstructorMascotas;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascotas> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascotas> mascotas, Activity activity){

        this.mascotas = mascotas;
        this.activity = activity;
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
        holder.NumeroRaiting.setText(String.valueOf(mascota.getRaiting()));

        holder.HuesoAmarillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darRaitingMascota(mascota);
                holder.NumeroRaiting.setText(String.valueOf(constructorMascotas.obtenerRaitingMascota(mascota)));
            }
        });

    }

    @Override
    public int getItemCount() {     //cantidad de elementos que contiene mi lista de mascotas
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private final ImageView FotoMascota;
        private final TextView NombreMascota;
        private final TextView NumeroRaiting;
        private final ImageButton HuesoAmarillo;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            FotoMascota = (ImageView) itemView.findViewById(R.id.FotoMascota);
            NombreMascota = (TextView) itemView.findViewById(R.id.NombreMascota);
            NumeroRaiting = (TextView) itemView.findViewById(R.id.NumeroRaiting);
            HuesoAmarillo = (ImageButton) itemView.findViewById(R.id.HuesoAmarillo);
        }
    }
}
