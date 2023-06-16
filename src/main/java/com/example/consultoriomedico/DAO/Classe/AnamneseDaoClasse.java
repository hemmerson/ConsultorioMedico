package com.example.consultoriomedico.DAO.Classe;

import com.example.consultoriomedico.DAO.ErroDAO;
import com.example.consultoriomedico.DAO.FabricaConexao;
import com.example.consultoriomedico.DAO.Interface.AnamneseDaoInterface;
import com.example.consultoriomedico.DAO.Interface.PacienteDaoInterface;
import com.example.consultoriomedico.Modelo.Anamnese;
import com.example.consultoriomedico.Modelo.Medico;
import com.example.consultoriomedico.Modelo.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
    public void inserir(Anamnese a) throws ErroDAO {
        String sql = "insert into Anamnese (exameFisico, examesComplementares, hipoteseDiagnostico, diagnostico, " +
                "tratamento, dataHora, Medico_idMedico, Paciente_idPaciente) values (?,?,?,?,?,?,?,?)";
        try(PreparedStatement pstm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
            pstm.setString(1, a.getExameFisico());
            pstm.setString(2, a.getExamesComplementares());
            pstm.setString(3, a.getHipoteseDiagnostico());
            pstm.setString(4, a.getDiagnostico());
            pstm.setString(5, a.getTratamento());
            pstm.setString(6, a.getDataHora().toString());
            pstm.setInt(7, a.getMedico().getCodigoMedico());
            pstm.setInt(8, a.getPaciente().getCodigoPaciente());
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
        Paciente p = null;
        String sql = "select * from Anamnese where idAnamnese = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                a = new Anamnese();
                m = new Medico();
                p = new Paciente();
                MedicoDaoClasse daoMedico = new MedicoDaoClasse();
                PacienteDaoInterface daoPacinte = new PacienteDaoClasse();
                a.setCodigo(rs.getInt(1));
                a.setExameFisico(rs.getString(2));
                a.setExamesComplementares(rs.getString(3));
                a.setHipoteseDiagnostico(rs.getString(4));
                a.setDiagnostico(rs.getString(5));
                a.setTratamento(rs.getString(6));
                a.setDataHora(LocalDateTime.parse(rs.getString(7), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                m = daoMedico.buscar(rs.getInt(8));
                p = daoPacinte.buscar(rs.getInt(9));
                a.setMedico(m);
                a.setPaciente(p);
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
                Paciente p;
                MedicoDaoClasse daoMedico = new MedicoDaoClasse();
                PacienteDaoInterface daoPaciente = new PacienteDaoClasse();
                a.setCodigo(rs.getInt(1));
                a.setExameFisico(rs.getString(2));
                a.setExamesComplementares(rs.getString(3));
                a.setHipoteseDiagnostico(rs.getString(4));
                a.setDiagnostico(rs.getString(5));
                a.setTratamento(rs.getString(6));
                a.setDataHora(LocalDateTime.parse(rs.getString(7), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                m = daoMedico.buscar(rs.getInt(8));
                p = daoPaciente.buscar(rs.getInt(9));
                a.setMedico(m);
                a.setPaciente(p);
                anamneses.add(a);
            }
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
        return anamneses;
    }

    @Override
    public ArrayList<Anamnese> buscar(Paciente p) throws ErroDAO {
        ArrayList<Anamnese> anamneses = new ArrayList<>();
        String sql = "select * from Anamnese where Paciente_idPaciente = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1, p.getCodigoPaciente());
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
                a.setDataHora(LocalDateTime.parse(rs.getString(7), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                m = daoMedico.buscar(rs.getInt(8));
                a.setMedico(m);
                a.setPaciente(p);
                anamneses.add(a);
            }
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
        return anamneses;
    }

    @Override
    public ArrayList<Anamnese> buscar(Paciente p, LocalDateTime dataInicio, LocalDateTime dataFinal) throws ErroDAO {
        ArrayList<Anamnese> anamneses = new ArrayList<>();
        String sql = "SELECT * FROM Anamnese WHERE Paciente_idPaciente = ? and" +
                " dataHora BETWEEN ? and ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1, p.getCodigoPaciente());
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
                a.setDataHora(LocalDateTime.parse(rs.getString(7), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                m = daoMedico.buscar(rs.getInt(8));
                a.setMedico(m);
                a.setPaciente(p);
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
//        String exameFisico = "Ausculta pulmonar com estertores crepitantes, febre, tosse produtiva";
//        String hipoteseDiagnostico = "Pneumonia";
//        String examesComplementares = "Raio-X do tórax, hemograma completo, cultura de escarro";
//        String diagnostico = "Pneumonia bacteriana";
//        String tratamento = "Antibióticos (Amoxicilina) por 7 dias, repouso, hidratação adequada";
//        Paciente p = new Paciente();
//        Medico m = new Medico();
//        p.setCodigoPaciente(1);
//        m.setCodigoMedico(1);
//        Anamnese a = new Anamnese(exameFisico,examesComplementares,hipoteseDiagnostico,diagnostico,tratamento,LocalDateTime.now(),m,p);
        try {
            LocalDateTime dataInicio = LocalDateTime.parse("2023-06-10T00:00:00", DateTimeFormatter.ISO_DATE_TIME);
            LocalDateTime dataFinal = LocalDateTime.parse("2023-06-17T00:00:00");
            List<Anamnese> anamneses;
            AnamneseDaoInterface dao = new AnamneseDaoClasse();
            PacienteDaoInterface daop = new PacienteDaoClasse();
            Paciente p = daop.buscar(1);
            anamneses = dao.buscar(p,dataInicio,dataFinal);
            System.out.println(anamneses);
        } catch (ErroDAO e) {
            throw new RuntimeException(e);
        }

    }

}
