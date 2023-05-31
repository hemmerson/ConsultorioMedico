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
    public void inserir(Prontuario p) throws ErroDAO;
    public void deletar(Prontuario p) throws ErroDAO;
    public void deletar(int codigo) throws ErroDAO;
    public void editar(Prontuario p) throws ErroDAO;
    public Prontuario buscar(int codigo) throws ErroDAO;
    public Prontuario buscar(Paciente p) throws ErroDAO;
    public ArrayList<Prontuario> buscar(Prontuario p) throws ErroDAO;
}
