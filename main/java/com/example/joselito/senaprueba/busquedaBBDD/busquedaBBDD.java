package com.example.joselito.senaprueba.busquedaBBDD;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.joselito.senaprueba.Basededatos.DBHelperProd;
import com.example.joselito.senaprueba.Basededatos.Producto;
import com.example.joselito.senaprueba.LectorOCR.LectorOCR;
import com.example.joselito.senaprueba.R;
import com.example.joselito.senaprueba.barcodereader.LectorCodigos;


/**
 * Created by joselito on 8/7/17.
 */

public class busquedaBBDD extends AppCompatActivity implements View.OnClickListener{
    public static String barcode = "codigo:";

    private String codBarras;

    /** Base de Datos **/

   // private DBHandlerProducto productohelper;
    private DBHelperProd db = new DBHelperProd(this);
    Producto prod;
    //List<Producto> ListaProd;

    private TextView mensaje;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);

        String codigo = getIntent().getStringExtra(barcode);

        TextView vista = (TextView) findViewById(R.id.barcode_value);
        codBarras = codigo;
        vista.setText(codigo);
        findViewById(R.id.volver).setOnClickListener(this);
        findViewById(R.id.cambio_boton).setOnClickListener(this);

        mensaje = (TextView)findViewById(R.id.mensaje);



        boolean aux = db.consultarcodigo(codigo);

        if(aux)
        {
            prod = db.getProducto(codigo);
            mensaje.setText("El producto está registrado");
            pintarsemaforo(prod);
        }else{
            mensaje.setText("El producto no está registrado. Por favor pulse en Leer Valores");
        }

    }

    private void pintarsemaforo(Producto prod) {

        Intent sem = new Intent(this, Semaforo.class);
        sem.putExtra(Semaforo.cod, codBarras);
        startActivity(sem);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.volver) {
            Intent intent = new Intent(this, LectorCodigos.class);
            startActivity(intent);
        } else {
            if (v.getId() == R.id.cambio_boton) {
                Intent OCRintent = new Intent(busquedaBBDD.this, LectorOCR.class);
                OCRintent.putExtra(LectorOCR.Barcode ,codBarras);
                startActivity(OCRintent);
            }


        }
    }
}
