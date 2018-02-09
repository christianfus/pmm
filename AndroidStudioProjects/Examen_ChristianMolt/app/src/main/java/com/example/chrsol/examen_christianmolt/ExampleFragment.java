package com.example.chrsol.examen_christianmolt;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by chrsol on 9/02/18.
 */

public class ExampleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.example_fragment, container, false);
    }

    static ExampleFragment newInstance(int number) {
        ExampleFragment f = new ExampleFragment();
        Bundle args = new Bundle();
        args.putInt("num", number);// Mantenemos el numero para usarlo en cualquier momento.
        f.setArguments(args);
        return f;

    }
}
