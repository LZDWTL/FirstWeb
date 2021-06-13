package cn.edu.servlet;

import cn.edu.bean.User;
import cn.edu.dao.IUserDao;
import cn.edu.dao.impl.UserDaoimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * @author LZDWTL
 * @date 2021-06-07 19:55
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/user/viewUser","/user/deleteUser","/user/updateUser1","/user/updateUser2","/user/addUser1","/user/addUser2"})
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        去数据库获取数据，根据SRP原则（单一职责原则），Swevlet只负责处理请求和响应
//        Servlet如果像拿到数据，需要将数据放入某个作用域中。
//        因此，Servlet必须和DAO曾耦合（Sevlet对DAO有依赖）

        IUserDao iUserDao=new UserDaoimpl();
        String uri=request.getRequestURI();
        if (uri.endsWith("viewUser")){          //也可以使用contains使用一下
            System.out.println("查询用户...");
            List<User> userList=iUserDao.viewUser();
            request.setAttribute("userList",userList);
            request.getRequestDispatcher("/user/viewUser.jsp").forward(request,response);  // “/”表示应用程序的根目录

        }else if(uri.endsWith("deleteUser")){
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println("删除用户："+id);
            iUserDao.deleteUser(id);
            request.getRequestDispatcher("/user/viewUser").forward(request,response);   //使用请求转发地址栏没有该成viewUser，还是原来的deleteUser
//            response.sendRedirect("/user/viewUser");   //重定向,删除使用有问题，删除后跳转viewUser失败

        }else if (uri.endsWith("updateUser1")){
            System.out.println("更改用户1");
            int id = Integer.parseInt(request.getParameter("id"));
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            request.setAttribute("id",id);
            request.setAttribute("password",password);
            request.setAttribute("username",username);
            request.getRequestDispatcher("/user/updateUser.jsp").forward(request,response);

        }else if(uri.endsWith("updateUser2")){
            System.out.println("更改用户2");
            int id=Integer.parseInt(request.getParameter("id"));
//            问什么同样是使用request.getParameter，不能直接获取input中的id值，需要通过地址传递
            System.out.println(id);
            String username=request.getParameter("name");
            String password=request.getParameter("pswd");
            System.out.println(username);
            System.out.println(password);
            iUserDao.updateUser(id,username,password);
            request.getRequestDispatcher("/user/viewUser").forward(request,response);   //请求转发
//            response.sendRedirect("/user/viewUser");   //重定向

        }else if(uri.endsWith("addUser1")){
            System.out.println("添加用户...");
            response.sendRedirect("/user/addUser.jsp");

        }else if(uri.endsWith("addUser2")){
            int id=Integer.parseInt(request.getParameter("id"));
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            iUserDao.addUser(id,username,password);
            response.sendRedirect("/user/viewUser");
        }

    }
}
