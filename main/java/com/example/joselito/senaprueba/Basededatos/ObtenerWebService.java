package com.example.joselito.senaprueba.Basededatos;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

/**
 * Created by joselito on 14/9/17.
 */

public class ObtenerWebService extends AsyncTask<String,Void,String> {

    private JSONArray productosJSON;

    private Producto prod = new Producto();

    @Override
    protected String doInBackground(String... params) {

        String devuelve ="";

        String cadena = params[0];
        URL url = null; // Url de donde queremos obtener información


        if(Objects.equals(params[1], "1")){    // Consulta de todos los productos

            try {
                url = new URL(cadena);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //Abrir la conexión
                connection.setRequestProperty("User-Agent", "Mozilla/5.0" +
                        " (Linux; Android 1.5; es-ES) Ejemplo HTTP");
                //connection.setHeader("content-type", "application/json");

                int respuesta = connection.getResponseCode();
                StringBuilder result = new StringBuilder();

                if (respuesta == HttpURLConnection.HTTP_OK){


                    InputStream in = new BufferedInputStream(connection.getInputStream());  // preparo la cadena de entrada

                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));  // la introduzco en un BufferedReader

                    // El siguiente proceso lo hago porque el JSONOBject necesita un String y tengo
                    // que tranformar el BufferedReader a String. Esto lo hago a traves de un
                    // StringBuilder.

                    String line;
                    while ((line = reader.readLine()) != null) {
                        result.append(line);        // Paso toda la entrada al StringBuilder
                    }

                    //Creamos un objeto JSONObject para poder acceder a los atributos (campos) del objeto.
                    JSONObject respuestaJSON = new JSONObject(result.toString());   //Creo un JSONObject a partir del StringBuilder pasado a cadena
                    //Accedemos al vector de resultados

                    String resultJSON = respuestaJSON.getString("estado");   // estado es el nombre del campo en el JSON

                    if (Objects.equals(resultJSON, "1")){      // hay productos a mostrar
                        productosJSON  = respuestaJSON.getJSONArray("producto");   // estado es el nombre del campo en el JSON
                        for(int i=0;i<productosJSON.length();i++){
                            devuelve = devuelve + productosJSON.getJSONObject(i).getString("Codigo") + ", " +
                                    productosJSON.getJSONObject(i).getString("Nombre") + ", " +
                                    productosJSON.getJSONObject(i).getString("kCalorias") + ", " +
                                    productosJSON.getJSONObject(i).getString("Carbohidratos") + ", " +
                                    productosJSON.getJSONObject(i).getString("Azucar") + ", " +
                                    productosJSON.getJSONObject(i).getString("Proteinas") + ", " +
                                    productosJSON.getJSONObject(i).getString("Sal") + ", " +
                                    productosJSON.getJSONObject(i).getString("Grasas_sat") + ", " +
                                    productosJSON.getJSONObject(i).getString("Grasas") + "\n";
                            Log.d("Donde aparece esto", devuelve);
                            Log.d(this.getClass().toString(), String.valueOf(productosJSON.length()));

                        }

                    }
                    else if (Objects.equals(resultJSON, "2")){
                        devuelve = "No hay productos";
                    }


                }


            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }

