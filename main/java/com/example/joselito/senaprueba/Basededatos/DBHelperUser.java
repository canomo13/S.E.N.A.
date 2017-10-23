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
 * Created by joselito on 11/9/17.
 */

public class DBHelperUser extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NOMBRE = "UsuariosDB";

    //Nombre de la tabla
    private static final String TABLA_USUARIOS = "Usuarios";

    //Nombre de las columnas

    private static final String NAME = "Nombre";

    private static final String APE = "Apellidos";

    private static final String CORREO = "Correo";

    private static final String USER = "Username";

    private static final String PASS =  "Pass";

    private static final String EDAD = "Edad";

    private static final String[] COLUMNS = {NAME,APE,CORREO,USER,PASS,EDAD};

    String tabla = " CREATE TABLE "+  TABLA_USUARIOS + " ( Username TEXT PRIMARY KEY, " +
            " Nombre TEXT, " + " Apellidos TEXT, " + " Pass TEXT, "
            + " Correo REAL, " + " Edad INTEGER )";

    public DBHelperUser(Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST Usuarios");
        this.onCreate(db);

    }

    public void addUser(Usuario usuario){

         Log.d("addUsuario", usuario.toString());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put(NAME, usuario.getNombre());
        valores.put(APE, usuario.getApellidos());
        valores.put(CORREO, usuario.getCorreo());
        valores.put(USER, usuario.getUsername());
        valores.put(PASS, usuario.getPass());
        valores.put(EDAD, usuario.getEdad());

        db.insert(TABLA_USUARIOS, null, valores);

        db.close();
    }

    public Usuario getUser(String username){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLA_USUARIOS, COLUMNS, " Username = ? ", new String[] {username}, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
            Log.i(this.getClass().toString(), String.valueOf(cursor.getCount()));
        }

        Usuario user=new Usuario();
        if(cursor.moveToFirst()){
            user.setNombre(cursor.getString(0));
            user.setApellidos(cursor.getString(1));
            user.setEdad(cursor.getString(5));
            user.setCorreo(cursor.getString(2));
            user.setUsername(cursor.getString(3));
            user.setPass(cursor.getString(4));
            //Log
            Log.d("getUser("+username+")",user.toString());
            Log.d("getUser("+cursor.getString(4)+")",user.toString());

            return user;
        }else{
            return user;
        }

    }

    public List<Usuario> getAllUser(){

        List<Usuario> usuarios = new LinkedList<Usuario>();

        String query = "SELECT * FROM " + TABLA_USUARIOS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        Usuario user = null;

        if(cursor.moveToFirst()){
            do {
                user = new Usuario();
                user.setNombre(cursor.getString(0));
                user.setApellidos(cursor.getString(1));
                user.setEdad(cursor.getString(2));
                user.setCorreo(cursor.getString(3));
                user.setUsername(cursor.getString(4));
                user.setPass(cursor.getString(5));
                usuarios.add(user);

            }while (cursor.moveToNext());
        }

        Log.d("getAllBooks()",usuarios.toString());

        return usuarios;
    }

    /*
    public int updateProducto(Producto producto){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put(CODIGO, producto.getCodigo());
        valores.put(NOMBRE, producto.getNombre());
        valores.put(KCALORIAS, producto.getkCal());
        valores.put(CARBOHIDRATOS, producto.getCarbohidratos());
        valores.put(AZUCAR, producto.getAzucar());
        valores.put(COLESTEROL, producto.getColesterol());
        valores.put(SAL, producto.getSal());
        valores.put(GRASAS_SAT, producto.getGrasas_Sat());
        valores.put(GRASAS, producto.getGrasas());

        int i = db.update(TABLA_PRODUCTOS, valores, CODIGO+" = ?",new String[] {String.valueOf(producto.getCodigo())});

        db.close();

        return i;
    }
*/
    public void deleteUser(Usuario user){

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLA_USUARIOS, USER + " = ? ",new String[]{user.getUsername()});

        db.close();

        Log.d("deleteProducto",user.toString());
    }

    public boolean consultarusuario(String usuario){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLA_USUARIOS, COLUMNS, " Username = ? ", new String[] {usuario}, null, null, null, null);

        if(cursor.getCount() == 0)
        {
            return false;
        }
        else{
            return true;
        }
    }
}
