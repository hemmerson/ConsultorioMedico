package com.example.consultoriomedico.Controle;

import com.example.consultoriomedico.DAO.Classe.MedicoDaoClasse;
import com.example.consultoriomedico.DAO.ErroDAO;
import com.example.consultoriomedico.DAO.Interface.MedicoDaoInterface;
import com.example.consultoriomedico.Modelo.Medico;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 05/06/2023
 */
@WebServlet(name = "cadastrarMedico", urlPatterns = {"/cadastrarMedico"})
public class CadastrarMedico extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String especializacao = request.getParameter("especializacao");

        if (login != null && senha != null && login.length()>0 && senha.length() > 0){
            Medico medicoSessao = (Medico) request.getSession().getAttribute("usuario");
            if (medicoSessao != null && medicoSessao.isIs_medico()){
                try{
                    Medico m = new Medico(login, senha, nome, cpf, true, especializacao);
                    MedicoDaoInterface dao = new MedicoDaoClasse();
                    dao.inserir(m);
                    dao.sair();
                    response.sendRedirect("index.jsp?mensagem=sucessocadastrarmedico");
                } catch (ErroDAO e) {
                    response.sendRedirect("index.jsp?mensagem=erroaotentarcadastrarmedico");
                }
            } else {
                response.sendRedirect("index.jsp?mensagem=erroaotentarcadastrarmedico");
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=erroaotentarcadastrarmedico");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("index.jsp?mensagem=acessonegado");
    }
}
