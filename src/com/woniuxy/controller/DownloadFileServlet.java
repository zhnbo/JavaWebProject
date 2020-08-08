package com.woniuxy.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;

/**
 * Description: 下载文件
 * @Author: Zh_o.
 * @Date: 2020/8/8 9:16
 */
@WebServlet("/downloadFile")
public class DownloadFileServlet extends HttpServlet implements Serializable {

    private static final long serialVersionUID = 3835586095426977740L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数
        String filename = request.getParameter("filename");
        // 获取IO流对象
        FileInputStream in = new FileInputStream(filename);
        ServletOutputStream out = response.getOutputStream();
        // 获取文件的Mime类型
        String mimeType = getServletContext().getMimeType(filename);
        // 设置响应的类型
        response.setHeader("context-type",mimeType);
        response.setHeader("content-disposition","attachment;filename=" + filename);
        byte[] b = new byte[1024];
        // 读取文件
        int len = -1;
        while ((len = in.read(b)) != -1) {
            out.write(b,0,len);
        }
        // 释放资源
        out.flush();
        out.close();
        in.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
