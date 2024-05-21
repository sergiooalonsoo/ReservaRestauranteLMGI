package com.masanz.da.spc.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reserva {

    private int id;
    private String nombre;
    private String turno;
    private int numComensales;
    private String fecha;
    private int numeroTelefono;


    public Reserva() {
        this(0, "", "", 0,"", 0);
    }


    public Reserva(int id, String nombre, String turno, int numComensales, String fecha, int numeroTelefono) {
        this.id = id;
        this.nombre = nombre;
        this.turno = turno;
        this.numComensales = numComensales;
        this.fecha = fecha;
        this.numeroTelefono = numeroTelefono;
    }

    public Reserva(String nombre, String turno, int numComensales, String fecha, int numeroTelefono) {
        this(0, "", "", 0, "", 0);
    }

    //region getSet
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getNumComensales() {
        return numComensales;
    }

    public void setNumComensales(int numComensales) {
        this.numComensales = numComensales;
    }


    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    //endregion

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", turno='" + turno + '\'' +
                ", numComensales=" + numComensales +
                ", fecha='" + fecha + '\'' +
                ", numeroTelefono=" + numeroTelefono +
                '}';
    }
}
