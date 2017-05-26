package com.leninball.appmascotas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

/**
 * Created by Lenin on 14/05/2017.
 */

public class ListadoMascotas extends AppCompatActivity{

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvFavoritas);


        GridLayoutManager glm = new GridLayoutManager(this,1);

        listaMascotas.setLayoutManager(glm);


        mostrarMascotasFavoritas();
    }



    public void mostrarMascotasFavoritas(){


        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.cow_icon_36988, "Jessica",1));
        mascotas.add(new Mascota(R.drawable.lenin, "Lenin",1));
        mascotas.add(new Mascota(R.drawable.frank, "Frank",1));
        mascotas.add(new Mascota(R.drawable.turtle_64, "Rafael",1));
        mascotas.add(new Mascota(R.drawable.dog_icon_36985, "Perritu",1));

        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }

}

