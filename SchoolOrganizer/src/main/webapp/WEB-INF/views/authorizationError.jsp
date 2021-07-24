<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Not authorized</title>
    <link rel="stylesheet" href="<c:url value="/resources/statics/form.css" />" type="text/css">
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>
<br><br>
<h1 class="form_title">Невозможно выполнить вход. Такой пользователь не зарегистрирован!</h1>

</body>
</html>
