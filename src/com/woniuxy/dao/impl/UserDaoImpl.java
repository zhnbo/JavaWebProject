package com.woniuxy.dao.impl;

import com.woniuxy.dao.UserDao;
import com.woniuxy.model.User;
import com.woniuxy.util.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.Serializable;
import java.util.List;

public class UserDaoImpl implements UserDao, Serializable {
    private static final long serialVersionUID = -1877381263084015790L;

    // 创建JdbcTemplate对象
    private JdbcTemplate jtl = new JdbcTemplate(DruidUtils.getDataSource());
    @Override
    public List<User> queryUserByEmail(String email) {
        // 定义SQL
        String sql = "SELECT id,email,password FROM t_user WHERE email = ?";
        return jtl.query(sql,new BeanPropertyRowMapper<User>(User.class),email);
    }

    @Override
    public int removeUserById(int id) {
        return 0;
    }

    @Override
    public int updateUserById(int id) {
        return 0;
    }

    @Override
    public int addUser(String email, String password) {
        return 0;
    }
}
