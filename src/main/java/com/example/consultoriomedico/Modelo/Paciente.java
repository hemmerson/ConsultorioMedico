package com.example.consultoriomedico.Modelo;

import java.time.LocalDateTime;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 30/05/2023
 */
public class Paciente extends Usuario{
    private int codigo;
    private String sexo, nomeMae, naturalidadeCidade, naturalidadeEstado, endereco;
    private LocalDateTime dataNascimento;
    private Prontuario prontuario;

    public Paciente() {
        super();
    }

    public Paciente(int codigo, String sexo, String nomeMae, String naturalidadeCidade, String naturalidadeEstado, String endereco, LocalDateTime dataNascimento) {
        this.codigo = codigo;
        this.sexo = sexo;
        this.nomeMae = nomeMae;
        this.naturalidadeCidade = naturalidadeCidade;
        this.naturalidadeEstado = naturalidadeEstado;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    public Paciente(int codigoUsuario, String login, String senha, String nome, String cpf, boolean is_medico, int codigo, String sexo, String nomeMae, String naturalidadeCidade, String naturalidadeEstado, String endereco, LocalDateTime dataNascimento) {
        super(codigoUsuario, login, senha, nome, cpf, is_medico);
        this.codigo = codigo;
        this.sexo = sexo;
        this.nomeMae = nomeMae;
        this.naturalidadeCidade = naturalidadeCidade;
        this.naturalidadeEstado = naturalidadeEstado;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
                "codigo=" + codigo +
                ", sexo='" + sexo + '\'' +
                ", nomeMae='" + nomeMae + '\'' +
                ", naturalidadeCidade='" + naturalidadeCidade + '\'' +
                ", naturalidadeEstado='" + naturalidadeEstado + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
