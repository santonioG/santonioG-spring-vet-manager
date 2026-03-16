package com.duoc.veterinaria.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {

    private String nombrePaciente;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
    private String veterinarioAsignado;

    public Cita() {
    }

    public Cita(String nombrePaciente, LocalDate fecha, LocalTime hora, String motivo, String veterinarioAsignado) {
        this.nombrePaciente = nombrePaciente;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.veterinarioAsignado = veterinarioAsignado;
    }



    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getVeterinarioAsignado() {
        return veterinarioAsignado;
    }

    public void setVeterinarioAsignado(String veterinarioAsignado) {
        this.veterinarioAsignado = veterinarioAsignado;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cita{");
        sb.append("nombrePaciente=").append(nombrePaciente);
        sb.append(", fecha=").append(fecha);
        sb.append(", hora=").append(hora);
        sb.append(", motivo=").append(motivo);
        sb.append(", veterinarioAsignado=").append(veterinarioAsignado);
        sb.append('}');
        return sb.toString();
    }
   
}
