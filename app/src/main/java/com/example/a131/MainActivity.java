package com.example.a131;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG =  MainActivity.class.getName();
    private static final int MAX_AGE = 150;
    int age = 0;
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextFIO = findViewById(R.id.editTextFIO);
        final EditText editTextAge = findViewById(R.id.editTextAge);

        Log.i(TAG, "Информационное сообщение при старте программы Health monitoring system");

        Button buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {

                                              try {
                                                  age = Integer.parseInt(editTextAge.getText().toString());
                                                  name = editTextFIO.getText().toString();

                                                  if (name.trim().length() == 0) {
                                                      Toast.makeText(MainActivity.this, "Введите имя пациента", Toast.LENGTH_LONG).show();
                                                                                                      }
                                                  else if (age > MAX_AGE || age < 1 ) {
                                                      Log.e(TAG, "Введено некорректное занчение в поле ВОЗРАСТ !");
                                                      Toast.makeText(MainActivity.this, "Введите возраст пациента от 1 до " + MAX_AGE, Toast.LENGTH_LONG).show();

                                                  } else {
                                                      Patient patient = new Patient(editTextFIO.getText().toString(), age);
                                                      Toast.makeText(MainActivity.this, patient.toString(), Toast.LENGTH_LONG).show();

                                                  }
                                              } catch (Exception e) {
                                                  Log.e(TAG, "Введено некорректное занчение в поле ВОЗРАСТ !");
                                                  Toast.makeText(MainActivity.this, "Введите имя и возраст пациента", Toast.LENGTH_LONG).show();

                                              }
                                          }
                                      }
        );

        Button buttonPressure = (Button) findViewById(R.id.buttonPressure);
        buttonPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PressureActivity.class);
                startActivity(intent);
            }
        });

        Button buttonHealthIndicator = (Button) findViewById(R.id.buttonHealthIndicator);
        buttonHealthIndicator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HealthIndicatorActivity.class);
                startActivity(intent);

            }
        });
    }
}