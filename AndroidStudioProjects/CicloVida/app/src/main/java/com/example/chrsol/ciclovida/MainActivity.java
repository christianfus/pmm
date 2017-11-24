package com.example.chrsol.ciclovida;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.chrsol.ciclovida.R.id.text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button boton = (Button) findViewById(R.id.boton);


        boton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(miIntent);
            }
        });}

        protected void showToast(CharSequence text) {
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        protected void showAlert( CharSequence text) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage(text);
            alert.setPositiveButton(android.R.string.ok, null);
            alert.show();
        }

        @Override
        protected void onStart() {
            super.onStart();
            Toast.makeText(this,"onStart", Toast.LENGTH_SHORT).show();
        }
        @Override
        protected void onResume() {
            super.onResume();
            Toast.makeText(this,"onResume", Toast.LENGTH_SHORT).show();
        }
        @Override
        protected void onPause() {
            Toast.makeText(this,"onPause", Toast.LENGTH_SHORT).show();
            super.onPause();
        }
        @Override
        protected void onStop() {
            super.onStop();
            Toast.makeText(this,"onStop", Toast.LENGTH_SHORT).show();
        }
        @Override
        protected void onRestart() {
            super.onRestart();
            Toast.makeText(this,"onRestart", Toast.LENGTH_SHORT).show();
        }
        @Override
        protected void onDestroy() {
            Toast.makeText(this,"onDestroy", Toast.LENGTH_SHORT).show();
            super.onDestroy();
        }


    }
