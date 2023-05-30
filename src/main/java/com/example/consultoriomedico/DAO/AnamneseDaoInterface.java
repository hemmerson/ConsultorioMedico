package com.example.consultoriomedico.DAO;

import com.example.consultoriomedico.Modelo.Anamnese;
import com.example.consultoriomedico.Modelo.Paciente;
import com.example.consultoriomedico.Modelo.Prontuario;

import java.util.ArrayList;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 30/05/2023
 */
public interface AnamneseDaoInterface {
    public void inserir(Anamnese a) throws ErroDAO;
    public void deletar(Anamnese a) throws ErroDAO;
    public void deletar(int codigo) throws ErroDAO;
    public void editar(Anamnese a) throws ErroDAO;
    public Anamnese buscar(int codigo) throws ErroDAO;
    public ArrayList<Anamnese> buscar(Anamnese a) throws ErroDAO;
    public ArrayList<Anamnese> buscar(Prontuario p) throws ErroDAO;
}
