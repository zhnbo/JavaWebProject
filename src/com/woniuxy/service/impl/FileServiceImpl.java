package com.woniuxy.service.impl;

import com.woniuxy.dao.impl.FileDaoImpl;
import com.woniuxy.model.FileModel;
import com.woniuxy.service.FileService;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 *
 * @Author: Zh_o.
 * @Date: 2020/8/7 17:06
 */
public class FileServiceImpl implements FileService, Serializable {
    private static final long serialVersionUID = 2560514887048198538L;

    private FileDaoImpl fdi = new FileDaoImpl();

    @Override
    public List<FileModel> queryFilePathAll() {
        return fdi.queryFilePathAll();
    }

    @Override
    public int addFile(String filePath) {
        return fdi.addFilePath(filePath);
    }

}
