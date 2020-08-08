package com.woniuxy.controller;

import com.woniuxy.service.impl.PageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * Description: 查询总页数
 * @Author: Zh_o.
 * @Date: 2020/8/8 12:12
 */
@WebServlet("/totalPage")
public class TotalPageServlet extends HttpServlet implements Serializable {

    private static final long serialVersionUID = 828853157237299249L;

    /**
     * Service对象
     */
    PageServiceImpl psi = new PageServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取总数据行数
        int totalPage = psi.getTotalPage();

        /* 总页数 (总数据行数余每页要显示的数据条数，若有余数，总页数 = 总数据条数 / 每页显示数据条数；
        若没有余数，总页数 = 总数据条数 / 每页显示数据条数 + 1) */
        int total = (totalPage % 5 == 0) ? (totalPage / 5) : (totalPage / 5) + 1;
        // 返回总页数
        response.getWriter().print(total);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
