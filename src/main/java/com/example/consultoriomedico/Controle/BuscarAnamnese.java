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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 09/06/2023
 */
@WebServlet(name = "BuscarAnamnese", urlPatterns = {"/buscaranamnese"})
public class BuscarAnamnese extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        LocalDateTime dataFinal;

        LocalDateTime dataInicio = LocalDateTime.parse(request.getParameter("dataInicio")+"T00:00:00");
        if(request.getParameter("dataFinal").length()>5){
            dataFinal = LocalDateTime.parse(request.getParameter("dataFinal")+"T23:59:59");
        }
        else{
            dataFinal = LocalDateTime.now();
        }
        try {
            PacienteDaoInterface daoPaciente = new PacienteDaoClasse();
            Paciente p = daoPaciente.buscar(Integer.parseInt(request.getParameter("codigoPaciente")));
            AnamneseDaoInterface daoAnamnese = new AnamneseDaoClasse();
            List<Anamnese> anamneses = daoAnamnese.buscar(p,dataInicio,dataFinal);
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
}
