package com.example.chrsol.examen_christianmolt;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chrsol on 9/02/18.
 */

public class PreferenciasFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.preferencias_fragment, container, false);
    }

    static PreferenciasFragment newInstance(int idRow, String tarea, String lugar,
                                            int importancia, String descripcion) {
        PreferenciasFragment f = new PreferenciasFragment();
        Bundle args = new Bundle();

        args.putInt("id", idRow);
        args.putString("tarea", tarea);
        args.putString("lugar", lugar);
        args.putInt("importancia", importancia);
        args.putString("descripcion", descripcion);
        f.setArguments(args);
        return f;
    }
}
