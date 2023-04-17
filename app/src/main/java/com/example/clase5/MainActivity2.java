package com.example.clase5;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import com.example.clase5.databinding.ActivityMain2Binding;
import com.example.clase5.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity implements SensorEventListener {
    ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if(sensorManager != null){

            Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

            if(sensor != null){
                Log.d("msg-test","si tengo :D");
                sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_UI);
            }else{
                Log.d("msg-test","no tengo :(");

            }

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();

        if(type == Sensor.TYPE_ACCELEROMETER){
            Log.d("msg-test","x: " + String.valueOf(sensorEvent.values[0]));
            Log.d("msg-test","y: " + String.valueOf(sensorEvent.values[1]));
            Log.d("msg-test","z: " + String.valueOf(sensorEvent.values[2]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}