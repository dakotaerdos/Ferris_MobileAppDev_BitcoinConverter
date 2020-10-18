package com.zybooks.bitcoinconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView usdTextNumber;
    public TextView bitcoinTextNumber;
    private final double bitcoinConversion = 10413;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usdTextNumber = findViewById(R.id.usdTextNumber);
        bitcoinTextNumber = findViewById(R.id.bitcoinTextNumber);

        usdTextNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String stringValue = s.toString();
                double newValue;

                try {
                    newValue = Double.parseDouble(stringValue);
                }
                catch (NumberFormatException ex ) {
                    newValue = 0;
                }

                bitcoinTextNumber.setText(String.valueOf(newValue/bitcoinConversion));
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        bitcoinTextNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String stringValue = s.toString();
                double newValue;

                try {
                    newValue = Double.parseDouble(stringValue);
                }
                catch (NumberFormatException ex ) {
                    newValue = 0;
                }

                usdTextNumber.setText(String.valueOf(newValue*bitcoinConversion));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}