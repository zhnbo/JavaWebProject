package com.woniuxy.controller;

import com.woniuxy.service.impl.FileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: Zh_o.
 */
@MultipartConfig
@WebServlet("/uploadServlet")
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = -4557966223089166786L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 保存路径
        String savePath = "D://Files";

        // 获取文件
        Part part = request.getPart("fileName");

        // 获取原文件名
        String header = part.getHeader("Content-Disposition");
        System.out.println(header);
        int start = header.lastIndexOf("=");
        String fileName = header.substring(start + 1)
                .replace("\"", "");

        // 保存文件
        if (fileName != null && !"".equals(fileName)) {
            String path = savePath + "/" + fileName;
            new FileServiceImpl().addFile("<a href='downloadFile?filename=" + path + "'>下载</a>");
            part.write(path);
        }

        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<title>Upload</title></head>");
        out.println("<body>");
        out.println("<h2>Success！</h2>");
        out.println("</body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
