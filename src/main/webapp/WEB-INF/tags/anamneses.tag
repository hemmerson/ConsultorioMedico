<%--
    Document   : template
    Created on : 04/06/2023, 16:57:02
    Author     : Hemmerson Luis Barros da Rosa
--%>

<%@tag description="Mostra uma lista de pacientes" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="meu" tagdir="/WEB-INF/tags" %>
<%@attribute name="anamneses" type="java.util.List<com.example.consultoriomedico.Modelo.Anamnese>" %>

<c:forEach items="${anamneses}" var="anamnese">
    <meu:anamnese a="${anamnese}" />
</c:forEach>