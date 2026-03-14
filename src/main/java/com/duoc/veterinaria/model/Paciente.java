package com.duoc.veterinaria.model;

public class Paciente {

    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private String nombreDueno;

    // Constructor vacío (necesario para Spring/Thymeleaf)
    public Paciente() {
    }

    public Paciente(int edad, String especie, String nombre, String nombreDueno, String raza) {
        this.edad = edad;
        this.especie = especie;
        this.nombre = nombre;
        this.nombreDueno = nombreDueno;
        this.raza = raza;
    }

    // Getters y Setters (Para que el Controller pueda leer los datos)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad<0) throw new IllegalArgumentException("La edad no puede ser negativa");
        this.edad = edad;
    }

    public String getNombreDueno() {
        return nombreDueno;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    //toString para debug
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paciente{");
        sb.append("nombre=").append(nombre);
        sb.append(", especie=").append(especie);
        sb.append(", raza=").append(raza);
        sb.append(", edad=").append(edad);
        sb.append(", nombreDueno=").append(nombreDueno);
        sb.append('}');
        return sb.toString();
    }
    


}
