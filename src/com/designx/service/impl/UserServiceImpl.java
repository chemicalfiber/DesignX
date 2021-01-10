package com.designx.service.impl;
/*
用户Service实现类
TODO 后端需要手动实现
 */
import com.designx.po.User;
import com.designx.service.UserService;
import com.designx.util.Page;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public User findUser(String userEmail, String userPassword) {
        return null;
    }

    @Override
    public User findUserById(int userId) {
        return null;
    }

    @Override
    public int updateUserPassword(int userId, String oldPassword, String password) {
        return 0;
    }

    @Override
    public Page<User> findAllUser(int page, int rows, String userId) {
        return null;
    }

    @Override
    public int deleteUser(int userId) {
        return 0;
    }
}
