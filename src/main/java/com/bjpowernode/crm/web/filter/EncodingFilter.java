package com.bjpowernode.crm.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter")
public class EncodingFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("进入字符过滤器");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("test/html;charset=utf-8");
        chain.doFilter(req, resp);
    }



}
