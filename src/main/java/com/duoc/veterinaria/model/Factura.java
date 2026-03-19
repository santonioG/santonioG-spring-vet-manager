package com.duoc.veterinaria.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombrePaciente;
    private List<String> servicios;
    private BigDecimal montoTotal;
    private LocalDateTime fechaEmision;
    
    public Factura() {
    }


    public Factura(LocalDateTime fechaEmision, Long id, BigDecimal montoTotal, String nombrePaciente, List<String> servicios) {
        this.fechaEmision = fechaEmision;
        this.id = id;
        this.montoTotal = montoTotal;
        this.nombrePaciente = nombrePaciente;
        this.servicios = List.copyOf(servicios); // copia defensiva también al guardar
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public List<String> getServicios() {
        return List.copyOf(servicios);
    }

    public void setServicios(List<String> servicios) {
    this.servicios = List.copyOf(servicios); // copia defensiva
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
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
        sb.append("Factura{");
        sb.append("id=").append(id);
        sb.append(", nombrePaciente=").append(nombrePaciente);
        sb.append(", servicios=").append(servicios);
        sb.append(", montoTotal=").append(montoTotal);
        sb.append(", fechaEmision=").append(fechaEmision);
        sb.append('}');
        return sb.toString();
    }



}
