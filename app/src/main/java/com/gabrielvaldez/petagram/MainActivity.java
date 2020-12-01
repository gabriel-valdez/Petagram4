package com.gabrielvaldez.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.gabrielvaldez.petagram.Activities.Contacto;
import com.gabrielvaldez.petagram.Adapter.PageAdapter;
import com.gabrielvaldez.petagram.Fragments.RecyclerView_Fragment1;
import com.gabrielvaldez.petagram.Fragments.RecyclerView_Fragment2;
import com.gabrielvaldez.petagram.Pojo.Mascotas;
import com.gabrielvaldez.petagram.Adapter.MascotaAdaptador;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.TabLayout);
        viewPager = (ViewPager) findViewById(R.id.ViewPager);

        setUpViewPager();

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    private ArrayList<Fragment> agregarFraments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerView_Fragment1());
        fragments.add(new RecyclerView_Fragment2());
        return fragments;
    }

    public void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFraments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_casa);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perro);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Favoritos:
                Intent Favoritos = new Intent(MainActivity.this, com.gabrielvaldez.petagram.Activities.Favoritos.class);
                startActivity(Favoritos);
                break;
            case R.id.Contacto:
                Intent Contactos = new Intent(MainActivity.this, Contacto.class);
                startActivity(Contactos);
                break;
            case R.id.AcercaDe:
                Intent AcercaDe = new Intent(MainActivity.this, com.gabrielvaldez.petagram.Activities.AcercaDe.class);
                startActivity(AcercaDe);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}