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
import java.time.format.DateTimeFormatter;
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
        Anamnese a = null;
        Medico m = null;
        Prontuario p = null;
        String sql = "select * from Anamnese where idAnamnese = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                a = new Anamnese();
                m = new Medico();
                p = new Prontuario();
                MedicoDaoClasse daoMedico = new MedicoDaoClasse();
                ProntuarioDaoClasse daoProntuario = new ProntuarioDaoClasse();
                a.setCodigo(rs.getInt(1));
                a.setExameFisico(rs.getString(2));
                a.setExamesComplementares(rs.getString(3));
                a.setHipoteseDiagnostico(rs.getString(4));
                a.setDiagnostico(rs.getString(5));
                a.setTratamento(rs.getString(6));
                a.setDataHora(LocalDateTime.parse(rs.getString(7), DateTimeFormatter.ISO_DATE_TIME));
                m = daoMedico.buscar(rs.getInt(8));
                p = daoProntuario.buscar(rs.getInt(9));
                a.setMedico(m);
                a.setProntuario(p);
            }
            rs.close();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
        return a;
    }

    @Override
    public ArrayList<Anamnese> buscar() throws ErroDAO {
        ArrayList<Anamnese> anamneses = new ArrayList<>();
        String sql = "select * from Anamnese";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                Anamnese a = new Anamnese();
                Medico m;
                Prontuario p;
                MedicoDaoClasse daoMedico = new MedicoDaoClasse();
                ProntuarioDaoClasse daoProntuario = new ProntuarioDaoClasse();
                a.setCodigo(rs.getInt(1));
                a.setExameFisico(rs.getString(2));
                a.setExamesComplementares(rs.getString(3));
                a.setHipoteseDiagnostico(rs.getString(4));
                a.setDiagnostico(rs.getString(5));
                a.setTratamento(rs.getString(6));
                a.setDataHora(LocalDateTime.parse(rs.getString(7), DateTimeFormatter.ISO_DATE_TIME));
                m = daoMedico.buscar(rs.getInt(8));
                p = daoProntuario.buscar(rs.getInt(9));
                a.setMedico(m);
                a.setProntuario(p);
                anamneses.add(a);
            }
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
        return anamneses;
    }

    @Override
    public ArrayList<Anamnese> buscar(Prontuario p) throws ErroDAO {
        ArrayList<Anamnese> anamneses = new ArrayList<>();
        String sql = "select * from Anamnese where Prontuario_idProntuario = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1, p.getCodigo());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                Anamnese a = new Anamnese();
                Medico m;
                MedicoDaoClasse daoMedico = new MedicoDaoClasse();
                a.setCodigo(rs.getInt(1));
                a.setExameFisico(rs.getString(2));
                a.setExamesComplementares(rs.getString(3));
                a.setHipoteseDiagnostico(rs.getString(4));
                a.setDiagnostico(rs.getString(5));
                a.setTratamento(rs.getString(6));
                a.setDataHora(LocalDateTime.parse(rs.getString(7), DateTimeFormatter.ISO_DATE_TIME));
                m = daoMedico.buscar(rs.getInt(8));
                a.setMedico(m);
                a.setProntuario(p);
                anamneses.add(a);
            }
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
        return anamneses;
    }

    @Override
    public ArrayList<Anamnese> buscar(Prontuario p, LocalDateTime dataInicio, LocalDateTime dataFinal) throws ErroDAO {
        ArrayList<Anamnese> anamneses = new ArrayList<>();
        String sql = "SELECT * FROM Anamnese WHERE Prontuario_idProntuario = ? and" +
                " dataNascimento BETWEEN ? and ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1, p.getCodigo());
            pstm.setString(2, dataInicio.toString());
            pstm.setString(3, dataFinal.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                Anamnese a = new Anamnese();
                Medico m;
                MedicoDaoClasse daoMedico = new MedicoDaoClasse();
                a.setCodigo(rs.getInt(1));
                a.setExameFisico(rs.getString(2));
                a.setExamesComplementares(rs.getString(3));
                a.setHipoteseDiagnostico(rs.getString(4));
                a.setDiagnostico(rs.getString(5));
                a.setTratamento(rs.getString(6));
                a.setDataHora(LocalDateTime.parse(rs.getString(7), DateTimeFormatter.ISO_DATE_TIME));
                m = daoMedico.buscar(rs.getInt(8));
                a.setMedico(m);
                a.setProntuario(p);
                anamneses.add(a);
            }
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
        return anamneses;
    }

    @Override
    public void sair() throws ErroDAO {
        try{
            con.close();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    public static void main(String[] args) {

    }

}
