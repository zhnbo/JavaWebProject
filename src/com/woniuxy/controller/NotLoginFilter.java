package com.woniuxy.controller;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * Description: 拦截未登录用户
 * @Author: Zh_o.
 * @Date: 2020/8/7 14:49
 *
 */
public class NotLoginFilter implements Filter, Serializable {

    private static final long serialVersionUID = 6328483037800451264L;

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 获取Cookie
        Cookie[] cookies = request.getCookies();
        // 遍历Cookies
        boolean flag = false;
        for (Cookie cookie : cookies) {
            if ("JSESSIONID".equals(cookie.getName())) {
                flag = true;
            }
        }
        // 判断是否已登录，有cookie说明已登录
        if (flag) {
            chain.doFilter(request,response);
        } else {
            // 跳转到登录页面
            request.getRequestDispatcher("index.html").forward(request,response);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
