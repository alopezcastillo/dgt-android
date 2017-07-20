package com.tutorial.albertopc.dgt_circulacion;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tutorial.albertopc.dgt_circulacion.Servicios.ServicioSQLite;

public class ExamenActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String examinador,fecha, doi;
    private int idEstado;
    private TextView tvDoi,tvFecha,tvCalificacion;
    private TableLayout t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    private TextView estado;
    private TextView tvfalta1,tvfalta2,tvfalta3,tvfalta4,tvfalta5,tvfalta6,tvfalta7,tvfalta8,tvfalta9,tvfalta10;
    String[] tiposGravedad={"LEVE","DEFICIENTE","ELIMINATORIA"};
    String[] codFaltas={"1.1.1","1.1.2","1.2.3","2.1.1","2.2.1","3.1.1","3.2.1","3.2.2","4.1.1","4.1.2","4.1.3"};
    String[] descFaltas={"Velocidad superior a la permitida.","Velocidad inferiror a la permitida","Velocidad inadecuada a las circunstancias","Uso inadecuado del intermitente","Intermitente no utilizado", "Incorporación peligrosa a la vía", "Cambio brusco de carril","Circulación por  carril incorrecto","Estacionamiento en lugar prohibido","Estacionamiento lejos del bordillo","Contacto con otro vehículo al estacionar"};
    private Spinner spCod1,spGrav1,spCod2,spGrav2,spCod3,spGrav3,spCod4,spGrav4,spCod5,spGrav5,spCod6,spGrav6,spCod7,spGrav7,spCod8,spGrav8,spCod9,spGrav9,spCod10,spGrav10;
    private ServicioSQLite servicioBD = new ServicioSQLite(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen);

        Bundle bundle = getIntent().getExtras();
        examinador=bundle.getString("examinador");
        idEstado=bundle.getInt("estado");
        estado=(TextView)findViewById(idEstado);
        fecha=bundle.getString("fecha");
        doi=bundle.getString("doi");
        tvDoi= (TextView)findViewById(R.id.tvDoi);
        tvFecha=(TextView) findViewById(R.id.tvFecha);
        tvCalificacion=(TextView)findViewById(R.id.tvCalificacion);
        tvCalificacion.setTextColor(Color.rgb(0,100,0));
        tvDoi.setText(doi);
        tvFecha.setText(fecha);
        tvfalta1=(TextView)findViewById(R.id.tvFalta1);
        tvfalta2=(TextView)findViewById(R.id.tvFalta2);
        tvfalta3=(TextView)findViewById(R.id.tvFalta3);
        tvfalta4=(TextView)findViewById(R.id.tvFalta4);
        tvfalta5=(TextView)findViewById(R.id.tvFalta5);
        tvfalta6=(TextView)findViewById(R.id.tvFalta6);
        tvfalta7=(TextView)findViewById(R.id.tvFalta7);
        tvfalta8=(TextView)findViewById(R.id.tvFalta8);
        tvfalta9=(TextView)findViewById(R.id.tvFalta9);
        tvfalta10=(TextView)findViewById(R.id.tvFalta10);
        t1=(TableLayout)findViewById(R.id.tableFalta1);
        t2=(TableLayout)findViewById(R.id.tableFalta2);
        t3=(TableLayout)findViewById(R.id.tableFalta3);
        t4=(TableLayout)findViewById(R.id.tableFalta4);
        t5=(TableLayout)findViewById(R.id.tableFalta5);
        t6=(TableLayout)findViewById(R.id.tableFalta6);
        t7=(TableLayout)findViewById(R.id.tableFalta7);
        t8=(TableLayout)findViewById(R.id.tableFalta8);
        t9=(TableLayout)findViewById(R.id.tableFalta9);
        t10=(TableLayout)findViewById(R.id.tableFalta10);
        spCod1=(Spinner) findViewById(R.id.spCodigo1);
        spCod2=(Spinner) findViewById(R.id.spCodigo2);
        spCod3=(Spinner) findViewById(R.id.spCodigo3);
        spCod4=(Spinner) findViewById(R.id.spCodigo4);
        spCod5=(Spinner) findViewById(R.id.spCodigo5);
        spCod6=(Spinner) findViewById(R.id.spCodigo6);
        spCod7=(Spinner) findViewById(R.id.spCodigo7);
        spCod8=(Spinner) findViewById(R.id.spCodigo8);
        spCod9=(Spinner) findViewById(R.id.spCodigo9);
        spCod10=(Spinner) findViewById(R.id.spCodigo10);
        spGrav1=(Spinner)findViewById(R.id.spGravedad1);
        spGrav2=(Spinner)findViewById(R.id.spGravedad2);
        spGrav3=(Spinner)findViewById(R.id.spGravedad3);
        spGrav4=(Spinner)findViewById(R.id.spGravedad4);
        spGrav5=(Spinner)findViewById(R.id.spGravedad5);
        spGrav6=(Spinner)findViewById(R.id.spGravedad6);
        spGrav7=(Spinner)findViewById(R.id.spGravedad7);
        spGrav8=(Spinner)findViewById(R.id.spGravedad8);
        spGrav9=(Spinner)findViewById(R.id.spGravedad9);
        spGrav10=(Spinner)findViewById(R.id.spGravedad10);
        ArrayAdapter<String> adapGrav = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, tiposGravedad);
        ArrayAdapter <String>adapCod = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, codFaltas);
        spGrav1.setAdapter(adapGrav);spGrav2.setAdapter(adapGrav);
        spGrav3.setAdapter(adapGrav);spGrav4.setAdapter(adapGrav);
        spGrav5.setAdapter(adapGrav);spGrav6.setAdapter(adapGrav);
        spGrav7.setAdapter(adapGrav);spGrav8.setAdapter(adapGrav);
        spGrav9.setAdapter(adapGrav);spGrav10.setAdapter(adapGrav);
        spCod1.setAdapter(adapCod);spCod2.setAdapter(adapCod);
        spCod3.setAdapter(adapCod);spCod4.setAdapter(adapCod);
        spCod5.setAdapter(adapCod);spCod6.setAdapter(adapCod);
        spCod7.setAdapter(adapCod);spCod8.setAdapter(adapCod);
        spCod9.setAdapter(adapCod);spCod10.setAdapter(adapCod);

        spGrav1.setOnItemSelectedListener(this);
        spGrav2.setOnItemSelectedListener(this);
        spGrav3.setOnItemSelectedListener(this);
        spGrav4.setOnItemSelectedListener(this);
        spGrav5.setOnItemSelectedListener(this);
        spGrav6.setOnItemSelectedListener(this);
        spGrav7.setOnItemSelectedListener(this);
        spGrav8.setOnItemSelectedListener(this);
        spGrav9.setOnItemSelectedListener(this);
        spGrav10.setOnItemSelectedListener(this);
        spCod1.setOnItemSelectedListener(this);
        spCod2.setOnItemSelectedListener(this);
        spCod3.setOnItemSelectedListener(this);
        spCod4.setOnItemSelectedListener(this);
        spCod5.setOnItemSelectedListener(this);
        spCod6.setOnItemSelectedListener(this);
        spCod7.setOnItemSelectedListener(this);
        spCod8.setOnItemSelectedListener(this);
        spCod9.setOnItemSelectedListener(this);
        spCod10.setOnItemSelectedListener(this);






    }
    public void addFalta(View view)
    {
        if(t1.getVisibility()==View.GONE)
        {  t1.setVisibility(View.VISIBLE);     }
        else if(t2.getVisibility()==View.GONE)
            t2.setVisibility(View.VISIBLE);
        else if(t3.getVisibility()==View.GONE)
        t3.setVisibility(View.VISIBLE);
        else if(t4.getVisibility()==View.GONE)
        t4.setVisibility(View.VISIBLE);
        else if(t5.getVisibility()==View.GONE)
            t5.setVisibility(View.VISIBLE);
        else if(t6.getVisibility()==View.GONE)
            t6.setVisibility(View.VISIBLE);
        else if(t7.getVisibility()==View.GONE)
            t7.setVisibility(View.VISIBLE);
        else if(t8.getVisibility()==View.GONE)
            t8.setVisibility(View.VISIBLE);
        else if(t9.getVisibility()==View.GONE)
            t9.setVisibility(View.VISIBLE);
        else if(t10.getVisibility()==View.GONE)
            t10.setVisibility(View.VISIBLE);


        actualizaNota(null);

    }
    public void remove1(View view)
    {
        t1.setVisibility(View.GONE);
        spCod1.setSelection(0);
        spGrav1.setSelection(0);
        actualizaNota(null);
    }
    public void remove2(View view)
    {
        t2.setVisibility(View.GONE); actualizaNota(null);
    }
    public void remove3(View view)
    {

        t3.setVisibility(View.GONE); actualizaNota(null);
    }
    public void remove4(View view)
    {
        t4.setVisibility(View.GONE); actualizaNota(null);
    }
    public void remove5(View view)
    {
        t5.setVisibility(View.GONE); actualizaNota(null);
    }public void remove6(View view)
    {
        t6.setVisibility(View.GONE); actualizaNota(null);
    }
    public void remove7(View view)
    {
        t7.setVisibility(View.GONE); actualizaNota(null);
    }public void remove8(View view)
    {
        t8.setVisibility(View.GONE); actualizaNota(null);
    }public void remove9(View view)
    {
        t9.setVisibility(View.GONE); actualizaNota(null);
    }
    public void remove10(View view)
    {
        t10.setVisibility(View.GONE); actualizaNota(null);
    }


    public void actualizaNota(View view)
    {
        int contador=0;
        if(t1.getVisibility()==View.VISIBLE)
        {String selec=spGrav1.getSelectedItem().toString();
           contador=contadorGravedad(selec,contador);
        }
        if(t2.getVisibility()==View.VISIBLE)
        {String selec=spGrav2.getSelectedItem().toString();
            contador=contadorGravedad(selec,contador);
        }
        if(t3.getVisibility()==View.VISIBLE)
        {String selec=spGrav3.getSelectedItem().toString();
            contador=contadorGravedad(selec,contador);
        }
        if(t4.getVisibility()==View.VISIBLE)
        {String selec=spGrav4.getSelectedItem().toString();
            contador=contadorGravedad(selec,contador);
        }
        if(t5.getVisibility()==View.VISIBLE)
        {String selec=spGrav5.getSelectedItem().toString();
            contador=contadorGravedad(selec,contador);
        }
        if(t6.getVisibility()==View.VISIBLE)
        {String selec=spGrav6.getSelectedItem().toString();
            contador=contadorGravedad(selec,contador);
        }
        if(t7.getVisibility()==View.VISIBLE)
        {String selec=spGrav7.getSelectedItem().toString();
            contador=contadorGravedad(selec,contador);
        }
        if(t8.getVisibility()==View.VISIBLE)
        {String selec=spGrav8.getSelectedItem().toString();
            contador=contadorGravedad(selec,contador);
        }if(t9.getVisibility()==View.VISIBLE)
    {String selec=spGrav9.getSelectedItem().toString();
        contador=contadorGravedad(selec,contador);}

        if(t10.getVisibility()==View.VISIBLE)
        {String selec=spGrav10.getSelectedItem().toString();
            contador=contadorGravedad(selec,contador);
        }

        if(contador>9)
        {tvCalificacion.setText("NO APTO");
            tvCalificacion.setTextColor(Color.rgb(200,0,0));}
        else{tvCalificacion.setText("APTO");
            tvCalificacion.setTextColor(Color.rgb(0,100,0));}
    }





    private int contadorGravedad(String grav,int contador)
    {
        int retorno=contador;
        if (grav.equals("LEVE"))
            retorno++;
        else if(grav.equals("DEFICIENTE"))
            retorno+=5;
        else retorno +=10;
        return retorno;
    }

    public void finalizar(View view)
    {
       // estado.setText(tvCalificacion.getText().toString());
        servicioBD.getTablaCitas().modificacionEstado(doi,tvCalificacion.getText().toString());
        Toast.makeText(this, "Prueba guardada",
                Toast.LENGTH_LONG).show();

        Intent i = new Intent(this, CitasActivity.class );
        i.putExtra("examinador", examinador);
        startActivity(i);
        finish();
    }
    public void cancelarExamen(View view)
    {
        Toast.makeText(this, "Cambios descartados",
                Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, CitasActivity.class );
        i.putExtra("examinador", examinador);
        startActivity(i);
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

       // parent.getItemAtPosition(position).toString();
      if(parent.getId()==R.id.spGravedad1 || parent.getId()==R.id.spGravedad2 || parent.getId()==R.id.spGravedad3 || parent.getId()==R.id.spGravedad4 || parent.getId()==R.id.spGravedad5 || parent.getId()==R.id.spGravedad6 || parent.getId()==R.id.spGravedad7 || parent.getId()==R.id.spGravedad8 || parent.getId()==R.id.spGravedad9 || parent.getId()==R.id.spGravedad10)
      {actualizaNota(null);}
        else
      if(parent.getId()==R.id.spCodigo1 )
      {   tvfalta1.setText(descFaltas[position]);}
      else
      if(parent.getId()==R.id.spCodigo2 )
      {   tvfalta2.setText(descFaltas[position]);}
      else
      if(parent.getId()==R.id.spCodigo3 )
      {   tvfalta3.setText(descFaltas[position]);}
      else
      if(parent.getId()==R.id.spCodigo4 )
      {   tvfalta4.setText(descFaltas[position]);}
      else
      if(parent.getId()==R.id.spCodigo5 )
      {   tvfalta5.setText(descFaltas[position]);}
      else
      if(parent.getId()==R.id.spCodigo6 )
      {   tvfalta6.setText(descFaltas[position]);}
      else
      if(parent.getId()==R.id.spCodigo7 )
      {   tvfalta7.setText(descFaltas[position]);}
      else
      if(parent.getId()==R.id.spCodigo8 )
      {   tvfalta8.setText(descFaltas[position]);}
      else
      if(parent.getId()==R.id.spCodigo9 )
      {   tvfalta9.setText(descFaltas[position]);}
      else
      if(parent.getId()==R.id.spCodigo10 )
      {   tvfalta10.setText(descFaltas[position]);}
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
