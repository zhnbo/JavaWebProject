package com.woniuxy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.model.JsonUser;
import com.woniuxy.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 * @Author: Zh_o.
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet implements Serializable {

    private static final long serialVersionUID = 5762575365291023989L;

    /**
     创建Service层对象
     */
    UserServiceImpl usi = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数
        String value = request.getParameter("key");
        // 创建Jackson核心对象
        ObjectMapper mapper = new ObjectMapper();
        // 转换为Java对象
        JsonUser jsonUser = mapper.readValue(value, JsonUser.class);
        String email = jsonUser.getEmail();
        String password = jsonUser.getPassword();
        String remember = jsonUser.getRemember();
        // 获取输出流对象
        PrintWriter out = response.getWriter();
        // 判断是否成功登录
        int flag = usi.loginIsSuccess(email,password);
        if (flag == 0) {
            // 未注册
            out.print(0);
        } else if (flag == -1) {
            // 密码错误
            out.print(-1);
        } else if (flag == 1) {
            // 登陆成功判断是否记住密码
            if (usi.isRemember(remember)) {
                // 获取Session
                HttpSession session = request.getSession();
                // 创建Cookie
                Cookie cookie = new Cookie("JSESSIONID",session.getId());
                cookie.setMaxAge(60 * 60 * 30);
                response.addCookie(cookie);
            }
            // 邮箱与密码都正确
            out.print(1);
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
