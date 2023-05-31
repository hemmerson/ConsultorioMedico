package com.example.consultoriomedico.Modelo;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 30/05/2023
 */
public class Medico extends Usuario{
    private int codigoMedico;
    private String especializacao;

    public Medico() {
        super();
    }

    public Medico(int codigoMedico, String especializacao) {
        this.codigoMedico = codigoMedico;
        this.especializacao = especializacao;
    }

    public Medico(String login, String senha, String nome, String cpf, boolean is_medico, String especializacao) {
        super(login, senha, nome, cpf, is_medico);
        this.especializacao = especializacao;
    }

    public int getCodigoMedico() {
        return codigoMedico;
    }


    public void setCodigoMedico(int codigoMedico) {
        this.codigoMedico = codigoMedico;
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
                "codigo=" + codigoMedico +
                ", especializacao='" + especializacao + '\'' +
                '}';
    }
}
