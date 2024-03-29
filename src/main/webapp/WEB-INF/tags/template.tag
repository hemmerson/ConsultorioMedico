<%--
    Document   : template
    Created on : 04/06/2023, 16:57:02
    Author     : Hemmerson Luis Barros da Rosa
--%>

<%@tag description="Esqueleto das páginas" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="mensagem" %>
<jsp:doBody var="conteudo"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <style>
        .container-wrapper {
            position: relative;
            min-height: 100vh;
            margin: 0;
            overflow: auto;
        }

        .readonly {
            background: #EEE;
            pointer-events: none;
            touch-action: none;
        }

        #mensagem {
            position: absolute;
            text-align: center;
            top: 10px;
            width: 80vw;
            left: 10vw;
            font-size: 1.2em;
            padding: .5em;
            opacity: 0;
            border: solid 1px rgb(0, 40, 0);
            background-color: #ccc;
            box-shadow: 5px 5px 5px black;
            animation: sumir 3s linear;
            z-index: 1;
        }

        @keyframes sumir {
            0% {
                opacity: 0.9;
            }
            90% {
                opacity: 0.9;
            }
            100% {
                opacity: 0;
            }
        }
    </style>
    <title>${initParam.titulo}</title>
</head>
<body class="d-flex flex-column h-100">
<div class="container-wrapper">
    <c:if test="${empty sessionScope.usuario}">
        <c:redirect url="login.jsp"/>
    </c:if>
    <c:if test="${mensagem!=''}">
        <div id="mensagem">
            <c:if test="${mensagem=='erroaomostrar'}">
                Erro ao tentar mostra os dados.
            </c:if>

            <c:if test="${mensagem=='sucessocadastraranamnese'}">
                Anamnese Cadastrada com sucesso.
            </c:if>
            <c:if test="${mensagem=='erroaotentarcadastraranamnese'}">
                Erro ao tentar cadastrar anamnese.
            </c:if>

            <c:if test="${mensagem=='erroaotentarcadastrarmedico'}">
                Erro ao tentar cadastrar médico.
            </c:if>
            <c:if test="${mensagem=='sucessocadastrarmedico'}">
                Médico cadastrado com sucesso.
            </c:if>
            <c:if test="${mensagem=='erroaotentareditarmedico'}">
                Erro ao tentar editar médico.
            </c:if>
            <c:if test="${mensagem=='sucessoeditarmedico'}">
                Médico editado com sucesso.
            </c:if>

            <c:if test="${mensagem=='erroaotentarcadastrarpaciente'}">
                Erro ao tentar cadastrar paciente.
            </c:if>
            <c:if test="${mensagem=='sucessocadastrarpaciente'}">
                Paciente cadastrado com sucesso.
            </c:if>
            <c:if test="${mensagem=='erroaotentareditarpaciente'}">
                Erro ao tentar editar paciente.
            </c:if>
            <c:if test="${mensagem=='sucessoeditarpaciente'}">
                Paciente editado com sucesso.
            </c:if>

            <c:if test="${mensagem=='acessonegado'}">
                Acesso negado! Você não tem permissão para essa ação!
            </c:if>

        </div>
    </c:if>

    <c:if test="${!empty sessionScope.usuario}">
        <c:set var="usuario" value="${sessionScope.usuario.nome}"/>
    </c:if>


    <header id="cabecalho">
        <div class="container">
            <div class="row justify-content-center mt-4">
                <nav class="navbar navbar-expand-lg navbar-dark bg-primary text-white rounded p-3">
                    <div class="container">
                        <a class="navbar-brand col-3" href="index.jsp">Consultório Médico</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                                data-bs-target="#navbarNavDropdown"
                                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNavDropdown">
                            <ul class="navbar-nav ms-auto">
                                <li class="nav-item">
                                    <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                                </li>
                                <li class="nav-item dropdown">
                                    <c:if test="${sessionScope.usuario.is_medico}">
                                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink"
                                           role="button"
                                           data-bs-toggle="dropdown" aria-expanded="false">
                                            Médicos
                                        </a>
                                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                            <li><a class="dropdown-item" href="formMedico.jsp?acao=cadastrar">Cadastrar
                                                Médico</a></li>
                                            <li><a class="dropdown-item" href="listarmedicos">Listar Médicos</a></li>
                                        </ul>
                                    </c:if>
                                </li>
                                <li class="nav-item dropdown">
                                    <c:if test="${sessionScope.usuario.is_medico}">
                                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink1"
                                           role="button"
                                           data-bs-toggle="dropdown" aria-expanded="false">
                                            Paciente
                                        </a>
                                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink1">
                                            <li><a class="dropdown-item" href="formPaciente.jsp?acao=cadastrar">Cadastrar
                                                Paciente</a></li>
                                            <li><a class="dropdown-item" href="listarpacientes">Listar Pacientes</a>
                                            </li>
                                        </ul>
                                    </c:if>
                                </li>

                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink2"
                                       role="button"
                                       data-bs-toggle="dropdown" aria-expanded="false">
                                        ${usuario} <i class="bi bi-person-circle"></i>
                                    </a>
                                    <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink2">

                                        <c:if test="${sessionScope.usuario.is_medico}">
                                            <c:set var="editarUsuario" value="formMedico.jsp?acao=editar"/>
                                            <c:set var="idUsuario" value="${sessionScope.usuario.codigo}"/>
                                            <c:set var="codigoMedico" value="${sessionScope.usuario.codigoMedico}"/>
                                            <c:set var="login" value="${sessionScope.usuario.login}"/>
                                            <c:set var="senha" value="${sessionScope.usuario.senha}"/>
                                            <c:set var="nome" value="${sessionScope.usuario.nome}"/>
                                            <c:set var="cpf" value="${sessionScope.usuario.cpf}"/>
                                            <c:set var="especializacao" value="${sessionScope.usuario.especializacao}"/>
                                            <c:set var="link"
                                                   value="${editarUsuario}&codigoMedico=${codigoMedico}&idUsuario=${idUsuario}&login=${login}&senha=${senha}&nome=${nome}&cpf=${cpf}&especializacao=${especializacao}"/>
                                        </c:if>

                                        <c:if test="${!sessionScope.usuario.is_medico}">
                                            <c:set var="editarUsuario" value="formPaciente.jsp?acao=editarporpaciente"/>
                                            <c:set var="idUsuario" value="${sessionScope.usuario.codigo}"/>
                                            <c:set var="codigoPaciente" value="${sessionScope.usuario.codigoPaciente}"/>
                                            <c:set var="login" value="${sessionScope.usuario.login}"/>
                                            <c:set var="senha" value="${sessionScope.usuario.senha}"/>
                                            <c:set var="nome" value="${sessionScope.usuario.nome}"/>
                                            <c:set var="cpf" value="${sessionScope.usuario.cpf}"/>
                                            <c:set var="sexo" value="${sessionScope.usuario.sexo}"/>
                                            <c:set var="dataNascimento" value="${sessionScope.usuario.dataNascimento}"/>
                                            <c:set var="nomeMae" value="${sessionScope.usuario.nomeMae}"/>
                                            <c:set var="naturalCidade"
                                                   value="${sessionScope.usuario.naturalidadeCidade}"/>
                                            <c:set var="naturalEstado"
                                                   value="${sessionScope.usuario.naturalidadeEstado}"/>
                                            <c:set var="endereco" value="${sessionScope.usuario.endereco}"/>
                                            <c:set var="link"
                                                   value="${editarUsuario}&codigoPaciente=${codigoPaciente}&idUsuario=${idUsuario}&login=${login}&senha=${senha}&nome=${nome}&cpf=${cpf}&sexo=${sexo}&nomeMae=${nomeMae}&dataNascimento=${dataNascimento}&naturalCidade=${naturalCidade}&naturalEstado=${naturalEstado}&endereco=${endereco}"/>
                                        </c:if>

                                        <li><a class="dropdown-item" href="${link}">Editar Usuário</a></li>
                                        <c:if test="${!sessionScope.usuario.is_medico}">
                                            <li><a class="dropdown-item"
                                                   href="prontuario?codigoPaciente=${sessionScope.usuario.codigoPaciente}">Mostrar
                                                Prontuário</a></li>
                                        </c:if>
                                        <li>
                                            <hr class="dropdown-divider"/>
                                        </li>
                                        <li><a class="dropdown-item" href="sair">Sair</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </header>
    <section id="conteudo">
        ${conteudo}
    </section>


    <div class="container ">
        <footer class="bg-primary text-center text-white rounded footer mt-5">
            <div class="row justify-content-center mt-5">

                <!-- Copyright -->
                <div class="text-center p-4">
                    © 2023 Copyright:
                    <a class="text-white" href="#">Hemmerson Luis Barros da Rosa</a>
                </div>
                <!-- Copyright -->

            </div>
        </footer>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>