package com.fivetic.recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EstadisticaHogar extends AppCompatActivity {

    private Button btn_volver_homehogar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistica_hogar);

        btn_volver_homehogar = findViewById(R.id.btn_volver_homehogar) ;

        btn_volver_homehogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volverhomehogar =  new Intent(EstadisticaHogar.this , HomeHogar.class ) ;
                startActivity(volverhomehogar);
            }
        });
    }
}