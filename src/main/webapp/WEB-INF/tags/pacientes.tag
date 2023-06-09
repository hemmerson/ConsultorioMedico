<%--
    Document   : template
    Created on : 04/06/2023, 16:57:02
    Author     : Hemmerson Luis Barros da Rosa
--%>

<%@tag import="java.util.List" %>
<%@tag import="com.example.consultoriomedico.Modelo.Paciente" %>
<%@tag description="Mostra uma lista de pacientes" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="meu" tagdir="/WEB-INF/tags" %>
<%@attribute name="pacientes" type="List<Paciente>" %>

<c:forEach items="${pacientes}" var="paciente">
    <meu:paciente p="${paciente}" />
</c:forEach>