package com.example.consultoriomedico.Modelo;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 30/05/2023
 */
public class Medico extends Usuario{
    private int codigo;
    private String especializacao;

    public Medico() {
        super();
    }

    public Medico(int codigo, String especializacao) {
        this.codigo = codigo;
        this.especializacao = especializacao;
    }

    public Medico(int codigoUsuario, String login, String senha, String nome, String cpf, boolean is_medico, int codigo, String especializacao) {
        super(codigoUsuario, login, senha, nome, cpf, is_medico);
        this.codigo = codigo;
        this.especializacao = especializacao;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Medico{" +
                "codigo=" + codigo +
                ", especializacao='" + especializacao + '\'' +
                '}';
    }
}
