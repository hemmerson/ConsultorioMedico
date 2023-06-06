package com.example.consultoriomedico.DAO.Interface;

import com.example.consultoriomedico.DAO.ErroDAO;
import com.example.consultoriomedico.Modelo.Anamnese;
import com.example.consultoriomedico.Modelo.Medico;
import com.example.consultoriomedico.Modelo.Paciente;
import com.example.consultoriomedico.Modelo.Prontuario;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 30/05/2023
 */
public interface AnamneseDaoInterface {
    public void inserir(Anamnese a, Prontuario p, Medico m) throws ErroDAO;
    public Anamnese buscar(int codigo) throws ErroDAO;
    public ArrayList<Anamnese> buscar() throws ErroDAO;
    public ArrayList<Anamnese> buscar(Prontuario p) throws ErroDAO;
    public ArrayList<Anamnese> buscar(Prontuario p, LocalDateTime dataInicio, LocalDateTime dataFinal) throws ErroDAO;
    public void sair() throws ErroDAO;
}
