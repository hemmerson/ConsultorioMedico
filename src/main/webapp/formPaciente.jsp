<%--
  Created by IntelliJ IDEA.
  User: "Hemmerson Luis Barros da Rosa" 
  Date: 05/06/2023
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="meu" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meu:template mensagem="${param.mensagem}" >

    <c:if test="${param.acao == 'cadastrar'}">
        <c:set var="titulo" value="Cadastrar Paciente" />
        <c:set var="acao" value="cadastrarPaciente"/>
        <c:set var="codigoPaciente" value=""/>
        <c:set var="idUsuario" value=""/>
        <c:set var="login" value=""/>
        <c:set var="senha" value=""/>
        <c:set var="nome" value=""/>
        <c:set var="cpf" value=""/>
        <c:set var="sexo" value=""/>
        <c:set var="dataNascimento" value=""/>
        <c:set var="nomeMae" value=""/>
        <c:set var="naturalCidade" value=""/>
        <c:set var="naturalEstado" value=""/>
        <c:set var="endereco" value=""/>
        <c:set var="botao" value="Cadastrar"/>
        <c:set var="readonlyClass" value="" />
    </c:if>

    <c:if test="${param.acao == 'editarporpaciente' || param.acao == 'editarpaciente'}">
        <c:set var="titulo" value="Editar Paciente" />
        <c:set var="codigoPaciente" value="${param.codigoPaciente}"/>
        <c:set var="idUsuario" value="${param.idUsuario}"/>
        <c:set var="login" value="${param.login}"/>
        <c:set var="senha" value="${param.senha}"/>
        <c:set var="nome" value="${param.nome}"/>
        <c:set var="cpf" value="${param.cpf}"/>
        <c:set var="sexo" value="${param.sexo}"/>
        <c:set var="dataNascimento" value="${param.dataNascimento.substring(0,10)}"/>
        <c:set var="nomeMae" value="${param.nomeMae}"/>
        <c:set var="naturalCidade" value="${param.naturalCidade}"/>
        <c:set var="naturalEstado" value="${param.naturalEstado}"/>
        <c:set var="endereco" value="${param.endereco}"/>
        <c:set var="botao" value="Editar"/>
        <c:set var="readonly" value="readonly"/>

    </c:if>

    <c:if test="${param.acao == 'editarporpaciente'}" >
        <c:set var="acao" value="editarporpaciente"/>
        <c:set var="disabled" value="readonly='readonly'" />
        <c:set var="classe" value="readonly" />
        <c:set var="desabilita" value="aria-disabled='true' tabindex='-1'" />
        <c:set var="readonlyClass" value="readonly" />
    </c:if>
    <c:if test="${param.acao == 'editarpaciente'}" >
        <c:set var="acao" value="editarpaciente"/>
        <c:set var="readonlyClass" value="" />

    </c:if>
    <c:if test="${param.acao == 'cadastrar'}" >
        <c:set var="disabled" value="" />
    </c:if>



    <div class="container">
        <div class="row justify-content-center mt-5">
            <div class="card-title text-center border-bottom">
                <h2 class="p-3"><i class="bi bi-file-earmark-medical"></i>${titulo}</h2>
            </div>
            <div class="col-lg-8 col-md-8 col-sm-8">
                <form class="row g-3" method="post" action="${acao}">
                    <input type="hidden" name="codigoPaciente" value="${codigoPaciente}" ${disabled}>
                    <input type="hidden" name="idUsuario" value="${idUsuario}" ${disabled}>
                    <div class="col-md-6">
                        <label for="login" class="form-label">Login</label>
                        <input type="text" class="form-control" id="login" name="login" value="${login}" ${readonly}>
                    </div>
                    <div class="col-md-6">
                        <label for="senha" class="form-label">Senha</label>
                        <input type="password" class="form-control" id="senha" name="senha" value="${senha}">
                    </div>
                    <div class="col-md-6">
                        <label for="nome" class="form-label">Nome</label>
                        <input type="text" class="form-control" id="nome" name="nome" value="${nome}" ${disabled}>
                    </div>
                    <div class="col-md-6">
                        <label for="cpf" class="form-label">CPF</label>
                        <input type="text" class="form-control" id="cpf" name="cpf" value="${cpf}" ${disabled}>
                    </div>
                    <hr>
                    <div class="col-md-6">
                        <label for="sexo" class="form-label">Sexo</label>
                        <select name="sexo" id="sexo" class="form-select ${readonlyClass}" ${desabilita}>
                            <option>Selecione</option>
                            <option value="masculino" <c:if test="${sexo == 'masculino'}">selected</c:if> >Masculino</option>
                            <option value="feminino" <c:if test="${sexo == 'feminino'}">selected</c:if> >Feminino</option>
                        </select>
                    </div>
                    <div class="col-md-6">
                        <label for="dataNascimento" class="form-label">Data de Nascimento</label>
                        <input type="date" id="dataNascimento" name="dataNascimento" class="form-control" value="${dataNascimento}" ${disabled}>
                    </div>
                    <div class="col-md-6">
                        <label for="nomeMae" class="form-label">Nome da Mãe</label>
                        <input type="text" class="form-control" id="nomeMae" name="nomeMae" value="${nomeMae}" ${disabled}>
                    </div>
                    <div class="col-md-6">

                    </div>
                    <div class="col-md-6">
                        <label for="naturalCidade" class="form-label">Cidade de Nascimento</label>
                        <input type="text" class="form-control" id="naturalCidade" name="naturalCidade" value="${naturalCidade}" ${disabled}>
                    </div>
                    <div class="col-md-6">
                        <label for="naturalEstado" class="form-label">Estado de Nascimento</label>
                        <select id="naturalEstado" name="naturalEstado" class="form-select ${readonlyClass}" ${desabilita} >
                            <option>Selecione</option>
                            <option value="AC" <c:if test="${naturalEstado == 'AC'}">selected</c:if>>Acre</option>
                            <option value="AL" <c:if test="${naturalEstado == 'AL'}">selected</c:if>>Alagoas</option>
                            <option value="AP" <c:if test="${naturalEstado == 'AP'}">selected</c:if>>Amapá</option>
                            <option value="AM" <c:if test="${naturalEstado == 'AM'}">selected</c:if>>Amazonas</option>
                            <option value="BA" <c:if test="${naturalEstado == 'BA'}">selected</c:if>>Bahia</option>
                            <option value="CE" <c:if test="${naturalEstado == 'CE'}">selected</c:if>>Ceará</option>
                            <option value="DF" <c:if test="${naturalEstado == 'DF'}">selected</c:if>>Distrito Federal</option>
                            <option value="ES" <c:if test="${naturalEstado == 'ES'}">selected</c:if>>Espírito Santo</option>
                            <option value="GO" <c:if test="${naturalEstado == 'GO'}">selected</c:if>>Goiás</option>
                            <option value="MA" <c:if test="${naturalEstado == 'MA'}">selected</c:if>>Maranhão</option>
                            <option value="MT" <c:if test="${naturalEstado == 'MT'}">selected</c:if>>Mato Grosso</option>
                            <option value="MS" <c:if test="${naturalEstado == 'MS'}">selected</c:if>>Mato Grosso do Sul</option>
                            <option value="MG" <c:if test="${naturalEstado == 'MG'}">selected</c:if>>Minas Gerais</option>
                            <option value="PA" <c:if test="${naturalEstado == 'PA'}">selected</c:if>>Pará</option>
                            <option value="PB" <c:if test="${naturalEstado == 'PB'}">selected</c:if>>Paraíba</option>
                            <option value="PR" <c:if test="${naturalEstado == 'PR'}">selected</c:if>>Paraná</option>
                            <option value="PE" <c:if test="${naturalEstado == 'PE'}">selected</c:if>>Pernambuco</option>
                            <option value="PI" <c:if test="${naturalEstado == 'PI'}">selected</c:if>>Piauí</option>
                            <option value="RJ" <c:if test="${naturalEstado == 'RJ'}">selected</c:if>>Rio de Janeiro</option>
                            <option value="RN" <c:if test="${naturalEstado == 'RN'}">selected</c:if>>Rio Grande do Norte</option>
                            <option value="RS" <c:if test="${naturalEstado == 'RS'}">selected</c:if>>Rio Grande do Sul</option>
                            <option value="RO" <c:if test="${naturalEstado == 'RO'}">selected</c:if>>Rondônia</option>
                            <option value="RR" <c:if test="${naturalEstado == 'RR'}">selected</c:if>>Roraima</option>
                            <option value="SC" <c:if test="${naturalEstado == 'SC'}">selected</c:if>>Santa Catarina</option>
                            <option value="SP" <c:if test="${naturalEstado == 'SP'}">selected</c:if>>São Paulo</option>
                            <option value="SE" <c:if test="${naturalEstado == 'SE'}">selected</c:if>>Sergipe</option>
                            <option value="TO" <c:if test="${naturalEstado == 'TO'}">selected</c:if>>Tocantins</option>
                            <option value="EX">Estrangeiro</option>
                        </select>
                    </div>
                    <div class="col-12">
                        <label for="endereco" class="form-label">Endereço Completo</label>
                        <input type="text" class="form-control" id="endereco" name="endereco"
                               placeholder="EX: Q. 310 Sul, Plano Diretor Sul, Palmas - TO" value="${endereco}">
                    </div>

                    <div class="col-12">
                        <button type="submit" class="btn btn-primary col-12"><i class="bi bi-save"></i>${botao}</button>
                    </div>
                    <hr>
                </form>
            </div>
        </div>
    </div>

</meu:template>