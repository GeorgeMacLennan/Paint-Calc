package com.example.paintcalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    InteriorRoom roomSpace = new InteriorRoom();
    EditText lengthT, widthT, heightT, doorsN, windowsN;
    TextView gal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Paint Calculator");
        lengthT = (EditText) findViewById(R.id.length_ET);
        widthT = (EditText)findViewById(R.id.width_ET);
        heightT = (EditText)findViewById(R.id.height_ET);
        doorsN = (EditText)findViewById(R.id.door_ET);
        windowsN = (EditText)findViewById(R.id.window_ET);
        gal = (TextView) findViewById(R.id.galTotal);

        lengthT.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try{
                    roomSpace.setLength(Double.parseDouble(charSequence.toString()));
                }
                catch(NumberFormatException e){
                    roomSpace.setLength(0.0);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        widthT.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try{
                    roomSpace.setWidth(Double.parseDouble(charSequence.toString()));
                }
                catch(NumberFormatException e){
                    roomSpace.setWidth(0.0);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        heightT.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try{
                    roomSpace.setHeight(Double.parseDouble(charSequence.toString()));
                }
                catch(NumberFormatException e){
                    roomSpace.setHeight(0.0);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        doorsN.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try{
                    roomSpace.setNumDoors(Integer.parseInt(charSequence.toString()));
                }
                catch(NumberFormatException e){
                    roomSpace.setNumDoors(0);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        windowsN.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try{
                    roomSpace.setNumWindows(Integer.parseInt(charSequence.toString()));
                }
                catch(NumberFormatException e){
                    roomSpace.setNumWindows(0);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    public void getHelp(View view)
    {
        Intent helpIntent = new Intent(MainActivity.this, HelpActivity.class);
        startActivity(helpIntent);
    }

    public void getGallons(View view)
    {
        gal.setText(String.valueOf(roomSpace.getGallons()));
    }
}
