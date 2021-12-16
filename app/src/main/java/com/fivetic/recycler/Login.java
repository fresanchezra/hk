package com.fivetic.recycler;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends AppCompatActivity implements View.OnClickListener {

    private Button btn_login;
    private Button btn_registrarse;
    private FirebaseAuth mAuth;
    private EditText editText_usuario;
    private EditText editText_clavelog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
        btn_registrarse = findViewById(R.id.btn_registrarse);

        editText_usuario = findViewById(R.id.editText_usuario);
        editText_clavelog = findViewById(R.id.editText_clavelog);

        btn_login.setOnClickListener(this);
        btn_registrarse.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_registrarse:
                irARegistro();
                break;
        }
    }

    private void irARegistro(){
        Intent ir_a_registro = new Intent(Login.this,Registro.class);
        startActivity(ir_a_registro);
    }

    private void login() {
        String txt_correo,txt_clave;

        txt_correo = editText_usuario.getText().toString();
        txt_clave = editText_clavelog.getText().toString();

        mAuth = FirebaseAuth.getInstance();

        mAuth.signInWithEmailAndPassword(txt_correo,txt_clave).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    editText_usuario.setText("");
                    editText_clavelog.setText("");
                    Intent siguiente = new Intent(Login.this,HomeHogar.class);
                    Toast.makeText(Login.this, "Logueado con exito", Toast.LENGTH_SHORT).show();
                    startActivity(siguiente);
                }
                else{
                    Toast.makeText(Login.this, "Error, verifica los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }




}