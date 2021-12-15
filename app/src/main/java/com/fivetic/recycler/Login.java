package com.fivetic.recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private Button btn_login ;
    private Button btn_registrarse ;

    private EditText editText_usuario ;
    private EditText editText_clavelog ;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login) ;
        btn_registrarse = findViewById(R.id.btn_registrarse) ;

        editText_usuario = findViewById(R.id.editText_usuario) ;
        editText_clavelog = findViewById(R.id.editText_clavelog) ;







        btn_login.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String usua = editText_usuario.getText().toString();
                System.out.println("**********usuario*************" + usua);
                if (usua.equals("Hogar")){
                    Intent homehogar = new Intent(Login.this, HomeHogar.class);
                    startActivity(homehogar);
                } else {
                    Intent homereciclador = new Intent(Login.this, HomeReciclador.class);
                    startActivity(homereciclador);
                }
            }
        });

        btn_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrarse = new Intent(Login.this, Registro.class);
                startActivity(registrarse);
            }
        });
    }

}