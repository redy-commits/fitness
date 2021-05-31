package com.fitness_g16;

import java.sql.Blob;

public class Rutina {
    private int idRutina,tiempoPreparacion;
    private String nombreRutina,descripcionRutina,duracion;
    private Blob codigoQR;

    public Rutina(){}

    public int getIdRutina(){return idRutina;}

    public void setIdRutina(int idRutina){this.idRutina = idRutina;}

    public int getTiempoPreparacion(){return tiempoPreparacion;}

    public void setTiempoPreparacion(int tiempoPreparacion){this.tiempoPreparacion = tiempoPreparacion;}

    public String getNombreRutina(){return nombreRutina;}

    public void setNombreRutina(String nombreRutina){this.nombreRutina = nombreRutina;}

    public String getDescripcionRutina(){return descripcionRutina;}

    public void setDescripcionRutina(String descripcionRutina){this.descripcionRutina = descripcionRutina;}

    public String getDuracion(){return duracion;}

    public void setDuracion(String duracion){this.duracion = duracion;}

    public Blob getCodigoQR(){return codigoQR;}

    public void setCodigoQR(Blob codigoQR){this.codigoQR = codigoQR;}}