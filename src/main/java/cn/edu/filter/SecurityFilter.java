package cn.edu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author LZDWTL
 * @date 2021-06-16 17:22
 */
public class SecurityFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        预处理
        System.out.println("登陆过滤");
        HttpServletRequest request=(HttpServletRequest)req;
        HttpSession session=request.getSession();
        String username= (String) session.getAttribute("username");
        if (username!=null || "".equals(username)){   //为什么是""
            System.out.println(username);
            chain.doFilter(req, resp);    //目标资源，例如deleteUser
        }else{
            HttpServletResponse response= (HttpServletResponse) resp;
            response.sendRedirect("loginUser.html");
        }
//        后处理
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
