package com.example.consultoriomedico.Modelo;

import java.util.Objects;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 30/05/2023
 */
public abstract class Usuario {
    private int codigo;
    private String login,senha,nome,cpf;
    private boolean is_medico;

    public Usuario() {
    }

    public Usuario(int codigo, String login, String senha, String nome, String cpf, boolean is_medico) {
        this.codigo = codigo;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
        this.is_medico = is_medico;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isIs_medico() {
        return is_medico;
    }

    public void setIs_medico(boolean is_medico) {
        this.is_medico = is_medico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return codigo == usuario.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "codigo=" + codigo +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", is_medico=" + is_medico +
                '}';
    }
}
