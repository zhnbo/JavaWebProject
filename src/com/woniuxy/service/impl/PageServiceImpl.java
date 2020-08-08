package com.woniuxy.service.impl;

import com.woniuxy.dao.impl.PageDaoImpl;
import com.woniuxy.model.FileModel;
import com.woniuxy.service.PageService;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 *
 * @Author: Zh_o.
 * @Date: 2020/8/8 10:51
 */
public class PageServiceImpl implements PageService, Serializable {

    private static final long serialVersionUID = 6504125607943619643L;

    private PageDaoImpl pdi = new PageDaoImpl();

    @Override
    public int getTotalPage() {
        // 返回总页数
        return pdi.queryTotalPage();
    }

    @Override
    public List<FileModel> getByPage(int startPage) {
        return pdi.queryPage(startPage);
    }
}
