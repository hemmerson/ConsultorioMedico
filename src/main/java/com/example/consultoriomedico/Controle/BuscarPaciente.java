package com.example.consultoriomedico.Controle;

import com.example.consultoriomedico.DAO.Classe.PacienteDaoClasse;
import com.example.consultoriomedico.DAO.ErroDAO;
import com.example.consultoriomedico.DAO.Interface.PacienteDaoInterface;
import com.example.consultoriomedico.Modelo.Medico;
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
@WebServlet(name = "BuscarPacientes", urlPatterns = {"/buscarpacientes"})
public class BuscarPaciente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            String cpf = request.getParameter("cpf");
            Medico medicoSessao = (Medico) request.getSession().getAttribute("usuario");
            if (medicoSessao != null && medicoSessao.isIs_medico()) {
                PacienteDaoInterface dao = new PacienteDaoClasse();
                List<Paciente> pacientes = dao.buscar(cpf);
                request.setAttribute("pacientes", pacientes);
                dao.sair();
                request.getRequestDispatcher("WEB-INF/listaPacientes.jsp").forward(request, response);
            } else {
                response.sendRedirect("index.jsp?mensagem=acessonegado");
            }
        } catch (ErroDAO e) {
            request.getRequestDispatcher("WEB-INF/listaPacientes.jsp?mensagem=erroaomostrar").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("index.jsp?mensagem=acessonegado");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("index.jsp?mensagem=acessonegado");
    }
}
