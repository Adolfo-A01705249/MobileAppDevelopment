package com.example.helloworld_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class childActivity extends AppCompatActivity {

    TextView textViewManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        textViewManager = findViewById(R.id.textView2);
        Intent intentReceiver = getIntent();
        String message = intentReceiver.getStringExtra("message");
        textViewManager.setText(message);
    }
}