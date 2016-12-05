package com.ss_baez.petagram3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.ss_baez.petagram3.adapter.PetAdaptador;
import com.ss_baez.petagram3.pojo.Pet;

import java.util.ArrayList;

public class LikesMascotas extends AppCompatActivity {

    private ArrayList<Pet> pets;
    private RecyclerView listaPets;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likes_mascotas);

        //agrega el action bar
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        //ocultar el nombre de la app que muestra por defecto
        getSupportActionBar().setTitle(null);
        //agregar la flechita que da hacia atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaPets = (RecyclerView) findViewById(R.id.rv_pets);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaPets.setLayoutManager(llm);
        inicializarListaPets();
        inicializarAdaptador();

    }

    public PetAdaptador objAdaptador;
    public void inicializarAdaptador(){
        objAdaptador = new PetAdaptador(pets, this);
        listaPets.setAdapter(objAdaptador);
    }

    public void inicializarListaPets(){
        pets = new ArrayList<Pet>();

        pets.add(new Pet(R.drawable.pet5, "Paco", "2"));
        pets.add(new Pet(R.drawable.pet4, "René", "10"));
        pets.add(new Pet(R.drawable.pet2, "Chaks", "2"));
        pets.add(new Pet(R.drawable.pet3, "Vektor", "6"));
        pets.add(new Pet(R.drawable.pet1, "Toby", "4"));
    }
}
