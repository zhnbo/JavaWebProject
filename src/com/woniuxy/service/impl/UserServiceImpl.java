package com.woniuxy.service.impl;

import com.woniuxy.dao.impl.UserDaoImpl;
import com.woniuxy.model.User;
import com.woniuxy.service.UserService;

import java.io.Serializable;

/**
 * @Author: Zh_o.
 */
public class UserServiceImpl implements UserService, Serializable {
    private static final long serialVersionUID = 853059833388438980L;

    private UserDaoImpl udi = new UserDaoImpl();


    @Override
    public User queryUserByEmail(String email) {
        return udi.queryUserByEmail(email).get(0);
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
    public boolean isRemember(String remember) {
        return "on".equals(remember);
    }

    @Override
    public int loginIsSuccess(String email, String password) {
        User user = udi.queryUserByEmail(email).get(0);
        // 邮箱未注册返回0
        if (udi.queryUserByEmail(email).isEmpty()) {
            return 0;
        }
        // 密码正确返回1
        if (user.getPassword().equals(password)) {
            return 1;
        }
        // 密码不正确返回-1
        return -1;
    }

    @Override
    public int addUser(String email, String password) {

        return 0;
    }
}
