package com.hotel.hotel.model;

import java.sql.Date;

public class Empleado {

    private Long idEmpleado;
    private String nombre;
    private int cedula;
    private String correo;
    private int telefono;
    private Date fechaIngreso; // Puedes usar Date si lo prefieres
    private int fkHotel;
    private int fkPuesto;

    // Getters y Setters

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getFkHotel() {
        return fkHotel;
    }

    public void setFkHotel(int fkHotel) {
        this.fkHotel = fkHotel;
    }

    public int getFkPuesto() {
        return fkPuesto;
    }

    public void setFkPuesto(int fkPuesto) {
        this.fkPuesto = fkPuesto;
    }
}
