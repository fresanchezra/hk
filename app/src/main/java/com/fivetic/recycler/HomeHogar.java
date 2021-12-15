package com.fivetic.recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeHogar extends AppCompatActivity {

    private Button btn_recogida ;
    private Button btn_ehogar ;
    private Button btn_phogar ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_hogar);

        btn_recogida = findViewById(R.id.btn_recogida) ;
        btn_ehogar = findViewById(R.id.btn_ehogar) ;
        btn_phogar = findViewById(R.id.btn_phogar) ;

        btn_recogida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shogar = new Intent(HomeHogar.this, SolicitudHogar.class) ;
                startActivity(shogar);

            }
        });

        btn_ehogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ehogar = new Intent(HomeHogar.this, EstadisticaHogar.class) ;
                startActivity(ehogar);

            }
        });

        btn_phogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phogar = new Intent(HomeHogar.this, Pedagogia.class) ;
                startActivity(phogar);

            }
        });


    }
}