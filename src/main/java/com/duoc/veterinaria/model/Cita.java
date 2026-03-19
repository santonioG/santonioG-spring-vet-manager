package com.duoc.veterinaria.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombrePaciente; // vincular al paciente
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
    private String veterinarioAsignado;

    public Cita() {
    }

    public Cita(LocalDate fecha, LocalTime hora, Long id, String motivo, String nombrePaciente, String veterinarioAsignado) {
        this.fecha = fecha;
        this.hora = hora;
        this.id = id;
        this.motivo = motivo;
        this.nombrePaciente = nombrePaciente;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cita{");
        sb.append("id=").append(id);
        sb.append(", nombrePaciente=").append(nombrePaciente);
        sb.append(", fecha=").append(fecha);
        sb.append(", hora=").append(hora);
        sb.append(", motivo=").append(motivo);
        sb.append(", veterinarioAsignado=").append(veterinarioAsignado);
        sb.append('}');
        return sb.toString();
    }
   
}
