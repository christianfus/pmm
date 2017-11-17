package com.example.chrsol.examen_christianmolto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Factura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        Bundle objeto = getIntent().getExtras();
        Pizzas pizzas = (Pizzas) objeto.getSerializable("Pizzas");
        TextView modelopizza = (TextView) findViewById(R.id.amodelo);
        TextView preciobase = (TextView) findViewById(R.id.apreciobase);
        TextView envio = (TextView) findViewById(R.id.aenvio);
        TextView extra = (TextView) findViewById(R.id.aextras);
        TextView unidades = (TextView) findViewById(R.id.aunidades);
        TextView costetotal = (TextView) findViewById(R.id.acostetotal);
        Button vuelta = (Button) findViewById(R.id.vuelta);
        final CheckBox hora = (CheckBox) findViewById(R.id.hora);
        final TextClock reloj = (TextClock) findViewById(R.id.reloj);

        modelopizza.setText(pizzas.getnombre());
        preciobase.setText(String.valueOf(pizzas.getPrecio()) + "€");
        extra.setText(objeto.getString("Queso") + objeto.getString("Tamaño") + objeto.getString("Ingredientes"));
        unidades.setText(objeto.getString("numeropizzas"));
        envio.setText(objeto.getString("nombreentrega"));
        costetotal.setText(objeto.getString("total"));

        hora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hora.isChecked()){
                    reloj.getTimeZone();
                    reloj.setVisibility(View.VISIBLE);
                }else{
                    reloj.setVisibility(View.INVISIBLE);
                }
            }
        });
        //Callback
        vuelta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver = new Intent(Factura.this, MainActivity.class);
                Bundle vuelta = new Bundle();
                vuelta.putString("hora", reloj.getText().toString());
                volver.putExtras(vuelta);
                setResult(RESULT_OK, volver);
                finish();
            }
        });
    }
}
