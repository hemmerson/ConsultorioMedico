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
import java.util.List;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 07/06/2023
 */
@WebServlet(name = "ListarMedicos", urlPatterns = {"/listarmedicos"})
public class ListarMedicos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        try{
            MedicoDaoInterface dao = new MedicoDaoClasse();
            List<Medico> medicos = dao.buscar();
            request.setAttribute("medicos", medicos);
            dao.sair();
            request.getRequestDispatcher("WEB-INF/listaMedicos.jsp").forward(request, response);
        } catch (ErroDAO e) {
            request.getRequestDispatcher("WEB-INF/listaMedicos.jsp?mensagem=erroaomostrar").forward(request, response);
        }
    }
}
