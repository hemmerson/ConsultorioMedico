package com.example.consultoriomedico.Controle;

import com.example.consultoriomedico.DAO.Classe.AnamneseDaoClasse;
import com.example.consultoriomedico.DAO.ErroDAO;
import com.example.consultoriomedico.DAO.Interface.AnamneseDaoInterface;
import com.example.consultoriomedico.Modelo.Anamnese;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 10/06/2023
 */
@WebServlet(name = "mostraAnamnese", urlPatterns = {"/mostraAnamnese"})
public class mostraAnamnese extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        int codigoAnamnese = Integer.parseInt(request.getParameter("codigoAnamnese"));
        try {
            AnamneseDaoInterface dao = new AnamneseDaoClasse();
            Anamnese a = dao.buscar(codigoAnamnese);
            request.setAttribute("anamnese", a);
            dao.sair();
            request.getRequestDispatcher("/WEB-INF/anamnese.jsp?mostrar=mostrar").forward(request, response);
        } catch (ErroDAO e) {
            request.getRequestDispatcher("WEB-INF/anamnese.jsp?mensagem=erroaomostrar").forward(request, response);
        }

    }
}
