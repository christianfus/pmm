package com.example.chrsol.layoutejer2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button red = (Button) findViewById(R.id.red);
        final Button blue = (Button) findViewById(R.id.blue);
        final Button yellow = (Button) findViewById(R.id.yellow);
        final Button clear = (Button) findViewById(R.id.clear);
        final TextView textv = (TextView) findViewById(R.id.textv) ;

        red.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textv.setBackgroundColor(Color.parseColor("#FF0000"));
            }
        });

        blue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textv.setBackgroundColor(Color.parseColor("#0000FF"));
            }
        });

        yellow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textv.setBackgroundColor(Color.parseColor("#FFFF00"));
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textv.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        });
    }


}
