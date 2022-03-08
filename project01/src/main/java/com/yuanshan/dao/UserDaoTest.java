package com.yuanshan.dao;


import com.yuanshan.pojo.User;
import com.yuanshan.utils.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserDaoTest {

    @Test
    public void findUserById(/*Integer userId*/) throws Exception {
        /*
        // 1. 读取mybatis.xml文件
        try {
            // 读取mybatis.xml文件转化成流对象
            InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

            // 通过 mybatis 提供的 build 把流对象转换成工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            // 通过工厂对象的openSession方法创建了连接对象 == jdbc中的connection对象
            // true: 表示自动提交
            SqlSession sqlSession = factory.openSession(true);

            // 接口的实现（数据库的连接实现）指定加载哪一个mapper文件
            // UserDaoImpl == UserDao.class
            UserDao userDao = sqlSession.getMapper(UserDao.class);

            // 接口方法实现查询
            User user = userDao.findUserById(2);

            // user对象转换成字符串输出
            System.out.println(user.toString());

            // 释放数据库连接
            sqlSession.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        // 引入工具类 【静态方法用类名进行调用】
        SqlSession sqlSession = MyBatisUtil.createSqlSession();

        // 连接数据库，实现数据传递
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        // 查询id=1的用户信息，封装成一个User对象
        User user = userDao.findUserById(1);

        System.out.println(user.toString());
        // 关闭数据库连接 【静态方法用类名进行调用】
        MyBatisUtil.closeSqlSession(sqlSession);
    }
}
