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

<fmt:parseDate value="${requestScope.paciente.dataNascimento}" pattern="yyyy-MM-dd'T'HH:mm" type="both" var="data"/>
<fmt:formatDate value='${data}' type='date' pattern='dd/MM/yyyy' var="dataFormatada"/>


<meu:template mensagem="${param.mensagem}">

    <div class="container">
        <div class="row justify-content-center mt-5">
            <div class="card-title text-center border-bottom">
                <h2 class="p-3"><i class="bi bi-file-earmark-medical"></i>Prontuário</h2>
            </div>
            <div class="col-lg-12 col-md-12 col-sm-12">
                <form class="row g-3">
                    <div class="col-md-3">
                        <label for="login" class="form-label">Login: </label>
                        <input type="text" class="form-control-plaintext form-control-sm bg-light" id="login"
                               name="login" disabled value="${requestScope.paciente.login}">
                    </div>
                    <div class="col-md-3">
                        <label for="nome" class="form-label">Nome: </label>
                        <input type="text" class="form-control-plaintext form-control-sm bg-light" id="nome" name="nome"
                               disabled value="${requestScope.paciente.nome}">
                    </div>
                    <div class="col-md-3">
                        <label for="cpf" class="form-label">CPF: </label>
                        <input type="text" class="form-control-plaintext form-control-sm bg-light" id="cpf" name="cpf"
                               disabled value="${requestScope.paciente.cpf}">
                    </div>
                    <div class="col-md-3">
                        <label for="sexo" class="form-label">Sexo: </label>
                        <input type="text" class="form-control-plaintext form-control-sm bg-light" id="sexo" name="sexo"
                               disabled value="${requestScope.paciente.sexo}">
                    </div>
                    <div class="col-md-3">
                        <label for="nomeMae" class="form-label">Nome Mãe: </label>
                        <input type="text" class="form-control-plaintext form-control-sm bg-light" id="nomeMae"
                               name="nomeMae" disabled value="${requestScope.paciente.nomeMae}">
                    </div>

                    <div class="col-md-3">
                        <label for="dataNascimento" class="form-label">Data de Nascimento: </label>
                        <input type="text" id="dataNascimento" name="dataNascimento"
                               class="form-control-plaintext form-control-sm bg-light" disabled
                        value="${dataFormatada}">
                    </div>

                    <div class="col-md-3">
                        <label for="naturalCidade" class="form-label">Cidade de Nascimento: </label>
                        <input type="text" class="form-control-plaintext form-control-sm bg-light" id="naturalCidade"
                               name="naturalCidade" disabled  value="${requestScope.paciente.naturalidadeCidade}">
                    </div>
                    <div class="col-md-3">
                        <label for="naturalEstado" class="form-label">Estado de Nascimento: </label>
                        <input type="text" class="form-control-plaintext form-control-sm bg-light" id="naturalEstado"
                               name="naturalEstado" disabled  value="${requestScope.paciente.naturalidadeEstado}">
                    </div>
                    <div class="col-12">
                        <label for="endereco" class="form-label">Endereço Completo: </label>
                        <input type="text" class="form-control-plaintext form-control-sm bg-light" id="endereco"
                               name="endereco" value="${requestScope.paciente.endereco}" disabled>
                    </div>
                    <hr/>

                    <div class="card-title text-center border-bottom">
                        <h5 class="p-3"><i class="bi bi-file-earmark-medical"></i>Consultas</h5>
                        <a href="abrirAnamneseCadastrar?codigoPaciente=${requestScope.paciente.codigoPaciente}" class="btn btn-outline-success btn-lg float-end">Nova Consulta</a>
                    </div>
                    <div class="col-lg-12 col-md-12 col-sm-12">
                        <table class="table table-striped table-hover table-sm">
                            <tr>
                                <th>PACIENTE</th>
                                <th>MÉDICO</th>
                                <th>DIAGNÓSTICO</th>
                                <th>DATA DA CONSULTA</th>
                                <th>HORÁRIO</th>
                                <th>ABRIR</th>
                            </tr>
                            <meu:anamneses anamneses="${requestScope.anamneses}" />
                        </table>
                    </div>


                    <div class="col-12">
                        <button type="submit" class="btn btn-primary col-12"><i class="bi bi-save"></i>
                            Cadastrar
                        </button>
                    </div>
                    <hr>
                </form>
            </div>
        </div>
    </div>
</meu:template>