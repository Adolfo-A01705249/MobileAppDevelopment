package mx.tec.sensorshw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class vibration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibration);

        Button vibButton =(Button)findViewById(R.id.button_vibrate);

        vibButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //Set the pattern for vibration
                long pattern[]={0,200,100,300,400}; // or you can just set a duration also in ms


                try {
                    Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(pattern, -1);


                }
                catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "This Hardware feature is not available", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}
