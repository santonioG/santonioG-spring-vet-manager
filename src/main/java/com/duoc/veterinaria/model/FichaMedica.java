package com.duoc.veterinaria.model;

public class FichaMedica {

    private String nombrePaciente;
    private String diagnostico;
    private String tratamiento;
    private String receta;
   
    public FichaMedica() {
    }

    public FichaMedica(String nombrePaciente, String diagnostico, String tratamiento, String receta) {
        this.nombrePaciente = nombrePaciente;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.receta = receta;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FichaMedica{");
        sb.append("nombrePaciente=").append(nombrePaciente);
        sb.append(", diagnostico=").append(diagnostico);
        sb.append(", tratamiento=").append(tratamiento);
        sb.append(", receta=").append(receta);
        sb.append('}');
        return sb.toString();
    }

}
