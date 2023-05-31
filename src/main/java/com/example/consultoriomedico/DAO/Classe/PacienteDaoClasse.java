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
                        "update Usuario set login = ?, senha = ?, nome = ?, cpf = ? where idUsuario = ?;" +
                        "UPDATE Paciente SET nomeMae = ?, dataNascimento = ?, sexo = ?, naturalidadeCidade = ?, naturalidadeEstado = ?," +
                        "endereco = ?  WHERE Usuario_idUsuario = ?;" +
                     "commit;";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setString(1, p.getLogin());
            pstm.setString(2, p.getSenha());
            pstm.setString(3, p.getNome());
            pstm.setString(4, p.getCpf());
            pstm.setInt(5, p.getCodigo());
            pstm.setString(6, p.getNomeMae());
            pstm.setString(7, p.getDataNascimento().toString());
            pstm.setString(8, p.getSexo());
            pstm.setString(9, p.getNaturalidadeCidade());
            pstm.setString(10, p.getNaturalidadeEstado());
            pstm.setString(11, p.getEndereco());
            pstm.setInt(12, p.getCodigo());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }

    }

    @Override
    public Paciente buscar(int codigo) throws ErroDAO {
        Paciente p = null;
        String sql = "select * from Usuario inner join Medico on idUsuario = Usuario_idUsuario where idUsuario = 1;";

        return null;
    }

    @Override
    public ArrayList<Paciente> buscar(Paciente p) throws ErroDAO {
        return null;
    }

    public static void main(String[] args){
        Paciente p = new Paciente("miguel","123","Miguel Barros Rosa", "888.222.111-33",false, "Masculino",
                "Thaize Macedo Rosa", "Palmas", "Tocantins", "Quadra 806 Sul", LocalDateTime.now());
//        Medico m1 = new Medico("hemmerson", "1234","Hemmerson Luis Rosa", "022.222.222-21", true, "Cardiologista");
        p.setCodigo(2);
        p.setCodigoPaciente(1);
        try{
            PacienteDaoClasse dao = new PacienteDaoClasse();
            dao.editar(p);
        } catch (ErroDAO e) {
            throw new RuntimeException(e);
        }
    }
}
