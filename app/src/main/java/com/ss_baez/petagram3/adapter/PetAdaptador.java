package com.ss_baez.petagram3.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ss_baez.petagram3.pojo.Pet;
import com.ss_baez.petagram3.R;

import java.util.ArrayList;

/**
 * Created by SS_Baez on 04/12/2016.
 */

public class PetAdaptador extends RecyclerView.Adapter<PetAdaptador.PetViewHolder> {

    ArrayList<Pet> pets;
    Activity objActivity;

    //Constructor que recibira un Arraylist
    public PetAdaptador(ArrayList<Pet> pets, Activity objActivity){
        this.pets = pets;
        this.objActivity = objActivity;
    }

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet, parent, false);
        return new PetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PetViewHolder holder, int position) {
        final Pet objPet = pets.get(position);
        holder.img_pet.setImageResource(objPet.getFoto());
        holder.tv_nombrePet.setText(objPet.getNombre());
        holder.tv_contadorLikes.setText(objPet.getContador());


        holder.btnImg_boneLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(objActivity, "Diste Like a " + objPet.getNombre(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder{

        private ImageView img_pet;
        private TextView tv_nombrePet;
        private ImageButton btnImg_boneLike;
        public TextView tv_contadorLikes;



        public PetViewHolder(View itemView) {
            super(itemView);

            img_pet = (ImageView) itemView.findViewById(R.id.img_pet);
            tv_nombrePet = (TextView) itemView.findViewById(R.id.tv_nombrePet);
            btnImg_boneLike = (ImageButton) itemView.findViewById(R.id.btnImg_boneLike);
            tv_contadorLikes = (TextView) itemView.findViewById(R.id.tv_contadorLikes);
        }
    }
}

