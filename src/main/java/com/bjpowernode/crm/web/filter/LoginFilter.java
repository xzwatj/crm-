package com.bjpowernode.crm.web.filter;

import com.bjpowernode.crm.settings.doMain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse)resp;
        User user=(User) request.getSession().getAttribute("userKey");
        String servletPath = request.getServletPath();
        if("/login.jsp".equals(servletPath)||"/settings/user/login.do".equals(servletPath)){
            chain.doFilter(req, resp);
        }else {
            if(user!=null){
                chain.doFilter(req, resp);
            }else{
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
        }

    }



}
