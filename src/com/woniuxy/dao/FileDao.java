package com.woniuxy.dao;

import com.woniuxy.model.FileModel;

import java.util.List;

/**
 * Description: 文件操作
 * @Author: Zh_o.
 * @Date: 2020/8/7 16:40
 */
public interface FileDao {

    public int addFilePath(String filePath);

    public List<FileModel> queryFilePathAll();
}
