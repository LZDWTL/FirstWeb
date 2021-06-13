<%--
  Created by IntelliJ IDEA.
  User: 10237
  Date: 2021/6/11
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>alterUser</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>用户名</th>
                <th>密码</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <form action="updateUser" method="get">
                <tr>
                    <td>
                        <input type="text" name="id" style="width: 100px" value="<%=request.getParameter("id")%>" readonly>
                    </td>
                    <td>
                        <input type="text" name="username" style="width: 200px" placeholder="<%=request.getParameter("username")%>">
                    </td>
                    <td>
                        <input type="text" name="password" style="width: 200px" placeholder="<%=request.getParameter("password")%>">
                    </td>
                    <td>
<%--                        <a href="updateUser2?id=<%=request.getAttribute("id")%>">确认修改</a>--%>
                        <input type="submit" value="确认修改">
                    </td>
                </tr>
            </form>
        </tbody>
    </table>
</body>
</html>
