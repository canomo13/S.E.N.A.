package com.example.joselito.senaprueba.GestionUsuarios;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.joselito.senaprueba.Basededatos.DBHelperUser;
import com.example.joselito.senaprueba.Basededatos.Usuario;
import com.example.joselito.senaprueba.R;
import com.example.joselito.senaprueba.barcodereader.LectorCodigos;


/**
 * Created by joselito on 17/8/17.
 */

public class activity_registro extends AppCompatActivity implements View.OnClickListener {


    private DBHelperUser DB;

    private EditText Nombre;
    private EditText Apellidos;
    private EditText Correo;
    private EditText user;
    private EditText pass;
    private EditText edad;


    String TAG = "Prueba";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registro);

        Nombre = (EditText) findViewById(R.id.txtNombre_del_usuario);
        Apellidos = (EditText) findViewById(R.id.txtApellido_del_usuario);
        Correo = (EditText) findViewById(R.id.txtEmail);
        user = (EditText) findViewById(R.id.txtUserName);
        pass = (EditText) findViewById(R.id.txtPass);
        edad = (EditText) findViewById(R.id.txtEdad);

        DB = new DBHelperUser(this);


        findViewById(R.id.boton_registro).setOnClickListener(this);

    }

    private void addusuario(String nombre, String apellidos, String correo, String user, String pass, String edad) {

        Usuario usuario = new Usuario(nombre, apellidos, correo, user, pass, edad);
        Log.i(TAG, "Llega hasta aqui" + usuario.toString());

        DB.addUser(usuario);

    }

    @Override
    public void onClick(View v){
        if (v.getId()==R.id.boton_registro){
            addusuario(Nombre.getText().toString(), Apellidos.getText().toString(), Correo.getText().toString(),
                    user.getText().toString(), pass.getText().toString(), edad.getText().toString());
            Intent intent = new Intent(this, LectorCodigos.class);
            startActivity(intent);
        }

    }



}
