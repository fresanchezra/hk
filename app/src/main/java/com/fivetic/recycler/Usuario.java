package com.fivetic.recycler;

public class Usuario {

    private String uid;
    private String tipo ;
    private String nombre;
    private String correo ;
    private String clave;
    private String direccion;
    private String ciudad ;

    //private String fecha;

    public Usuario(){

    }

    public Usuario(String uid,String tipo, String nombre,String correo,String clave,String direccion, String ciudad){
        this.setUid(uid);
        this.setTipo(tipo);
        this.setNombre(nombre);
        this.setCorreo(correo);
        this.setClave(clave);
        this.setDireccion(direccion);
        this.setCiudad(ciudad);
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }







}