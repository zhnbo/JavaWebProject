package com.woniuxy.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * Description: 设置编码的过滤器
 * ClassName: SetEncodingFilter
 * @Author: Zh_o.
 * @Date: 2020/8/7 9:21
 */

public class SetEncodingFilter implements Filter, Serializable {

    private static final long serialVersionUID = 5043967902867383897L;

    /**
     * 定义变量记录编码集
     */
    private String encoding = null;

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 设置编码方式
        request.setCharacterEncoding(encoding);
        response.setContentType("text/html");
        response.setCharacterEncoding(encoding);
        // 放行
        chain.doFilter(request,response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        // 读取编码集
        this.encoding = config.getInitParameter("encoding");
    }

}
