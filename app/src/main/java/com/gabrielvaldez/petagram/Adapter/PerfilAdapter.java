package com.gabrielvaldez.petagram.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gabrielvaldez.petagram.Pojo.MiMascota;
import com.gabrielvaldez.petagram.R;

import java.util.ArrayList;

public class PerfilAdapter  extends RecyclerView.Adapter<PerfilAdapter.MiMascotaViewHolder>{

    ArrayList<MiMascota> miMascota;

    public PerfilAdapter(ArrayList<MiMascota> miMascotas){
        this.miMascota = miMascotas;
    }

    @NonNull
    @Override
    public MiMascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview2,parent,false);
        return new MiMascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MiMascotaViewHolder holder, int position) {
        MiMascota miMascotas= miMascota.get(position);
        holder.FotoPerfil.setImageResource(miMascotas.getFotoMiMascota());
        holder.RaitingPerfil.setText(miMascotas.getRaitingMiMascota());
    }

    @Override
    public int getItemCount() {
        return miMascota.size();
    }


    public static class MiMascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView FotoPerfil;
        private TextView RaitingPerfil;

        public MiMascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            FotoPerfil = (ImageView) itemView.findViewById(R.id.FotoPerfil);
            RaitingPerfil = (TextView) itemView.findViewById(R.id.RaitingPerfil);
        }
    }
}
