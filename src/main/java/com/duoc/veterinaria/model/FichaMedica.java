package com.duoc.veterinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FichaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombrePaciente;
    private String diagnostico;
    private String tratamiento;
    private String receta;
   
    public FichaMedica() {
    }

    public FichaMedica(String diagnostico, Long id, String nombrePaciente, String receta, String tratamiento) {
        this.diagnostico = diagnostico;
        this.id = id;
        this.nombrePaciente = nombrePaciente;
        this.receta = receta;
        this.tratamiento = tratamiento;
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

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
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
        sb.append("FichaMedica{");
        sb.append("id=").append(id);
        sb.append(", nombrePaciente=").append(nombrePaciente);
        sb.append(", diagnostico=").append(diagnostico);
        sb.append(", tratamiento=").append(tratamiento);
        sb.append(", receta=").append(receta);
        sb.append('}');
        return sb.toString();
    }

    

}
