package com.example.consultoriomedico.Controle;

import com.example.consultoriomedico.DAO.Classe.MedicoDaoClasse;
import com.example.consultoriomedico.DAO.Classe.PacienteDaoClasse;import com.example.consultoriomedico.DAO.ErroDAO;
import com.example.consultoriomedico.DAO.Interface.MedicoDaoInterface;
import com.example.consultoriomedico.DAO.Interface.PacienteDaoInterface;import com.example.consultoriomedico.Modelo.Medico;
import com.example.consultoriomedico.Modelo.Paciente;import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;import java.time.LocalDateTime;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 05/06/2023
 */
@WebServlet(name = "cadastrarPaciente", urlPatterns = {"/cadastrarPaciente"})
public class CadastrarPaciente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String sexo = request.getParameter("sexo");
        LocalDateTime dataNascimento = LocalDateTime.parse(request.getParameter("dataNascimento")+"T00:00:00.000");
        System.out.println(dataNascimento);
        String nomeMae = request.getParameter("nomeMae");
        String naturalidadeCidade = request.getParameter("naturalCidade");
        String naturalidadeEstado = request.getParameter("naturalEstado");
        String endereco = request.getParameter("endereco");

        if (login != null && senha != null && login.length()>0 && senha.length() > 0){
            Medico medicoSessao = (Medico) request.getSession().getAttribute("usuario");
            if (medicoSessao != null && medicoSessao.isIs_medico()){
                try{
                    Paciente p = new Paciente(login, senha, nome, cpf, false, sexo, nomeMae, naturalidadeCidade,
                            naturalidadeEstado, endereco, dataNascimento);
                    PacienteDaoInterface dao = new PacienteDaoClasse();
                    dao.inserir(p);
                    dao.sair();
                    response.sendRedirect("index.jsp?mensagem=sucessocadastrarpaciente");
                } catch (ErroDAO e) {
                    response.sendRedirect("index.jsp?mensagem=erroaotentarcadastrarpaciente");
                }
            }
            else {
                response.sendRedirect("index.jsp?mensagem=erroaotentarcadastrarpaciente");
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=erroaotentarcadastrarpaciente");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("index.jsp?mensagem=acessonegado");
    }
}
