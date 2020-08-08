package com.woniuxy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.model.FileModel;
import com.woniuxy.service.impl.PageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * Description: 分页查询
 * @Author: Zh_o.
 * @Date: 2020/8/8 10:53
 */
@WebServlet("/page")
public class PageServlet extends HttpServlet implements Serializable {

    private static final long serialVersionUID = 8494792020927327511L;

    private PageServiceImpl psi = new PageServiceImpl();

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取当前页数
        String _currentPage = request.getParameter("id");
        // 转换为int
        int currentPage = Integer.parseInt(_currentPage);
        // 起始页数 =（当前页数 - 1 * 5）
        int startPage = (currentPage - 1) * 5;
        // 获取数据
        List<FileModel> page = psi.getByPage(startPage);
        // 将要显示的数据存入Context域
        getServletContext().setAttribute("pageData",page);
        // 重定向到下载文件页面
        response.sendRedirect("download.html?id=" + _currentPage);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
