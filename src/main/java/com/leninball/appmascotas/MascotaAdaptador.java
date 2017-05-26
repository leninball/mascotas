package com.leninball.appmascotas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Lenin on 29/04/2017.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.ContactoViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;


    public MascotaAdaptador(ArrayList<Mascota> mascota, Activity activity){
        this.mascotas = mascota;
        this.activity = activity;
    }

    //Inflar el layout y lo pasará al viewholder para que el obtenga los view
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pets,parent,false);
        return new ContactoViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada bind
    @Override
    public void onBindViewHolder(ContactoViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgFotoMascota.setImageResource(mascota.getFoto());
        holder.tvNombreMascota.setText(mascota.getNombre());
        holder.tvRatingMascota.setText(String.valueOf(mascota.getLikes()));

        holder.imgFotoMascota.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(activity,mascota.getNombre(),Toast.LENGTH_SHORT).show();
                /*Intent intent = new Intent(activity,DetalleContacto.class);
                intent.putExtra("nombre",contacto.getNombre());
                intent.putExtra("telefono",contacto.getTelefono());
                intent.putExtra("email",contacto.getEmail());
                activity.startActivity(intent);*/
            }
        });

        holder.btnLike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,"Diste like a " + mascota.getNombre(),Toast.LENGTH_SHORT).show ();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFotoMascota;
        private TextView tvNombreMascota;
        private TextView tvRatingMascota;
        private ImageButton btnLike;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFotoMascota = (ImageView) itemView.findViewById(R.id.imgFotoMascota);
            tvNombreMascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvRatingMascota = (TextView) itemView.findViewById(R.id.tvRatingMascota);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
    }
