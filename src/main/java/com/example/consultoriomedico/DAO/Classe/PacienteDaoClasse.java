package com.example.consultoriomedico.DAO.Classe;

import com.example.consultoriomedico.DAO.ErroDAO;
import com.example.consultoriomedico.DAO.FabricaConexao;
import com.example.consultoriomedico.DAO.Interface.PacienteDaoInterface;
import com.example.consultoriomedico.Modelo.Medico;
import com.example.consultoriomedico.Modelo.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 31/05/2023
 */
public class PacienteDaoClasse implements PacienteDaoInterface {
    private Connection con;

    public PacienteDaoClasse() throws ErroDAO {
        con = FabricaConexao.pegaConexao();
    }

    @Override
    public void inserir(Paciente p) throws ErroDAO {
        String sql = "insert into Usuario (login, senha, is_medico, nome, cpf) values (?,?,false,?,?)";
        try (PreparedStatement pstm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, p.getLogin());
            pstm.setString(2, p.getSenha());
            pstm.setString(3, p.getNome());
            pstm.setString(4, p.getCpf());
            pstm.executeUpdate();
            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                p.setCodigo(rs.getInt(1));
                sql = "insert into Paciente (sexo, dataNascimento, nomeMae, naturalidadeCidade,naturalidadeEstado, endereco, Usuario_idUsuario) values (?,?,?,?,?,?,?)";
                PreparedStatement pstm1 = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstm1.setString(1, p.getSexo());
                pstm1.setString(2, p.getDataNascimento().toString());
                pstm1.setString(3, p.getNomeMae());
                pstm1.setString(4, p.getNaturalidadeCidade());
                pstm1.setString(5, p.getNaturalidadeEstado());
                pstm1.setString(6, p.getEndereco());
                pstm1.setInt(7, p.getCodigo());
                pstm1.executeUpdate();
                ResultSet rs1 = pstm1.getGeneratedKeys();
                if (rs.next())
                    p.setCodigoPaciente(rs1.getInt(1));
                pstm1.close();
            }
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void editar(Paciente p) throws ErroDAO {
        String sql = "start transaction;" +
                        "update Usuario set senha = ?, nome = ?, cpf = ? where idUsuario = ?;" +
                        "UPDATE Paciente SET nomeMae = ?, dataNascimento = ?, sexo = ?, naturalidadeCidade = ?, naturalidadeEstado = ?," +
                        "endereco = ?  WHERE Usuario_idUsuario = ?;" +
                     "commit;";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setString(1, p.getSenha());
            pstm.setString(2, p.getNome());
            pstm.setString(3, p.getCpf());
            pstm.setInt(4, p.getCodigo());
            pstm.setString(5, p.getNomeMae());
            pstm.setString(6, p.getDataNascimento().toString());
            pstm.setString(7, p.getSexo());
            pstm.setString(8, p.getNaturalidadeCidade());
            pstm.setString(9, p.getNaturalidadeEstado());
            pstm.setString(10, p.getEndereco());
            pstm.setInt(11, p.getCodigo());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }

    }

    public void editar(String senha, String endereco, int idUsuario) throws ErroDAO {
        String sql = "start transaction;" +
                "update Usuario set senha = ? where idUsuario = ?;" +
                "UPDATE Paciente SET endereco = ?  WHERE Usuario_idUsuario = ?;" +
                "commit;";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setString(1, senha);
            pstm.setInt(2, idUsuario);
            pstm.setString(3, endereco);
            pstm.setInt(4, idUsuario);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }

    }

    @Override
    public Paciente buscar(int codigo) throws ErroDAO {
        Paciente p = null;
        String sql = "select * from Usuario inner join Paciente on idUsuario = Usuario_idUsuario where idUsuario = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1,codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                p = new Paciente();
                p.setCodigo(rs.getInt(1));
                p.setLogin(rs.getString(2));
                p.setSenha(rs.getString(3));
                p.setIs_medico(rs.getBoolean(4));
                p.setNome(rs.getString(5));
                p.setCpf(rs.getString(6));
                p.setCodigoPaciente(rs.getInt(7));
                p.setSexo(rs.getString(8));
                p.setDataNascimento(LocalDateTime.parse(rs.getString(9), DateTimeFormatter.ISO_DATE_TIME));
                p.setNomeMae(rs.getString(10));
                p.setNaturalidadeCidade(rs.getString(11));
                p.setNaturalidadeEstado(rs.getString(12));
                p.setEndereco(rs.getString(13));
            }
            rs.close();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
        return p;
    }

    @Override
    public Paciente buscar(String login, String senha) throws ErroDAO {
        Paciente p = null;
        String sql = "select * from Usuario inner join Paciente on idUsuario = Usuario_idUsuario where login = ? and senha = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setString(1, login);
            pstm.setString(2, senha);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                p = new Paciente();
                p.setCodigo(rs.getInt(1));
                p.setLogin(rs.getString(2));
                p.setSenha(rs.getString(3));
                p.setIs_medico(rs.getBoolean(4));
                p.setNome(rs.getString(5));
                p.setCpf(rs.getString(6));
                p.setCodigoPaciente(rs.getInt(7));
                p.setSexo(rs.getString(8));
                p.setDataNascimento(LocalDateTime.parse(rs.getString(9), DateTimeFormatter.ISO_DATE_TIME));
                p.setNomeMae(rs.getString(10));
                p.setNaturalidadeCidade(rs.getString(11));
                p.setNaturalidadeEstado(rs.getString(12));
                p.setEndereco(rs.getString(13));
            }
            rs.close();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
        return p;
    }

    @Override
    public void sair() throws ErroDAO {
        try{
            con.close();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }
    @Override
    public ArrayList<Paciente> buscar() throws ErroDAO {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        String sql = "select * from Usuario inner join Paciente on idUsuario = Usuario_idUsuario";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                Paciente paciente = new Paciente();
                paciente.setCodigo(rs.getInt(1));
                paciente.setLogin(rs.getString(2));
                paciente.setSenha(rs.getString(3));
                paciente.setIs_medico(rs.getBoolean(4));
                paciente.setNome(rs.getString(5));
                paciente.setCpf(rs.getString(6));
                paciente.setCodigoPaciente(rs.getInt(7));
                paciente.setSexo(rs.getString(8));
                paciente.setDataNascimento(LocalDateTime.parse(rs.getString(9), DateTimeFormatter.ISO_DATE_TIME));
                paciente.setNomeMae(rs.getString(10));
                paciente.setNaturalidadeCidade(rs.getString(11));
                paciente.setNaturalidadeEstado(rs.getString(12));
                paciente.setEndereco(rs.getString(13));
                pacientes.add(paciente);
            }
            rs.close();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
        return pacientes;
    }

    public static void main(String[] args){
//        Paciente p = new Paciente("miguel","123","Miguel Barros Rosa", "888.222.111-33",false, "Masculino",
//                "Thaize Macedo Rosa", "Palmas", "Tocantins", "Quadra 806 Sul", LocalDateTime.now());
//        Medico m1 = new Medico("hemmerson", "1234","Hemmerson Luis Rosa", "022.222.222-21", true, "Cardiologista");
//        p.setCodigo(2);
//        p.setCodigoPaciente(1);
        try{
            PacienteDaoClasse dao = new PacienteDaoClasse();
//            Paciente p = dao.buscar("miguel", "123");
//            System.out.println(p);
            ArrayList<Paciente> pacientes = dao.buscar();
            for (Paciente p: pacientes) {
                System.out.println(p);
            }
        } catch (ErroDAO e) {
            throw new RuntimeException(e);
        }
    }
}
