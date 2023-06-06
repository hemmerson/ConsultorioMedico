package com.example.consultoriomedico.DAO.Interface;

import com.example.consultoriomedico.DAO.ErroDAO;
import com.example.consultoriomedico.Modelo.Medico;
import com.example.consultoriomedico.Modelo.Paciente;

import java.util.ArrayList;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 30/05/2023
 */
public interface PacienteDaoInterface {
    public void inserir(Paciente p) throws ErroDAO;

//    public void deletar(Paciente p) throws ErroDAO;
//    public void deletar(int codigo) throws ErroDAO;

    public void editar(Paciente p) throws ErroDAO;
    public void editar(String senha, String endereco, int idUsuario) throws ErroDAO;
    public Paciente buscar(int codigo) throws ErroDAO;
    public Paciente buscar(String login, String senha) throws ErroDAO;
    public ArrayList<Paciente> buscar() throws ErroDAO;
    public void sair() throws ErroDAO;
}
