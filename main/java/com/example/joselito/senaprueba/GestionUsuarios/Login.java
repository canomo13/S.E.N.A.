package com.example.joselito.senaprueba.GestionUsuarios;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.joselito.senaprueba.Basededatos.DBHelperUser;
import com.example.joselito.senaprueba.Basededatos.Usuario;
import com.example.joselito.senaprueba.R;
import com.example.joselito.senaprueba.barcodereader.LectorCodigos;

import java.util.Objects;

/**
 * Created by joselito on 11/9/17.
 */

public class Login extends AppCompatActivity implements View.OnClickListener{

    private EditText user;
    private EditText pass;

    private TextView mensaje;

    private Button login;
    private Button registrarse;

    private DBHelperUser DB = new DBHelperUser(this);
    private Usuario usuario_aux;
    private boolean aux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

        user=(EditText)findViewById(R.id.txtUserNameLogin);
        pass=(EditText)findViewById(R.id.txtPassLogin);

        mensaje=(TextView)findViewById(R.id.Mensaje);

        login=(Button)findViewById(R.id.boton_login);
        login.setOnClickListener(this);

        registrarse=(Button)findViewById(R.id.boton_registro);
        registrarse.setOnClickListener(this);


        Log.d(this.getClass().toString(), user.getText().toString());
        Log.d(this.getClass().toString(), String.valueOf(aux));



    }

    private void pasarpantalla(boolean auxiliar) {


        usuario_aux= new Usuario();

        if(auxiliar)
        {
            usuario_aux = DB.getUser(user.getText().toString());

            Log.d(this.getClass().toString(), user.getText().toString());
            Log.d(this.getClass().toString(), pass.getText().toString());
            Log.d(this.getClass().toString() + " Pass ", usuario_aux.getPass());
            Log.d(this.getClass().toString() + " Apellidos ", usuario_aux.getApellidos());
            Log.d(this.getClass().toString() + " Edad ", usuario_aux.getEdad());
            Log.d(this.getClass().toString() + " Nombre ", usuario_aux.getNombre());
            Log.d(this.getClass().toString() + " Username ", usuario_aux.getUsername());
            Log.d(this.getClass().toString() + " Correo ", usuario_aux.getCorreo());

            if (Objects.equals(pass.getText().toString(), usuario_aux.getPass()))
            {
                Intent intent = new Intent(this, LectorCodigos.class);
                startActivity(intent);
            }
            else{
                mensaje.setText("Contraseña incorrecta");
            }
        }else{
            mensaje.setText("Usuario no encontrado. Registrese para continuar");
        }

    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.boton_login){
            aux = DB.consultarusuario(user.getText().toString());
            pasarpantalla(aux);
        }else{
            if (v.getId()==R.id.boton_registro){
                Intent intent = new Intent(this, activity_registro.class);
                startActivity(intent);
            }
        }

    }
}
