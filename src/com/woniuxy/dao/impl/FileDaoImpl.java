package com.woniuxy.dao.impl;

import com.woniuxy.dao.FileDao;
import com.woniuxy.model.FileModel;
import com.woniuxy.util.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.Serializable;
import java.util.List;

/**
 * Description: 文件DAO实现类
 * @Author: Zh_o.
 * @Date: 2020/8/7 16:41
 */
public class FileDaoImpl implements FileDao, Serializable {

    private static final long serialVersionUID = 7999150535155400085L;

    private JdbcTemplate jtl = new JdbcTemplate(DruidUtils.getDataSource());

    @Override
    public int addFilePath(String filePath) {
        String sql = "INSERT INTO t_files (file) VALUES (?)";
        return jtl.update(sql,filePath);
    }

    @Override
    public List<FileModel> queryFilePathAll() {
        String sql = "SELECT id,file FROM t_files";
        return jtl.query(sql,new BeanPropertyRowMapper<FileModel>(FileModel.class));
    }
}
