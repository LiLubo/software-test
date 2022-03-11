package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.MyBatisUtil;

import java.util.List;

public class UserDaoTest {
    @Test
    public void findAllUser() {
        SqlSession sqlSession = MyBatisUtil.createSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        try {
            List<User> users = userDao.find();

            for (User user:users) {
                System.out.println(user.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void findUserById() {
        SqlSession sqlSession = MyBatisUtil.createSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        try {
            User user = userDao.findUserById(2);
            System.out.println(user.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }
}
