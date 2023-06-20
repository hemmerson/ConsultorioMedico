package com.example.consultoriomedico.Controle;

import com.example.consultoriomedico.DAO.Classe.AnamneseDaoClasse;
import com.example.consultoriomedico.DAO.Classe.MedicoDaoClasse;
import com.example.consultoriomedico.DAO.Classe.PacienteDaoClasse;
import com.example.consultoriomedico.DAO.ErroDAO;
import com.example.consultoriomedico.DAO.Interface.AnamneseDaoInterface;
import com.example.consultoriomedico.DAO.Interface.MedicoDaoInterface;
import com.example.consultoriomedico.DAO.Interface.PacienteDaoInterface;
import com.example.consultoriomedico.Modelo.Anamnese;
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
 * on date 05/06/2023
 */
@WebServlet(name = "cadastrarAnamnese", urlPatterns = {"/cadastrarAnamnese"})
public class CadastrarAnamnese extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Paciente p;
        int codigoPaciente = Integer.parseInt(request.getParameter("codigoPaciente"));
        LocalDateTime dataConsulta = LocalDateTime.parse(request.getParameter("dataHoraConsulta").toString());

        String exameFisico = request.getParameter("exameFisico");
        String hipoteseDiagnostico = request.getParameter("hipoteseDiagnostico");
        String examesComplementares = request.getParameter("examesComplementares");
        String diagnostico = request.getParameter("diagnostico");
        String tratamento = request.getParameter("tratamento");
        Medico medicoSessao = (Medico) request.getSession().getAttribute("usuario");
        if (medicoSessao != null && medicoSessao.isIs_medico()) {
            try {
                PacienteDaoInterface daoPaciente = new PacienteDaoClasse();
                MedicoDaoInterface daoMedico = new MedicoDaoClasse();
                AnamneseDaoInterface daoAnamnese = new AnamneseDaoClasse();
                p = daoPaciente.buscar(codigoPaciente);
                Anamnese a = new Anamnese(exameFisico,examesComplementares,hipoteseDiagnostico,diagnostico,tratamento,dataConsulta,medicoSessao,p);
                daoAnamnese.inserir(a);
                daoAnamnese.sair();
                daoMedico.sair();
                daoPaciente.sair();
                response.sendRedirect("prontuario?codigoPaciente="+p.getCodigoPaciente()+"&mensagem=sucessocadastraranamnese");
            } catch (ErroDAO e) {
                response.sendRedirect("prontuario?codigoPaciente="+codigoPaciente+"&mensagem=erroaotentarcadastraranamnese");
            }
        } else {
            response.sendRedirect("prontuario?codigoPaciente="+codigoPaciente+"&mensagem=erroaotentarcadastraranamnese");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("index.jsp?mensagem=acessonegado");
    }
}
