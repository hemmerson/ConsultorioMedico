package com.example.consultoriomedico.Controle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 06/06/2023
 */

@WebServlet(name = "Sair", urlPatterns = {"/sair"})
public class Sair extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession s=request.getSession(false);
        if(s!=null) {
            s.removeAttribute("usuario");
        }
        response.sendRedirect("login.jsp");
    }
}
