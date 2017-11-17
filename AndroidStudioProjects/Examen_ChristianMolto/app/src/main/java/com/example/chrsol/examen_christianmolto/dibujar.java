package com.example.chrsol.examen_christianmolto;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class dibujar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Dibujo(this));

    }

    public class Dibujo extends View {
        public Dibujo(Context context) {
            super(context);
        }

        float x = 50;
        float y = 50;
        String accion = "accion";
        Path path = new Path();

        protected void onDraw(Canvas canvas) {

            Paint pizza = new Paint();
            Paint pepperoni = new Paint();
            Paint linea_une = new Paint();
            Paint linea_delante = new Paint();
            Paint linea_trasera = new Paint();



            pizza.setColor(Color.BLACK);
            pizza.setStrokeWidth(15);
            pizza.setStyle(Paint.Style.STROKE);

            pepperoni.setColor(Color.RED);
            pepperoni.setStrokeWidth(50);
            pepperoni.setStyle(Paint.Style.STROKE);

            canvas.drawCircle(500, 500, 400, pizza);
            canvas.drawCircle(300, 300, 20, pepperoni);
            canvas.drawCircle(700, 700, 30, pepperoni);
            canvas.drawCircle(300, 700, 30, pepperoni);


            linea_une.setColor(Color.BLACK);
            linea_une.setStrokeWidth(15);
            linea_une.setStyle(Paint.Style.STROKE);


            linea_delante.setColor(Color.BLACK);
            linea_delante.setStrokeWidth(15);
            linea_delante.setStyle(Paint.Style.STROKE);

            canvas.drawLine(800, 500, 700, 500, linea_delante);

            linea_trasera.setColor(Color.BLACK);
            linea_trasera.setStrokeWidth(15);
            linea_trasera.setStyle(Paint.Style.STROKE);

            canvas.drawLine(200, 500, 100, 500, linea_trasera);

            Paint tactil = new Paint();

            tactil.setColor(Color.RED);
            tactil.setStrokeWidth(15);
            tactil.setStyle(Paint.Style.STROKE);

            canvas.drawPath(path, tactil);

        }
    }
}