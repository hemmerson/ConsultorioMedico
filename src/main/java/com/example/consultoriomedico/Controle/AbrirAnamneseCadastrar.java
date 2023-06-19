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
import java.time.LocalDateTime;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 05/06/2023
 */
@WebServlet(name = "abrirAnamneseCadastrar", urlPatterns = {"/abrirAnamneseCadastrar"})
public class AbrirAnamneseCadastrar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        int codigoPaciente = Integer.parseInt(request.getParameter("codigoPaciente"));

        Medico medicoSessao = (Medico) request.getSession().getAttribute("usuario");
        if (medicoSessao != null && medicoSessao.isIs_medico()) {
            try {
                PacienteDaoInterface daoPaciente = new PacienteDaoClasse();
                Paciente p = daoPaciente.buscar(codigoPaciente);
                LocalDateTime dataHoraConsulta = LocalDateTime.now();
                request.setAttribute("paciente",p);
                request.setAttribute("medico",medicoSessao);
                request.setAttribute("dataConsulta", dataHoraConsulta);
                request.getRequestDispatcher("WEB-INF/anamnese.jsp").forward(request, response);
            } catch (ErroDAO e) {
                request.getRequestDispatcher("WEB-INF/anamnese.jsp?mensagem=erroaoabriranamnese").forward(request, response);
            }
        } else {
            response.sendRedirect("prontuario.jsp?mensagem=acessonegado");
        }

    }
}
