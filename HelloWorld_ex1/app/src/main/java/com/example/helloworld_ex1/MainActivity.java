package com.example.helloworld_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonManager;
    TextView textViewManager;
    ImageView imageViewManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign managers to their components
        buttonManager = findViewById(R.id.button); // all components are all called "views"
        textViewManager = findViewById(R.id.textView);
        imageViewManager = findViewById(R.id.imageView);

        buttonManager.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(imageViewManager.getVisibility() == View.VISIBLE) {
                    imageViewManager.setVisibility(View.INVISIBLE);
                }
                else {
                    imageViewManager.setVisibility(View.VISIBLE);
                }

                // Activities are given launched through intents
                Intent intent = new Intent(MainActivity.this, childActivity.class);
                String message = textViewManager.getText().toString();
                intent.putExtra("message", message);
                startActivity(intent);
            }
        });
    }
}