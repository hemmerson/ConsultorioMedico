<%--
  Created by IntelliJ IDEA.
  User: "Hemmerson Luis Barros da Rosa" 
  Date: 04/06/2023
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="meu" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meu:login mensagem="${param.mensagem}" >

    <c:if test="${!empty sessionScope.usuario}" >
        <c:redirect url="index.jsp" />
    </c:if>

<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-lg-4 col-md-8 col-sm-8">
            <div class="card shadow">
                <div class="card-title text-center border-bottom">
                    <h2 class="p-3">Login</h2>
                </div>
                <div class="card-body">
                    <form action="login" method="post">
                        <div class="mb-4 form-floating">
                            <input type="text" class="form-control" id="floatingInput" placeholder="Login" name="login">
                            <label for="floatingInput">Login</label>
                        </div>
                        <div class="mb-4 form-floating">
                            <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="senha">
                            <label for="floatingPassword">Password</label>
                        </div>
                        <div class="mb-4 d-grid">
                            <button type="submit" class="btn btn-primary">Login</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</meu:login>