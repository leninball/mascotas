package com.leninball.appmascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);


        GridLayoutManager glm = new GridLayoutManager(this,1);

        listaMascotas.setLayoutManager(glm);


        inicializarListaMascotas();
        inicializarAdaptador();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            case R.id.mStar:
                Intent intent = new Intent(this,ListadoMascotas.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.dog_icon_36985, "Perritu",1));
        mascotas.add(new Mascota(R.drawable.lenin, "Lenin",1));
        mascotas.add(new Mascota(R.drawable.frank, "Frank",1));
        mascotas.add(new Mascota(R.drawable.cow_icon_36988, "Jessica",1));
        mascotas.add(new Mascota(R.drawable.turtle_64, "Rafael",1));
    }

}
