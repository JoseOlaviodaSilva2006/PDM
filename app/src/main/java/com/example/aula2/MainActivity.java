package com.example.aula2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private TextView lightLevelTextView;
    private ListView sensorListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initializeViews();
        initializeSensor();
        populateSensorList();
    }

    private void initializeViews() {
        lightLevelTextView = findViewById(R.id.textView);
        sensorListView = findViewById(R.id.list);
    }

    private void initializeSensor() {
.        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (lightSensor != null) {
            sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    private void populateSensorList() {
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        List<String> sensorNames = sensors.stream()
                .map(Sensor::getName)
                .collect(Collectors.toList());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sensorNames);
        sensorListView.setAdapter(adapter);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            lightLevelTextView.setText(String.valueOf(event.values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.i("SensorAccuracy", "Accuracy changed for sensor " + sensor.getName() + " to " + accuracy);
    }
}