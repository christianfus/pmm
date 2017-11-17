package com.example.chrsol.examen_christianmolto;

import java.io.Serializable;

public class Pizzas implements Serializable{
    private  String nombre;
    private  String descripcion;
    private  double precio;

    public Pizzas (String nombre, String descripcion, double precio){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public  String getnombre (){
        return nombre;
    }
    public  String getdescripcion (){return descripcion;}
    public  double getPrecio (){
        return precio;
    }
}
