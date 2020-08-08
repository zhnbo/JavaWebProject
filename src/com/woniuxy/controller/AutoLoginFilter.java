package com.woniuxy.controller;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Description: 判断是否自动登录
 * ClassName: AutoLoginFilter
 * @Author: Zh_o.
 * @Date: 2020/8/7 9:33
 */
public class AutoLoginFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 获取Session
        HttpSession session = request.getSession();
        // 获取Cookie
        Cookie[] cookies = request.getCookies();
        // 定义一个变量，记录是否存在JSESSIONID
        boolean flag = false;
        // 定义一个变量，记录JSESSIONID
        String id = null;
        // 遍历Cookie，判断是否存在JSESSIONID
        for (Cookie cookie : cookies) {
            // 如果存在,改变 变量的值为true
            if ("JSESSIONID".equals(cookie.getName())) {
                flag = true;
                id = cookie.getValue();
                break;
            }
        }
        // 判断请求cookie中的ID与当前ID是否相同
        if (flag && id.equals(session.getId())) {
            // 跳转到主界面
            request.getRequestDispatcher("mainUI.html").forward(request,response);
        } else {
            // 反之则放行
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
