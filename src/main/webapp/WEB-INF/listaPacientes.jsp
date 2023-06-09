<%--
  Created by IntelliJ IDEA.
  User: "Hemmerson Luis Barros da Rosa" 
  Date: 08/06/2023
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="meu" tagdir="/WEB-INF/tags/" %>
<meu:template mensagem="${param.mensagem}">

  <div class="container">
    <div class="row justify-content-center mt-5">
      <div class="card-title text-center border-bottom">
        <h2 class="p-3"><i class="bi bi-file-earmark-medical"></i>Lista de Pacientes</h2>
      </div>
      <div class="col-lg-10 col-md-10 col-sm-10">
        <table class="table table-striped table-hover">
          <tr>
            <th>NOME</th>
            <th>CPF</th>
            <th>LOGIN</th>
            <th>DATA DE NASCIMENTO</th>
            <th>EDITAR</th>
            <th>PRONTUÁRIO</th>
          </tr>
          <meu:pacientes pacientes="${requestScope.pacientes}" />
        </table>
      </div>
    </div>
  </div>

</meu:template>