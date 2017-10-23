package com.example.joselito.senaprueba.LectorOCR;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joselito.senaprueba.Basededatos.DBHelperProd;
import com.example.joselito.senaprueba.Basededatos.Producto;
import com.example.joselito.senaprueba.GestionProductos.GestionProductos;
import com.example.joselito.senaprueba.R;
import com.example.joselito.senaprueba.busquedaBBDD.busquedaBBDD;

import java.util.ArrayList;
import java.util.Objects;

import static android.view.Gravity.END;
import static android.view.Gravity.START;

/**
 * Created by joselito on 26/8/17.
 */

public class valoresnutricionales extends AppCompatActivity implements View.OnClickListener {

    public static final String  valores = "Valores";
    public static final String contador = "contador";
    public static final String Barcode = "Codigo de Barras";

    private EditText nombreprod;
    private String nombreaux;
    private ArrayList<String> mostrartexto;
    private String codbarras;

    DBHelperProd DB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        codbarras = getIntent().getStringExtra(Barcode);

        setContentView(R.layout.mostrar_valores);
        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootview);


        Log.d("Donde esta barcode", codbarras);

        findViewById(R.id.texto_no).setOnClickListener(this);
        findViewById(R.id.registro_prod).setOnClickListener(this);
        findViewById(R.id.volver_ocr).setOnClickListener(this);

        mostrartexto = getIntent().getStringArrayListExtra(valores);
        int contador_aux = 0;
        contador_aux = getIntent().getIntExtra(contador, contador_aux);

        boolean control = false;

        nombreprod = (EditText) findViewById(R.id.ETnombre);

        Log.i("Dentro de valores", String.valueOf(mostrartexto.size()));
        Log.d(this.getClass().toString(), mostrartexto.toString());
        int i, aux = 0;

        DB = new DBHelperProd(this);

        for (i = 0; i < contador_aux; i++) {
            TextView mostrar_valores = new TextView(this);
            Log.i("For de valores", mostrartexto.get(i));
            switch (mostrartexto.get(i)) {
                case "Energía":
                    mostrar_valores.setText(mostrartexto.get(i));
                    mostrar_valores.setGravity(START);
                    break;
                case "Energia":
                    mostrar_valores.setText(mostrartexto.get(i));
                    mostrar_valores.setGravity(START);
                    break;
                case "Valor energético":
                    mostrar_valores.setText(mostrartexto.get(i));
                    mostrar_valores.setGravity(START);
                    break;
                case "Valor energético / Energia":
                    mostrar_valores.setText(mostrartexto.get(i));
                    mostrar_valores.setGravity(START);
                    break;
                case "Grasas":
                    mostrar_valores.setText(mostrartexto.get(i));
                    mostrar_valores.setGravity(START);
                    break;
                case "Fat":
                    mostrar_valores.setText(mostrartexto.get(i));
                    mostrar_valores.setGravity(START);
                    break;
                case "Proteinas":
                    mostrar_valores.setText(mostrartexto.get(i));
                    mostrar_valores.setGravity(START);
                    break;
                case "Proteínas":
                    mostrar_valores.setText(mostrartexto.get(i));
                    mostrar_valores.setGravity(START);
                    break;
                case "Saturadas":
                    mostrar_valores.setText(mostrartexto.get(i));
                    mostrar_valores.setGravity(START);
                    break;
                case "Saturados":
                    mostrar_valores.setText(mostrartexto.get(i));
                    mostrar_valores.setGravity(START);
                    break;
                case "Sal":
                    mostrar_valores.setText(mostrartexto.get(i));
                    mostrar_valores.setGravity(START);
                    break;
                case "De los cuales Azúcares":
                    mostrar_valores.setText(mostrartexto.get(i));
                    mostrar_valores.setGravity(START);
                    break;
                case "de los cuales Azúcares":
                    mostrar_valores.setText(mostrartexto.get(i));
                    mostrar_valores.setGravity(START);
                    break;
                case "de los cuales azúcares":
                    mostrar_valores.setText(mostrartexto.get(i));
                    mostrar_valores.setGravity(START);
                    break;
                case "Azùcares":
                    mostrar_valores.setText(mostrartexto.get(i));
                    mostrar_valores.setGravity(START);
                    break;
                case "Azúcares":
                    mostrar_valores.setText(mostrartexto.get(i));
                    mostrar_valores.setGravity(START);
                    break;
                case "Azucares":
                    mostrar_valores.setText(mostrartexto.get(i));
                    mostrar_valores.setGravity(START);
                    break;
                case "Hidratos de Carbono":
                    mostrar_valores.setText(mostrartexto.get(i));
                    mostrar_valores.setGravity(START);
                    break;
                case "Hidratos de carbono":
                    mostrar_valores.setText(mostrartexto.get(i));
                    mostrar_valores.setGravity(START);
                    break;
                case "H. de Carbono":
                    mostrar_valores.setText(mostrartexto.get(i));
                    mostrar_valores.setGravity(START);
                    break;
                case "Fibras":
                    mostrar_valores.setText(mostrartexto.get(i));
                    mostrar_valores.setGravity(START);
                    break;
                default:{
                    String aux_valor = mostrartexto.get(i);
                    for (int j=0; j<aux_valor.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_valor.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_valor.charAt(j)), ",") || Objects.equals(String.valueOf(aux_valor.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_valor.charAt(j)), "1") || Objects.equals(String.valueOf(aux_valor.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_valor.charAt(j)), "3") || Objects.equals(String.valueOf(aux_valor.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_valor.charAt(j)), "5") || Objects.equals(String.valueOf(aux_valor.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_valor.charAt(j)), "7") || Objects.equals(String.valueOf(aux_valor.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_valor.charAt(j)), "9") || Objects.equals(String.valueOf(aux_valor.charAt(j)), ".") ||
                                Objects.equals(String.valueOf(aux_valor.charAt(j)), "g") || Objects.equals(String.valueOf(aux_valor.charAt(j)), "k") ||
                                Objects.equals(String.valueOf(aux_valor.charAt(j)), "J") || Objects.equals(String.valueOf(aux_valor.charAt(j)), "c") ||
                                Objects.equals(String.valueOf(aux_valor.charAt(j)), "a") || Objects.equals(String.valueOf(aux_valor.charAt(j)), "l") )
                        {

                            Log.d(this.getClass().toString(), mostrartexto.get(i));
                            mostrar_valores.setText(mostrartexto.get(i));
                            mostrar_valores.setGravity(END);
                        }else{
                            mostrar_valores.setText(mostrartexto.get(i));
                            mostrar_valores.setGravity(START);
                        }
                    }
                }
            }
            mostrar_valores.setTextColor(getColor(R.color.letras));
            //mostrar_valores.setTextColor(getColor(R.color.derecha));
            mostrar_valores.setTextSize(15);
                mostrar_valores.setTypeface(mostrar_valores.getTypeface(), Typeface.BOLD);

                rootView.addView(mostrar_valores);

        }
        nombreaux = nombreprod.getText().toString();

    }

    private void guardar_valores(ArrayList<String> mostrartexto, String codbarras, String nombreaux)
    {

        String kcal= "0";
        String proteinas = "0";
        String grasas = "0";
        String sat = "0";
        String sal="0";
        String azucar="0";
        String carbo="0";
        String codigo;
        String nombre;

        int valor_control = 0;

        for (int i=0; i<mostrartexto.size();i++){
            if(Objects.equals(mostrartexto.get(i), "Valor energético") && Objects.equals(valor_control, 0)){
                valor_control = 1;
            }else{
                valor_control++;
            }
            switch (mostrartexto.get(i)){
                case "Valor Energético":
                    String aux_valor = mostrartexto.get(i+2);
                    String aux2_valor ="";
                    for (int j=0; j<aux_valor.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_valor.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_valor.charAt(j)), ",") || Objects.equals(String.valueOf(aux_valor.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_valor.charAt(j)), "1") || Objects.equals(String.valueOf(aux_valor.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_valor.charAt(j)), "3") || Objects.equals(String.valueOf(aux_valor.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_valor.charAt(j)), "5") || Objects.equals(String.valueOf(aux_valor.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_valor.charAt(j)), "7") || Objects.equals(String.valueOf(aux_valor.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_valor.charAt(j)), "9") || Objects.equals(String.valueOf(aux_valor.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_valor.charAt(j)), ",")) {
                                aux2_valor = aux2_valor + ".";
                            }
                            else
                            {
                                aux2_valor = aux2_valor + aux_valor.charAt(j);
                            }
                        }
                    }
                    kcal = aux2_valor;
                    break;
                case "Energía":
                    String aux_energia = mostrartexto.get(i+2);
                    String aux2_energia ="";
                    for (int j=0; j<aux_energia.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_energia.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_energia.charAt(j)), ",") || Objects.equals(String.valueOf(aux_energia.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_energia.charAt(j)), "1") || Objects.equals(String.valueOf(aux_energia.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_energia.charAt(j)), "3") || Objects.equals(String.valueOf(aux_energia.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_energia.charAt(j)), "5") || Objects.equals(String.valueOf(aux_energia.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_energia.charAt(j)), "7") || Objects.equals(String.valueOf(aux_energia.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_energia.charAt(j)), "9") || Objects.equals(String.valueOf(aux_energia.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_energia.charAt(j)), ",")) {
                                aux2_energia = aux2_energia + ".";
                            }
                            else
                            {
                                aux2_energia = aux2_energia + aux_energia.charAt(j);
                            }
                        }
                    }
                    kcal = aux2_energia;
                    break;
                case "Valor energético / Energía":
                    String aux_energia_1 = mostrartexto.get(i+1);
                    String aux2_energia_1 ="";
                    int aux = aux_energia_1.length();
                    Log.d(this.getClass().toString(), "Valor aux Energia: " + aux);
                    for (int j=0; j<aux_energia_1.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_energia_1.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_energia_1.charAt(j)), ",") || Objects.equals(String.valueOf(aux_energia_1.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_energia_1.charAt(j)), "1") || Objects.equals(String.valueOf(aux_energia_1.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_energia_1.charAt(j)), "3") || Objects.equals(String.valueOf(aux_energia_1.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_energia_1.charAt(j)), "5") || Objects.equals(String.valueOf(aux_energia_1.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_energia_1.charAt(j)), "7") || Objects.equals(String.valueOf(aux_energia_1.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_energia_1.charAt(j)), "9") || Objects.equals(String.valueOf(aux_energia_1.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_energia_1.charAt(j)), ",")) {
                                aux2_energia_1 = aux2_energia_1 + ".";
                            }
                            else
                            {
                                aux2_energia_1 = aux2_energia_1 + aux_energia_1.charAt(j);
                            }
                        }
                    }
                    kcal = aux2_energia_1;
                    break;
                case "Valor energético":
                    Log.d(this.getClass().toString(), String.valueOf(valor_control));
                    if(valor_control == 1){
                        String aux_energia_2 = mostrartexto.get(i+2);

                        Log.d(this.getClass().toString(), mostrartexto.get(i+2));
                        String aux2_energia_2 ="";

                        for (int j=0; j<aux_energia_2.length();j++)
                        {
                            Log.d(this.getClass().toString(), String.valueOf(aux_energia_2.charAt(j)));
                            if (Objects.equals(String.valueOf(aux_energia_2.charAt(j)), ",") || Objects.equals(String.valueOf(aux_energia_2.charAt(j)), "0") ||
                                    Objects.equals(String.valueOf(aux_energia_2.charAt(j)), "1") || Objects.equals(String.valueOf(aux_energia_2.charAt(j)), "2") ||
                                    Objects.equals(String.valueOf(aux_energia_2.charAt(j)), "3") || Objects.equals(String.valueOf(aux_energia_2.charAt(j)), "4") ||
                                    Objects.equals(String.valueOf(aux_energia_2.charAt(j)), "5") || Objects.equals(String.valueOf(aux_energia_2.charAt(j)), "6") ||
                                    Objects.equals(String.valueOf(aux_energia_2.charAt(j)), "7") || Objects.equals(String.valueOf(aux_energia_2.charAt(j)), "8") ||
                                    Objects.equals(String.valueOf(aux_energia_2.charAt(j)), "9") || Objects.equals(String.valueOf(aux_energia_2.charAt(j)), "."))
                            {
                                if (Objects.equals(String.valueOf(aux_energia_2.charAt(j)), ",")) {
                                    aux2_energia_2 = aux2_energia_2 + ".";
                                }
                                else
                                {
                                    aux2_energia_2 = aux2_energia_2 + aux_energia_2.charAt(j);
                                }
                            }
                        }
                        kcal = aux2_energia_2;
                    }else{
                        int cont = mostrartexto.size()-i+2;
                        String aux_energia_2 = mostrartexto.get(cont);
                        Log.d(this.getClass().toString(), "kcal: " + mostrartexto.get(cont));
                        String aux2_energia_2 ="";

                        for (int j=0; j<aux_energia_2.length();j++)
                        {
                            Log.d(this.getClass().toString(), String.valueOf(aux_energia_2.charAt(j)));
                            if (Objects.equals(String.valueOf(aux_energia_2.charAt(j)), ",") || Objects.equals(String.valueOf(aux_energia_2.charAt(j)), "0") ||
                                    Objects.equals(String.valueOf(aux_energia_2.charAt(j)), "1") || Objects.equals(String.valueOf(aux_energia_2.charAt(j)), "2") ||
                                    Objects.equals(String.valueOf(aux_energia_2.charAt(j)), "3") || Objects.equals(String.valueOf(aux_energia_2.charAt(j)), "4") ||
                                    Objects.equals(String.valueOf(aux_energia_2.charAt(j)), "5") || Objects.equals(String.valueOf(aux_energia_2.charAt(j)), "6") ||
                                    Objects.equals(String.valueOf(aux_energia_2.charAt(j)), "7") || Objects.equals(String.valueOf(aux_energia_2.charAt(j)), "8") ||
                                    Objects.equals(String.valueOf(aux_energia_2.charAt(j)), "9") || Objects.equals(String.valueOf(aux_energia_2.charAt(j)), "."))
                            {
                                if (Objects.equals(String.valueOf(aux_energia_2.charAt(j)), ",")) {
                                    aux2_energia_2 = aux2_energia_2 + ".";
                                }
                                else
                                {
                                    aux2_energia_2 = aux2_energia_2 + aux_energia_2.charAt(j);
                                }
                            }
                        }
                        kcal = aux2_energia_2;
                    }
                    break;
                case "Grasas":
                    String aux_grasas = mostrartexto.get(i+1);
                    String aux2_grasas ="";
                    for (int j=0; j<aux_grasas.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_grasas.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_grasas.charAt(j)), ",") || Objects.equals(String.valueOf(aux_grasas.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_grasas.charAt(j)), "1") || Objects.equals(String.valueOf(aux_grasas.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_grasas.charAt(j)), "3") || Objects.equals(String.valueOf(aux_grasas.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_grasas.charAt(j)), "5") || Objects.equals(String.valueOf(aux_grasas.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_grasas.charAt(j)), "7") || Objects.equals(String.valueOf(aux_grasas.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_grasas.charAt(j)), "9") || Objects.equals(String.valueOf(aux_grasas.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_grasas.charAt(j)), ",")) {
                                aux2_grasas = aux2_grasas + ".";
                            }
                            else
                            {
                                aux2_grasas = aux2_grasas + aux_grasas.charAt(j);
                            }
                        }
                    }
                    grasas = aux2_grasas;
                    break;
                case "Fat":
                    String aux_fat = mostrartexto.get(i+1);
                    String aux2_fat ="";
                    for (int j=0; j<aux_fat.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_fat.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_fat.charAt(j)), ",") || Objects.equals(String.valueOf(aux_fat.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_fat.charAt(j)), "1") || Objects.equals(String.valueOf(aux_fat.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_fat.charAt(j)), "3") || Objects.equals(String.valueOf(aux_fat.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_fat.charAt(j)), "5") || Objects.equals(String.valueOf(aux_fat.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_fat.charAt(j)), "7") || Objects.equals(String.valueOf(aux_fat.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_fat.charAt(j)), "9") || Objects.equals(String.valueOf(aux_fat.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_fat.charAt(j)), ",")) {
                                aux2_fat = aux2_fat + ".";
                            }
                            else
                            {
                                aux2_fat = aux2_fat + aux_fat.charAt(j);
                            }
                        }
                    }
                    grasas = aux2_fat;
                    break;
                case "Proteinas":
                    String aux_proteinas = mostrartexto.get(i+1);
                    String aux2_proteinas ="";
                    for (int j=0; j<aux_proteinas.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_proteinas.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_proteinas.charAt(j)), ",") || Objects.equals(String.valueOf(aux_proteinas.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_proteinas.charAt(j)), "1") || Objects.equals(String.valueOf(aux_proteinas.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_proteinas.charAt(j)), "3") || Objects.equals(String.valueOf(aux_proteinas.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_proteinas.charAt(j)), "5") || Objects.equals(String.valueOf(aux_proteinas.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_proteinas.charAt(j)), "7") || Objects.equals(String.valueOf(aux_proteinas.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_proteinas.charAt(j)), "9") || Objects.equals(String.valueOf(aux_proteinas.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_proteinas.charAt(j)), ",")) {
                                aux2_proteinas = aux2_proteinas + ".";
                            }
                            else
                            {
                                aux2_proteinas = aux2_proteinas + aux_proteinas.charAt(j);
                            }
                        }
                    }
                    proteinas = aux2_proteinas;
                    Log.d(this.getClass().toString(), proteinas);
                    break;
                case "Proteínas":
                    String aux_proteinas_1 = mostrartexto.get(i+1);
                    String aux2_proteinas_1 ="";
                    for (int j=0; j<aux_proteinas_1.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_proteinas_1.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_proteinas_1.charAt(j)), ",") || Objects.equals(String.valueOf(aux_proteinas_1.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_proteinas_1.charAt(j)), "1") || Objects.equals(String.valueOf(aux_proteinas_1.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_proteinas_1.charAt(j)), "3") || Objects.equals(String.valueOf(aux_proteinas_1.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_proteinas_1.charAt(j)), "5") || Objects.equals(String.valueOf(aux_proteinas_1.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_proteinas_1.charAt(j)), "7") || Objects.equals(String.valueOf(aux_proteinas_1.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_proteinas_1.charAt(j)), "9") || Objects.equals(String.valueOf(aux_proteinas_1.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_proteinas_1.charAt(j)), ",")) {
                                aux2_proteinas_1 = aux2_proteinas_1 + ".";
                            }
                            else
                            {
                                aux2_proteinas_1 = aux2_proteinas_1 + aux_proteinas_1.charAt(j);
                            }
                        }
                    }
                    proteinas = aux2_proteinas_1;
                    Log.d(this.getClass().toString(), proteinas);
                    break;
                case "Saturadas":
                    String aux_sat1 = mostrartexto.get(i+1);
                    String aux2_sat1 ="";
                    for (int j=0; j<aux_sat1.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_sat1.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_sat1.charAt(j)), ",") || Objects.equals(String.valueOf(aux_sat1.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_sat1.charAt(j)), "1") || Objects.equals(String.valueOf(aux_sat1.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_sat1.charAt(j)), "3") || Objects.equals(String.valueOf(aux_sat1.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_sat1.charAt(j)), "5") || Objects.equals(String.valueOf(aux_sat1.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_sat1.charAt(j)), "7") || Objects.equals(String.valueOf(aux_sat1.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_sat1.charAt(j)), "9") || Objects.equals(String.valueOf(aux_sat1.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_sat1.charAt(j)), ",")) {
                                aux2_sat1 = aux2_sat1 + ".";
                            }
                            else
                            {
                                aux2_sat1 = aux2_sat1 + aux_sat1.charAt(j);
                            }
                        }
                    }
                    sat = aux2_sat1;
                    Log.d(this.getClass().toString(), sat);
                    break;
                case "Saturados":
                    String aux_sat = mostrartexto.get(i+1);
                    String aux2_sat ="";
                    for (int j=0; j<aux_sat.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_sat.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_sat.charAt(j)), ",") || Objects.equals(String.valueOf(aux_sat.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_sat.charAt(j)), "1") || Objects.equals(String.valueOf(aux_sat.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_sat.charAt(j)), "3") || Objects.equals(String.valueOf(aux_sat.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_sat.charAt(j)), "5") || Objects.equals(String.valueOf(aux_sat.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_sat.charAt(j)), "7") || Objects.equals(String.valueOf(aux_sat.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_sat.charAt(j)), "9") || Objects.equals(String.valueOf(aux_sat.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_sat.charAt(j)), ",")) {
                                aux2_sat = aux2_sat + ".";
                            }
                            else
                            {
                                aux2_sat = aux2_sat + aux_sat.charAt(j);
                            }
                        }
                    }
                    sat = aux2_sat;
                    Log.d(this.getClass().toString(), sat);
                    break;
                case "saturadas":
                    String aux_sat_2 = mostrartexto.get(i+1);
                    String aux2_sat_2 ="";
                    for (int j=0; j<aux_sat_2.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_sat_2.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_sat_2.charAt(j)), ",") || Objects.equals(String.valueOf(aux_sat_2.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_sat_2.charAt(j)), "1") || Objects.equals(String.valueOf(aux_sat_2.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_sat_2.charAt(j)), "3") || Objects.equals(String.valueOf(aux_sat_2.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_sat_2.charAt(j)), "5") || Objects.equals(String.valueOf(aux_sat_2.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_sat_2.charAt(j)), "7") || Objects.equals(String.valueOf(aux_sat_2.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_sat_2.charAt(j)), "9") || Objects.equals(String.valueOf(aux_sat_2.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_sat_2.charAt(j)), ",")) {
                                aux2_sat_2 = aux2_sat_2 + ".";
                            }
                            else
                            {
                                aux2_sat_2 = aux2_sat_2 + aux_sat_2.charAt(j);
                            }
                        }
                    }
                    sat = aux2_sat_2;
                    Log.d(this.getClass().toString(), sat);
                    break;
                case "de las cuales saturadas":
                    String aux_sat_3 = mostrartexto.get(i+1);
                    String aux2_sat_3 ="";
                    for (int j=0; j<aux_sat_3.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_sat_3.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_sat_3.charAt(j)), ",") || Objects.equals(String.valueOf(aux_sat_3.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_sat_3.charAt(j)), "1") || Objects.equals(String.valueOf(aux_sat_3.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_sat_3.charAt(j)), "3") || Objects.equals(String.valueOf(aux_sat_3.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_sat_3.charAt(j)), "5") || Objects.equals(String.valueOf(aux_sat_3.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_sat_3.charAt(j)), "7") || Objects.equals(String.valueOf(aux_sat_3.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_sat_3.charAt(j)), "9") || Objects.equals(String.valueOf(aux_sat_3.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_sat_3.charAt(j)), ",")) {
                                aux2_sat_3 = aux2_sat_3 + ".";
                            }
                            else
                            {
                                aux2_sat_3 = aux2_sat_3 + aux_sat_3.charAt(j);
                            }
                        }
                    }
                    sat = aux2_sat_3;
                    Log.d(this.getClass().toString(), sat);
                    break;
                case "Sal":
                    String aux_sal;
                    if(Objects.equals(mostrartexto.get(i+1), "")){
                      aux_sal="0";
                    }else{
                        aux_sal = mostrartexto.get(i+1);
                    }
                    String aux2_sal ="";
                    for (int j=0; j<aux_sal.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_sal.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_sal.charAt(j)), ",") || Objects.equals(String.valueOf(aux_sal.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_sal.charAt(j)), "1") || Objects.equals(String.valueOf(aux_sal.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_sal.charAt(j)), "3") || Objects.equals(String.valueOf(aux_sal.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_sal.charAt(j)), "5") || Objects.equals(String.valueOf(aux_sal.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_sal.charAt(j)), "7") || Objects.equals(String.valueOf(aux_sal.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_sal.charAt(j)), "9") || Objects.equals(String.valueOf(aux_sal.charAt(j)), ".") ||
                                Objects.equals(String.valueOf(aux_sal.charAt(j)), null))
                        {
                            if (Objects.equals(String.valueOf(aux_sal.charAt(j)), ",")) {
                                aux2_sal = aux2_sal + ".";
                            }
                            else if(!Objects.equals(String.valueOf(aux_sal.charAt(j)), ","))
                            {
                                aux2_sal = aux2_sal + aux_sal.charAt(j);
                            }else if(Objects.equals(String.valueOf(aux_sal.charAt(j)), null)){
                                aux2_sal = "0";

                            }
                        }
                    }
                    sal = aux2_sal;
                    Log.d(this.getClass().toString(), sal);
                    break;
                case "Azúcares":
                    String aux_azucar_1 = mostrartexto.get(i+1);
                    String aux2_azucar_1 ="";
                    for (int j=0; j<aux_azucar_1.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_azucar_1.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_azucar_1.charAt(j)), ",") || Objects.equals(String.valueOf(aux_azucar_1.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_azucar_1.charAt(j)), "1") || Objects.equals(String.valueOf(aux_azucar_1.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_azucar_1.charAt(j)), "3") || Objects.equals(String.valueOf(aux_azucar_1.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_azucar_1.charAt(j)), "5") || Objects.equals(String.valueOf(aux_azucar_1.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_azucar_1.charAt(j)), "7") || Objects.equals(String.valueOf(aux_azucar_1.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_azucar_1.charAt(j)), "9") || Objects.equals(String.valueOf(aux_azucar_1.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_azucar_1.charAt(j)), ",")) {
                                aux2_azucar_1 = aux2_azucar_1 + ".";
                            }
                            else
                            {
                                aux2_azucar_1 = aux2_azucar_1 + aux_azucar_1.charAt(j);
                            }
                        }
                    }
                    azucar = aux2_azucar_1;
                    Log.d(this.getClass().toString(), azucar);
                    break;
                case "Azùcares":
                    String aux_azucar_2 = mostrartexto.get(i+1);
                    String aux2_azucar_2 ="";
                    for (int j=0; j<aux_azucar_2.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_azucar_2.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_azucar_2.charAt(j)), ",") || Objects.equals(String.valueOf(aux_azucar_2.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_azucar_2.charAt(j)), "1") || Objects.equals(String.valueOf(aux_azucar_2.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_azucar_2.charAt(j)), "3") || Objects.equals(String.valueOf(aux_azucar_2.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_azucar_2.charAt(j)), "5") || Objects.equals(String.valueOf(aux_azucar_2.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_azucar_2.charAt(j)), "7") || Objects.equals(String.valueOf(aux_azucar_2.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_azucar_2.charAt(j)), "9") || Objects.equals(String.valueOf(aux_azucar_2.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_azucar_2.charAt(j)), ",")) {
                                aux2_azucar_2 = aux2_azucar_2 + ".";
                            }
                            else
                            {
                                aux2_azucar_2 = aux2_azucar_2 + aux_azucar_2.charAt(j);
                            }
                        }
                    }
                    azucar = aux2_azucar_2;
                    Log.d(this.getClass().toString(), azucar);
                    break;
                case "Azucares":
                    String aux_azucar_3 = mostrartexto.get(i+1);
                    String aux2_azucar_3 ="";
                    for (int j=0; j<aux_azucar_3.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_azucar_3.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_azucar_3.charAt(j)), ",") || Objects.equals(String.valueOf(aux_azucar_3.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_azucar_3.charAt(j)), "1") || Objects.equals(String.valueOf(aux_azucar_3.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_azucar_3.charAt(j)), "3") || Objects.equals(String.valueOf(aux_azucar_3.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_azucar_3.charAt(j)), "5") || Objects.equals(String.valueOf(aux_azucar_3.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_azucar_3.charAt(j)), "7") || Objects.equals(String.valueOf(aux_azucar_3.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_azucar_3.charAt(j)), "9") || Objects.equals(String.valueOf(aux_azucar_3.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_azucar_3.charAt(j)), ",")) {
                                aux2_azucar_3 = aux2_azucar_3 + ".";
                            }
                            else
                            {
                                aux2_azucar_3 = aux2_azucar_3 + aux_azucar_3.charAt(j);
                            }
                        }
                    }
                    azucar = aux2_azucar_3;
                    Log.d(this.getClass().toString(), azucar);
                    break;
                case "de los cuales azucares":
                    String aux_azucar_4 = mostrartexto.get(i+1);
                    String aux2_azucar_4 ="";
                    for (int j=0; j<aux_azucar_4.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_azucar_4.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_azucar_4.charAt(j)), ",") || Objects.equals(String.valueOf(aux_azucar_4.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_azucar_4.charAt(j)), "1") || Objects.equals(String.valueOf(aux_azucar_4.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_azucar_4.charAt(j)), "3") || Objects.equals(String.valueOf(aux_azucar_4.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_azucar_4.charAt(j)), "5") || Objects.equals(String.valueOf(aux_azucar_4.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_azucar_4.charAt(j)), "7") || Objects.equals(String.valueOf(aux_azucar_4.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_azucar_4.charAt(j)), "9") || Objects.equals(String.valueOf(aux_azucar_4.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_azucar_4.charAt(j)), ",")) {
                                aux2_azucar_4 = aux2_azucar_4 + ".";
                            }
                            else
                            {
                                aux2_azucar_4 = aux2_azucar_4 + aux_azucar_4.charAt(j);
                            }
                        }
                    }
                    azucar = aux_azucar_4;
                    Log.d(this.getClass().toString(), azucar);
                    break;
                case "azucares":
                    String aux_azucar_5 = mostrartexto.get(i+1);
                    String aux2_azucar_5 ="";
                    for (int j=0; j<aux_azucar_5.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_azucar_5.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_azucar_5.charAt(j)), ",") || Objects.equals(String.valueOf(aux_azucar_5.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_azucar_5.charAt(j)), "1") || Objects.equals(String.valueOf(aux_azucar_5.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_azucar_5.charAt(j)), "3") || Objects.equals(String.valueOf(aux_azucar_5.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_azucar_5.charAt(j)), "5") || Objects.equals(String.valueOf(aux_azucar_5.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_azucar_5.charAt(j)), "7") || Objects.equals(String.valueOf(aux_azucar_5.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_azucar_5.charAt(j)), "9") || Objects.equals(String.valueOf(aux_azucar_5.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_azucar_5.charAt(j)), ",")) {
                                aux2_azucar_5 = aux2_azucar_5 + ".";
                            }
                            else
                            {
                                aux2_azucar_5 = aux2_azucar_5 + aux_azucar_5.charAt(j);
                            }
                        }
                    }
                    azucar = aux2_azucar_5;
                    Log.d(this.getClass().toString(), azucar);
                    break;
                case "De los cuales azúcares":
                    String aux_azucar_6 = mostrartexto.get(i+1);
                    String aux2_azucar_6 ="";
                    for (int j=0; j<aux_azucar_6.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_azucar_6.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_azucar_6.charAt(j)), ",") || Objects.equals(String.valueOf(aux_azucar_6.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_azucar_6.charAt(j)), "1") || Objects.equals(String.valueOf(aux_azucar_6.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_azucar_6.charAt(j)), "3") || Objects.equals(String.valueOf(aux_azucar_6.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_azucar_6.charAt(j)), "5") || Objects.equals(String.valueOf(aux_azucar_6.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_azucar_6.charAt(j)), "7") || Objects.equals(String.valueOf(aux_azucar_6.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_azucar_6.charAt(j)), "9") || Objects.equals(String.valueOf(aux_azucar_6.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_azucar_6.charAt(j)), ",")) {
                                aux2_azucar_6 = aux2_azucar_6 + ".";
                            }
                            else
                            {
                                aux2_azucar_6 = aux2_azucar_6 + aux_azucar_6.charAt(j);
                            }
                        }
                    }
                    azucar = aux2_azucar_6;
                    Log.d(this.getClass().toString(), azucar);
                    break;
                case "de los cuales azúcares":
                    String aux_azucar_7 = mostrartexto.get(i+1);
                    String aux2_azucar_7 ="";
                    for (int j=0; j<aux_azucar_7.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_azucar_7.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_azucar_7.charAt(j)), ",") || Objects.equals(String.valueOf(aux_azucar_7.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_azucar_7.charAt(j)), "1") || Objects.equals(String.valueOf(aux_azucar_7.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_azucar_7.charAt(j)), "3") || Objects.equals(String.valueOf(aux_azucar_7.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_azucar_7.charAt(j)), "5") || Objects.equals(String.valueOf(aux_azucar_7.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_azucar_7.charAt(j)), "7") || Objects.equals(String.valueOf(aux_azucar_7.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_azucar_7.charAt(j)), "9") || Objects.equals(String.valueOf(aux_azucar_7.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_azucar_7.charAt(j)), ",")) {
                                aux2_azucar_7 = aux2_azucar_7 + ".";
                            }
                            else
                            {
                                aux2_azucar_7 = aux2_azucar_7 + aux_azucar_7.charAt(j);
                            }
                        }
                    }
                    azucar = aux2_azucar_7;
                    Log.d(this.getClass().toString(), azucar);
                    break;
                case "H. de Carbono":
                    String aux_carbo = mostrartexto.get(i+1);
                    String aux2_carbo ="";
                    for (int j=0; j<aux_carbo.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_carbo.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_carbo.charAt(j)), ",") || Objects.equals(String.valueOf(aux_carbo.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_carbo.charAt(j)), "1") || Objects.equals(String.valueOf(aux_carbo.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_carbo.charAt(j)), "3") || Objects.equals(String.valueOf(aux_carbo.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_carbo.charAt(j)), "5") || Objects.equals(String.valueOf(aux_carbo.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_carbo.charAt(j)), "7") || Objects.equals(String.valueOf(aux_carbo.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_carbo.charAt(j)), "9") || Objects.equals(String.valueOf(aux_carbo.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_carbo.charAt(j)), ",")) {
                                aux2_carbo = aux2_carbo + ".";
                            }
                            else
                            {
                                aux2_carbo = aux2_carbo + aux_carbo.charAt(j);
                            }
                        }
                    }
                    carbo = aux2_carbo;
                    Log.d(this.getClass().toString(), azucar);
                    break;
                case "Hidratos de Carbono":
                    String aux_carbo_1 = mostrartexto.get(i+1);
                    String aux2_carbo_1 ="";
                    for (int j=0; j<aux_carbo_1.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_carbo_1.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_carbo_1.charAt(j)), ",") || Objects.equals(String.valueOf(aux_carbo_1.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_carbo_1.charAt(j)), "1") || Objects.equals(String.valueOf(aux_carbo_1.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_carbo_1.charAt(j)), "3") || Objects.equals(String.valueOf(aux_carbo_1.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_carbo_1.charAt(j)), "5") || Objects.equals(String.valueOf(aux_carbo_1.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_carbo_1.charAt(j)), "7") || Objects.equals(String.valueOf(aux_carbo_1.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_carbo_1.charAt(j)), "9") || Objects.equals(String.valueOf(aux_carbo_1.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_carbo_1.charAt(j)), ",")) {
                                aux2_carbo_1 = aux2_carbo_1 + ".";
                            }
                            else
                            {
                                aux2_carbo_1 = aux2_carbo_1 + aux_carbo_1.charAt(j);
                            }
                        }
                    }
                    carbo = aux2_carbo_1;
                    Log.d(this.getClass().toString(), azucar);
                    break;
                case "Carbono":
                    String aux_carbo_2 = mostrartexto.get(i+1);
                    String aux2_carbo_2 ="";
                    for (int j=0; j<aux_carbo_2.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_carbo_2.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_carbo_2.charAt(j)), ",") || Objects.equals(String.valueOf(aux_carbo_2.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_carbo_2.charAt(j)), "1") || Objects.equals(String.valueOf(aux_carbo_2.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_carbo_2.charAt(j)), "3") || Objects.equals(String.valueOf(aux_carbo_2.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_carbo_2.charAt(j)), "5") || Objects.equals(String.valueOf(aux_carbo_2.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_carbo_2.charAt(j)), "7") || Objects.equals(String.valueOf(aux_carbo_2.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_carbo_2.charAt(j)), "9") || Objects.equals(String.valueOf(aux_carbo_2.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_carbo_2.charAt(j)), ",")) {
                                aux2_carbo_2 = aux2_carbo_2 + ".";
                            }
                            else
                            {
                                aux2_carbo_2 = aux2_carbo_2 + aux_carbo_2.charAt(j);
                            }
                        }
                    }
                    carbo = aux2_carbo_2;
                    Log.d(this.getClass().toString(), azucar);
                    break;
                case "carbono":
                    String aux_carbo_3 = mostrartexto.get(i+1);
                    String aux2_carbo_3 ="";
                    for (int j=0; j<aux_carbo_3.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_carbo_3.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_carbo_3.charAt(j)), ",") || Objects.equals(String.valueOf(aux_carbo_3.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_carbo_3.charAt(j)), "1") || Objects.equals(String.valueOf(aux_carbo_3.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_carbo_3.charAt(j)), "3") || Objects.equals(String.valueOf(aux_carbo_3.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_carbo_3.charAt(j)), "5") || Objects.equals(String.valueOf(aux_carbo_3.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_carbo_3.charAt(j)), "7") || Objects.equals(String.valueOf(aux_carbo_3.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_carbo_3.charAt(j)), "9") || Objects.equals(String.valueOf(aux_carbo_3.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_carbo_3.charAt(j)), ",")) {
                                aux2_carbo_3 = aux2_carbo_3 + ".";
                            }
                            else
                            {
                                aux2_carbo_3 = aux2_carbo_3 + aux_carbo_3.charAt(j);
                            }
                        }
                    }
                    carbo = aux2_carbo_3;
                    Log.d(this.getClass().toString(), azucar);
                    break;
                case "Hidratos de carbono":
                    String aux_carbo_4 = mostrartexto.get(i+1);
                    String aux2_carbo_4 ="";
                    for (int j=0; j<aux_carbo_4.length();j++)
                    {
                        Log.d(this.getClass().toString(), String.valueOf(aux_carbo_4.charAt(j)));
                        if (Objects.equals(String.valueOf(aux_carbo_4.charAt(j)), ",") || Objects.equals(String.valueOf(aux_carbo_4.charAt(j)), "0") ||
                                Objects.equals(String.valueOf(aux_carbo_4.charAt(j)), "1") || Objects.equals(String.valueOf(aux_carbo_4.charAt(j)), "2") ||
                                Objects.equals(String.valueOf(aux_carbo_4.charAt(j)), "3") || Objects.equals(String.valueOf(aux_carbo_4.charAt(j)), "4") ||
                                Objects.equals(String.valueOf(aux_carbo_4.charAt(j)), "5") || Objects.equals(String.valueOf(aux_carbo_4.charAt(j)), "6") ||
                                Objects.equals(String.valueOf(aux_carbo_4.charAt(j)), "7") || Objects.equals(String.valueOf(aux_carbo_4.charAt(j)), "8") ||
                                Objects.equals(String.valueOf(aux_carbo_4.charAt(j)), "9") || Objects.equals(String.valueOf(aux_carbo_4.charAt(j)), "."))
                        {
                            if (Objects.equals(String.valueOf(aux_carbo_4.charAt(j)), ",")) {
                                aux2_carbo_4 = aux2_carbo_4 + ".";
                            }
                            else
                            {
                                aux2_carbo_4 = aux2_carbo_4 + aux_carbo_4.charAt(j);
                            }
                        }
                    }
                    carbo = aux2_carbo_4;
                    Log.d(this.getClass().toString(), azucar);
                    break;
            }

        }

        codigo = codbarras;
        nombre = nombreaux;
        Log.d(this.getClass().toString(), codigo + ", " + nombre + ", " + kcal + ", " + sat + ", "
                + carbo + ", " + azucar + ", " + sal + ", " + grasas + ", " + sat);


        addProd(kcal, proteinas, sat, sal, grasas, azucar, carbo , codigo);
    }

    private void addProd(String kcal, String proteinas, String  sat, String sal, String
            grasas, String azucar, String carbohidratos, String codigo)
    {
        Producto prod = new Producto(codigo, nombreprod.getText().toString(), kcal, carbohidratos, azucar, sal, proteinas, grasas, sat);

        DB.addProducto(prod);
        Toast.makeText(this,"Producto guardado correctamente", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, busquedaBBDD.class);
        Log.i(this.getClass().toString(), "dentro de añadir " + nombreprod.getText().toString());
        intent.putExtra(busquedaBBDD.barcode, codigo);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.texto_no:{
                Intent OCRintent = new Intent(valoresnutricionales.this, GestionProductos.class);
                OCRintent.putExtra(GestionProductos.codigobarras ,codbarras);
                startActivity(OCRintent);
                break;
            }
            case R.id.registro_prod: {
                guardar_valores(mostrartexto,codbarras,nombreaux);
                break;
            }
            case R.id.volver_ocr:{
                Intent i = new Intent(valoresnutricionales.this, LectorOCR.class);
                i.putExtra(LectorOCR.Barcode ,codbarras);
                startActivity(i);
                break;
            }

        }
    }


}
