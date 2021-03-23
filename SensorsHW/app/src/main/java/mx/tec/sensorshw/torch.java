package mx.tec.sensorshw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class torch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch);

        Button onButton =(Button)findViewById(R.id.button_on);
        onButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                try {

                    CameraManager camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                    String cameraId = camManager.getCameraIdList()[0];
                    camManager.setTorchMode(cameraId, true);

                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Cannot load camera module" , Toast.LENGTH_LONG).show();

                }


            }
        });

        Button offButton =(Button)findViewById(R.id.button_off);
        offButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    CameraManager camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                    String cameraId = camManager.getCameraIdList()[0];
                    camManager.setTorchMode(cameraId, false);

                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Cannot load camera module" , Toast.LENGTH_LONG).show();

                }

            }
        });


    }
}