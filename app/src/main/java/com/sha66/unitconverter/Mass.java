package com.sha66.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Mass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.munits, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner fromSpinner = (Spinner) findViewById(R.id.spinner_from);
        Spinner toSpinner = (Spinner) findViewById(R.id.spinner_to);

        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);


    }
    public void convert(View view) {
        Spinner fromSpinner, toSpinner;
        EditText fromEditText, toEditText;

        fromSpinner = (Spinner) findViewById(R.id.spinner_from);
        toSpinner = (Spinner) findViewById(R.id.spinner_to);
        fromEditText = (EditText) findViewById(R.id.editText_from);
        toEditText = (EditText) findViewById(R.id.editText_to);

        String fromString = (String) fromSpinner.getSelectedItem();
        String toString = (String) toSpinner.getSelectedItem();
        double input = Double.valueOf(fromEditText.getText().toString());

        Converter2.Unit fromUnit = Converter2.Unit.fromString(fromString);
        Converter2.Unit toUnit = Converter2.Unit.fromString(toString);

        Converter2 converter = new Converter2(fromUnit, toUnit);
        NumberFormat formatter = new DecimalFormat("###,###.#####");
        double result = converter.convert(input);
        toEditText.setText(String.valueOf(formatter.format(result)));
    }
}
