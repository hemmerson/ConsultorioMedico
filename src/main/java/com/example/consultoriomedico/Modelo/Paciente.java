package com.example.consultoriomedico.Modelo;

import java.time.LocalDateTime;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 30/05/2023
 */
public class Paciente extends Usuario{
    private int codigoPaciente;
    private String sexo, nomeMae, naturalidadeCidade, naturalidadeEstado, endereco;
    private LocalDateTime dataNascimento;
    private Prontuario prontuario;

    public Paciente() {
        super();
    }

    public Paciente(int codigoPaciente, String sexo, String nomeMae, String naturalidadeCidade, String naturalidadeEstado, String endereco, LocalDateTime dataNascimento) {
        this.codigoPaciente = codigoPaciente;
        this.sexo = sexo;
        this.nomeMae = nomeMae;
        this.naturalidadeCidade = naturalidadeCidade;
        this.naturalidadeEstado = naturalidadeEstado;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    public Paciente(String login, String senha, String nome, String cpf, boolean is_medico, String sexo, String nomeMae, String naturalidadeCidade, String naturalidadeEstado, String endereco, LocalDateTime dataNascimento) {
        super(login, senha, nome, cpf, is_medico);
        this.sexo = sexo;
        this.nomeMae = nomeMae;
        this.naturalidadeCidade = naturalidadeCidade;
        this.naturalidadeEstado = naturalidadeEstado;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    public int getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(int codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNaturalidadeCidade() {
        return naturalidadeCidade;
    }

    public void setNaturalidadeCidade(String naturalidadeCidade) {
        this.naturalidadeCidade = naturalidadeCidade;
    }

    public String getNaturalidadeEstado() {
        return naturalidadeEstado;
    }

    public void setNaturalidadeEstado(String naturalidadeEstado) {
        this.naturalidadeEstado = naturalidadeEstado;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Paciente{" +
                "codigo=" + codigoPaciente +
                ", sexo='" + sexo + '\'' +
                ", nomeMae='" + nomeMae + '\'' +
                ", naturalidadeCidade='" + naturalidadeCidade + '\'' +
                ", naturalidadeEstado='" + naturalidadeEstado + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
