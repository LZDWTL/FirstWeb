<%--
  Created by IntelliJ IDEA.
  User: 10237
  Date: 2021/6/13
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addUser</title>
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
            <form action="addUser" method="get">
                <tr>
                    <td><input type="text" name="id" style="width: 100px"></td>
                    <td><input type="text" name="username" style="width: 200px"></td>
                    <td><input type="text" name="password" style="width: 200px"></td>
                    <td><input type="submit" value="添加"></td>
                </tr>
            </form>
        </tbody>
    </table>
</body>
</html>
