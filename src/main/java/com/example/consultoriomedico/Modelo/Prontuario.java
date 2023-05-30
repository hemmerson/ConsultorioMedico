package com.example.consultoriomedico.Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 30/05/2023
 */
public class Prontuario {
    private int codigo;
    private Paciente paciente;
    private List<Anamnese> anamneses = new ArrayList<>();

    public Prontuario() {
    }

    public Prontuario(int codigo, Paciente paciente, List<Anamnese> anamneses) {
        this.codigo = codigo;
        this.paciente = paciente;
        this.anamneses = anamneses;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Anamnese> getAnamneses() {
        return anamneses;
    }

    public void setAnamneses(List<Anamnese> anamneses) {
        this.anamneses = anamneses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prontuario that = (Prontuario) o;
        return codigo == that.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Prontuario{" +
                "codigo=" + codigo +
                ", paciente=" + paciente +
                ", anamneses=" + anamneses +
                '}';
    }
}
