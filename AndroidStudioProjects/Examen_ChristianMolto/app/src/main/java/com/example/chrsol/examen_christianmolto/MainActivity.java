package com.example.chrsol.examen_christianmolto;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Pizzas[] datos = new Pizzas[]{
            new Pizzas("MARGARITA: ", "JAMÓN/TOMATE", 12),
            new Pizzas("TRES QUESOS: ", "QUESO1/QUESO2", 15),
            new Pizzas("BARBACOA: ", "CARNE/TOMATE", 10),
    };

    private Object[] calculos;
    private double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Para rellenear el spinner
        AdaptadorPizzas adaptador = new AdaptadorPizzas(this);
        final Spinner pizzas = (Spinner) findViewById(R.id.pizzas);
        pizzas.setAdapter(adaptador);

        Button calcular = (Button)findViewById(R.id.calcular);
        final RadioGroup entrega = (RadioGroup)findViewById(R.id.entrega);
        final Button local = (Button)findViewById(R.id.local);
        final Button domicilio = (Button)findViewById(R.id.domicilio);
        final EditText numeropizzas = (EditText)findViewById(R.id.numeropizzas);
        final CheckBox tamano = (CheckBox)findViewById(R.id.tamano);
        final CheckBox ingredientes = (CheckBox)findViewById(R.id.ingredientes);
        final CheckBox queso = (CheckBox)findViewById(R.id.queso);


        //Cálculos precio Pizza
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent paso = new Intent(MainActivity.this, Factura.class);

                Bundle pasoobjetos = new Bundle();

                double precioPizza = datos[pizzas.getSelectedItemPosition()].getPrecio();
                Pizzas pizzas1 = new Pizzas (datos[pizzas.getSelectedItemPosition()].getnombre(),
                        datos[pizzas.getSelectedItemPosition()].getdescripcion(),
                        datos[pizzas.getSelectedItemPosition()].getPrecio());
                pasoobjetos.putSerializable("Pizzas", pizzas1);
                paso.putExtras(pasoobjetos);

                total = Float.parseFloat(numeropizzas.getText().toString()) * datos[pizzas.getSelectedItemPosition()].getPrecio();

                double PrecioPizzas = 0;
                if (numeropizzas.getText().toString().isEmpty()){
                    numeropizzas.setText("0");
                }

                paso.putExtra("numeropizzas", numeropizzas.getText().toString());
                paso.putExtra("preciopizzas", String.valueOf(PrecioPizzas));


                double tarifa = 0;
                String ntarifa = " ";
                if (entrega.getCheckedRadioButtonId() == R.id.local){
                    ntarifa = local.getText().toString();
                    tarifa = (total * 10 ) / 100;
                    ntarifa = local.getText().toString();
                }
                if (entrega.getCheckedRadioButtonId() == R.id.domicilio){
                    ntarifa = domicilio.getText().toString();
                    tarifa = 0;
                    ntarifa = domicilio.getText().toString();
                }
                paso.putExtra("nombreentrega", ntarifa);
                paso.putExtra("tarifa", String.valueOf(tarifa));
                total = total + tarifa;


                boolean checked = false;
                if(tamano.isChecked()){
                    checked = true;
                    paso.putExtra("Tamaño ", tamano.getText().toString());
                    paso.putExtra("checked", checked);
                }
                if(queso.isChecked()){
                    checked = true;
                    paso.putExtra("Queso", queso.getText().toString());
                    paso.putExtra("checked2", checked);
                }
                if(ingredientes.isChecked()){
                    checked = true;
                    paso.putExtra("Ingredientes ", ingredientes.getText().toString());
                    paso.putExtra("checked2", checked);
                }
                startActivity(paso);


                paso.putExtra("total", String.valueOf(total));
                String mensaje = "Total = " + total;
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }
        });
    }

    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.acerca:
                Intent acerca = new Intent(MainActivity.this, acercade.class);
                startActivity(acerca);
                return true;
            case R.id.dibujar:
                Intent dibujo = new Intent(MainActivity.this, dibujar.class);
                startActivity(dibujo);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public class AdaptadorPizzas extends ArrayAdapter<Pizzas> {
        Activity context;

        AdaptadorPizzas(Activity context){
            super(context, R.layout.listitem_pizza, datos);
            this.context = context;
        }
        public View getDropDownView (int position, View convertView, ViewGroup parent){
            View vistaDesplegada = getView(position, convertView, parent);
            return  vistaDesplegada;

        }

        public View getView(int i, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_pizza, null);

            TextView lblTitulo = (TextView) item.findViewById(R.id.LblZona);
            lblTitulo.setText(datos[i].getnombre());

            TextView lblSubtitulo = (TextView) item.findViewById(R.id.LblContinente);
            lblSubtitulo.setText(datos[i].getdescripcion());

            TextView lblPrecio = (TextView)item.findViewById(R.id.LblPrecio);
            lblPrecio.setText(String.valueOf(datos[i].getPrecio()) + "€");

            return (item);
        }

    }
}
