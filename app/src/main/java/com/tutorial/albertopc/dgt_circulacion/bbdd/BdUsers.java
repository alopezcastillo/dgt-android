package com.tutorial.albertopc.dgt_circulacion.bbdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.tutorial.albertopc.dgt_circulacion.entity.Usuario;

/**
 * Created by Alberto PC on 15/04/2017.
 */

public class BdUsers extends SQLiteOpenHelper {


    public BdUsers(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(usuario text key,password text, nombre text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public String consultaUsuarioPassword(String user,String pass)
    {
        String retorno=null;
        SQLiteDatabase bd=this.getReadableDatabase();
        Cursor fila = bd.rawQuery(
                "select nombre from users where usuario='" + user +"' and password ='" + pass +"'", null);
        if (fila.moveToFirst()) {
            retorno=fila.getString(0);}
        return  retorno;

    }

    public void alta(Usuario user) {

        SQLiteDatabase bd=this.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("usuario", user.getUsuario());
        registro.put("password", user.getPassword());
        registro.put("nombre", user.getNombre());
        bd.insert("users", null, registro);
        bd.close();

    }

   //añadir métodos
}
