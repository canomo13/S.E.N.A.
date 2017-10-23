package com.example.joselito.senaprueba.busquedaBBDD;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.joselito.senaprueba.Basededatos.DBHelperProd;
import com.example.joselito.senaprueba.Basededatos.Producto;
import com.example.joselito.senaprueba.GestionProductos.GestionProductos;
import com.example.joselito.senaprueba.R;
import com.example.joselito.senaprueba.barcodereader.LectorCodigos;

import java.util.Objects;

/**
 * Created by joselito on 10/9/17.
 */

public class Semaforo extends AppCompatActivity implements View.OnClickListener{

    public static String cod = "codigo:";

    private TextView kcal2;
    private TextView proteinas2;
    private TextView sat2;
    private TextView sal2;
    private TextView grasas2;
    private TextView azucar2;
    private TextView carbo2;
    private String codigo;

    private DBHelperProd db = new DBHelperProd(this);



    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.semaforo);

        codigo = getIntent().getStringExtra(cod);

        String barcode = codigo;
        kcal2 = (TextView) findViewById(R.id.kcal2);
        TextView nombreprod2 = (TextView) findViewById(R.id.nombreprod2);
        proteinas2 = (TextView) findViewById(R.id.proteinas2);
        sat2 = (TextView) findViewById(R.id.sat2);
        sal2 = (TextView) findViewById(R.id.sal2);
        grasas2 = (TextView) findViewById(R.id.grasas2);
        azucar2 = (TextView) findViewById(R.id.azucar2);
        carbo2 = (TextView) findViewById(R.id.carbo2);


        findViewById(R.id.volver_sem).setOnClickListener(this);
        findViewById(R.id.actualizar).setOnClickListener(this);

        Producto prod_aux = db.getProducto(barcode);

        String kcal_aux=prod_aux.getkCal();
        String carbo_aux=prod_aux.getCarbohidratos();

        nombreprod2.setText(prod_aux.getNombre());
        nombreprod2.setTypeface(nombreprod2.getTypeface(), Typeface.BOLD_ITALIC);
        if(Objects.equals(kcal_aux, "")){
            pintarkcal("0");

        }else{
            pintarkcal(prod_aux.getkCal());
        }
        pintarproteinas(prod_aux.getProteinas());
        pintarsal(prod_aux.getSal());
        if(Objects.equals(carbo_aux, "")){
            pintarcarbo("0");
        }else{
            pintarcarbo(prod_aux.getCarbohidratos());
        }
        pintarazucar(prod_aux.getAzucar());
        pintargrasas(prod_aux.getGrasas());
        pintarsat(prod_aux.getGrasas_Sat());
        Log.i(this.getClass().toString(), "SAL: " + prod_aux.getSal());
        Log.i(this.getClass().toString(), "kCal: " + prod_aux.getkCal());



    }

    public void onClick(View v)
    {
        if (v.getId() == R.id.volver_sem) {
            Intent intent = new Intent(this, LectorCodigos.class);
            startActivity(intent);
        }else if (v.getId() == R.id.actualizar){
            Intent intent = new Intent(this, GestionProductos.class);
            intent.putExtra(GestionProductos.codigobarras, codigo);
            startActivity(intent);
        }
    }

    private void pintarsat(String grasas_sat)
    {
        String auxiliar="";
        Log.d(this.getClass().toString(), grasas_sat);
        Log.d(this.getClass().toString(), String.valueOf(grasas_sat.length()));
        for (int i=0; i<grasas_sat.length();i++)
        {
            Log.d(this.getClass().toString(), String.valueOf(grasas_sat.charAt(i)));
            if (Objects.equals(String.valueOf(grasas_sat.charAt(i)), ",") || Objects.equals(String.valueOf(grasas_sat.charAt(i)), "0") ||
                    Objects.equals(String.valueOf(grasas_sat.charAt(i)), "1") || Objects.equals(String.valueOf(grasas_sat.charAt(i)), "2") ||
                    Objects.equals(String.valueOf(grasas_sat.charAt(i)), "3") || Objects.equals(String.valueOf(grasas_sat.charAt(i)), "4") ||
                    Objects.equals(String.valueOf(grasas_sat.charAt(i)), "5") || Objects.equals(String.valueOf(grasas_sat.charAt(i)), "6") ||
                    Objects.equals(String.valueOf(grasas_sat.charAt(i)), "7") || Objects.equals(String.valueOf(grasas_sat.charAt(i)), "8") ||
                    Objects.equals(String.valueOf(grasas_sat.charAt(i)), "9") || Objects.equals(String.valueOf(grasas_sat.charAt(i)), "."))
            {
                if (Objects.equals(String.valueOf(grasas_sat.charAt(i)), ",")) {
                    auxiliar = auxiliar + ".";
                } else {
                    auxiliar = auxiliar + grasas_sat.charAt(i);
                    Log.d(this.getClass().toString(), "entra en el if");
                    Log.d(this.getClass().toString(), auxiliar);
                }
            }
        }
        Log.i("Dentro de pintarsat"+ this.getClass().toString(),grasas_sat);
        if (Double.parseDouble(auxiliar) < 6)
        {
            sat2.setText(grasas_sat);
            sat2.setTextColor(Color.parseColor("#FFFFFF"));
            sat2.setBackgroundColor(Color.parseColor("#117B01"));
        }
        else
        {
            if (Double.parseDouble(auxiliar) >= 6 && Double.parseDouble(auxiliar) < 12   )
            {
                sat2.setText(grasas_sat);
                sat2.setTextColor(Color.parseColor("#000000"));
                sat2.setBackgroundColor(Color.parseColor("#FFC300"));
            }
            else
            {
                if (Double.parseDouble(auxiliar) >= 12)
                {
                    Log.d("Dentro del ultimo if"+this.getClass().toString(), grasas_sat);
                    sat2.setText(grasas_sat);
                    sat2.setTextColor(Color.parseColor("#FFFFFF"));
                    sat2.setBackgroundColor(Color.parseColor("#ff0000"));
                }
            }
        }
    }

    private void pintargrasas(String grasas)
    {
        String auxiliar="";
        Log.d(this.getClass().toString(), grasas);
        Log.d(this.getClass().toString(), String.valueOf(grasas.length()));
        for (int i=0; i<grasas.length();i++)
        {
            Log.d(this.getClass().toString(), String.valueOf(grasas.charAt(i)));
            if (Objects.equals(String.valueOf(grasas.charAt(i)), ",") || Objects.equals(String.valueOf(grasas.charAt(i)), "0") ||
                    Objects.equals(String.valueOf(grasas.charAt(i)), "1") || Objects.equals(String.valueOf(grasas.charAt(i)), "2") ||
                    Objects.equals(String.valueOf(grasas.charAt(i)), "3") || Objects.equals(String.valueOf(grasas.charAt(i)), "4") ||
                    Objects.equals(String.valueOf(grasas.charAt(i)), "5") || Objects.equals(String.valueOf(grasas.charAt(i)), "6") ||
                    Objects.equals(String.valueOf(grasas.charAt(i)), "7") || Objects.equals(String.valueOf(grasas.charAt(i)), "8") ||
                    Objects.equals(String.valueOf(grasas.charAt(i)), "9") || Objects.equals(String.valueOf(grasas.charAt(i)), "."))
            {
                if (Objects.equals(String.valueOf(grasas.charAt(i)), ",")) {
                    auxiliar = auxiliar + ".";
                } else {
                    auxiliar = auxiliar + grasas.charAt(i);
                }
            }
        }
        Log.d(this.getClass().toString(), auxiliar);
        if (Double.parseDouble(auxiliar) < 19.5)
        {
            grasas2.setText(grasas);
            grasas2.setTextColor(Color.parseColor("#FFFFFF"));
            grasas2.setBackgroundColor(Color.parseColor("#117B01"));
        }
        else
        {
            if (Double.parseDouble(auxiliar) >= 19.5 && Double.parseDouble(auxiliar) < 39)
            {
                grasas2.setText(grasas);
                grasas2.setTextColor(Color.parseColor("#000000"));
                grasas2.setBackgroundColor(Color.parseColor("#FFC300"));
            }
            else
            {
                if (Double.parseDouble(auxiliar) >= 39)
                {
                    grasas2.setText(grasas);
                    grasas2.setTextColor(Color.parseColor("#FFFFFF"));
                    grasas2.setBackgroundColor(Color.parseColor("#ff0000"));
                }
            }
        }

    }

    private void pintarazucar(String azucar)
    {
        String auxiliar="";
        Log.d(this.getClass().toString(), azucar);
        Log.d(this.getClass().toString(), String.valueOf(azucar.length()));
        for (int i=0; i<azucar.length();i++){
            Log.d(this.getClass().toString(), String.valueOf(azucar.charAt(i)));
            if(Objects.equals(String.valueOf(azucar.charAt(i)), ",")|| Objects.equals(String.valueOf(azucar.charAt(i)), "0") || Objects.equals(String.valueOf(azucar.charAt(i)), "1") || Objects.equals(String.valueOf(azucar.charAt(i)), "2") ||
                    Objects.equals(String.valueOf(azucar.charAt(i)), "3") || Objects.equals(String.valueOf(azucar.charAt(i)), "4") || Objects.equals(String.valueOf(azucar.charAt(i)), "5") ||
                    Objects.equals(String.valueOf(azucar.charAt(i)), "6") || Objects.equals(String.valueOf(azucar.charAt(i)), "7") || Objects.equals(String.valueOf(azucar.charAt(i)), "8") ||
                    Objects.equals(String.valueOf(azucar.charAt(i)), "9") || Objects.equals(String.valueOf(azucar.charAt(i)), "."))
            {
                if(Objects.equals(String.valueOf(azucar.charAt(i)), ","))
                {
                    auxiliar = auxiliar + ".";
                }
                else {
                    auxiliar = auxiliar + azucar.charAt(i);
                    Log.d(this.getClass().toString(), "entra en el if");
                    Log.d(this.getClass().toString(), "Azucar: " + auxiliar);
                }
            }
        }Log.d(this.getClass().toString(), auxiliar);
        if (Double.parseDouble(auxiliar) < 7.5)
        {
            azucar2.setText(azucar);
            azucar2.setTextColor(Color.parseColor("#FFFFFF"));
            azucar2.setBackgroundColor(Color.parseColor("#117B01"));
        }
        else
        {
            if (Double.parseDouble(auxiliar) >= 7.5 && Double.parseDouble(auxiliar) < 15)
            {
                azucar2.setText(azucar);
                azucar2.setTextColor(Color.parseColor("#000000"));
                azucar2.setBackgroundColor(Color.parseColor("#FFC300"));
            }
            else
            {
                if (Double.parseDouble(auxiliar) >= 15)
                {
                    azucar2.setText(azucar);
                    azucar2.setTextColor(Color.parseColor("#FFFFFF"));
                    azucar2.setBackgroundColor(Color.parseColor("#ff0000"));
                }
            }
        }

    }

    private void pintarcarbo(String carbohidratos)
    {
        String auxiliar="";
        Log.d(this.getClass().toString(), carbohidratos);
        Log.d(this.getClass().toString(), String.valueOf(carbohidratos.length()));
        for (int i=0; i<carbohidratos.length();i++)
        {
            Log.d(this.getClass().toString(), String.valueOf(carbohidratos.charAt(i)));
            if (Objects.equals(String.valueOf(carbohidratos.charAt(i)), ",") || Objects.equals(String.valueOf(carbohidratos.charAt(i)), "0") ||
                    Objects.equals(String.valueOf(carbohidratos.charAt(i)), "1") || Objects.equals(String.valueOf(carbohidratos.charAt(i)), "2") ||
                    Objects.equals(String.valueOf(carbohidratos.charAt(i)), "3") || Objects.equals(String.valueOf(carbohidratos.charAt(i)), "4") ||
                    Objects.equals(String.valueOf(carbohidratos.charAt(i)), "5") || Objects.equals(String.valueOf(carbohidratos.charAt(i)), "6") ||
                    Objects.equals(String.valueOf(carbohidratos.charAt(i)), "7") || Objects.equals(String.valueOf(carbohidratos.charAt(i)), "8") ||
                    Objects.equals(String.valueOf(carbohidratos.charAt(i)), "9") || Objects.equals(String.valueOf(carbohidratos.charAt(i)), "."))
            {
                if (Objects.equals(String.valueOf(carbohidratos.charAt(i)), ",")) {
                    auxiliar = auxiliar + ".";
                } else {
                    auxiliar = auxiliar + carbohidratos.charAt(i);
                    Log.d(this.getClass().toString(), "entra en el if");
                    Log.d(this.getClass().toString(), auxiliar);
                }
            }
        }
        if (Double.parseDouble(auxiliar) < 90)
        {
            carbo2.setText(carbohidratos);
            carbo2.setTextColor(Color.parseColor("#FFFFFF"));
            carbo2.setBackgroundColor(Color.parseColor("#117B01"));
        }
        else
        {
            if (Double.parseDouble(auxiliar) >= 90 && Double.parseDouble(auxiliar) < 180)
            {
                carbo2.setText(carbohidratos);
                carbo2.setTextColor(Color.parseColor("#000000"));
                carbo2.setBackgroundColor(Color.parseColor("#FFC300"));
            }
            else
            {
                if (Double.parseDouble(auxiliar) >= 180)
                {
                    carbo2.setText(carbohidratos);
                    carbo2.setTextColor(Color.parseColor("#FFFFFF"));
                    carbo2.setBackgroundColor(Color.parseColor("#ff0000"));
                }
            }
        }
    }

    private void pintarsal(String sal)
    {
        String auxiliar="";
        Log.d(this.getClass().toString(), sal);
        Log.d(this.getClass().toString(), String.valueOf(sal.length()));
        for (int i=0; i<sal.length();i++)
        {
            Log.d(this.getClass().toString(), String.valueOf(sal.charAt(i)));
            if (Objects.equals(String.valueOf(sal.charAt(i)), ",") || Objects.equals(String.valueOf(sal.charAt(i)), "0") ||
                    Objects.equals(String.valueOf(sal.charAt(i)), "1") || Objects.equals(String.valueOf(sal.charAt(i)), "2") ||
                    Objects.equals(String.valueOf(sal.charAt(i)), "3") || Objects.equals(String.valueOf(sal.charAt(i)), "4") ||
                    Objects.equals(String.valueOf(sal.charAt(i)), "5") || Objects.equals(String.valueOf(sal.charAt(i)), "6") ||
                    Objects.equals(String.valueOf(sal.charAt(i)), "7") || Objects.equals(String.valueOf(sal.charAt(i)), "8") ||
                    Objects.equals(String.valueOf(sal.charAt(i)), "9") || Objects.equals(String.valueOf(sal.charAt(i)), "."))
            {
                if (Objects.equals(String.valueOf(sal.charAt(i)), ",")) {
                    auxiliar = auxiliar + ".";
                } else {
                    auxiliar = auxiliar + sal.charAt(i);
                    Log.d(this.getClass().toString(), "entra en el if");
                    Log.d(this.getClass().toString(), auxiliar);
                }
            }
        }

        if (Double.parseDouble(auxiliar) < 1.5)
        {
            sal2.setText(sal);
            sal2.setTextColor(Color.parseColor("#FFFFFF"));
            sal2.setBackgroundColor(Color.parseColor("#117B01"));
        }
        else
        {
            if (Double.parseDouble(auxiliar) >= 1.5 && Double.parseDouble(auxiliar) < 3)
            {
                sal2.setText(sal);
                sal2.setTextColor(Color.parseColor("#000000"));
                sal2.setBackgroundColor(Color.parseColor("#FFC300"));
            }
            else
            {
                if (Double.parseDouble(auxiliar) >= 3)
                {
                    sal2.setText(sal);
                    sal2.setTextColor(Color.parseColor("#FFFFFF"));
                    sal2.setBackgroundColor(Color.parseColor("#ff0000"));
                }
            }
        }
    }

    private void pintarproteinas(String proteinas)
    {
        String auxiliar="";
        Log.d(this.getClass().toString(), proteinas);
        Log.d(this.getClass().toString(), String.valueOf(proteinas.length()));
        for (int i=0; i<proteinas.length();i++){
            Log.d(this.getClass().toString(), String.valueOf(proteinas.charAt(i)));
            if(Objects.equals(String.valueOf(proteinas.charAt(i)), ",")|| Objects.equals(String.valueOf(proteinas.charAt(i)), "0") || Objects.equals(String.valueOf(proteinas.charAt(i)), "1") || Objects.equals(String.valueOf(proteinas.charAt(i)), "2") ||
                    Objects.equals(String.valueOf(proteinas.charAt(i)), "3") || Objects.equals(String.valueOf(proteinas.charAt(i)), "4") || Objects.equals(String.valueOf(proteinas.charAt(i)), "5") ||
                    Objects.equals(String.valueOf(proteinas.charAt(i)), "6") || Objects.equals(String.valueOf(proteinas.charAt(i)), "7") || Objects.equals(String.valueOf(proteinas.charAt(i)), "8") ||
                    Objects.equals(String.valueOf(proteinas.charAt(i)), "9") || Objects.equals(String.valueOf(proteinas.charAt(i)), "."))
            {
                if(Objects.equals(String.valueOf(proteinas.charAt(i)), ","))
                {
                    auxiliar = auxiliar + ".";
                }
                else
                {
                    auxiliar = auxiliar + proteinas.charAt(i);
                    Log.d(this.getClass().toString(), "entra en el if");
                    Log.d(this.getClass().toString(), auxiliar);
                }

            }
        }Log.d(this.getClass().toString(),"final del for" + auxiliar);

        if (Double.parseDouble(auxiliar) < 15)
        {
            proteinas2.setText(proteinas);
            proteinas2.setTextColor(Color.parseColor("#FFFFFF"));
            proteinas2.setBackgroundColor(Color.parseColor("#117B01"));
        }
        else
        {
            if (Double.parseDouble(auxiliar) >= 15 && Double.parseDouble(auxiliar) < 60)
            {
                proteinas2.setText(proteinas);
                proteinas2.setTextColor(Color.parseColor("#000000"));
                proteinas2.setBackgroundColor(Color.parseColor("#FFC300"));
            }
            else
            {
                if (Double.parseDouble(auxiliar) >= 60)
                {
                    proteinas2.setText(proteinas);
                    proteinas2.setTextColor(Color.parseColor("#FFFFFF"));
                    proteinas2.setBackgroundColor(Color.parseColor("#ff0000"));
                }
            }
        }
    }

    private void pintarkcal(String kcal)
    {
        String auxiliar="";
        Log.d(this.getClass().toString(), kcal);
        Log.d(this.getClass().toString(), String.valueOf(kcal.length()));
        for (int i=0; i<kcal.length();i++){
            Log.d(this.getClass().toString(), String.valueOf(kcal.charAt(i)));
            if(Objects.equals(String.valueOf(kcal.charAt(i)), "0") || Objects.equals(String.valueOf(kcal.charAt(i)), "1") || Objects.equals(String.valueOf(kcal.charAt(i)), "2") ||
                    Objects.equals(String.valueOf(kcal.charAt(i)), "3") || Objects.equals(String.valueOf(kcal.charAt(i)), "4") || Objects.equals(String.valueOf(kcal.charAt(i)), "5") ||
                    Objects.equals(String.valueOf(kcal.charAt(i)), "6") || Objects.equals(String.valueOf(kcal.charAt(i)), "7") || Objects.equals(String.valueOf(kcal.charAt(i)), "8") ||
                    Objects.equals(String.valueOf(kcal.charAt(i)), "9"))
            {

                auxiliar = auxiliar + kcal.charAt(i);
                Log.d(this.getClass().toString(), "entra en el if");
                Log.d(this.getClass().toString(), auxiliar);
            }
        }Log.d(this.getClass().toString(), auxiliar);
        if (Integer.parseInt(auxiliar) < 200)
        {
            kcal2.setText(auxiliar);
            kcal2.setTextColor(Color.parseColor("#FFFFFF"));
            kcal2.setBackgroundColor(Color.parseColor("#117B01"));
        }
        else
        {
            if (Integer.parseInt(auxiliar) >= 200 && Integer.parseInt(auxiliar) < 500)
            {
                kcal2.setText(kcal);
                kcal2.setTextColor(Color.parseColor("#000000"));
                kcal2.setBackgroundColor(Color.parseColor("#FFC300"));
            }
            else
            {
                if (Integer.parseInt(auxiliar) >= 500)
                {
                    kcal2.setText(kcal);
                    kcal2.setTextColor(Color.parseColor("#FFFFFF"));
                    kcal2.setBackgroundColor(Color.parseColor("#ff0000"));
                }
            }
        }
    }

}
