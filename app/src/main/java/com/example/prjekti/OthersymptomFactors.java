package com.example.prjekti;

/**
 * @author Gresa Krasniqi
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class OthersymptomFactors extends AppCompatActivity {

    private Button resultsButton;
    private CheckBox lightsensCB, nauseaCB, appetitelossCB, tiredCB, feverCB, otherCB;
    private String lightsens, nausea, appetiteloss, tired, fever, other;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_symptoms_factor);

        this.lightsensCB = findViewById(R.id.lightsensCheckBox);
        this.nauseaCB = findViewById(R.id.nauseaCheckBox);
        this.appetitelossCB = findViewById(R.id.appetitelossCheckBox);
        this.tiredCB = findViewById(R.id.tiredCheckBox);
        this.feverCB = findViewById(R.id.feverCheckBox);
        this.otherCB = findViewById(R.id.otherCheckBox);

        Intent factors = getIntent();


    }

    public void resultsButtonPressed(View v){
        //creating shared preferences file to send objects to xml file
        SharedPreferences mPrefs = getSharedPreferences("SP", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = mPrefs.edit();

        if(lightsensCB.isChecked()) {

            lightsens = lightsensCB.getText().toString();
            prefsEditor.putString("Stress", lightsens);
            ((SharedPreferences.Editor) prefsEditor).commit();
        }

        if(nauseaCB.isChecked()){

            nausea = nauseaCB.getText().toString();
            prefsEditor.putString("Nausea", nausea);
            ((SharedPreferences.Editor) prefsEditor).commit();

        }

        if(appetitelossCB.isChecked()){

            appetiteloss = appetitelossCB.getText().toString();
            prefsEditor.putString("Loss of appetite", appetiteloss);
            ((SharedPreferences.Editor) prefsEditor).commit();
        }
        if(tiredCB.isChecked()){

            tired = tiredCB.getText().toString();
            prefsEditor.putString("Tired", tired);
            ((SharedPreferences.Editor) prefsEditor).commit();
        }
        if(feverCB.isChecked()){

            fever = feverCB.getText().toString();
            prefsEditor.putString("Fever", fever);
            ((SharedPreferences.Editor) prefsEditor).commit();
        }
        if(otherCB.isChecked()){

            other = otherCB.getText().toString();
            prefsEditor.putString("Other", other);
            ((SharedPreferences.Editor) prefsEditor).commit();
        }
        else{
            prefsEditor.putString("No side effects or other symptoms ", null);
            ((SharedPreferences.Editor) prefsEditor).commit();

        }

        // get shared preferences for values
        SharedPreferences sh = getSharedPreferences("SP", MODE_PRIVATE);
        SharedPreferences.Editor shEdit = sh.edit();

        String lightsensFactorFromXML = sh.getString("Sensitivity to Light", "");
        String nauseaFactorFromXML = sh.getString("Nausea", "");
        String appetitelossFactorFromXML = sh.getString("Loss of appetite", "");
        String tiredFactorFromXML = sh.getString("Tired", "");
        String feverFactorFromXML = sh.getString("Fever", "");
        String otherFactorFromXML = sh.getString("Other", "");


        Log.d("TAG",   lightsensFactorFromXML+ "\n" + nauseaFactorFromXML);

        // sending data to next activity
        Intent results = new Intent(this, Results.class);
        results.putExtra("Sensitivity to Light", lightsensFactorFromXML);
        results.putExtra("Nausea", nauseaFactorFromXML);
        results.putExtra("Loss of appetite", appetitelossFactorFromXML);
        results.putExtra("Tired", tiredFactorFromXML);
        results.putExtra("Fever", feverFactorFromXML);
        results.putExtra("Other", otherFactorFromXML);


        startActivity(results);



    }
}