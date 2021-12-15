package com.fivetic.recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SolicitudHogar extends AppCompatActivity {

    private Button btn_volver_hogar1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_hogar);

        btn_volver_hogar1 = findViewById(R.id.btn_volver_hogar1) ;

        btn_volver_hogar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vhogar = new Intent( SolicitudHogar.this, HomeHogar.class) ;
                startActivity(vhogar);
            }
        });
    }
}