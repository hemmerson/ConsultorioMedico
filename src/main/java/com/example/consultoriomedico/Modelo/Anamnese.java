package com.example.consultoriomedico.Modelo;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 30/05/2023
 */
public class Anamnese {
    private int codigo;
    private String exameFisico, examesComplementares, hipoteseDiagnostico;
    private String diagnostico, tratamento;
    private LocalDateTime dataHora;
    private Medico medico;
    private Paciente paciente;

    public Anamnese() {
    }

    public Anamnese(int codigo, String exameFisico, String examesComplementares, String hipoteseDiagnostico, String diagnostico, String tratamento, LocalDateTime dataHora, Medico medico, Paciente paciente) {
        this.codigo = codigo;
        this.exameFisico = exameFisico;
        this.examesComplementares = examesComplementares;
        this.hipoteseDiagnostico = hipoteseDiagnostico;
        this.diagnostico = diagnostico;
        this.tratamento = tratamento;
        this.dataHora = dataHora;
        this.medico = medico;
        this.paciente = paciente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getExameFisico() {
        return exameFisico;
    }

    public void setExameFisico(String exameFisico) {
        this.exameFisico = exameFisico;
    }

    public String getExamesComplementares() {
        return examesComplementares;
    }

    public void setExamesComplementares(String examesComplementares) {
        this.examesComplementares = examesComplementares;
    }

    public String getHipoteseDiagnostico() {
        return hipoteseDiagnostico;
    }

    public void setHipoteseDiagnostico(String hipoteseDiagnostico) {
        this.hipoteseDiagnostico = hipoteseDiagnostico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anamnese anamnese = (Anamnese) o;
        return codigo == anamnese.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Anamnese{" +
                "codigo=" + codigo +
                ", exameFisico='" + exameFisico + '\'' +
                ", examesComplementares='" + examesComplementares + '\'' +
                ", hipoteseDiagnostico='" + hipoteseDiagnostico + '\'' +
                ", diagnostico='" + diagnostico + '\'' +
                ", tratamento='" + tratamento + '\'' +
                ", dataHora=" + dataHora +
                ", medico=" + medico +
                ", paciente=" + paciente +
                '}';
    }
}
