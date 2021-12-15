package com.fivetic.recycler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.* ;
import com.fivetic.recycler.Constantes;
import com.fivetic.recycler.Usuario;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Registro extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth ;
    private RadioGroup btn_radioGroup ;
    private EditText editText_nombre ;
    private EditText editText_correo ;
    private EditText editText_clavereg ;
    private EditText editText_direccion ;
    private EditText editText_ciudad ;
    private Button btn_acept ;
    /*private LocationManager ubicacion;
    private TextView TextViewlatitud;
    private TextView TextViewlongitud;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mAuth = FirebaseAuth.getInstance();

        btn_radioGroup = findViewById(R.id.btn_radioGroup) ;
        editText_nombre = findViewById(R.id.editText_nombre) ;
        editText_correo = findViewById(R.id.editText_correo) ;
        editText_clavereg = findViewById(R.id.editText_clavereg) ;
        editText_ciudad = findViewById(R.id.editText_ciudad) ;
        editText_direccion = findViewById(R.id.editText_direccion) ;
        btn_acept = findViewById(R.id.btn_acept) ;

        /*localizacion();
        registrarLocalizacion();*/
        btn_acept.setOnClickListener(this);
    }

    public void onClick(View v) {


        String tipo, nombre, correo, clave, direccion, ciudad;

        nombre = editText_nombre.getText().toString();
        correo = editText_correo.getText().toString();
        clave = editText_clavereg.getText().toString();
        direccion = editText_direccion.getText().toString();
        ciudad = editText_ciudad.getText().toString();

        tipo = "Hogar";
        Pattern pat_num = Pattern.compile("[0-9]");
        Pattern pat_esp = Pattern.compile("[$&+,:;=?@#|'<>.^*()%!-]");
        Pattern pat_alfa = Pattern.compile("[A-Z]");

        Matcher mat_clave_esp = pat_esp.matcher(clave);
        boolean match_found_clave_esp = mat_clave_esp.find();

        Matcher mat_clave_num = pat_num.matcher(clave);
        boolean match_found_clave_num = mat_clave_num.find();

        Matcher mat_clave_alfa = pat_alfa.matcher(clave);
        boolean match_found_clave_alfa = mat_clave_alfa.find();

        // implementar geolocalizacion
        // funciones de localizacion

        if(clave.length()>=8){

              if (match_found_clave_esp || match_found_clave_num || match_found_clave_alfa){
                  registarUsuario(tipo, nombre, correo, clave, direccion, ciudad);

              }  else {
                  Toast.makeText(Registro.this,"Por favor Valida los datos",Toast.LENGTH_LONG).show();

              }
        }else{
             Toast.makeText(Registro.this,"Por favor Valida los datos",Toast.LENGTH_LONG).show();
        }
}


    /*private void localizacion(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION
            },1000);
        }
        TextViewlongitud= findViewById(R.id.longitud);
        TextViewlatitud= findViewById(R.id.latitud);
        ubicacion=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location loc=ubicacion.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (ubicacion!=null){
            Log.d("latitud",String.valueOf(loc.getLatitude()));
            Log.d("longitud",String.valueOf(loc.getLongitude()));
        }
    }

    private void registrarLocalizacion() {
        ubicacion = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        ubicacion.requestLocationUpdates(LocationManager.GPS_PROVIDER, 30000, 0, new milocalizacionListener());
    }

    private class milocalizacionListener implements LocationListener {

        @Override
        public void onLocationChanged(@NonNull Location location) {
            double lat =location.getLatitude();
            double lon =location.getLongitude();
            TextViewlongitud.setText(String.valueOf(lon));
            TextViewlatitud.setText(String.valueOf(lat));
        }


        @Override
        public void onLocationChanged(@NonNull List<Location> locations) {

        }

        @Override
        public void onFlushComplete(int requestCode) {

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(@NonNull String provider) {

        }

        @Override
        public void onProviderDisabled(@NonNull String provider) {

        }
    }*/


    public void registarUsuario( String tipo,  String nombre, String correo, String clave, String direccion, String ciudad){
        //System.out.println("en la funcion registrar usuario");
        System.out.println( "valor de nombre en la funcion ---> "+ nombre);

        mAuth.createUserWithEmailAndPassword(correo,clave).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                String uid;
                if(task.isSuccessful())
                {
                    Toast.makeText(Registro.this,"EXITO EN LA CREACION DE USUARIO",Toast.LENGTH_LONG).show();
                    //TODO: Guardar datos complementarios del registro
                    uid = task.getResult().getUser().getUid();
                    guardarDatosUsuario(new Usuario(uid,tipo,nombre, correo,clave,direccion, ciudad));
                }
                else
                {
                    Toast.makeText(Registro.this, "ERROR AL CREAR USUARIO",Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    private void guardarDatosUsuario(Usuario usuario)
    {
        FirebaseDatabase db;
        DatabaseReference dr1,dr2;

        db = FirebaseDatabase.getInstance();
        dr1 = db.getReference(usuario.getUid()).child(Constantes.DATOS);
        //Ingresar
        dr2 = dr1.push();
        dr2.setValue(usuario);
        dr2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    Intent irAHomeHogar;
                    resetearCampos();

                    irAHomeHogar = new Intent(Registro.this,HomeHogar.class);
                    startActivity(irAHomeHogar);
                }
                else{
                    Toast.makeText(Registro.this, "USUARIO CREADO, DATOS NO GUERDADOS",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void resetearCampos(){
        editText_nombre.setText("");
        editText_correo.setText("");
        editText_clavereg.setText("");
        editText_direccion.setText("");
        editText_ciudad.setText("");

    }

}