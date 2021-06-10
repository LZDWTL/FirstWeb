<%@ page import="cn.edu.bean.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 10237
  Date: 2021/6/7
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>viewUser</title>
    <style>
        table,tr,th,td{
            border:1px solid black;
            border-collapse: collapse;
        }
    </style>

</head>
<body>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>姓名</th>
                <th>密码</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<User> userList= (List<User>) request.getAttribute("userList");
//                对集合进行循环，每一个循环都时一个tr
                for(int i=0;i<userList.size();i++){
            %>
            <tr>
                <td><%=userList.get(i).getId() %></td>
                <td><%=userList.get(i).getUsername() %></td>
                <td><%=userList.get(i).getPassword() %></td>
                <td>
                    <a href="alterUser?id=<%=userList.get(i).getId()%>">修改</a>
                    <a href="deleteUser?id=<%=userList.get(i).getId()%>">删除</a>
<%--                    为什么写/user/deleteUser 会出错？--%>
                </td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>