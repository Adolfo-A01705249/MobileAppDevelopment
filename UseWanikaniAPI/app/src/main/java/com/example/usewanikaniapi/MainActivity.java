package com.example.usewanikaniapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.BreakIterator;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Do default activity creation stuff
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Attach event listener to get stats button
        Button requestButton = findViewById(R.id.calculate_btn);
        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = findViewById(R.id.calculate_btn);
                btn.setEnabled(false);
                getStats("https://api.wanikani.com/v2/assignments");
            }
        });
    }

    // Gets data from the Wanikani API and shows it on screen
    private void getStats(String url) {
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
            (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    // Traverse the data returned by the API
                    JSONArray data = response.optJSONArray("data");
                    for(int i = 0; i < data.length(); i++) {
                        JSONObject assignment = data.optJSONObject(i);
                        JSONObject assignmentData = assignment.optJSONObject("data");
                        String subjectType = assignmentData.optString("subject_type");

                        if(subjectType.equals("radical")) {
                            increaseCount((TextView) findViewById(R.id.radical_txt));
                        }
                        else if(subjectType.equals("kanji")) {
                            increaseCount((TextView) findViewById(R.id.kanji_txt));
                        }
                        else if(subjectType.equals("vocabulary")) {
                            increaseCount((TextView) findViewById(R.id.vocabulary_txt));
                        }
                    }

                    // Repeat request if there's another page
                    JSONObject pages = response.optJSONObject("pages");
                    String nextUrl = pages.optString("next_url");
                    if(nextUrl.equals("null")) {
                        displaySuccess();
                    }
                    else {
                        getStats(nextUrl);
                    }
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    // TODO: Handle error
                    displayError("The request didn't work!");
                }
            }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "Bearer 905977b4-d5e1-4cf1-8f26-d0ef1fac7caa");
                return params;
            }
        };

        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest);
    }

    private void displayError(String errorString) {
        TextView errorTextView = (TextView) findViewById(R.id.errors_txt);
        errorTextView.setText(errorString);
    }

    private void displaySuccess() {
        TextView successTextView = (TextView) findViewById(R.id.complete_txt);
        successTextView.setVisibility(TextView.VISIBLE);
    }

    private void increaseCount(TextView textView) {
        String text = (String) textView.getText();
        int count = Integer.parseInt(text);
        textView.setText(String.valueOf(count+1));
    }
}