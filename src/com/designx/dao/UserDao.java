package com.designx.dao;

import com.designx.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//用户实体类
public interface UserDao {
    // 用户注册
    public int addUser(User user);
    // 用户登录
    public User findUser(@Param("userEmail")String userEmail,@Param("password")String password);
    // 查找用户
    public User findUserById(int userId);
    // 更改密码
    public User updateUserPassword(@Param("userId")int userId,@Param("oldPassword")String oldPassword,@Param("password")String password);
    // 查询用户列表
    public List<User> findAllUser(User user);
    // 删除用户
    int deleteUser(int userId);
}
