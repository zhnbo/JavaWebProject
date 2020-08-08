package com.woniuxy.service;

import com.woniuxy.model.User;

public interface UserService {

    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    public User queryUserByEmail(String email);

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

    /**
     * 判断邮箱是否已存在
     * @param email
     * @return
     */

    /**
     * 判断能否登录成功
     * @param email
     * @param password
     * @return
     */
    public int loginIsSuccess(String email, String password);

    /**
     * 判断是否记住密码
     * @param remember
     */
    public boolean isRemember(String remember);
}
