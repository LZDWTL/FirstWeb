package cn.edu;

import cn.edu.dao.Jdbc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LZDWTL
 * @date 2021-06-06 10:29
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        Jdbc jdbc=new Jdbc();
        System.out.println(username);
        System.out.println(password);
//        if("张三".equals(username) && "123".equals(password)){
//            System.out.println("登陆成共");
//        }
        if(jdbc.selectUser(username,password)){
            request.setAttribute("username",username);    //把username放入request作用域中，以便JSP可以从request作用域中取数据
            request.getRequestDispatcher("loginSuccess.jsp").forward(request,response);  //跳转到loginSuccess.jsp

/*               早期的servlet就是像下面这样子去写的*/
//            System.out.println("登陆成功");
//            PrintWriter out =response.getWriter();
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<meta charset=\"UTF-8\">");
//            out.println("<title>");
//            out.println("动态产生数据");
//            out.println("</title>");
//            out.println("</head>");
//            out.println("<body>欢迎你"+username+"</body>");
//            out.println("</html>");
//            out.flush();
        }
    }
}
