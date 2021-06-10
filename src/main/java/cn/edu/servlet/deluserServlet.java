package cn.edu.servlet;

import cn.edu.dao.IUserDao;
import cn.edu.dao.impl.UserDaoimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LZDWTL
 * @date 2021-06-07 23:17
 */
//@WebServlet(name = "deluserServlet",urlPatterns = {"/user/deleteUser"})
public class deluserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = (int) request.getAttribute("id");
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        IUserDao iUserDao=new UserDaoimpl();
        iUserDao.deleteUser(id);
        request.getRequestDispatcher("/user/viewUser").forward(request,response);
    }
}
