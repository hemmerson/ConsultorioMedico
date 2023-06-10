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

<c:if test="${empty param.mostrar}">
    <c:set var="exameFisico" value=""/>
    <c:set var="examesComplementares" value=""/>
    <c:set var="hipoteseDiagnostico" value=""/>
    <c:set var="diagnostico" value=""/>
    <c:set var="tratamento" value=""/>
    <c:set var="nomeMedico" value="${sessionScope.usuario.nome}"/>
    <c:set var="nomePaciente" value="${requestScope.paciente.nome}"/>
    <c:set var="codigoPaciente" value="${requestScope.paciente.codigoPaciente}"/>
    <c:set var="dataConsulta" value="${requestScope.dataConsulta}"/>

    <fmt:parseDate value="${dataConsulta}" pattern="yyyy-MM-dd'T'HH:mm" type="both" var="data"/>
    <fmt:formatDate value='${data}' type='both' pattern='dd/MM/yyyy HH:mm' var="dataFormatada"/>

</c:if>

<c:if test="${param.mostrar == 'mostrar'}">
    <c:set var="exameFisico" value="${requestScope.anamnese.exameFisico}"/>
    <c:set var="examesComplementares" value="${requestScope.anamnese.examesComplementares}"/>
    <c:set var="hipoteseDiagnostico" value="${requestScope.anamnese.hipoteseDiagnostico}"/>
    <c:set var="diagnostico" value="${requestScope.anamnese.diagnostico}"/>
    <c:set var="tratamento" value="${requestScope.anamnese.tratamento}"/>
    <c:set var="nomeMedico" value="${requestScope.anamnese.medico.nome}"/>
    <c:set var="nomePaciente" value="${requestScope.anamnese.paciente.nome}"/>
    <c:set var="codigoPaciente" value="${requestScope.anamnese.paciente.codigoPaciente}"/>
    <c:set var="dataConsulta" value="${requestScope.anamnese.dataHora}"/>
    <c:set var="disabled" value="disabled"/>


    <fmt:parseDate value="${dataConsulta}" pattern="yyyy-MM-dd'T'HH:mm" type="both" var="data"/>
    <fmt:formatDate value='${data}' type='both' pattern='dd/MM/yyyy HH:mm' var="dataFormatada"/>
</c:if>


<meu:template mensagem="${param.mensagem}">

    <div class="container">
        <div class="row justify-content-center mt-5">
            <div class="card-title text-center border-bottom">
                <h2 class="p-3"><i class="bi bi-file-earmark-medical"></i>Anamnese</h2>
            </div>
            <div class="col-lg-8 col-md-8 col-sm-8">
                <form class="row g-3" method="post" action="cadastrarAnamnese">
                    <input type="hidden" name="codigoPaciente" value="${codigoPaciente}">
                    <input type="hidden" name="dataHoraConsulta" value="${dataConsulta}">
                    <div class="col-md-7">
                        <h5 class="form-label text-primary">Paciente: ${nomePaciente}</h5>
                    </div>
                    <div class="col-md-5">
                        <h5 class="form-label text-primary">Data e hora: ${dataFormatada}</h5>
                    </div>
                    <div class="col-md-12">
                        <label class="form-label text-primary">Médico: ${nomeMedico}</label>
                    </div>
                    <hr class="text-danger"/>
                    <div class="col-md-12">
                        <div class="form-floating">
                            <textarea class="form-control" placeholder="Escreva o exame físico" id="exameFisico"
                                      name="exameFisico" style="height: 100px" ${disabled}>${exameFisico}</textarea>
                            <label for="exameFisico">Exame Físico:</label>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-floating">
                            <textarea class="form-control" placeholder="Escreva a hipótese de dianóstico"
                                      id="hipoteseDiagnostico" name="hipoteseDiagnostico"
                                      style="height: 100px" ${disabled}>${hipoteseDiagnostico}</textarea>
                            <label for="hipoteseDiagnostico">Hipóstese de Diagnóstico:</label>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-floating">
                            <textarea class="form-control" placeholder="Escreva os exames Complementares"
                                      id="examesComplementares" name="examesComplementares"
                                      style="height: 100px" ${disabled}>${examesComplementares}</textarea>
                            <label for="examesComplementares">Exames Complementares:</label>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-floating">
                            <textarea class="form-control" placeholder="Escreva o dianóstico" id="diagnostico"
                                      name="diagnostico" style="height: 100px" ${disabled}>${diagnostico}</textarea>
                            <label for="diagnostico">Diagnóstico:</label>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-floating">
                            <textarea class="form-control" placeholder="Escreva o Tratamento utilizado" id="tratamento"
                                      name="tratamento" style="height: 100px" ${disabled}>${tratamento}</textarea>
                            <label for="tratamento">Tratamento:</label>
                        </div>
                    </div>

                    <c:if test="${empty param.mostrar}">
                        <div class="col-12">
                            <button type="submit" class="btn btn-primary col-12"><i class="bi bi-save"></i>
                                Salvar Anamnese
                            </button>
                        </div>
                    </c:if>
                    <hr>
                </form>
            </div>
        </div>
    </div>


</meu:template>