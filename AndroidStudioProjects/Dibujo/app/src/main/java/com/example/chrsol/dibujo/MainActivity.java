package com.example.chrsol.dibujo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View {
        public EjemploView(Context contexto) {
            super(contexto);
        }

        protected void onDraw(Canvas canvas) {
            Paint pincel = new Paint();
            pincel.setColor(Color.BLUE);
            pincel.setStrokeWidth(15);
            pincel.setStyle(Paint.Style.STROKE);


            for (int i = 0; i < 100; i += 100) {
                canvas.drawCircle(i + 50, i + 50, 50 + i, pincel);
            }
            for (int i = 0; i < 100; i += 100) {
                canvas.drawCircle(i + 50, i - 50, 50 - i, pincel);
            }
        }


    }
}