<%--
  Created by IntelliJ IDEA.
  User: "Hemmerson Luis Barros da Rosa" 
  Date: 09/06/2023
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="meu" tagdir="/WEB-INF/tags" %>

<fmt:parseDate value="${requestScope.dataConsulta}" pattern="yyyy-MM-dd'T'HH:mm" type="both" var="data"/>
<fmt:formatDate value='${data}' type='both' pattern='dd/MM/yyyy HH:mm' var="dataFormatada"/>


<meu:template mensagem="${param.mensagem}">

    <div class="container">
        <div class="row justify-content-center mt-5">
            <div class="card-title text-center border-bottom">
                <h2 class="p-3"><i class="bi bi-file-earmark-medical"></i>Anamnese</h2>
            </div>
            <div class="col-lg-8 col-md-8 col-sm-8">
                <form class="row g-3" method="post" action="cadastrarAnamnese">
                    <input type="hidden" name="codigoPaciente" value="${requestScope.paciente.codigoPaciente}">
                    <input type="hidden" name="dataHoraConsulta" value="${requestScope.dataConsulta}">
                    <div class="col-md-7">
                        <h5 class="form-label text-primary">Paciente:  ${requestScope.paciente.nome}</h5>
                    </div>
                    <div class="col-md-5">
                        <h5 class="form-label text-primary">Data e hora:  ${dataFormatada}</h5>
                    </div>
                    <hr class="text-danger" />
                    <div class="col-md-12">
                        <div class="form-floating">
                            <textarea class="form-control" placeholder="Escreva o exame físico" id="exameFisico"
                                      name="exameFisico" style="height: 100px"></textarea>
                            <label for="exameFisico">Exame Físico:</label>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-floating">
                            <textarea class="form-control" placeholder="Escreva a hipótese de dianóstico"
                                      id="hipoteseDiagnostico" name="hipoteseDiagnostico" style="height: 100px"></textarea>
                            <label for="hipoteseDiagnostico">Hipóstese de Diagnóstico:</label>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-floating">
                            <textarea class="form-control" placeholder="Escreva os exames Complementares"
                                      id="examesComplementares" name="examesComplementares" style="height: 100px"></textarea>
                            <label for="examesComplementares">Exames Complementares:</label>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-floating">
                            <textarea class="form-control" placeholder="Escreva o dianóstico" id="diagnostico"
                                      name="diagnostico" style="height: 100px"></textarea>
                            <label for="diagnostico">Diagnóstico:</label>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-floating">
                            <textarea class="form-control" placeholder="Escreva o Tratamento utilizado" id="tratamento"
                                      name="tratamento" style="height: 100px"></textarea>
                            <label for="tratamento">Tratamento:</label>
                        </div>
                    </div>

                    <div class="col-12">
                        <button type="submit" class="btn btn-primary col-12"><i class="bi bi-save"></i>
                            Salvar Anamnese</button>
                    </div>
                    <hr>
                </form>
            </div>
        </div>
    </div>


</meu:template>