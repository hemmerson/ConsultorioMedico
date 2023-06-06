<%@tag description="minha tag para login" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="mensagem"%>
<jsp:doBody var="corpo" />

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        #mensagem {
            position: absolute;
            text-align: center;
            top:10px;
            width:80vw;
            left:10vw;
            font-size:1.2em;
            padding:1em;
            opacity: 0;
            border:solid 1px rgb(0,40,0);
            background-color: #ccc;
            box-shadow: 5px 5px 5px black;
            animation:sumir 3s linear;
            z-index: 1;
        }
        @keyframes sumir{
            0%{
                opacity:0.9;
            }
            90%
            {
                opacity:0.9;
            }
            100%{
                opacity:0;
            }
        }
    </style>
    <title>Login - Consultorio Médico</title>
</head>
<body>
<div>
    ${corpo}
</div>

    <c:if test="${mensagem!=''}">
        <div id="mensagem">
            <c:if test="${mensagem=='erroaomostrar'}">
                Erro ao tentar mostra os dados.
            </c:if>
            <c:if test="${mensagem=='errologinesenha'}">
                Informe o login e a senha.
            </c:if>
            <c:if test="${mensagem=='errousuarioesenhaincorreto'}">
                Usuario ou senha incorretos.
            </c:if>
            <c:if test="${mensagem=='errobuscarloginesenha'}">
                Erro no sistema ao tentar logar.
            </c:if>
            <c:if test="${mensagem=='sucessoaocadastrarpost'}">
                Cadastrado com sucesso.
            </c:if>
            <c:if test="${mensagem=='erroaocadastrarpost'}">
                Erro ao tentar cadastrar.
            </c:if>

            <c:if test="${mensagem=='erroaotentarcadastrarusuario'}">
                Erro ao tentar cadastrar usuário.
            </c:if>
            <c:if test="${mensagem=='sucessocadastrarusuario'}">
                Usuário cadastrado com sucesso.
            </c:if>
            <c:if test="${mensagem=='errodadoslogininvalido'}">
                Erro: dados incorretos.
            </c:if>

            <c:if test="${mensagem=='sucessocadastrocomentario'}">
                Sucesso ao cadastrar o comentário.
            </c:if>
            <c:if test="${mensagem=='errocadastrocomentario'}">
                Erro ao cadastrar o comentário.
            </c:if>
        </div>
    </c:if>

</body>
</html>