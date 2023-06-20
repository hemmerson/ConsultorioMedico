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
 * on date 06/06/2023
 */
@WebServlet(name = "EditarMedico", urlPatterns = {"/editarmedico"})
public class EditarMedico extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        int codigoMedico = Integer.parseInt(request.getParameter("codigoMedico"));
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
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
                    m.setCodigoMedico(codigoMedico);
                    m.setCodigo(idUsuario);
                    MedicoDaoInterface dao = new MedicoDaoClasse();
                    dao.editar(m);
                    dao.sair();
                    response.sendRedirect("index.jsp?mensagem=sucessoeditarmedico");
                } catch (ErroDAO e) {
                    response.sendRedirect("index.jsp?mensagem=erroaotentareditarmedico");
                }
            }
            else {
                response.sendRedirect("index.jsp?mensagem=erroaotentareditarmedico");
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=erroaotentareditarmedico");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("index.jsp?mensagem=acessonegado");
    }
}
