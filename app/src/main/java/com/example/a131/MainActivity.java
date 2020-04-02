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

    private static final String TAG = "Health monitoring system";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextFIO = (EditText) findViewById(R.id.editTextFIO);
        final EditText editTextAge = (EditText) findViewById(R.id.editTextAge);

        Log.i(TAG, "Информационное сообщение при старте программы Health monitoring system");

        Button buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {


                                              int age = 0;
                                              int maxAge = 150;
                                              boolean success = false;
                                              try {
                                                  age = Integer.parseInt(editTextAge.getText().toString());
                                                  if (age > maxAge || age < 1) {
                                                      Log.e(TAG, "Введено некорректное занчение в поле ВОЗРАСТ !");
                                                      Toast.makeText(MainActivity.this, "Введите число от 1 до " + maxAge, Toast.LENGTH_LONG).show();
                                                  } else {
                                                      success = true;
                                                  }
                                              } catch (Exception e) {
                                                  Log.e(TAG, "Введено некорректное занчение в поле ВОЗРАСТ !");
                                                  Toast.makeText(MainActivity.this, "Введите число от 1 до 100", Toast.LENGTH_LONG).show();
                                              }
                                              if (success) {
                                                  Patient patient = new Patient(editTextFIO.getText().toString(), age);
                                                  Toast.makeText(MainActivity.this, patient.toString(), Toast.LENGTH_LONG).show();
                                              } else {
                                                  Log.e(TAG, "Введено некорректное значение на экране MainActivity ");
                                                  editTextAge.setText("");
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
