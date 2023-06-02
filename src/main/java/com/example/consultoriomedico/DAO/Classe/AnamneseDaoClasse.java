package com.example.consultoriomedico.DAO.Classe;

import com.example.consultoriomedico.DAO.ErroDAO;
import com.example.consultoriomedico.DAO.FabricaConexao;
import com.example.consultoriomedico.DAO.Interface.AnamneseDaoInterface;
import com.example.consultoriomedico.Modelo.Anamnese;
import com.example.consultoriomedico.Modelo.Medico;
import com.example.consultoriomedico.Modelo.Prontuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 02/06/2023
 */
public class AnamneseDaoClasse implements AnamneseDaoInterface {
    private Connection con;

    public AnamneseDaoClasse() throws ErroDAO{
        con = FabricaConexao.pegaConexao();
    }
    @Override
    public void inserir(Anamnese a, Prontuario p, Medico m) throws ErroDAO {
        String sql = "insert into Anamnese (exameFisico, examesComplementares, hipoteseDiagnostico, diagnostico, " +
                "tratamento, dataHora, Medico_idMedico, Prontuario_idProntuario) values (?,?,?,?,?,?,?,?)";
        try(PreparedStatement pstm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
            pstm.setString(1, a.getExameFisico());
            pstm.setString(2, a.getExamesComplementares());
            pstm.setString(3, a.getHipoteseDiagnostico());
            pstm.setString(4, a.getDiagnostico());
            pstm.setString(5, a.getTratamento());
            pstm.setString(6, a.getDataHora().toString());
            pstm.setInt(7, m.getCodigoMedico());
            pstm.setInt(8, p.getCodigo());
            pstm.executeUpdate();
            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()){
                a.setCodigo(rs.getInt(1));
            }
            rs.close();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public Anamnese buscar(int codigo) throws ErroDAO {
        return null;
    }

    @Override
    public ArrayList<Anamnese> buscar(Anamnese a) throws ErroDAO {
        return null;
    }

    @Override
    public ArrayList<Anamnese> buscar(Prontuario p) throws ErroDAO {
        return null;
    }

    @Override
    public ArrayList<Anamnese> buscar(Prontuario p, LocalDateTime dataInicio, LocalDateTime dataFinal) throws ErroDAO {
        return null;
    }
}
