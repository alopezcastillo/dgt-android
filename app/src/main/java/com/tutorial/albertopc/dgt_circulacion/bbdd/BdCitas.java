package com.tutorial.albertopc.dgt_circulacion.bbdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tutorial.albertopc.dgt_circulacion.entity.Cita;

import java.util.ArrayList;

/**
 * Created by Alberto PC on 15/04/2017.
 */

public class BdCitas extends SQLiteOpenHelper {


    public BdCitas(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table citas(id integer key, doi text,fechaCitacion text,autoescuela text,vehiculo text,examinador text, estado text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean alta(Cita cita) {
     //   AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
     //           "administracion", null, 1);
        boolean retorno =true;
        try{

        SQLiteDatabase bd = this.getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put("id", cita.getId());
        registro.put("doi", cita.getDoi());
        registro.put("fechaCitacion", cita.getFecha());
        registro.put("autoescuela", cita.getAutoescuela());
        registro.put("vehiculo", cita.getVehiculo());
        registro.put("examinador", cita.getExaminador());
        registro.put("estado", cita.getEstado());
        bd.insert("citas", null, registro);
        bd.close();}
        catch(Exception ex){retorno=false;}
        return retorno;

    }
    public void modificacionEstado(String doi, String estado) {

        SQLiteDatabase bd = this.getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put("estado", estado);
        int cant = bd.update("citas", registro, "doi= '"+ doi+"'", null);
        bd.close();

    }

    public ArrayList<Cita> consultaPorExaminador(String examinador) {

        SQLiteDatabase bd = this.getWritableDatabase();
        Cursor cursor = bd.rawQuery(
                "select id,doi,fechaCitacion,autoescuela,vehiculo,estado from citas where examinador= '"+examinador+"'", null);
        ArrayList<Cita> mArrayList = new ArrayList<Cita>();
        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Cita cit = new Cita();
            // The Cursor is now set to the right position
            cit.setId(Integer.valueOf(cursor.getInt(0)));
            cit.setDoi(cursor.getString(1));
            cit.setFecha(cursor.getString(2));
            cit.setAutoescuela(cursor.getString(3));
            cit.setVehiculo(cursor.getString(4));
            cit.setExaminador(examinador);
            cit.setEstado(cursor.getString(5));
            mArrayList.add(cit);
        }
        bd.close();
        return mArrayList;
    }
   //añadir métodos
}
