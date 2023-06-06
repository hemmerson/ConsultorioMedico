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

<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="card-title text-center border-bottom">
            <h2 class="p-3"><i class="bi bi-file-earmark-medical"></i>Cadastrar Medico</h2>
        </div>
        <div class="col-lg-8 col-md-8 col-sm-8">
            <form class="row g-3" method="post" action="cadastrarMedico">
                <div class="col-md-6">
                    <label for="login" class="form-label">Login</label>
                    <input type="text" class="form-control" id="login" name="login">
                </div>
                <div class="col-md-6">
                    <label for="senha" class="form-label">Senha</label>
                    <input type="password" class="form-control" id="senha" name="senha">
                </div>
                <div class="col-md-6">
                    <label for="nome" class="form-label">Nome</label>
                    <input type="text" class="form-control" id="nome" name="nome">
                </div>
                <div class="col-md-6">
                    <label for="cpf" class="form-label">CPF</label>
                    <input type="text" class="form-control" id="cpf" name="cpf">
                </div>
                <hr>
                <div class="col-12">
                    <label for="especialidade" class="form-label">Especialidade</label>
                    <input type="text" class="form-control" id="especialidade" name="especialidade">
                </div>

                <div class="col-12">
                    <button type="submit" class="btn btn-primary col-12"><i class="bi bi-save"></i>  Cadastrar</button>
                </div>
            </form>
        </div>
    </div>
</div>
</meu:template>
