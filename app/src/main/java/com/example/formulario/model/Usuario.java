package com.example.formulario.model;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String rfc, signoChino, signoZodiacal, nombre, apPat, apMat, fecha;
    private int edad;

    public Usuario(String rfc, String signoChino, String signoZodiacal, String nombre, String apPat, String apMat, String fecha, int edad) {
        this.rfc = rfc;
        this.signoChino = signoChino;
        this.signoZodiacal = signoZodiacal;
        this.nombre = nombre;
        this.apPat = apPat;
        this.apMat = apMat;
        this.fecha = fecha;
        this.edad = edad;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getSignoChino() {
        return signoChino;
    }

    public void setSignoChino(String signoChino) {
        this.signoChino = signoChino;
    }

    public String getSignoZodiacal() {
        return signoZodiacal;
    }

    public void setSignoZodiacal(String signoZodiacal) {
        this.signoZodiacal = signoZodiacal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPat() {
        return apPat;
    }

    public void setApPat(String apPat) {
        this.apPat = apPat;
    }

    public String getApMat() {
        return apMat;
    }

    public void setApMat(String apMat) {
        this.apMat = apMat;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
