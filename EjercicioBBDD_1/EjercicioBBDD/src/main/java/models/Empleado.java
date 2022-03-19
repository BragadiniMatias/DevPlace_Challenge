package models;

import java.util.ArrayList;

public class Empleado {

    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private double salario;
    private int antiguedad;
    private String nombrePuesto;
    private String municipalidad;

    public Empleado() {
    }
    //Constructores
    public Empleado(String nombre, String apellido, String telefono, String email, double salario, int antiguedad,
                    String nombrePuesto, String municipalidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.salario = salario;
        this.antiguedad = antiguedad;
        this.nombrePuesto = nombrePuesto;
        this.municipalidad = municipalidad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public int getAntiguedad() {
        return antiguedad;
    }
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    public String getNombrePuesto() {
        return nombrePuesto;
    }
    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }
    public String getMunicipalidad() {
        return municipalidad;
    }
    public void setMunicipalidad(String municipalidad) {
        this.municipalidad = municipalidad;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "antiguedad=" + antiguedad + ", apellido=" + apellido + ", email=" + email + ", id=" + id + ", municipalidad=" + municipalidad + ", nombre=" + nombre + ", nombrePuesto=" + nombrePuesto
                + ", salario=" + salario + ", telefono=" + telefono;
    }
}