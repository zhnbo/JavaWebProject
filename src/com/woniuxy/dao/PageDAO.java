package com.woniuxy.dao;

import com.woniuxy.model.FileModel;

import java.util.List;

/**
 * Description:
 *
 * @Author: Zh_o.
 * @Date: 2020/8/8 10:15
 */
public interface PageDAO {

    /**
     * 查询总数据行数
     * @return
     */
    public int queryTotalPage();

    public List<FileModel> queryPage(int startPage);
}
