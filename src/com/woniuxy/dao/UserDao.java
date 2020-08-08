package com.woniuxy.dao;

import com.woniuxy.model.User;

import java.util.List;

public interface UserDao {

    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    public List<User> queryUserByEmail(String email);

    /**
     * 根据ID删除用户信息
     * @param id
     * @return
     */
    public int removeUserById(int id);

    /**
     * 根据ID修改用户信息
     * @param id
     * @return
     */
    public int updateUserById(int id);

    /**
     * 新增用户信息
     * @param email
     * @param password
     * @return
     */
    public int addUser(String email,String password);
}
