<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Log in</title>
    <link rel="stylesheet" href="<c:url value="/resources/statics/form.css" />" type="text/css">
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>
<br><br>
<h1 class="form_title">Добро пожаловать!</h1>
<br><br>
<form class="form" action="register" method="post">
    <h4>Войдите в свой аккаунт или зарегистрируйтесть как новый пользователь</h4>
    <br><br>
    <div class="buttons">
        <a href="${pageContext.request.contextPath}/login" class="button">Вход</a>
        <a href="${pageContext.request.contextPath}/register" class="button">Регистрация</a>
    </div>
</form>

</body>
</html>
