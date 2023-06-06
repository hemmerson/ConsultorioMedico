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
            <h2 class="p-3"><i class="bi bi-file-earmark-medical"></i>Cadastrar Paciente</h2>
        </div>
        <div class="col-lg-8 col-md-8 col-sm-8">
            <form class="row g-3" method="post" action="cadastrarPaciente">
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
                <div class="col-md-6">
                    <label for="sexo" class="form-label">Sexo</label>
                    <select name="sexo" id="sexo" class="form-control">
                        <option>Selecione</option>
                        <option value="masculino">Masculino</option>
                        <option value="feminino">Feminino</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <label for="dataNascimento" class="form-label">Data de Nascimento</label>
                    <input type="date" id="dataNascimento" name="dataNascimento" class="form-control">
                </div>
                <div class="col-md-6">
                    <label for="nomeMae" class="form-label">Nome da Mãe</label>
                    <input type="text" class="form-control" id="nomeMae" name="nomeMae">
                </div>
                <div class="col-md-6">

                </div>
                <div class="col-md-6">
                    <label for="naturalCidade" class="form-label">Cidade de Nascimento</label>
                    <input type="text" class="form-control" id="naturalCidade" name="naturalCidade">
                </div>
                <div class="col-md-6">
                    <label for="naturalEstado" class="form-label">Estado de Nascimento</label>
                    <select id="naturalEstado" name="naturalEstado" class="form-select">
                        <option selected>Selecione</option>
                        <option value="AC">Acre</option>
                        <option value="AL">Alagoas</option>
                        <option value="AP">Amapá</option>
                        <option value="AM">Amazonas</option>
                        <option value="BA">Bahia</option>
                        <option value="CE">Ceará</option>
                        <option value="DF">Distrito Federal</option>
                        <option value="ES">Espírito Santo</option>
                        <option value="GO">Goiás</option>
                        <option value="MA">Maranhão</option>
                        <option value="MT">Mato Grosso</option>
                        <option value="MS">Mato Grosso do Sul</option>
                        <option value="MG">Minas Gerais</option>
                        <option value="PA">Pará</option>
                        <option value="PB">Paraíba</option>
                        <option value="PR">Paraná</option>
                        <option value="PE">Pernambuco</option>
                        <option value="PI">Piauí</option>
                        <option value="RJ">Rio de Janeiro</option>
                        <option value="RN">Rio Grande do Norte</option>
                        <option value="RS">Rio Grande do Sul</option>
                        <option value="RO">Rondônia</option>
                        <option value="RR">Roraima</option>
                        <option value="SC">Santa Catarina</option>
                        <option value="SP">São Paulo</option>
                        <option value="SE">Sergipe</option>
                        <option value="TO">Tocantins</option>
                        <option value="EX">Estrangeiro</option>
                    </select>
                </div>
                <div class="col-12">
                    <label for="endereco" class="form-label">Endereço Completo</label>
                    <input type="text" class="form-control" id="endereco" name="endereco"
                           placeholder="Q. 310 Sul, Plano Diretor Sul, Palmas - TO">
                </div>

                <div class="col-12">
                    <button type="submit" class="btn btn-primary col-12"><i class="bi bi-save"></i>
                        Cadastrar</button>
                </div>
                <hr>
            </form>
        </div>
    </div>
</div>

</meu:template>
