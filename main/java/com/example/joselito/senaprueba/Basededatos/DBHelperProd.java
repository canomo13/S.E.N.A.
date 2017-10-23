package com.example.joselito.senaprueba.Basededatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;




/**
 * Created by joselito on 7/9/17.
 */

public class DBHelperProd extends SQLiteOpenHelper {


    // IP de mi Url
    String IP = "http://basedatossena.esy.es/";
    // Rutas de los Web Services
    String GET_BY_ID = IP + "proyectosena/webservices/obtener_productos_por_id.php";
    String UPDATE = IP + "proyectosena/webservices//actualizar_producto.php";
    String INSERT = IP + "proyectosena/webservices//insertar_producto.php";

    ObtenerWebService hiloconexion;



    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NOMBRE = "ProductosDB";

    //Nombre de la tabla
    private static final String TABLA_PRODUCTOS = "Productos";

    //Nombre de las columnas
    private static final String CODIGO = "Codigo";
    private static final String NOMBRE = "Nombre";
    private static final String KCALORIAS = "kCalorias";
    private static final String CARBOHIDRATOS = "Carbohidratos";
    private static final String AZUCAR = "Azucar";
    private static final String COLESTEROL = "Colesterol";
    private static final String SAL = "Sal";
    private static final String GRASAS_SAT = "Grasas_sat";
    private static final String GRASAS = "Grasas";

    private static final String[] COLUMNS = {CODIGO,NOMBRE,KCALORIAS,CARBOHIDRATOS,AZUCAR,COLESTEROL,SAL,GRASAS,GRASAS_SAT};

    String tabla = "CREATE TABLE "+  TABLA_PRODUCTOS + "( Codigo TEXT PRIMARY KEY UNIQUE, " +
            "Nombre TEXT, " + "kCalorias INTEGER, " + "Carbohidratos REAL, "
            + "Azucar REAL, " + "Colesterol REAL, " + "Sal REAL, " + "Grasas_sat REAL, "
            + "Grasas REAL )";

    public DBHelperProd(Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST productos");
        this.onCreate(db);

    }

    public void addProducto(Producto producto){

       // Log.d("addProducto", producto.toString());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put(CODIGO, producto.getCodigo());
        valores.put(NOMBRE, producto.getNombre());
        valores.put(KCALORIAS, producto.getkCal());
        valores.put(CARBOHIDRATOS, producto.getCarbohidratos());
        valores.put(AZUCAR, producto.getAzucar());
        valores.put(COLESTEROL, producto.getProteinas());
        valores.put(SAL, producto.getSal());
        valores.put(GRASAS, producto.getGrasas());
        valores.put(GRASAS_SAT, producto.getGrasas_Sat());


        db.insert(TABLA_PRODUCTOS, null, valores);
        Log.d(this.getClass().toString(),"Antes de mandar al servidor");
        hiloconexion = new ObtenerWebService();
        hiloconexion.execute(INSERT, "3", producto.getCodigo(),producto.getNombre(),producto.getkCal(),producto.getCarbohidratos(),
                    producto.getAzucar(),producto.getProteinas(),producto.getSal(),producto.getGrasas(),producto.getGrasas_Sat());


        db.close();
    }

    public Producto getProducto(String codigo){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLA_PRODUCTOS,COLUMNS, " codigo = ? ", new String[] {String.valueOf(codigo)}, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
            Log.i(this.getClass().toString(), String.valueOf(cursor.getCount()));
        }

        Producto prod=new Producto();
        if(cursor.moveToFirst()){
            prod.setCodigo(cursor.getString(0));
            prod.setNombre(cursor.getString(1));
            prod.setkCal(cursor.getString(2));
            prod.setCarbohidratos(cursor.getString(3));
            prod.setAzucar(cursor.getString(4));
            prod.setProteinas(cursor.getString(5));
            prod.setSal(cursor.getString(6));
            prod.setGrasas(cursor.getString(7));
            prod.setGrasas_Sat(cursor.getString(8));

            //Log
            Log.d("getProducto("+codigo+")",prod.toString());
            Log.d("getProducto("+cursor.getString(1)+")",prod.toString());

            return prod;
        }else{
            return prod;
        }

    }

    public List<Producto> getAllProductos(){

        List<Producto> productos = new LinkedList<Producto>();

        String query = "SELECT * FROM " + TABLA_PRODUCTOS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        Producto prod = null;

        if(cursor.moveToFirst()){
            do {
                prod = new Producto();
                prod.setCodigo(cursor.getString(0));
                prod.setNombre(cursor.getString(1));
                prod.setkCal(cursor.getString(2));
                prod.setCarbohidratos(cursor.getString(3));
                prod.setAzucar(cursor.getString(4));
                prod.setProteinas(cursor.getString(5));
                prod.setSal(cursor.getString(6));
                prod.setGrasas_Sat(cursor.getString(7));
                prod.setGrasas(cursor.getString(8));

                productos.add(prod);

            }while (cursor.moveToNext());
        }

        Log.d("getAllBooks()",productos.toString());

        return productos;
    }

    public int updateProducto(Producto producto){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put(CODIGO, producto.getCodigo());
        valores.put(NOMBRE, producto.getNombre());
        valores.put(KCALORIAS, producto.getkCal());
        valores.put(CARBOHIDRATOS, producto.getCarbohidratos());
        valores.put(AZUCAR, producto.getAzucar());
        valores.put(COLESTEROL, producto.getProteinas());
        valores.put(SAL, producto.getSal());
        valores.put(GRASAS_SAT, producto.getGrasas_Sat());
        valores.put(GRASAS, producto.getGrasas());

        int i = db.update(TABLA_PRODUCTOS, valores, CODIGO+" = ?",new String[] {String.valueOf(producto.getCodigo())});

        hiloconexion = new ObtenerWebService();
        hiloconexion.execute(UPDATE, "4", producto.getCodigo(),producto.getNombre(),producto.getkCal(),producto.getCarbohidratos(),
                    producto.getAzucar(),producto.getProteinas(),producto.getSal(),producto.getGrasas_Sat(),producto.getGrasas());



        db.close();

        return i;
    }

    public void deleteProducto(Producto producto){

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLA_PRODUCTOS, CODIGO + " = ? ",new String[]{String.valueOf(producto.getCodigo())});

        db.close();

        Log.d("deleteProducto",producto.toString());
    }

    public boolean consultarcodigo(String codigo){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLA_PRODUCTOS,COLUMNS, " codigo = ? ", new String[] {String.valueOf(codigo)}, null, null, null, null);

        if(cursor.getCount() == 0)
        {
            return false;
        }
        else{
            return true;
        }
    }



}
