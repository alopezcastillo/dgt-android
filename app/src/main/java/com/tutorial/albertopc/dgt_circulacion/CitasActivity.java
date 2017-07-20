package com.tutorial.albertopc.dgt_circulacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.tutorial.albertopc.dgt_circulacion.Servicios.ServicioSQLite;
import com.tutorial.albertopc.dgt_circulacion.entity.Cita;


import java.util.ArrayList;

public class CitasActivity extends AppCompatActivity {

    private TextView tvDoi1,tvDoi2,tvDoi3,tvDoi4,tvDoi5,tvDoi6,tvDoi7,tvDoi8,tvDoi9;
    private TextView tvFecha1,tvFecha2,tvFecha3,tvFecha4,tvFecha5,tvFecha6,tvFecha7,tvFecha8,tvFecha9;
    private TextView tvAuto1,tvAuto2,tvAuto3,tvAuto4,tvAuto5,tvAuto6,tvAuto7,tvAuto8,tvAuto9;
    //No es private para ser modificado desde examen.
    TextView tvEstado1,tvEstado2,tvEstado3,tvEstado4,tvEstado5,tvEstado6,tvEstado7,tvEstado8,tvEstado9;
    private TextView tvVehiculo1, tvVehiculo2,tvVehiculo3,tvVehiculo4,tvVehiculo5,tvVehiculo6,tvVehiculo7,tvVehiculo8,tvVehiculo9;
    private ServicioSQLite servicioBD = new ServicioSQLite(this);

