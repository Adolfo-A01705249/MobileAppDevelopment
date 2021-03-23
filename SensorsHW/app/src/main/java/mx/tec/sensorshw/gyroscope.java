package mx.tec.sensorshw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;


//Sensor Event Listener
public class gyroscope extends AppCompatActivity {
    float roll, pitch, yaw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);


        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        final Sensor gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        // Create a listener
        SensorEventListener gyroscopeSensorListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {

                //output the Roll [2], Pitch [2] and Yawn [2] values
                roll = sensorEvent.values[2];
                pitch = sensorEvent.values[1];
                yaw = sensorEvent.values[0];

                TextView xValues = (TextView) findViewById(R.id.valueX);
                TextView yValues = (TextView) findViewById(R.id.valueY);
                TextView zValues = (TextView) findViewById(R.id.valueZ);

                xValues.setText("" + roll);
                yValues.setText("" + pitch);
                zValues.setText("" + yaw);

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }


        };

        sensorManager.registerListener(gyroscopeSensorListener, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
}