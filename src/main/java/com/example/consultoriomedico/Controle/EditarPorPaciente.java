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

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 06/06/2023
 */
@WebServlet(name = "EditarPorPaciente", urlPatterns = {"/editarporpaciente"})
public class EditarPorPaciente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String senha = request.getParameter("senha");
        String endereco = request.getParameter("endereco");
        int idUsuario = Integer.parseInt(request.getParameter("codigoUsuario"));

        if (senha != null && endereco != null && endereco.length() > 0 && senha.length() > 0) {
            Paciente pacienteSessao = (Paciente) request.getSession().getAttribute("usuario");
            if (pacienteSessao != null && !pacienteSessao.isIs_medico()) {

                try {
                    PacienteDaoInterface dao = new PacienteDaoClasse();
                    dao.editar(senha,endereco,idUsuario);
                    dao.sair();
                    response.sendRedirect("index.jsp?mensagem=sucessoeditarpaciente");
                } catch (ErroDAO e) {
                    response.sendRedirect("index.jsp?mensagem=erroaotentareditarpaciente");
                }
            } else {
                response.sendRedirect("index.jsp?mensagem=erroaotentareditarpaciente");
            }
        }
    }
}
