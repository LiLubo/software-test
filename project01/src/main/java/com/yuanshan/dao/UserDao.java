package com.yuanshan.dao;

import com.yuanshan.pojo.User;

public interface UserDao {
//    根据用户id获取用户对象
    public User findUserById(Integer userId) throws Exception;
}