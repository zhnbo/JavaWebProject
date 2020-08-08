package com.woniuxy.service;

import com.woniuxy.model.FileModel;

import java.util.List;

/**
 * Description:
 *
 * @Author: Zh_o.
 * @Date: 2020/8/7 17:04
 */
public interface FileService {

    public int addFile(String filePath);

    public List<FileModel> queryFilePathAll();

}
