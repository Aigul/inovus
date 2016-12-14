<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: innopolis
  Date: 28.10.16
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Форма входа</title>
  </head>
  <body>
    <h3>Вход</h3>
    <%
      if ("true".equals(request.getParameter("error"))) {
        out.println("<p style=\"color:red;\">\n" +
                "      Имя пользователя и пароль не подходит\n" +
                "    </p>\n" +
                "    ");
      }
      if ("true".equals(request.getParameter("exit"))) {
        out.println("<p style=\"color:green;\">\n" +
                "      Вы вышли из приложения\n" +
                "    </p>\n" +
                "    ");
      }
    %>
    <form action="/j_spring_security_check" method="post">
      Имя пользователя: <input type="text" name="j_username"><br>
      Пароль: <input type="password" name="j_password"><br>
      <button type="submit">Войти</button><br>
    </form>
    <br>
    <a href="/sign-up">Регистрация</a>
  </body>
</html>
