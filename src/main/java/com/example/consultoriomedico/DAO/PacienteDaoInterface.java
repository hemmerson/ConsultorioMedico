package com.example.consultoriomedico.DAO;

import com.example.consultoriomedico.Modelo.Paciente;

import java.util.ArrayList;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 30/05/2023
 */
public interface PacienteDaoInterface {
    public void inserir(Paciente p) throws ErroDAO;
    public void deletar(Paciente p) throws ErroDAO;
    public void deletar(int codigo) throws ErroDAO;
    public void editar(Paciente p) throws ErroDAO;
    public Paciente buscar(int codigo) throws ErroDAO;
    public ArrayList<Paciente> buscar(Paciente p) throws ErroDAO;
}
