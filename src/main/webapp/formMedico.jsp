<%--
  Created by IntelliJ IDEA.
  User: "Hemmerson Luis Barros da Rosa" 
  Date: 05/06/2023
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="meu" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meu:template mensagem="${param.mensagem}" >

    <c:if test="${param.acao == 'cadastrar'}">
        <c:set var="titulo" value="Cadastrar Médico" />
        <c:set var="acao" value="cadastrarMedico"/>
        <c:set var="codigoMedico" value=""/>
        <c:set var="idUsuario" value=""/>
        <c:set var="login" value=""/>
        <c:set var="senha" value=""/>
        <c:set var="nome" value=""/>
        <c:set var="cpf" value=""/>
        <c:set var="especializacao" value=""/>
        <c:set var="botao" value="Cadastrar"/>
    </c:if>
    <c:if test="${param.acao == 'editar'}">
        <c:set var="titulo" value="Editar Médico" />
        <c:set var="acao" value="editarmedico"/>
        <c:set var="codigoMedico" value="${param.codigoMedico}"/>
        <c:set var="idUsuario" value="${param.idUsuario}"/>
        <c:set var="login" value="${param.login}"/>
        <c:set var="senha" value="${param.senha}"/>
        <c:set var="nome" value="${param.nome}"/>
        <c:set var="cpf" value="${param.cpf}"/>
        <c:set var="especializacao" value="${param.especializacao}"/>
        <c:set var="botao" value="Editar"/>
    </c:if>

<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="card-title text-center border-bottom">
            <h2 class="p-3"><i class="bi bi-file-earmark-medical"></i>${titulo}</h2>
        </div>
        <div class="col-lg-8 col-md-8 col-sm-8">
            <form class="row g-3" method="post" action="${acao}">
                <input type="hidden" name="codigoMedico" value="${codigoMedico}">
                <input type="hidden" name="idUsuario" value="${idUsuario}">
                <div class="col-md-6">
                    <label for="login" class="form-label">Login</label>
                    <input type="text" class="form-control" id="login" name="login" value="${login}">
                </div>
                <div class="col-md-6">
                    <label for="senha" class="form-label">Senha</label>
                    <input type="password" class="form-control" id="senha" name="senha" value="${senha}">
                </div>
                <div class="col-md-6">
                    <label for="nome" class="form-label">Nome</label>
                    <input type="text" class="form-control" id="nome" name="nome" value="${nome}">
                </div>
                <div class="col-md-6">
                    <label for="cpf" class="form-label">CPF</label>
                    <input type="text" class="form-control" id="cpf" name="cpf" value="${cpf}">
                </div>
                <hr>
                <div class="col-12">
                    <label for="especializacao" class="form-label">Especialidade</label>
                    <input type="text" class="form-control" id="especializacao" name="especializacao" value="${especializacao}">
                </div>

                <div class="col-12">
                    <button type="submit" class="btn btn-primary col-12"><i class="bi bi-save"></i>  ${botao}</button>
                </div>
            </form>
        </div>
    </div>
</div>
</meu:template>
