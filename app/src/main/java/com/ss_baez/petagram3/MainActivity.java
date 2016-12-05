package com.ss_baez.petagram3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ss_baez.petagram3.fragments.PerfilFragment;
import com.ss_baez.petagram3.fragments.RecyclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar     = (Toolbar) findViewById(R.id.toolbar);
        tabLayout   = (TabLayout) findViewById(R.id.tabLayout);
        viewPager   = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        toolbar.setTitle("");
        toolbar.setLogo(R.drawable.ic_huella);

        //Además se va a realizar una validación
        if (toolbar != null){
            //consiga:
            setSupportActionBar(toolbar);
        }


    }

    //2Para añadir los fragments a la lista
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment()); //Este se mostrara en el primer "tap"
        fragments.add(new PerfilFragment());
        return fragments;
    }

    //1Esto viene después del PageAdapter.class
    private void setUpViewPager(){ //Este metodo lo que hará sera poner en orbita los fragments

        //Para ello se tendran que añadir los fragments a un arreglo de fragments, que se hizo arriba
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments())); //Aquí se sta pasando la lista de fragments que se quieren agregar a PageAdapter
        //Una vez que ya se tiene el viewpager configurado se debe agregar a:
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_pets);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_my_dog);


    }

    //Menu de opciones para que lo muestre en la vista
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    //Para controlar que va a suceder dependiendo q se seleccione en el menu opciones
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu_likes:
                Toast.makeText(this, "Mascotas Favoritas", Toast.LENGTH_SHORT).show();
                Intent objIntent = new Intent(MainActivity.this, LikesMascotas.class);
                startActivity(objIntent);
                break;

            case R.id.menu_contacto:
                Toast.makeText(this, "Contacto", Toast.LENGTH_SHORT).show();
                Intent objIntent2 = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(objIntent2);
                break;

            case R.id.menu_acercade:
                Toast.makeText(this, "Acerca de", Toast.LENGTH_SHORT).show();
                Intent objIntent3 = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(objIntent3);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
