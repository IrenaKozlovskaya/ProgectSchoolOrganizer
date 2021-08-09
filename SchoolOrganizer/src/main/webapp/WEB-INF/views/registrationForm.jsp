<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <meta charset="UTF-8">
    <title>Registration</title>
    <link rel="stylesheet" href="<c:url value="/resources/statics/form.css" />" type="text/css">
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>
<br><br>


<spring:form class="form" method="post"  action="register" onsubmit="return checkForm()">

    <h1 class="form_title">Регистрация</h1>

    <table style="with: 50%">
        <tr>
            <td>E-mail</td>
            <td><input id="email" type="text" name="email" /></td>
        </tr>
        <tr>
            <td>Пароль</td>
            <td><input id="password" type="password" name="password" /></td>
        </tr>
        <tr>
            <td>Повторите пароль</td>
            <td><input id="repassword" type="password" name="repassword"/></td>
        </tr>
    </table>
    <br>
    <button id="button" type="button" onclick="passwordChek()">Проверить пароль</button>
    <br><br>
    <div id="messagePass"></div>
    <br>
    <input class="form_button" type="submit" value="Зарегистрироваться"/>
</spring:form>

</body>

<script type="text/javascript">

    const reg = /^.+@.+\..+$/;
    const minimum8Chars = /^.{8,}$/
    const withoutSpaces = /^\S*$/
    const email = document.getElementById('email');
    const pass = document.getElementById('password');
    const repass = document.getElementById('repassword');
    let messagePass = document.getElementById('messagePass')
    let password
    let userEmail

    function checkForm() {

        password = pass.value
        userEmail = email.value

        if (!reg.test(userEmail)) {
            alert('Введите корректный e-mail');
            return false;
        }
        if (!minimum8Chars.test(password) ||
            !withoutSpaces.test(password)) {
            alert('Неподходящий пароль!');
            return false;
        }
        if (password !== repass.value) {
            alert('Пароли не совпадают!');
            return false;
        }
        return true;
    }

    function passwordChek() {

        password = pass.value
        messagePass.innerHTML = "Пароль  " + password

        if (!minimum8Chars.test(password)) {
            messagePass.innerHTML += "  содержит меньше 8 символов!"
        } else if (!withoutSpaces.test(password)) {
            messagePass.innerHTML += "  содержит пробелы!"
        } else {
            messagePass.innerHTML += "  разрешен!"
        }

    }
</script>
</html>

