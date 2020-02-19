package com.example.myapplication.ui.signup;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class CountryOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
        //Toast.makeText(adapterView.getContext(),
        //        "OnItemSelectedListener : " + adapterView.getItemAtPosition(pos).toString(),
        //        Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
