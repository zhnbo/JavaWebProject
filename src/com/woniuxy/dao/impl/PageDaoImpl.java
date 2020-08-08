package com.woniuxy.dao.impl;

import com.woniuxy.dao.PageDAO;
import com.woniuxy.model.FileModel;
import com.woniuxy.util.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @Author: Zh_o.
 * @Date: 2020/8/8 10:16
 */
public class PageDaoImpl implements PageDAO, Serializable {
    private static final long serialVersionUID = 7884865085298445821L;

    JdbcTemplate jtl = new JdbcTemplate(DruidUtils.getDataSource());

    @Override
    public List<FileModel> queryPage(int startPage) {
        String sql = "SELECT id,file FROM `t_files` LIMIT ?,5";
        return jtl.query(sql, new BeanPropertyRowMapper<FileModel>(FileModel.class), startPage);
    }

    @Override
    public int queryTotalPage() {
        String sql = "SELECT COUNT(id) AS totalpage FROM `t_files`;";
        Map<String, Object> map = jtl.queryForMap(sql);
        Object totalpage = map.get("totalpage");
        int i = Integer.parseInt(totalpage + "");
        System.out.println(i);
        return i;
    }
}
