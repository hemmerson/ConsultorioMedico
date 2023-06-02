package com.example.consultoriomedico.DAO.Interface;

import com.example.consultoriomedico.DAO.ErroDAO;
import com.example.consultoriomedico.Modelo.Paciente;
import com.example.consultoriomedico.Modelo.Prontuario;

import java.util.ArrayList;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 30/05/2023
 */
public interface ProntuarioDaoInterface {
    public void inserir(Prontuario prontuario, Paciente paciente) throws ErroDAO;

    public void editar(Prontuario prontuario) throws ErroDAO;
    public Prontuario buscar(Paciente paciente) throws ErroDAO;
    public ArrayList<Prontuario> buscar(Prontuario prontuario) throws ErroDAO;
}
