package com.example.consultoriomedico.Controle;

import com.example.consultoriomedico.DAO.Classe.PacienteDaoClasse;
import com.example.consultoriomedico.DAO.ErroDAO;
import com.example.consultoriomedico.DAO.Interface.PacienteDaoInterface;
import com.example.consultoriomedico.Modelo.Paciente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 07/06/2023
 */
@WebServlet(name = "ListarPacientes", urlPatterns = {"/listarpacientes"})
public class ListarPacientes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        try{
            PacienteDaoInterface dao = new PacienteDaoClasse();
            List<Paciente> pacientes = dao.buscar();
            request.setAttribute("pacientes", pacientes);
            dao.sair();
            request.getRequestDispatcher("WEB-INF/listaPacientes.jsp").forward(request, response);
        } catch (ErroDAO e) {
            request.getRequestDispatcher("WEB-INF/listaPacientes.jsp?mensagem=erroaomostrar").forward(request, response);
        }
    }
}
