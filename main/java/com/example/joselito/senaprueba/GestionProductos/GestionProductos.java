package com.example.joselito.senaprueba.GestionProductos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joselito.senaprueba.Basededatos.DBHelperProd;
import com.example.joselito.senaprueba.Basededatos.ObtenerWebService;
import com.example.joselito.senaprueba.Basededatos.Producto;
import com.example.joselito.senaprueba.R;
import com.example.joselito.senaprueba.busquedaBBDD.busquedaBBDD;

/**
 * Created by joselito on 23/8/17.
 */

public class GestionProductos extends AppCompatActivity implements View.OnClickListener {

    public static final String codigobarras = "Codigo de Barras:";

    private TextView barcode;

    ObtenerWebService hiloconexion;

    String IP = "http://basedatossena.esy.es/";
    String DELETE = IP + "proyectosena/webservices//borrar_producto.php";

    private EditText nombreprod;
    private EditText kcal;
    private EditText proteinas;
    private EditText sat;
    private EditText sal;
    private EditText grasas;
    private EditText azucar;
    private EditText carbo;

    private String nombreaux;
    private String kcalaux;
    private String proteinasaux;
    private String sataux;
    private String salaux;
    private String grasasaux;
    private String azucaraux;
    private String carboaux;

    public static final String textoprueba = "";
    String codigodebarras;

    //Producto prod = new Producto();
    private DBHelperProd DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.gestion_productos);

        codigodebarras = getIntent().getStringExtra(codigobarras);

        barcode = (TextView) findViewById(R.id.barcode);
        barcode.setText(String.format("Código de Barras: %s", codigodebarras));

        nombreprod = (EditText) findViewById(R.id.ETnombre);
        kcal = (EditText) findViewById(R.id.ETkcal);
        proteinas = (EditText) findViewById(R.id.ETProteinas);
        sat = (EditText) findViewById(R.id.ETsat);
        sal = (EditText) findViewById(R.id.ETsal);
        grasas = (EditText) findViewById(R.id.ETgrasas);
        azucar = (EditText) findViewById(R.id.ETazucar);
        carbo = (EditText) findViewById(R.id.ETcarbo);

        nombreaux = String.valueOf(nombreprod.getText());
        Log.i(this.getClass().toString(), nombreprod.getText().toString());
        kcalaux = String.valueOf(kcal.getText());
        Log.i(this.getClass().toString(), kcalaux);
        proteinasaux = String.valueOf(proteinas.getText());
        Log.i(this.getClass().toString(), proteinasaux);
        sataux = String.valueOf(sat.getText());
        Log.i(this.getClass().toString(), sataux);
        salaux = String.valueOf(sal.getText());
        Log.i(this.getClass().toString(), salaux);
        grasasaux = String.valueOf(grasas.getText());
        Log.i(this.getClass().toString(), grasasaux);
        azucaraux = String.valueOf(azucar.getText());
        Log.i(this.getClass().toString(), azucaraux);
        carboaux = String.valueOf(carbo.getText());
        Log.i(this.getClass().toString(), carboaux);

        findViewById(R.id.registrar_producto).setOnClickListener(this);
        findViewById(R.id.actualizar_prod).setOnClickListener(this);

        DB = new DBHelperProd(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.registrar_producto) {
            addProducto(nombreprod.getText().toString(), kcal.getText().toString(), proteinas.getText().toString(),
                    sat.getText().toString(), sal.getText().toString(), grasas.getText().toString(),
                    azucar.getText().toString(), carbo.getText().toString(), codigodebarras);
            Intent intent = new Intent(this, busquedaBBDD.class);
            Log.i(this.getClass().toString(), "dentro de añadir " + nombreprod.getText().toString());
            intent.putExtra(busquedaBBDD.barcode, codigodebarras);
            startActivity(intent);
        }else if(v.getId() == R.id.actualizar_prod){
            updateProducto(nombreprod.getText().toString(), kcal.getText().toString(), proteinas.getText().toString(),
                    sat.getText().toString(), sal.getText().toString(), grasas.getText().toString(),
                    azucar.getText().toString(), carbo.getText().toString(), codigodebarras);
            Intent intent = new Intent(this, busquedaBBDD.class);
            Log.i(this.getClass().toString(), "dentro de añadir " + nombreprod.getText().toString());
            intent.putExtra(busquedaBBDD.barcode, codigodebarras);
            startActivity(intent);

        }
    }

    private void updateProducto(String nombre, String kcal, String colesterol, String grasas_sat, String sal, String
            grasas, String azucar, String carbohidratos, String codigo)
    {
        Producto prod = new Producto(codigo, nombre, kcal, carbohidratos, azucar, sal, colesterol, grasas, grasas_sat);

        hiloconexion = new ObtenerWebService();
        hiloconexion.execute(DELETE, "5",codigo);


        DB.updateProducto(prod);
        Toast.makeText(this, "Producto actualizado correctamente", Toast.LENGTH_SHORT).show();
    }


    private void addProducto(String nombre, String kcal, String colesterol, String grasas_sat, String sal, String
            grasas, String azucar, String carbohidratos, String codigo)
    {

     Producto prod = new Producto(codigo, nombre, kcal, carbohidratos, azucar, sal, colesterol, grasas, grasas_sat);

        DB.addProducto(prod);
        Toast.makeText(this, "Producto guardado correctamente", Toast.LENGTH_SHORT).show();
    }

}