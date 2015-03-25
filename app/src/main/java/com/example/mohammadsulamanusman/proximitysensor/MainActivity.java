package com.example.mohammadsulamanusman.proximitysensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    TextView presure1, presure2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presure1
                = (TextView)findViewById(R.id.presure1);
        presure2
                = (TextView)findViewById(R.id.presure2);

        SensorManager mySensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        Sensor LightSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if(LightSensor != null){
            presure1.setText("Sensor Available");
            mySensorManager.registerListener(
                    TestSensorListener,
                    LightSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);

        }else{
            presure1.setText("Sensor.  NOT Available");
        }
    }

    private final SensorEventListener TestSensorListener
            = new SensorEventListener(){

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType() == Sensor.TYPE_PROXIMITY){
                presure2.setText("Values are : " + event.values[0]);
                Log.d("Loggggggg : ", String.valueOf(+event.values[0]));

                // if(textLIGHT_reading.setText("Light: " + event.values[0]);)
            }
        }

    };

}
