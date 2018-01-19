package com.example.chrsol.basededatos;

public class Cliente {

    private String nombre;
    private int codigo;
    private String telefono;

    public Cliente(String nom, int cod, String tel) {
        nombre = nom;
        codigo = cod;
        telefono = tel;
    }

    public String getNombre(){

        return nombre;
    }

    public int getCodigo(){

        return codigo;
    }
    public String getTelefono(){

        return telefono;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }


}
