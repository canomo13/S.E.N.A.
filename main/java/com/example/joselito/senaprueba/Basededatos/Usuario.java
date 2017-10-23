package com.example.joselito.senaprueba.Basededatos;


import static java.lang.String.format;

/**
 * Created by joselito on 27/7/17.
 */

public class Usuario {

    public String Nombre;

    public String Apellidos;

    public String Correo;

    public String Username;

    public String Pass;

    public String Edad;

    @Override
    public String toString(){
        return format("%s, %s, %s, %s, %s, %s", Nombre, Apellidos, Correo, Username, Pass, Edad);
    }
    /**
     * Constructores
     **/

    public Usuario() {
    }

    public Usuario(String Nombre, String Apellidos, String Correo, String Username, String Pass, String Edad){

        this.Nombre=Nombre;
        this.Apellidos=Apellidos;
        this.Correo=Correo;
        this.Username=Username;
        this.Pass=Pass;
        this.Edad=Edad;
    }


    /** Getter y Setter **/


    public void setNombre(String nombre) {this.Nombre = nombre;}

    public String getNombre(){return Nombre;}

    public void setApellidos(String apellidos){this.Apellidos = apellidos;}

    public String getApellidos(){return Apellidos;}

    public void setCorreo(String correo){this.Correo = correo;}

    public String getCorreo(){return Correo;}

    public void setUsername(String user){this.Username = user;}

    public String getUsername(){return Username;}

    public void setPass(String password){this.Pass = password;}

    public String getPass(){return Pass;}

    public void setEdad(String Edad){this.Edad = Edad;}

    public String getEdad(){return Edad;}

}