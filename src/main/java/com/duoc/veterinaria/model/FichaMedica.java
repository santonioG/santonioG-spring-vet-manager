package com.duoc.veterinaria.model;

import java.time.LocalDateTime;

public class FichaMedica {

    private Long id;
    private String nombrePaciente; // Para vincularla con el paciente
    private String diagnostico;
    private String tratamiento;
    private String medicamentos;
    private String notasMedicas;
    private LocalDateTime fechaRegistro;

    public FichaMedica() {
        this.fechaRegistro = LocalDateTime.now(); // Se marca la fecha automaticamente
    }

    public FichaMedica(String diagnostico, LocalDateTime fechaRegistro, Long id, String medicamentos, String nombrePaciente, String notasMedicas, String tratamiento) {
        this.diagnostico = diagnostico;
        this.fechaRegistro = fechaRegistro;
        this.id = id;
        this.medicamentos = medicamentos;
        this.nombrePaciente = nombrePaciente;
        this.notasMedicas = notasMedicas;
        this.tratamiento = tratamiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getNotasMedicas() {
        return notasMedicas;
    }

    public void setNotasMedicas(String notasMedicas) {
        this.notasMedicas = notasMedicas;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FichaMedica{");
        sb.append("id=").append(id);
        sb.append(", nombrePaciente=").append(nombrePaciente);
        sb.append(", diagnostico=").append(diagnostico);
        sb.append(", tratamiento=").append(tratamiento);
        sb.append(", medicamentos=").append(medicamentos);
        sb.append(", notasMedicas=").append(notasMedicas);
        sb.append(", fechaRegistro=").append(fechaRegistro);
        sb.append('}');
        return sb.toString();
    }

}
