package com.woniuxy.service;

import com.woniuxy.model.FileModel;

import java.util.List;

/**
 * Description:
 *
 * @Author: Zh_o.
 * @Date: 2020/8/8 10:50
 */
public interface PageService {

    public int getTotalPage();

    public List<FileModel> getByPage(int startPage);
}
