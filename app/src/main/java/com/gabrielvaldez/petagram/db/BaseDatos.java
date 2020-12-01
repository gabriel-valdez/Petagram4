package com.gabrielvaldez.petagram.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.gabrielvaldez.petagram.Pojo.Mascotas;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER " +
                                        ")";
        String queryCrearTablaRaitingMascotas = "CREATE TABLE " + ConstantesBaseDatos.TABLE_RAITING_MASCOTAS + "(" +
                                        ConstantesBaseDatos.TABLE_RAITING_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBaseDatos.TABLE_RAITING_MASCOTAS_ID_MASCOTAS + " INTEGER , " +
                                        ConstantesBaseDatos.TABLE_RAITING_MASCOTAS_NUMERO_RAITING + " INTEGER , " +
                                        "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_RAITING_MASCOTAS_ID_MASCOTAS +") " +
                                        "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")" +
                                        ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaRaitingMascotas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_RAITING_MASCOTAS);
        onCreate(db);
    }

    public ArrayList<Mascotas> obtenerTodasLasMascotas (){
        ArrayList<Mascotas> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascotas mascotaActual = new Mascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryRaiting= "SELECT COUNT (" + ConstantesBaseDatos.TABLE_RAITING_MASCOTAS_NUMERO_RAITING +")" +
                    " FROM " + ConstantesBaseDatos.TABLE_RAITING_MASCOTAS +
                    " WHERE " + ConstantesBaseDatos.TABLE_RAITING_MASCOTAS_ID_MASCOTAS + "=" + mascotaActual.getId();

            Cursor registroRaiting = db.rawQuery(queryRaiting,null);
            if(registroRaiting.moveToNext()){
                mascotaActual.setRaiting(registroRaiting.getInt(0));
            }else{
                mascotaActual.setRaiting(0);
            }

            mascotas.add(mascotaActual);
        }


        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS,null,contentValues);

    }

    public void insertarRaitingMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_RAITING_MASCOTAS,null, contentValues);
        db.close();
    }

    public int obtenerRaitingMascotas(Mascotas mascotas){
        int Raiting = 0;

        String query=   "SELECT COUNT (" + ConstantesBaseDatos.TABLE_RAITING_MASCOTAS_NUMERO_RAITING +")" +
                        " FROM " + ConstantesBaseDatos.TABLE_RAITING_MASCOTAS +
                        " WHERE " + ConstantesBaseDatos.TABLE_RAITING_MASCOTAS_ID_MASCOTAS + "=" + mascotas.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        if (registros.moveToNext()) {
            Raiting = registros.getInt(0);
        }

        db.close();
        return Raiting;
    }
}
