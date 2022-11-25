package com.example.varosok;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class ListActivity extends AppCompatActivity {

    String data = "";

    private TextView listActivityTextView;
    private Button listActivityButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listactivity);
        listActivityTextView.setMovementMethod(new ScrollingMovementMethod());
        init();
        kiiratas();

        listActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void kiiratas() {
        PerformNetworkRequest request = new PerformNetworkRequest("GET");
        request.execute();
    }

    private void frissitMuvelet() {
        this.runOnUiThread(frissites);
    }

    private Runnable frissites = new Runnable() {
        @Override
        public void run() {
            listActivityTextView.setText(data);
        }
    };

    private class PerformNetworkRequest extends AsyncTask<Void, Void, String> {
        String method;
        String content;

        public PerformNetworkRequest(String method) {
            this.method = method;
            this.content = " ";
        }

        public PerformNetworkRequest(String method, String content) {
            this.method = method;
            this.content = content;
        }


        @Override
        protected String doInBackground(Void... voids) {
            try {
                if (method.equals("GET")){
                    data = Request.getData();
                } else {
                    data = Request.postData(content);
                }
            } catch (IOException e) {
                data = e.getMessage();
            }

            frissitMuvelet();
            return data;
        }
    }


    private void init () {
        listActivityTextView = findViewById(R.id.listActivityTextView);
        listActivityButton = findViewById(R.id.listActivityButton);
    }
}