package com.example.consultoriomedico.DAO.Interface;

import com.example.consultoriomedico.DAO.ErroDAO;
import com.example.consultoriomedico.Modelo.Anamnese;
import com.example.consultoriomedico.Modelo.Medico;
import com.example.consultoriomedico.Modelo.Paciente;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 30/05/2023
 */
public interface AnamneseDaoInterface {
    public void inserir(Anamnese a, Paciente p, Medico m) throws ErroDAO;
    public Anamnese buscar(int codigo) throws ErroDAO;
    public ArrayList<Anamnese> buscar() throws ErroDAO;
    public ArrayList<Anamnese> buscar(Paciente p) throws ErroDAO;
    public ArrayList<Anamnese> buscar(Paciente p, LocalDateTime dataInicio, LocalDateTime dataFinal) throws ErroDAO;
    public void sair() throws ErroDAO;
}
