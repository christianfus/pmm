package com.example.chrsol.a4botones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class radio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);


        final RadioGroup rg = (RadioGroup)findViewById(R.id.gruporb);
        final RadioButton suma = (RadioButton)findViewById(R.id.suma);
        final RadioButton resta = (RadioButton)findViewById(R.id.resta);

        final EditText num1 = (EditText) findViewById(R.id.num1);
        final EditText num2 = (EditText) findViewById(R.id.num2);
        final Button boton = (Button) findViewById(R.id.boton);
        final TextView resultado = (TextView) findViewById(R.id.resultado);

        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int operacion = 0;

                if(suma.isChecked()){
                    int numero1 = Integer.parseInt(num1.getText().toString());
                    int numero2 = Integer.parseInt(num2.getText().toString());
                    operacion = numero1 + numero2;
                }
                else if (resta.isChecked()){
                    int numero1 = Integer.parseInt(num1.getText().toString());
                    int numero2 = Integer.parseInt(num2.getText().toString());
                    operacion = numero1 - numero2;
                }

                resultado.setText(String.valueOf(operacion));
            }
        });

       /* rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {

            }
        });*/
    }
}
