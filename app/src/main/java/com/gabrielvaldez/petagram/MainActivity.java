package com.gabrielvaldez.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList <Mascotas> mascotas ;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        listaMascotas = (RecyclerView) findViewById(R.id.Mascotas);

        LinearLayoutManager Llm = new LinearLayoutManager(this);
        Llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(Llm);
        InicializarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void InicializarListaMascotas(){
        mascotas = new ArrayList <Mascotas>();

        mascotas.add(new Mascotas(R.drawable.perro,R.drawable.ic_hueso, R.drawable.ic_dog_bone_icon_134489, "Mario","4"));
        mascotas.add(new Mascotas(R.drawable.cerdo_animado,R.drawable.ic_hueso, R.drawable.ic_dog_bone_icon_134489,"Timmy","5"));
        mascotas.add(new Mascotas(R.drawable.gato,R.drawable.ic_hueso, R.drawable.ic_dog_bone_icon_134489,"Tom","2"));
        mascotas.add(new Mascotas(R.drawable.hamnster,R.drawable.ic_hueso, R.drawable.ic_dog_bone_icon_134489,"Jerry","3"));
        mascotas.add(new Mascotas(R.drawable.nutria, R.drawable.ic_hueso, R.drawable.ic_dog_bone_icon_134489,"Arturo","1"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.Favoritos){
            Intent Favoritos = new Intent(MainActivity.this,Favoritos.class);
            startActivity(Favoritos);
        }

        return super.onOptionsItemSelected(item);
    }
}