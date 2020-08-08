package com.woniuxy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.model.FileModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * Description: 当前页面显示数据
 * @Author: Zh_o.
 * @Date: 2020/8/7 16:34
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet implements Serializable {

    private static final long serialVersionUID = -1526561342111169560L;

    /**
     * Jackson核心对象
     */
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从Context域里面取出需要显示的数据
        Object pageData = getServletContext().getAttribute("pageData");
        // 转换为List
        List<FileModel> list = (List<FileModel>) pageData;
        // 转换为Json
        String s = mapper.writeValueAsString(list);
        // 将Context里面的数据清空
        getServletContext().removeAttribute("pageData");
        // 返回数据
        response.getWriter().print(s);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
