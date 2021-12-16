package com.fivetic.recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;


import android.view.View;

import android.widget.EditText;


public class Pedagogia extends AppCompatActivity {

    private Button btn_volver ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedagogia);

        btn_volver = findViewById(R.id.btn_volver) ;

        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volverHHogar = new Intent(Pedagogia.this, HomeHogar.class) ;
                startActivity (volverHHogar);
            }
        });



    }
}