            return devuelve;


        }
        else if(Objects.equals(params[1], "2")){    // consulta por id

            try {
                url = new URL(cadena);
                HttpURLConnection connection = (HttpURLConnection)url.openConnection(); //Abrir la conexión
                connection.setRequestProperty("User-Agent", "Mozilla/55.0.3 " +
                        " (Linux; Android 1.5; es-ES) SENA");
                //connection.setHeader("content-type", "application/json");

                int respuesta = connection.getResponseCode();
                StringBuilder result = new StringBuilder();

                if (respuesta == HttpURLConnection.HTTP_OK){


                    InputStream in = new BufferedInputStream(connection.getInputStream());  // preparo la cadena de entrada

                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));  // la introduzco en un BufferedReader

                    // El siguiente proceso lo hago porque el JSONOBject necesita un String y tengo
                    // que tranformar el BufferedReader a String. Esto lo hago a traves de un
                    // StringBuilder.

                    String line;
                    while ((line = reader.readLine()) != null) {
                        result.append(line);        // Paso toda la entrada al StringBuilder
                    }

                    //Creamos un objeto JSONObject para poder acceder a los atributos (campos) del objeto.
                    JSONObject respuestaJSON = new JSONObject(result.toString());   //Creo un JSONObject a partir del StringBuilder pasado a cadena
                    //Accedemos al vector de resultados

                    String resultJSON = respuestaJSON.getString("estado");   // estado es el nombre del campo en el JSON

                    if (Objects.equals(resultJSON, "1")){      // hay un producto que mostrar
                      devuelve = devuelve + respuestaJSON.getJSONObject("producto").getString("Codigo") + ", " +
                                respuestaJSON.getJSONObject("producto").getString("Nombre") + ", " +
                                respuestaJSON.getJSONObject("producto").getString("kCalorias") + ", " +
                                respuestaJSON.getJSONObject("producto").getString("Carbohidratos") + ", " +
                                respuestaJSON.getJSONObject("producto").getString("Azucar") + ", " +
                                respuestaJSON.getJSONObject("producto").getString("Colesterol") + ", " +
                                respuestaJSON.getJSONObject("producto").getString("Sal") + ", " +
                                respuestaJSON.getJSONObject("producto").getString("Grasas_sat") + ", " +
                                respuestaJSON.getJSONObject("producto").getString("Grasas") + ", ";

                    }
                    else if (Objects.equals(resultJSON, "2")){
                        devuelve = "No hay productos";
                    }

                }
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

            return devuelve;


        }
        else if(Objects.equals(params[1], "3")){    // insert

            try {
                HttpURLConnection urlConn;

                DataOutputStream printout;
                DataInputStream input;
                url = new URL(cadena);
                urlConn = (HttpURLConnection) url.openConnection();
                urlConn.setDoInput(true);
                urlConn.setDoOutput(true);
                urlConn.setUseCaches(false);
                urlConn.setRequestProperty("Content-Type", "application/json");
                urlConn.setRequestProperty("Accept", "application/json");
                urlConn.connect();
                //Creo el Objeto JSON
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("Codigo", params[2]);
                Log.d(this.getClass().toString(), params[2]);
                jsonParam.put("Nombre", params[3]);
                Log.d(this.getClass().toString(), params[3]);
                jsonParam.put("kCalorias", params[4]);
                Log.d(this.getClass().toString(), params[4]);
                jsonParam.put("Carbohidratos",params[5]);
                Log.d(this.getClass().toString(), params[5]);
                jsonParam.put("Azucar", params[6]);
                Log.d(this.getClass().toString(), params[6]);
                jsonParam.put("Proteinas", params[7]);
                Log.d(this.getClass().toString(), params[7]);
                jsonParam.put("Sal",params[8]);
                Log.d(this.getClass().toString(), params[8]);
                jsonParam.put("Grasas", params[9]);
                Log.d(this.getClass().toString(), params[9]);
                jsonParam.put("Grasas_sat", params[10]);
                Log.d(this.getClass().toString(), params[10]);
                // Envio los parámetros post.
                OutputStream os = urlConn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(jsonParam.toString());
                writer.flush();
                writer.close();

                int respuesta = urlConn.getResponseCode();


                StringBuilder result = new StringBuilder();

                if (respuesta == HttpURLConnection.HTTP_OK) {

                    String line;
                    BufferedReader br=new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                    while ((line=br.readLine()) != null) {
                        result.append(line);
                        //response+=line;
                    }
                    Log.d(this.getClass().toString(), "Resultado: "+ String.valueOf(respuesta));

                    //Creamos un objeto JSONObject para poder acceder a los atributos (campos) del objeto.
                    JSONObject respuestaJSON = new JSONObject(result.toString());   //Creo un JSONObject a partir del StringBuilder pasado a cadena
                    //Accedemos al vector de resultados

                    String resultJSON = respuestaJSON.getString("estado");   // estado es el nombre del campo en el JSON

                    if (resultJSON == "1") {      // hay un producto que mostrar
                        devuelve = "Producto insertado correctamente";

                    } else if (resultJSON == "2") {
                        devuelve = "El producto no pudo insertarse";
                    }

                }

            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }

            return devuelve;


        }
        else if(Objects.equals(params[1], "4")){    // update

            try {
                HttpURLConnection urlConn;

                DataOutputStream printout;
                DataInputStream input;
                url = new URL(cadena);
                urlConn = (HttpURLConnection) url.openConnection();
                urlConn.setDoInput(true);
                urlConn.setDoOutput(true);
                urlConn.setUseCaches(false);
                urlConn.setRequestProperty("Content-Type", "application/json");
                urlConn.setRequestProperty("Accept", "application/json");
                urlConn.connect();
                //Creo el Objeto JSON
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("Codigo", params[2]);
                Log.d(this.getClass().toString(), params[2]);
                jsonParam.put("Nombre", params[3]);
                Log.d(this.getClass().toString(), params[3]);
                jsonParam.put("kCalorias", params[4]);
                Log.d(this.getClass().toString(), params[4]);
                jsonParam.put("Carbohidratos",params[5]);
                Log.d(this.getClass().toString(), params[5]);
                jsonParam.put("Azucar", params[6]);
                Log.d(this.getClass().toString(), params[6]);
                jsonParam.put("Proteinas", params[7]);
                Log.d(this.getClass().toString(), params[7]);
                jsonParam.put("Sal",params[8]);
                Log.d(this.getClass().toString(), params[8]);
                jsonParam.put("Grasas_sat", params[9]);
                Log.d(this.getClass().toString(), params[9]);
                jsonParam.put("Grasas", params[10]);
                Log.d(this.getClass().toString(), params[10]);
                // Envio los parámetros post.
                OutputStream os = urlConn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(jsonParam.toString());
                writer.flush();
                writer.close();

                int respuesta = urlConn.getResponseCode();
                Log.d(this.getClass().toString(), "Resultado: "+ String.valueOf(respuesta));


                StringBuilder result = new StringBuilder();

                if (respuesta == HttpURLConnection.HTTP_OK) {

                    String line;
                    BufferedReader br=new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                    while ((line=br.readLine()) != null) {
                        result.append(line);
                        //response+=line;
                    }

                    Log.d(this.getClass().toString(), "Result: " + String.valueOf(result));

                    //Creamos un objeto JSONObject para poder acceder a los atributos (campos) del objeto.
                    JSONObject respuestaJSON = new JSONObject(result.toString());   //Creo un JSONObject a partir del StringBuilder pasado a cadena
                    //Accedemos al vector de resultados
                    String resultJSON = respuestaJSON.getString("estado");   // estado es el nombre del campo en el JSON

                    if (resultJSON == "1") {      // hay un producto que mostrar
                        devuelve = "Producto actualizado correctamente";

                    } else if (resultJSON == "2") {
                        devuelve = "El producto no pudo actualizarse";
                    }

                }

            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }

            return devuelve;

        }
        else if(Objects.equals(params[1], "5")) {    // delete

            try {
                HttpURLConnection urlConn;

                DataOutputStream printout;
                DataInputStream input;
                url = new URL(cadena);
                urlConn = (HttpURLConnection) url.openConnection();
                urlConn.setDoInput(true);
                urlConn.setDoOutput(true);
                urlConn.setUseCaches(false);
                urlConn.setRequestProperty("Content-Type", "application/json");
                urlConn.setRequestProperty("Accept", "application/json");
                urlConn.connect();
                //Creo el Objeto JSON
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("Codigo", params[2]);
                // Envio los parámetros post.
                OutputStream os = urlConn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(jsonParam.toString());
                writer.flush();
                writer.close();

                int respuesta = urlConn.getResponseCode();


                StringBuilder result = new StringBuilder();

                if (respuesta == HttpURLConnection.HTTP_OK) {

                    String line;
                    BufferedReader br=new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                    while ((line=br.readLine()) != null) {
                        result.append(line);
                        //response+=line;
                    }

                    Log.d(this.getClass().toString(), "Result: " + String.valueOf(result));

                    Log.d(this.getClass().toString(), String.valueOf(HttpURLConnection.HTTP_OK));
                    //Creamos un objeto JSONObject para poder acceder a los atributos (campos) del objeto.
                    JSONObject respuestaJSON = new JSONObject(result.toString());   //Creo un JSONObject a partir del StringBuilder pasado a cadena
                    //Accedemos al vector de resultados

                    String resultJSON = respuestaJSON.getString("estado");   // estado es el nombre del campo en el JSON

                    if (Objects.equals(resultJSON, "1")) {      // hay un producto que mostrar
                        devuelve = "Producto borrado correctamente";

                    } else if (Objects.equals(resultJSON, "2")) {
                        devuelve = "No hay productos";
                    }

                }

            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }

            return devuelve;

        }
        return null;
    }

    public void actualizarbasededatos(DBHelperProd db) {
        String codigo;

        for (int i=0; i<productosJSON.length(); i++){
            try {
                codigo = productosJSON.getJSONObject(i).getString("Codigo");
                Log.d(this.getClass().toString(), "Entra en actualizarbasededatos");
                if(!db.consultarcodigo(codigo)){
                    Log.d(this.getClass().toString(), "Entra en el if de actualizarbasededatos");
                    prod.setCodigo(codigo);
                    prod.setNombre(productosJSON.getJSONObject(i).getString("Nombre"));
                    prod.setkCal(productosJSON.getJSONObject(i).getString("kCalorias"));
                    prod.setCarbohidratos(productosJSON.getJSONObject(i).getString("Carbohidratos"));
                    prod.setAzucar(productosJSON.getJSONObject(i).getString("Azucar"));
                    prod.setProteinas(productosJSON.getJSONObject(i).getString("Proteinas"));
                    prod.setSal(productosJSON.getJSONObject(i).getString("Sal"));
                    prod.setGrasas_Sat(productosJSON.getJSONObject(i).getString("Grasas_sat"));
                    prod.setGrasas(productosJSON.getJSONObject(i).getString("Grasas"));
                    Log.d(this.getClass().toString(), prod.toString());
                    db.addProducto(prod);
                }else{
                    Log.d(this.getClass().toString(), "No Entra en el if actualizarbasededatos");

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    protected void onCancelled(String s) {
        super.onCancelled(s);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}

