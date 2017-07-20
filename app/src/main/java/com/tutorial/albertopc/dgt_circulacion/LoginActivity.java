package com.tutorial.albertopc.dgt_circulacion;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tutorial.albertopc.dgt_circulacion.Servicios.ServicioSQLite;
import com.tutorial.albertopc.dgt_circulacion.bbdd.BdUsers;



public class LoginActivity extends AppCompatActivity {

    private EditText etName, etPass;
    protected  String hayBD=null;
    private ServicioSQLite servicioBD = new ServicioSQLite(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etName=(EditText)findViewById(R.id.etName);
        etPass=(EditText)findViewById(R.id.etPass);



        SharedPreferences prefe=getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        hayBD=prefe.getString("bd","");
        if( hayBD==null || hayBD.equals(""))
        {

            SharedPreferences.Editor editor=prefe.edit();
            editor.putString("bd", "ok");
            editor.commit();
            servicioBD.altaBD();
        }


    }



    public void login(View view)
    {
        String user = etName.getText().toString();
        String pass = etPass.getText().toString();
        if(user.isEmpty() || pass.isEmpty())
        {
            Toast.makeText(this, "No se admiten parámetros vacíos",Toast.LENGTH_SHORT).show();
        }
        else
        {
            String nombre= servicioBD.getTablaUsers().consultaUsuarioPassword(user,pass);
            if (nombre!=null && !nombre.isEmpty())
            {
                //   try {

                Intent i = new Intent(this, CitasActivity.class );
                i.putExtra("examinador", user);
                startActivity(i);
                Toast.makeText(this, "Bienvenido "+nombre,
                        Toast.LENGTH_SHORT).show();
                //       Thread.sleep(3000);
                //   } catch (InterruptedException e) {
                //       e.printStackTrace();
                //     }
            } else
                Toast.makeText(this, "Usuario o contraseña erróneos",
                        Toast.LENGTH_LONG).show();

        }
    }





}
