package com.gabrielvaldez.petagram.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gabrielvaldez.petagram.Adapter.MascotaAdaptador;
import com.gabrielvaldez.petagram.Pojo.Mascotas;
import com.gabrielvaldez.petagram.Presentador.IRecyclerViewFragmentsPresenter;
import com.gabrielvaldez.petagram.Presentador.RecyclerViewFragmentsPresenter;
import com.gabrielvaldez.petagram.R;

import java.util.ArrayList;

public class RecyclerView_Fragment1 extends Fragment implements IRecyclerViewFragmentsView {

    private ArrayList<Mascotas> mascotas ;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentsPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview1,container,false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.Mascotas);
        presenter = new RecyclerViewFragmentsPresenter(this, getContext());
        return v;

    }
        /*
    public void InicializarListaMascotas(){
        mascotas = new ArrayList <Mascotas>();
        mascotas.add(new Mascotas(R.drawable.perro, "Mario",4));
        mascotas.add(new Mascotas(R.drawable.cerdo_animado,"Timmy",5));
        mascotas.add(new Mascotas(R.drawable.gato,"Tom",2));
        mascotas.add(new Mascotas(R.drawable.hamnster,"Jerry",3));
        mascotas.add(new Mascotas(R.drawable.nutria,"Arturo",1));
    }  */

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager Llm = new LinearLayoutManager(getActivity());
        Llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(Llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascotas> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
