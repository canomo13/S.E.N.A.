package com.example.joselito.senaprueba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.joselito.senaprueba.Basededatos.DBHelperProd;
import com.example.joselito.senaprueba.Basededatos.ObtenerWebService;
import com.example.joselito.senaprueba.GestionUsuarios.Login;
import com.example.joselito.senaprueba.GestionUsuarios.activity_registro;

import java.util.concurrent.ExecutionException;


public class ventana_ini extends AppCompatActivity implements View.OnClickListener {

    // IP de mi Url
    String IP = "http://basedatossena.esy.es/";
    // Rutas de los Web Services
    String GET = IP + "proyectosena/webservices/obtener_productos.php";

    private DBHelperProd db = new DBHelperProd(this);

    ObtenerWebService hiloconexion;

    private TextView nombre;
    private TextView subnombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        nombre = (TextView)findViewById(R.id.NombreAPP);
        subnombre=(TextView)findViewById(R.id.Subnombre);

        setContentView(R.layout.activity_ventana_ini);

        findViewById(R.id.boton_empezar).setOnClickListener(this);


        hiloconexion = new ObtenerWebService();
        try {
            hiloconexion.execute(GET, "1").get();
            hiloconexion.actualizarbasededatos(db);


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


       }



    @Override
    public void onClick(View v){

        if(v.getId()==R.id.boton_empezar){
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        }
        else{
            if (v.getId()==R.id.boton_registro){
                Intent intent = new Intent(this, activity_registro.class);
                startActivity(intent);
            }
        }


    }


}


