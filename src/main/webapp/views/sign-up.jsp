<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: innopolis
  Date: 30.10.16
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<style>
    .error {
        color: #ff0000;
        font-weight: bold;
    }
</style>
<head>
    <title>Форма регистрации</title>
</head>
<body>
    <h3>Регистрация</h3>
    <p class="error">${error}</p>
    <form:form action="sign-up" method="post" commandName="reg">
        Имя пользователя:<input type="text" name="name">
        <form:errors path="name" cssClass="error"/><br>
        Пароль: <input type="password" name="password">
        <form:errors path="password" cssClass="error"/><br>
        Повторите пароль: <input type="password" name="repassword">
        <form:errors path="passwordValid" cssClass="error"/> <br>
        <br>
        <button type="submit">Зарегистрироваться</button>
    </form:form>
</body>
</html>
