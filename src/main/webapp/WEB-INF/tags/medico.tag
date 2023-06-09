<%--
    Document   : template
    Created on : 04/06/2023, 16:57:02
    Author     : Hemmerson Luis Barros da Rosa
--%>

<%@tag description="recebe um medico com atributo e mostra na tela" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@attribute name="m" type="com.example.consultoriomedico.Modelo.Medico" %>
<%@attribute name="completo"%>

<c:set var="editarUsuario" value="formMedico.jsp?acao=editar" />
<c:set var="idUsuario" value="${m.codigo}" />
<c:set var="codigoMedico" value="${m.codigoMedico}" />
<c:set var="login" value="${m.login}" />
<c:set var="senha" value="${m.senha}" />
<c:set var="nome" value="${m.nome}" />
<c:set var="cpf" value="${m.cpf}" />
<c:set var="especializacao" value="${m.especializacao}" />
<c:set var="link" value="${editarUsuario}&codigoMedico=${codigoMedico}&idUsuario=${idUsuario}&login=${login}&senha=${senha}&nome=${nome}&cpf=${cpf}&especializacao=${especializacao}" />

<tr>
    <td>${nome}</td>
    <td>${cpf}</td>
    <td>${login}</td>
    <td>${especializacao}</td>
    <td style="text-align: center;"><a href="${link}" class="btn btn-outline-primary btn-sm"><i class="bi bi-pencil-square"></i></a></td>
</tr>
