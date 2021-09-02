package com.sha66.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Delcaring widgets
   TextView textView;
   Button distance, mass, temp;
    // these are the global variables
    Spinner classSpinner, divSpinner;
    // string variable to store selected values
    String selectedClass, selectedDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initiating widgets
        textView = findViewById(R.id.textView);
        distance = findViewById(R.id.distance);
        mass = findViewById(R.id.mass);
        temp = findViewById(R.id.temp);



        distance.setOnClickListener(v -> {
            // Calling new activity Distance
    Intent intent = new Intent(this,Distance.class);
    startActivity(intent);
        });
        mass.setOnClickListener(v -> {
            // Calling new activity Mass
            Intent intent = new Intent(this,Mass.class);
            startActivity(intent);
        });
        temp.setOnClickListener(v -> {
            // Calling new activity Temperature
            Intent intent = new Intent(this,Temperature.class);
            startActivity(intent);
        });


    }
    }
