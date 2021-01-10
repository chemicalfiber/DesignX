package com.designx.service;

import com.designx.po.User;
import com.designx.util.Page;


/*
用户Service接口
 */
public interface UserService {
    // 用户注册
    public int addUser(User user);
    // 登录
    public User findUser(String userEmail,String userPassword);
    // 查找用户(后台管理用)
    public User findUserById(int userId);
    // 更改密码
    public int updateUserPassword(int userId, String oldPassword, String password);
    // 查询用户列表
    public Page<User> findAllUser(int page,int rows,String userId); // 由于普通用户没有状态，所以不需要status这个参数
    // 删除用户
    int deleteUser(int userId);
}
