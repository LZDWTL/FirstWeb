<%--
  Created by IntelliJ IDEA.
  User: 10237
  Date: 2021/6/6
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP网页测试</title>
</head>
<body>
    Welcome!欢迎你
    <%=request.getAttribute("username")%>
</body>
</html>
