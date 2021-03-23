package mx.tec.sensorshw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class sms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        Button smsButton =findViewById(R.id.button_sms);
        smsButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();

                smsManager.sendTextMessage("00000000", null, "This is the lab example", null, null);
                Toast.makeText(getApplicationContext(), "SMS Sent", Toast.LENGTH_SHORT).show();
            }
        });
    }
}