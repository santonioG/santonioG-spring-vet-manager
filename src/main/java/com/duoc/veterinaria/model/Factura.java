package com.duoc.veterinaria.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Factura {

    private String nombrePaciente;
    private List<String> servicios;
    private BigDecimal montoTotal;
    private LocalDateTime fechaEmision;

    // Constructor completo — cuando tú provees la fecha
    public Factura(String nombrePaciente, List<String> servicios, BigDecimal montoTotal, LocalDateTime fechaEmision) {
    this.nombrePaciente = nombrePaciente;
    this.servicios = List.copyOf(servicios); // copia defensiva también al guardar
    this.montoTotal = montoTotal;
    this.fechaEmision = fechaEmision;
    }

    // Constructor conveniente — fecha se genera automáticamente
    public Factura(String nombrePaciente, List<String> servicios, BigDecimal montoTotal) {
    this(nombrePaciente, servicios, montoTotal, LocalDateTime.now()); // delega al de arriba
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factura{");
        sb.append("nombrePaciente=").append(nombrePaciente);
        sb.append(", servicios=").append(servicios);
        sb.append(", montoTotal=").append(montoTotal);
        sb.append(", fechaEmision=").append(fechaEmision);
        sb.append('}');
        return sb.toString();
    }

}
