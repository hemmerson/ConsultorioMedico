<%--
    Document   : template
    Created on : 04/06/2023, 16:57:02
    Author     : Hemmerson Luis Barros da Rosa
--%>

<%@tag description="recebe um paciente com atributo e mostra na tela" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@attribute name="p" type="com.example.consultoriomedico.Modelo.Paciente" %>
<%@attribute name="completo"%>

<c:set var="editarUsuario" value="formPaciente.jsp?acao=editarpaciente" />
<c:set var="idUsuario" value="${p.codigo}" />
<c:set var="codigoPaciente" value="${p.codigoPaciente}" />
<c:set var="login" value="${p.login}" />
<c:set var="senha" value="${p.senha}" />
<c:set var="nome" value="${p.nome}" />
<c:set var="cpf" value="${p.cpf}" />
<c:set var="sexo" value="${p.sexo}" />
<c:set var="dataNascimento" value="${p.dataNascimento}" />
<c:set var="nomeMae" value="${p.nomeMae}" />
<c:set var="naturalCidade" value="${p.naturalidadeCidade}" />
<c:set var="naturalEstado" value="${p.naturalidadeEstado}" />
<c:set var="endereco" value="${p.endereco}" />
<c:set var="link" value="${editarUsuario}&codigoPaciente=${codigoPaciente}&idUsuario=${idUsuario}&login=${login}&senha=${senha}&nome=${nome}&cpf=${cpf}&sexo=${sexo}&nomeMae=${nomeMae}&dataNascimento=${dataNascimento}&naturalCidade=${naturalCidade}&naturalEstado=${naturalEstado}&endereco=${endereco}" />

<tr>
    <td>${nome}</td>
    <td>${cpf}</td>
    <td>${login}</td>
    <td><fmt:parseDate value="${dataNascimento}" pattern="yyyy-MM-dd'T'HH:mm" type="both" var="dataehora"/>
        <fmt:formatDate value="${dataehora}" type="date" pattern="dd/MM/yyyy"/></td>
    <td style="text-align: center;"><a href="${link}" class="btn btn-outline-primary btn-sm"><i class="bi bi-pencil-square"></i></a></td>
    <td style="text-align: center;"><a href="prontuario?codigoPaciente=${codigoPaciente}" class="btn btn-outline-success btn-sm"><i class="bi bi-clipboard2-pulse-fill"></i></a></td>
</tr>
