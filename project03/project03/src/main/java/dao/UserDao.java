package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.User;

public interface UserDao {
    public List<User> findByGender (Integer gender) throws Exception;

    // Mybatis 不支持两个参数及以上 多个参数需通过参数注解的方式来传输
    // @Param("a") <class> <value>  #{a} 注解的别名最好和参数名以及列名和属性名一致
    // public List<User> findByGenderAndByName (@Param("a") Integer gender,@Param("b") String name) throws Exception;

    // 模糊查询
    public List<User> findByGenderAndByName (@Param("gender") Integer gender,@Param("userName") String userName) throws Exception;


    public int del(Integer id) throws Exception;
    public int insert(User user) throws Exception;
    public int update(Integer id) throws Exception;
    
}