<%--
    Document   : template
    Created on : 04/06/2023, 16:57:02
    Author     : Hemmerson Luis Barros da Rosa
--%>

<%@tag description="recebe uma anamnese com atributo e mostra na tela" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@attribute name="a" type="com.example.consultoriomedico.Modelo.Anamnese" %>
<%@attribute name="completo"%>

<c:set var="editarUsuario" value="formPaciente.jsp?acao=editarpaciente" />

<c:set var="nomePaciente" value="${a.paciente.nome}" />
<c:set var="nomeMedico" value="${a.medico.nome}" />
<c:set var="diagnostico" value="${a.diagnostico}" />

<c:set var="dataConsulta" value="${a.dataHora}" />

<fmt:parseDate value="${dataConsulta}" pattern="yyyy-MM-dd'T'HH:mm" type="both" var="dataehora"/>
<fmt:formatDate value="${dataehora}" type="date" pattern="dd/MM/yyyy" var="data"/>
<fmt:formatDate value="${dataehora}" type="time" pattern="HH:mm" var="hora"/>

<tr>
    <td>${nomePaciente}</td>
    <td>${nomeMedico}</td>
    <td>${diagnostico}</td>
    <td>${data}</td>
    <td>${hora}</td>
    <td style="text-align: center;"><a href="mostraAnamnese?codigoAnamnese=${a.codigo}" class="btn btn-outline-primary btn-sm"><i class="bi bi-pencil-square"></i></a></td>
</tr>
