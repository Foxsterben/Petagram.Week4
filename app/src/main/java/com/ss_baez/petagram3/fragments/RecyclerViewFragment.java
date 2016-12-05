package com.ss_baez.petagram3.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ss_baez.petagram3.pojo.Pet;
import com.ss_baez.petagram3.adapter.PetAdaptador;
import com.ss_baez.petagram3.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    private ArrayList<Pet> pets;
    private RecyclerView listaPets;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        listaPets = (RecyclerView) v.findViewById(R.id.rv_pets);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaPets.setLayoutManager(llm);
        inicializarListaPets();
        inicializarAdaptador();

        return v;
    }

    public void inicializarListaPets(){
        pets = new ArrayList<Pet>();

        pets.add(new Pet(R.drawable.pet1, "Toby", "4"));
        pets.add(new Pet(R.drawable.pet2, "Chaks", "2"));
        pets.add(new Pet(R.drawable.pet3, "Vektor", "6"));
        pets.add(new Pet(R.drawable.pet4, "René", "10"));
        pets.add(new Pet(R.drawable.pet5, "Paco", "2"));
    }

    public PetAdaptador objAdaptador;
    public void inicializarAdaptador(){
        objAdaptador = new PetAdaptador(pets, getActivity());
        listaPets.setAdapter(objAdaptador);
    }

}
