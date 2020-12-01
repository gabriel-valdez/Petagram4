package com.gabrielvaldez.petagram.Presentador;

import android.content.Context;

import com.gabrielvaldez.petagram.Fragments.IRecyclerViewFragmentsView;
import com.gabrielvaldez.petagram.Pojo.Mascotas;
import com.gabrielvaldez.petagram.db.ConstructorMascotas;

import java.util.ArrayList;

public class RecyclerViewFragmentsPresenter implements IRecyclerViewFragmentsPresenter {

    private IRecyclerViewFragmentsView iRecyclerViewFragmentsView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas> mascotas;

    public RecyclerViewFragmentsPresenter(IRecyclerViewFragmentsView iRecyclerViewFragmentsView, Context context) {
        this.iRecyclerViewFragmentsView = iRecyclerViewFragmentsView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas  = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();

    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentsView.inicializarAdaptadorRV(iRecyclerViewFragmentsView.crearAdaptador(mascotas));
        iRecyclerViewFragmentsView.generarLinearLayoutVertical();
    }
}
