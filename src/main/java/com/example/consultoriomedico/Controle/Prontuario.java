package com.example.consultoriomedico.Controle;

import com.example.consultoriomedico.DAO.Classe.AnamneseDaoClasse;
import com.example.consultoriomedico.DAO.Classe.PacienteDaoClasse;
import com.example.consultoriomedico.DAO.ErroDAO;
import com.example.consultoriomedico.DAO.Interface.AnamneseDaoInterface;
import com.example.consultoriomedico.DAO.Interface.PacienteDaoInterface;
import com.example.consultoriomedico.Modelo.Anamnese;
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
 * on date 09/06/2023
 */
@WebServlet(name = "Prontuario", urlPatterns = {"/prontuario"})
public class Prontuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        try {
            PacienteDaoInterface daoPaciente = new PacienteDaoClasse();
            Paciente p = daoPaciente.buscar(Integer.parseInt(request.getParameter("codigoPaciente")));
            AnamneseDaoInterface daoAnamnese = new AnamneseDaoClasse();
            List<Anamnese> anamneses = daoAnamnese.buscar(p);
            p.setAnamneses(anamneses);
            request.setAttribute("paciente", p);
            request.setAttribute("anamneses", anamneses);
            daoPaciente.sair();
            daoAnamnese.sair();
            request.getRequestDispatcher("WEB-INF/prontuario.jsp").forward(request, response);
        } catch (ErroDAO e) {
            request.getRequestDispatcher("WEB-INF/prontuario.jsp?mensagem=erroaomostrar").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
    }
}
