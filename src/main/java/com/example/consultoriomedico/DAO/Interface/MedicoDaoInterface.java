package com.example.consultoriomedico.DAO.Interface;

import com.example.consultoriomedico.DAO.ErroDAO;
import com.example.consultoriomedico.Modelo.Medico;

import java.util.ArrayList;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 30/05/2023
 */
public interface MedicoDaoInterface {
    public void inserir(Medico m) throws ErroDAO;

//    public void deletar(Medico m) throws ErroDAO;
//    public void deletar(int codigo) throws ErroDAO;

    public void editar(Medico m) throws ErroDAO;
    public Medico buscar(int codigo) throws ErroDAO;
    public Medico buscar(String login, String senha) throws ErroDAO;
    public ArrayList<Medico> buscar() throws ErroDAO;
}
