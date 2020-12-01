package com.gabrielvaldez.petagram.Fragments;

import com.gabrielvaldez.petagram.Adapter.MascotaAdaptador;
import com.gabrielvaldez.petagram.Pojo.Mascotas;

import java.util.ArrayList;

public interface IRecyclerViewFragmentsView {

        public void generarLinearLayoutVertical();

        public MascotaAdaptador crearAdaptador (ArrayList<Mascotas> mascotas);

        public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
