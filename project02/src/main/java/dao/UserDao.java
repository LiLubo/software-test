package dao;

import pojo.User;

import java.util.List;

public interface UserDao {
    /**
     * 返回所有的用户信息
     * @return List<User>
     * @throws Exception
     */
    public List<User> find() throws Exception;

    /**
     * 通过用户Id查找并显示用户信息
     * @param userId:要查找的用户ID
     * @return User对象
     * @throws Exception
     */
    public User findUserById(Integer userId) throws Exception;
}
