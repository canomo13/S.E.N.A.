package com.example.joselito.senaprueba.Basededatos;

/**
 * Created by joselito on 7/9/17.
 */


import static java.lang.String.format;

/**
 * Created by joselito on 28/5/17.
 */

public class Producto
{

    private String Codigo;

    private String Nombre;

    private String kCal;

    private String Carbohidratos;

    private String azucar;

    private String Sal;

    private String Proteinas;

    private String Grasas;

    private String Sat;

    @Override
    public String toString(){
        return format("%s, %s, %s, %s %s, %s, %s, %S, %s", Codigo, Nombre,
                kCal, Carbohidratos, azucar, Sal, Proteinas, Grasas, Sat);
    }

    //Constructores

    public Producto(){}

    public Producto(String codigo, String nombre, String kCalorias, String carbohidratos, String  azucar, String sal, String proteinas, String grasas, String Grasassat){

        this.Codigo=codigo;
        this.Nombre=nombre;
        this.Carbohidratos=carbohidratos;
        this.azucar=azucar;
        this.Proteinas=proteinas;
        this.kCal=kCalorias;
        this.Sal=sal;
        this.Grasas=grasas;
        this.Sat=Grasassat;

    }

    //Getters y Setters

    public String getCodigo(){
        return Codigo;
    }

    public void setCodigo(String codigo){
        this.Codigo=codigo;
    }

    public String getNombre(){
        return Nombre;
    }

    public void setNombre(String nombre){
        this.Nombre=nombre;
    }

    public String getkCal(){
        return kCal;
    }

    public void setkCal(String kcalorias){
        this.kCal=kcalorias;
    }

    public String getCarbohidratos(){
        return Carbohidratos;
    }

    public void setCarbohidratos(String carbo){
        this.Carbohidratos=carbo;
    }

    public String getAzucar(){
        return azucar;
    }

    public void setAzucar(String azucar){
        this.azucar=azucar;
    }

    public String getSal(){
        return Sal;
    }

    public void setSal(String sal){
        this.Sal=sal;
    }

    public String getProteinas(){
        return Proteinas;
    }

    public void setProteinas(String colesterol){
        this.Proteinas=colesterol;
    }

    public String getGrasas(){
        return Grasas;
    }

    public void setGrasas(String grasas){
        this.Grasas=grasas;
    }

    public String getGrasas_Sat(){
        return Sat;
    }

    public void setGrasas_Sat(String grasas_sat){
        this.Sat=grasas_sat;
    }
}

