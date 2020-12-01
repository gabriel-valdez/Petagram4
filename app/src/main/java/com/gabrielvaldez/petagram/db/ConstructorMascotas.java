package com.gabrielvaldez.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.gabrielvaldez.petagram.Pojo.Mascotas;
import com.gabrielvaldez.petagram.R;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final Integer RAITING = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascotas> obtenerDatos(){
        /*ArrayList<Mascotas> mascotas = new ArrayList <Mascotas>();
        mascotas.add(new Mascotas(R.drawable.perro, "Mario",4));
        mascotas.add(new Mascotas(R.drawable.cerdo_animado,"Timmy",5));
        mascotas.add(new Mascotas(R.drawable.gato,"Tom",2));
        mascotas.add(new Mascotas(R.drawable.hamnster,"Jerry",3));
        mascotas.add(new Mascotas(R.drawable.nutria,"Arturo",1));
        return mascotas; */

        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mario" );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro );

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Timmy" );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.cerdo_animado );

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Tom" );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.gato );

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Jerry" );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.hamnster );

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Arturo" );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.nutria );

        db.insertarMascota(contentValues);
    }

    public void darRaitingMascota(Mascotas mascotas){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_RAITING_MASCOTAS_ID_MASCOTAS, mascotas.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_RAITING_MASCOTAS_NUMERO_RAITING, RAITING);
        db.insertarRaitingMascota(contentValues);
    }

    public int obtenerRaitingMascota(Mascotas mascotas) {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerRaitingMascotas(mascotas);
    }
}
