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
@WebServlet(name = "UserServlet", urlPatterns = {"/user/viewUser","/user/deleteUser"})
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
            System.out.println("返回数据...");

            List<User> userList=iUserDao.viewUser();

            request.setAttribute("userList",userList);
            request.getRequestDispatcher("/user/viewUser.jsp").forward(request,response);
        }else if(uri.endsWith("deleteUser")){
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println("删除用户："+id);
            iUserDao.deleteUser(id);
            request.getRequestDispatcher("/user/viewUser").forward(request,response);
        }



    }
}
