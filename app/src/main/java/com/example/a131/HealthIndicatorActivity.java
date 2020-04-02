package com.example.a131;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HealthIndicatorActivity extends AppCompatActivity {

    private static final String TAG = "Health monitoring system";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_indicator);


        final EditText editTextWeight = (EditText) findViewById(R.id.editTextWeight);
        final EditText editTextSteps = (EditText) findViewById(R.id.editTextSteps);

        Button buttonHealthIndicatorSave = (Button) findViewById(R.id.buttonHealthIndicatorSave);
        buttonHealthIndicatorSave.setOnClickListener(new View.OnClickListener() {
                                                         @Override
                                                         public void onClick(View v) {
                                                             double weight = 0.0;
                                                             int steps = 0;
                                                             boolean success = false;

                                                             if (
                                                                     isCorrectDouble(editTextWeight.getText().toString(), 1.000, 300.000, "Некорректное значение веса")
                                                                             &&
                                                                             isCorrectInt(editTextSteps.getText().toString(), 0, 100000, "Некорректное значение шагов")
                                                             ) {
                                                                 weight = Double.parseDouble(editTextWeight.getText().toString());
                                                                 steps = Integer.parseInt(editTextSteps.getText().toString());
                                                                 HealthIndicator healthIndicator = new HealthIndicator(weight, steps);
                                                                 Toast.makeText(HealthIndicatorActivity.this, healthIndicator.toString(), Toast.LENGTH_LONG).show();
                                                             } else {
                                                                 Log.e(TAG, "Введено некорректное занчение на экране  HealthIndicatorActivity !!! ");
                                                                 //Toast.makeText(PressureActivity.this, pressure.toString(), Toast.LENGTH_LONG).show();
                                                                 //editTextAge.setText("");
                                                             }
                                                         }
                                                     }
        );

    }

    public boolean isCorrectDouble(String inputText, double min, double max, String messageText) {
        boolean result = false;
        try {
            double inputDouble = Double.parseDouble(inputText);
            if (inputDouble <= max && inputDouble >= min) {
                result = true;
            } else {
                Log.e(TAG, "Введено " + messageText);
                Toast.makeText(HealthIndicatorActivity.this, messageText + " Введите число от " + min + " до " + max, Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Log.e(TAG, "Введено " + messageText);
            Toast.makeText(HealthIndicatorActivity.this, "Введите число от " + min + " до " + max, Toast.LENGTH_LONG).show();
        }
        return result;
    }

    public boolean isCorrectInt(String inputText, int min, int max, String messageText) {
        boolean result = false;
        try {
            int inputInt = Integer.parseInt(inputText);
            if (inputInt <= max && inputInt >= min) {
                result = true;
            } else {
                Log.e(TAG, "Введено " + messageText);
                Toast.makeText(HealthIndicatorActivity.this, messageText + " Введите число от " + min + " до " + max, Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Log.e(TAG, "Введено " + messageText);
            Toast.makeText(HealthIndicatorActivity.this, "Введите число от " + min + " до " + max, Toast.LENGTH_LONG).show();
        }
        return result;
    }

}