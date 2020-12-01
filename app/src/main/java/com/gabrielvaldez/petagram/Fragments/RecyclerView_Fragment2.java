package com.gabrielvaldez.petagram.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gabrielvaldez.petagram.Adapter.MascotaAdaptador;
import com.gabrielvaldez.petagram.Adapter.PerfilAdapter;
import com.gabrielvaldez.petagram.Pojo.Mascotas;
import com.gabrielvaldez.petagram.Pojo.MiMascota;
import com.gabrielvaldez.petagram.R;

import java.util.ArrayList;

public class RecyclerView_Fragment2 extends Fragment {

    private ArrayList<MiMascota> miMascota ;
    private RecyclerView ListaPerfil;


    public RecyclerView_Fragment2() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview2,container,false);

        ListaPerfil = (RecyclerView) v.findViewById(R.id.MiPerfil);

        GridLayoutManager ggm = new GridLayoutManager(getActivity(),2);

        ListaPerfil.setLayoutManager(ggm);
        InicializarListaPerfil();
        inicializarAdaptador2();
        return v;
    }

    public void inicializarAdaptador2(){
        PerfilAdapter adaptador = new PerfilAdapter(miMascota);
        ListaPerfil.setAdapter(adaptador);
    }


    public void InicializarListaPerfil(){
        miMascota = new ArrayList<MiMascota>();

        miMascota.add(new MiMascota(R.drawable.perro,"5"));
        miMascota.add(new MiMascota(R.drawable.perro,"2"));
        miMascota.add(new MiMascota(R.drawable.perro,"3"));
        miMascota.add(new MiMascota(R.drawable.perro,"1"));
        miMascota.add(new MiMascota(R.drawable.perro,"4"));
        miMascota.add(new MiMascota(R.drawable.perro,"5"));
        miMascota.add(new MiMascota(R.drawable.perro,"6"));
        miMascota.add(new MiMascota(R.drawable.perro,"3"));
        miMascota.add(new MiMascota(R.drawable.perro,"0"));
    }
}