    String examinador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);
        tvDoi1=(TextView) findViewById(R.id.tvDoi1);
        tvDoi2=(TextView) findViewById(R.id.tvDoi2);
        tvDoi3=(TextView) findViewById(R.id.tvDoi3);
        tvDoi4=(TextView) findViewById(R.id.tvDoi4);
        tvDoi5=(TextView) findViewById(R.id.tvDoi5);
        tvDoi6=(TextView) findViewById(R.id.tvDoi6);
        tvDoi7=(TextView) findViewById(R.id.tvDoi7);
        tvDoi8=(TextView) findViewById(R.id.tvDoi8);
        tvDoi9=(TextView) findViewById(R.id.tvDoi9);
        tvFecha1=(TextView) findViewById(R.id.tvFecha1);
        tvFecha2=(TextView) findViewById(R.id.tvFecha2);
        tvFecha3=(TextView) findViewById(R.id.tvFecha3);
        tvFecha4=(TextView) findViewById(R.id.tvFecha4);
        tvFecha5=(TextView) findViewById(R.id.tvFecha5);
        tvFecha6=(TextView) findViewById(R.id.tvFecha6);
        tvFecha7=(TextView) findViewById(R.id.tvFecha7);
        tvFecha8=(TextView) findViewById(R.id.tvFecha8);
        tvFecha9=(TextView) findViewById(R.id.tvFecha9);
        tvAuto1=(TextView) findViewById(R.id.tvAuto1);
        tvAuto2=(TextView) findViewById(R.id.tvAuto2);
        tvAuto3=(TextView) findViewById(R.id.tvAuto3);
        tvAuto4=(TextView) findViewById(R.id.tvAuto4);
        tvAuto5=(TextView) findViewById(R.id.tvAuto5);
        tvAuto6=(TextView) findViewById(R.id.tvAuto6);
        tvAuto7=(TextView) findViewById(R.id.tvAuto7);
        tvAuto8=(TextView) findViewById(R.id.tvAuto8);
        tvAuto9=(TextView) findViewById(R.id.tvAuto9);
        tvEstado1=(TextView) findViewById(R.id.tvEstado1);
        tvEstado2=(TextView) findViewById(R.id.tvEstado2);
        tvEstado3=(TextView) findViewById(R.id.tvEstado3);
        tvEstado4=(TextView) findViewById(R.id.tvEstado4);
        tvEstado5=(TextView) findViewById(R.id.tvEstado5);
        tvEstado6=(TextView) findViewById(R.id.tvEstado6);
        tvEstado7=(TextView) findViewById(R.id.tvEstado7);
        tvEstado8=(TextView) findViewById(R.id.tvEstado8);
        tvEstado9=(TextView) findViewById(R.id.tvEstado9);
        tvVehiculo1=(TextView) findViewById(R.id.tvVehiculo1);
        tvVehiculo2=(TextView) findViewById(R.id.tvVehiculo2);
        tvVehiculo3=(TextView) findViewById(R.id.tvVehiculo3);
        tvVehiculo4=(TextView) findViewById(R.id.tvVehiculo4);
        tvVehiculo5=(TextView) findViewById(R.id.tvVehiculo5);
        tvVehiculo6=(TextView) findViewById(R.id.tvVehiculo6);
        tvVehiculo7=(TextView) findViewById(R.id.tvVehiculo7);
        tvVehiculo8=(TextView) findViewById(R.id.tvVehiculo8);
        tvVehiculo9=(TextView) findViewById(R.id.tvVehiculo9);
        Bundle bundle = getIntent().getExtras();
        examinador=bundle.getString("examinador");
        //   tablaCitas= new BdCitas(this, "administracion", null, 1);
        //   tablaCitas= new BdCitas(this, "admin", null, 1);
        cargaCitas();






    }
    private  void cargaCitas()
    {
        ArrayList<Cita> citas = servicioBD.getTablaCitas().consultaPorExaminador(examinador);
        if(!citas.isEmpty()) {
            tvDoi1.setText(citas.get(0).getDoi());
            tvDoi2.setText(citas.get(1).getDoi());
            tvDoi3.setText(citas.get(2).getDoi());
            tvDoi4.setText(citas.get(3).getDoi());
            tvDoi5.setText(citas.get(4).getDoi());
            tvDoi6.setText(citas.get(5).getDoi());
            tvDoi7.setText(citas.get(6).getDoi());
            tvDoi8.setText(citas.get(7).getDoi());
            tvDoi9.setText(citas.get(8).getDoi());
            tvEstado1.setText(citas.get(0).getEstado());
            tvEstado2.setText(citas.get(1).getEstado());
            tvEstado3.setText(citas.get(2).getEstado());
            tvEstado4.setText(citas.get(3).getEstado());
            tvEstado5.setText(citas.get(4).getEstado());
            tvEstado6.setText(citas.get(5).getEstado());
            tvEstado7.setText(citas.get(6).getEstado());
            tvEstado8.setText(citas.get(7).getEstado());
            tvEstado9.setText(citas.get(8).getEstado());
            tvAuto1.setText(citas.get(0).getAutoescuela());
            tvAuto2.setText(citas.get(1).getAutoescuela());
            tvAuto3.setText(citas.get(2).getAutoescuela());
            tvAuto4.setText(citas.get(3).getAutoescuela());
            tvAuto5.setText(citas.get(4).getAutoescuela());
            tvAuto6.setText(citas.get(5).getAutoescuela());
            tvAuto7.setText(citas.get(6).getAutoescuela());
            tvAuto8.setText(citas.get(7).getAutoescuela());
            tvAuto9.setText(citas.get(8).getAutoescuela());
            tvFecha1.setText(citas.get(0).getFecha());
            tvFecha2.setText(citas.get(1).getFecha());
            tvFecha3.setText(citas.get(2).getFecha());
            tvFecha4.setText(citas.get(3).getFecha());
            tvFecha5.setText(citas.get(4).getFecha());
            tvFecha6.setText(citas.get(5).getFecha());
            tvFecha7.setText(citas.get(6).getFecha());
            tvFecha8.setText(citas.get(7).getFecha());
            tvFecha9.setText(citas.get(8).getFecha());
            tvVehiculo1.setText(citas.get(0).getVehiculo());
            tvVehiculo2.setText(citas.get(1).getVehiculo());
            tvVehiculo3.setText(citas.get(2).getVehiculo());
            tvVehiculo4.setText(citas.get(3).getVehiculo());
            tvVehiculo5.setText(citas.get(4).getVehiculo());
            tvVehiculo6.setText(citas.get(5).getVehiculo());
            tvVehiculo7.setText(citas.get(6).getVehiculo());
            tvVehiculo8.setText(citas.get(7).getVehiculo());
            tvVehiculo9.setText(citas.get(8).getVehiculo());
        }
    }

    public void seleccionaExamen(View view)
    {


        boolean creado=false;
        String dni=null,fecha=null;
        int id=0;
        switch (view.getId())
        {
            case R.id.table1: if(tvEstado1.getText().equals("Creado")){creado=true;dni=tvDoi1.getText().toString();fecha=tvFecha1.getText().toString();id=R.id.tvEstado1;}break;
            case R.id.table2: if(tvEstado2.getText().equals("Creado")){creado=true;dni=tvDoi2.getText().toString();fecha=tvFecha2.getText().toString();id=R.id.tvEstado2;}break;
            case R.id.table3: if(tvEstado3.getText().equals("Creado")){creado=true;dni=tvDoi3.getText().toString();fecha=tvFecha3.getText().toString();id=R.id.tvEstado3;}break;
            case R.id.table4: if(tvEstado4.getText().equals("Creado")){creado=true;dni=tvDoi4.getText().toString();fecha=tvFecha4.getText().toString();id=R.id.tvEstado4;}break;
            case R.id.table5: if(tvEstado5.getText().equals("Creado")){creado=true;dni=tvDoi5.getText().toString();fecha=tvFecha5.getText().toString();id=R.id.tvEstado5;}break;
            case R.id.table6: if(tvEstado6.getText().equals("Creado")){creado=true;dni=tvDoi6.getText().toString();fecha=tvFecha6.getText().toString();id=R.id.tvEstado6;}break;
            case R.id.table7: if(tvEstado7.getText().equals("Creado")){creado=true;dni=tvDoi7.getText().toString();fecha=tvFecha7.getText().toString();id=R.id.tvEstado7;}break;
            case R.id.table8: if(tvEstado8.getText().equals("Creado")){creado=true;dni=tvDoi8.getText().toString();fecha=tvFecha8.getText().toString();id=R.id.tvEstado8;}break;
            case R.id.table9: if(tvEstado9.getText().equals("Creado")){creado=true;dni=tvDoi9.getText().toString();fecha=tvFecha9.getText().toString();id=R.id.tvEstado9;}break;

        }
        if(creado){Toast.makeText(this, "Comenzando examen",
                Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, ExamenActivity.class );
            i.putExtra("examinador", examinador);
            i.putExtra("estado",id);
            i.putExtra("fecha",fecha);
            i.putExtra("doi",dni);
            startActivity(i);
           // cargaCitas();
            finish();
        }
        else {Toast.makeText(this, "Examen ya calificado",
                Toast.LENGTH_LONG).show();}
    }
    public void cerrarSesion(View view)
    {

        finish();
    }

}
