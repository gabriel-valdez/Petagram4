package com.gabrielvaldez.petagram.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.se.omapi.Session;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gabrielvaldez.petagram.R;

import java.util.Properties;

public class Contacto extends AppCompatActivity {

    EditText NombreContacto;
    EditText EmailContacto;
    EditText Mensaje;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NombreContacto = findViewById(R.id.etNombreContacto);
        EmailContacto = findViewById(R.id.etEmail);
        Mensaje = findViewById(R.id.etMensaje);

    }
    public void EnviarMail(View v){

        String EnviarCorreo = EmailContacto.getText().toString();
        String Nombre = NombreContacto.getText().toString();
        String EnviarMensaje = Mensaje.getText().toString();

        Intent I = new Intent(Intent.ACTION_SEND);
        I.putExtra(Intent.EXTRA_EMAIL, new String[]{EnviarCorreo});
        I.putExtra(Intent.EXTRA_SUBJECT,Nombre);
        I.putExtra(Intent.EXTRA_TEXT,EnviarMensaje);
        I.setType("messege/rfc822");
        startActivity(Intent.createChooser(I, "Email"));

    }
}
