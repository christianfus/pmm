package com.example.chrsol.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView nom = (TextView) findViewById(R.id.nom);
        Bundle bundle = getIntent().getExtras();
        String dato = bundle.getString("Info").toString();
        nom.setText("Hola " + dato);
    }
}
