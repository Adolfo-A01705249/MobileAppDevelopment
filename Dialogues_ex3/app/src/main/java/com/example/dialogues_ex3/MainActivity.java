package com.example.dialogues_ex3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context maContext;
    Toast maToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maContext = getApplicationContext();

        // Toast
        maToast = new Toast(maContext);
        maToast.makeText(maContext, "Hello from a toast", Toast.LENGTH_LONG).show();

        // Regular dialogue
        AlertDialog.Builder dialogConf = new AlertDialog.Builder(this);

        dialogConf.setTitle("Are you ok with it?");
        dialogConf.setMessage("This is the Text of the Neutral Dialog");
        dialogConf.setIcon(R.mipmap.ic_launcher);
        dialogConf.setNeutralButton("OKEY", null);
        dialogConf.setPositiveButton("YUP", null);
        dialogConf.setNegativeButton("NOPE", null);

        AlertDialog maDialog = dialogConf.create();
        maDialog.show();

        // Notification
        Notification.Builder notificationConf = new Notification.Builder(this);

        notificationConf.setContentTitle("This is a notification");
        notificationConf.setContentText("This is the text of the notification lol.");
        notificationConf.setSmallIcon(R.mipmap.ic_launcher);

        NotificationManager myNotification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        myNotification.notify(123, notificationConf.build());

    }
}