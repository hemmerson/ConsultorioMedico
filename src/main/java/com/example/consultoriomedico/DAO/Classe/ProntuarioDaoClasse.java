package com.example.consultoriomedico.DAO.Classe;

import com.example.consultoriomedico.DAO.ErroDAO;
import com.example.consultoriomedico.DAO.FabricaConexao;
import com.example.consultoriomedico.DAO.Interface.ProntuarioDaoInterface;
import com.example.consultoriomedico.Modelo.Paciente;
import com.example.consultoriomedico.Modelo.Prontuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 01/06/2023
 */
public class ProntuarioDaoClasse implements ProntuarioDaoInterface {
    private Connection con;

    public ProntuarioDaoClasse() throws ErroDAO{
        con = FabricaConexao.pegaConexao();
    }
    @Override
    public void inserir(Prontuario prontuario) throws ErroDAO {
        String sql = "insert into Prontuario (Paciente_idPaciente) values (?)";
        try(PreparedStatement pstm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
            pstm.setInt(1, prontuario.getPaciente().getCodigoPaciente());
            pstm.executeUpdate();
            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()){
                prontuario.setCodigo(rs.getInt(1));
            }
            rs.close();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void editar(Prontuario prontuario) throws ErroDAO {

    }

    @Override
    public Prontuario buscar(Paciente paciente) throws ErroDAO {
        Prontuario p = null;
        String sql = "select * from Prontuario where Paciente_idPaciente = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1, paciente.getCodigoPaciente());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                p = new Prontuario();
                p.setCodigo(rs.getInt(1));
                p.setPaciente(paciente);
            }
            rs.close();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
        return p;
    }

    @Override
    public Prontuario buscar(int codigo) throws ErroDAO {
        Prontuario p = null;
        String sql = "select * from Prontuario where idProntuario = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                p = new Prontuario();
                p.setCodigo(rs.getInt(1));
            }
            rs.close();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
        return p;
    }

    @Override
    public ArrayList<Prontuario> buscar() throws ErroDAO {
        return null;
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
        try{
            Paciente paciente = new Paciente();
            paciente.setCodigoPaciente(1);
            Prontuario p = new Prontuario();
            p.setPaciente(paciente);
            ProntuarioDaoClasse dao = new ProntuarioDaoClasse();
            dao.inserir(p);
        } catch (ErroDAO e) {
            throw new RuntimeException(e);
        }
    }

}
