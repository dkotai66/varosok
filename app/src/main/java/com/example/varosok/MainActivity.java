package com.example.varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button listazas, ujFelvetel;
    private String url = "https://retoolapi.dev/akoAz5/varosok";
    private List<Varosok> orszagok = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        ujFelvetel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openListActivity();
            }
        });
    }

    private void openListActivity(){
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    private void init(){
        listazas = findViewById(R.id.listazas);
        ujFelvetel = findViewById(R.id.ujFelvetel);
    }
}
