package com.example.chrsol.llamadaseventos;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

/**
 * Created by chrsol on 10/10/17.
 */

public class miButton extends Button implements View.OnClickListener {
    Context ctx=null;
    public miButton(Context context) {
        super(context);
        ctx=context;
        this.setOnClickListener(this); //recoger evento
    }
    //cuando se cree desde un recurso XML
    public miButton(Context context, AttributeSet attr){
        super(context,attr);
        ctx=context;
        this.setOnClickListener(this);
    }
    //cuando se cree desde un recurso XML
    public miButton(Context context, AttributeSet attr, int defaultStyles){
        super(context, attr, defaultStyles);
        ctx=context;
        this.setOnClickListener(this);
    }
}
    @Override
    public void onClick(View v){
        Toast.makeText(ctx, "Pulsado mi botón", Toast.LENGTH_SHORT).show();
    }
