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

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 04/06/2023
 */
@WebServlet(name="login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login=request.getParameter("login");
        String senha=request.getParameter("senha");
        if(login!=null&&senha!=null&&login.length()>0&&senha.length()>0){
            try {
                MedicoDaoInterface dao=new MedicoDaoClasse();
                Medico m= dao.buscar(login, senha);
                dao.sair();
                if(m==null){
                    PacienteDaoInterface dao1 = new PacienteDaoClasse();
                    Paciente p = dao1.buscar(login, senha);
                    dao1.sair();
                    if (p == null)
                        response.sendRedirect("login.jsp?mensagem=errousuarioesenhaincorreto");
                    else{
                        request.getSession().setAttribute("usuario", p);
                        response.sendRedirect("index.jsp");
                    }
                }
                else
                {
                    request.getSession().setAttribute("usuario", m);
                    response.sendRedirect("index.jsp");
                }
            } catch (ErroDAO ex) {
                response.sendRedirect("login.jsp?mensagem=errobuscarloginesenha");
            }
        }
        else{
            response.sendRedirect("login.jsp?mensagem=errologinesenha");
        }

    }
}
