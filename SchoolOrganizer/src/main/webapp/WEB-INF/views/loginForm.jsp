<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<form class="form" action="login" method="post">

    <h1 class="form_title">Вход</h1>
    <table style="with: 50%">
        <tr>
            <td>Логин</td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td>Пароль</td>
            <td><input type="password" name="password"/></td>
        </tr>
    </table>
    <br><br>
    <input class="form_button" type="submit" value="Войти"/>
</form>

</body>
</html>


