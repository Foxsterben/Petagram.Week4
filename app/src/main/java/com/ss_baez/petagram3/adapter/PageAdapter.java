package com.ss_baez.petagram3.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by SS_Baez on 04/12/2016.
 */

public class PageAdapter extends FragmentPagerAdapter {

    //Además se va a manejar una variable:
    private ArrayList<Fragment> fragments; //Un arreglo de fragmentos

    public PageAdapter(FragmentManager fm, ArrayList<Fragment> fragments) { //Al constructor se le agrega un ArrayList
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position); //Lo que se va a estar devolviendo sera un fragment en particular, a partir de la posicion
    }

    @Override
    public int getCount() {
        return fragments.size(); //Se estará devolviendo el tamaño de la lista de fragments
    }
}
