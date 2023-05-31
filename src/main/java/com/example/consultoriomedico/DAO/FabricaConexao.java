package com.example.consultoriomedico.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 30/05/2023
 */
public class FabricaConexao {
    public static Connection pegaConexao() throws ErroDAO{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/ConsultorioMedico?allowMultiQueries=true&useSSL=false","root","admin");
        } catch (ClassNotFoundException | SQLException e) {
            throw new ErroDAO(e);
        }
    }

    public static void main(String[] args) {
        try {
            FabricaConexao.pegaConexao();
            System.out.print("Conexão Ok");
        } catch (ErroDAO e) {
            throw new RuntimeException(e);
        }
    }
}
