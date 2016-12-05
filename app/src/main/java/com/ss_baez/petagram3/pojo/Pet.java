package com.ss_baez.petagram3.pojo;

/**
 * Created by SS_Baez on 04/12/2016.
 */

public class Pet {

    private String nombre;
    private int foto;
    private String contador;

    public Pet(int foto, String nombre, String contador){
        this.foto = foto;
        this.nombre = nombre;
        this.contador = contador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getContador() {
        return contador;
    }

    public void setContador(String contador) {
        this.contador = contador;
    }
}
