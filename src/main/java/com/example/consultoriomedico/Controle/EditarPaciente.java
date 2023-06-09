package com.example.consultoriomedico.Controle;

import com.example.consultoriomedico.DAO.Classe.MedicoDaoClasse;
import com.example.consultoriomedico.DAO.Classe.PacienteDaoClasse;
import com.example.consultoriomedico.DAO.ErroDAO;
import com.example.consultoriomedico.DAO.Interface.MedicoDaoInterface;
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
 * on date 06/06/2023
 */
@WebServlet(name = "EditarPaciente", urlPatterns = {"/editarpaciente"})
public class EditarPaciente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        int codigoPaciente = Integer.parseInt(request.getParameter("codigoPaciente"));
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String sexo = request.getParameter("sexo");
        LocalDateTime dataNascimento = LocalDateTime.parse(request.getParameter("dataNascimento")+"T00:00:00.000");
        String nomeMae = request.getParameter("nomeMae");
        String naturalidadeCidade = request.getParameter("naturalCidade");
        String naturalidadeEstado = request.getParameter("naturalEstado");
        String endereco = request.getParameter("endereco");

        if (login != null && senha != null && login.length()>0 && senha.length() > 0){
            Medico medicoSessao = (Medico) request.getSession().getAttribute("usuario");
            if (medicoSessao != null && medicoSessao.isIs_medico()){
                try{
                    Paciente p = new Paciente(login, senha, nome, cpf, true, sexo,nomeMae, naturalidadeCidade, naturalidadeEstado,endereco, dataNascimento);
                    p.setCodigoPaciente(codigoPaciente);
                    p.setCodigo(idUsuario);
                    PacienteDaoInterface dao = new PacienteDaoClasse();
                    dao.editar(p);
                    dao.sair();
                    response.sendRedirect("listarpacientes?mensagem=sucessoeditarpaciente");
                } catch (ErroDAO e) {
                    response.sendRedirect("listarpacientes?mensagem=erroaotentareditarpaciente");
                }
            }
            else {
                response.sendRedirect("listarpacientes?mensagem=erroaotentareditarpaciente");
            }
        }
    }
}
