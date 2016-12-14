<%--
  Created by IntelliJ IDEA.
  User: innopolis
  Date: 30.10.16
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Приветствие</title>
</head>
<body>
    <script language="JavaScript">
        var time = new Date();
        var hour = time.getHours();
        if(hour == 22 || hour == 23) document.write('<H2>'+"Доброй ночи, ${name}!"+'</H2>');
        if(hour >= 0 && hour <= 5) document.write('<H3>'+"Доброй ночи, ${name}!"+'</H3>');
        if(hour >= 6 && hour <= 9) document.write('<H3>'+"Доброе утро, ${name}!"+'</H3>');
        if(hour >= 10 && hour <= 17) document.write('<H3>'+"Добрый день, ${name}!"+'</H3>');
        if(hour >= 18 && hour <= 21) document.write('<H3>'+"Добрый вечер, ${name}!"+'</H3>');
    </script>

    <form action="/logout">
        <button type="submit">Выйти</button>
    </form>
</body>
</html>
