package com.example.consultoriomedico.DAO.Classe;

import com.example.consultoriomedico.DAO.ErroDAO;
import com.example.consultoriomedico.DAO.FabricaConexao;
import com.example.consultoriomedico.DAO.Interface.MedicoDaoInterface;
import com.example.consultoriomedico.Modelo.Medico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicoDaoClasse implements MedicoDaoInterface {
    private Connection con;
    public MedicoDaoClasse() throws ErroDAO {
        con = FabricaConexao.pegaConexao();
    }

    @Override
    public void inserir(Medico m) throws ErroDAO {
        String sql = "insert into Usuario (login, senha, is_medico, nome, cpf) values (?,?,true,?,?)";
        try (PreparedStatement pstm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, m.getLogin());
            pstm.setString(2, m.getSenha());
            pstm.setString(3, m.getNome());
            pstm.setString(4, m.getCpf());
            pstm.executeUpdate();
            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                m.setCodigo(rs.getInt(1));
                sql = "insert into Medico (especializacao, Usuario_idUsuario) values (?,?)";
                PreparedStatement pstm1 = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstm1.setString(1, m.getEspecializacao());
                pstm1.setInt(2, m.getCodigo());
                pstm1.executeUpdate();
                ResultSet rs1 = pstm1.getGeneratedKeys();
                if (rs.next())
                    m.setCodigoMedico(rs1.getInt(1));
                pstm1.close();
            }
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void editar(Medico m) throws ErroDAO {
        String sql = "start transaction;" +
                        "update Usuario set login = ?, senha = ?, nome = ?, cpf = ? where idUsuario = ?;" +
                        "update Medico set especializacao = ? where Usuario_idUsuario = ?;" +
                        "commit;";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setString(1, m.getLogin());
            pstm.setString(2, m.getSenha());
            pstm.setString(3, m.getNome());
            pstm.setString(4, m.getCpf());
            pstm.setInt(5, m.getCodigo());
            pstm.setString(6, m.getEspecializacao());
            pstm.setInt(7, m.getCodigo());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }

    }

    @Override
    public Medico buscar(int codigo) throws ErroDAO {
        Medico m = null;
        String sql = "select * from Usuario inner join Medico on idUsuario = Usuario_idUsuario where idMedico = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1,codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                m = new Medico();
                m.setCodigo(rs.getInt(1));
                m.setLogin(rs.getString(2));
                m.setSenha(rs.getString(3));
                m.setIs_medico(rs.getBoolean(4));
                m.setNome(rs.getString(5));
                m.setCpf(rs.getString(6));
                m.setCodigoMedico(rs.getInt(7));
                m.setEspecializacao(rs.getString(8));
            }
            rs.close();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
        return m;
    }

    @Override
    public Medico buscar(String login, String senha) throws ErroDAO {
        Medico m = null;
        String sql = "select * from Usuario inner join Medico on idUsuario = Usuario_idUsuario where login = ? and senha = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setString(1, login);
            pstm.setString(2, senha);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                m = new Medico();
                m.setCodigo(rs.getInt(1));
                m.setLogin(rs.getString(2));
                m.setSenha(rs.getString(3));
                m.setIs_medico(rs.getBoolean(4));
                m.setNome(rs.getString(5));
                m.setCpf(rs.getString(6));
                m.setCodigoMedico(rs.getInt(7));
                m.setEspecializacao(rs.getString(8));
            }
            rs.close();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
        return m;
    }

    @Override
    public ArrayList<Medico> buscar() throws ErroDAO {
        ArrayList<Medico> medicos = new ArrayList<>();
        String sql = "select * from Usuario inner join Medico on idUsuario = Usuario_idUsuario";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                Medico medico = new Medico();
                medico.setCodigo(rs.getInt(1));
                medico.setLogin(rs.getString(2));
                medico.setSenha(rs.getString(3));
                medico.setIs_medico(rs.getBoolean(4));
                medico.setNome(rs.getString(5));
                medico.setCpf(rs.getString(6));
                medico.setCodigoMedico(rs.getInt(7));
                medico.setEspecializacao(rs.getString(8));
                medicos.add(medico);
            }
            rs.close();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
        return medicos;
    }

    @Override
    public void sair() throws ErroDAO {
        try{
            con.close();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }
    public static void main(String[] args){
//        Medico m = new Medico("pauloh", "1234","Paulo Henrique", "333.222.222-21", true, "Pediatra");
//        Medico m1 = new Medico("hemmerson", "1234","Hemmerson Luis Rosa", "022.222.222-21", true, "Cardiologista");
//        m1.setCodigo(1);
//        m1.setCodigoMedico(1);
        try{
            MedicoDaoClasse dao = new MedicoDaoClasse();
//            Medico m = dao.buscar("hemmerson", "1234");
//            System.out.println(m);
            ArrayList<Medico> medicos = dao.buscar();
            for (Medico m: medicos) {
                System.out.println(m);
            }
        } catch (ErroDAO e) {
            throw new RuntimeException(e);
        }
    }
}
