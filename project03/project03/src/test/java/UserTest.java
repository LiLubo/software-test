import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import dao.UserDao;
import pojo.User;
import utils.MyBatisUtils;

public class UserTest {

    @Test
    public void find() {
        SqlSession sqlSession = MyBatisUtils.createSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        try {
            List<User> users = userDao.findByGender(1);

            for (User user : users) {
                System.out.println(user.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void findByGenderAndByName() {
        SqlSession sqlSession = MyBatisUtils.createSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        try {
            List<User> users = userDao.findByGenderAndByName(2, "杨过");

            for (User user : users) {
                System.out.println(user.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void del() {
        SqlSession sqlSession = MyBatisUtils.createSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        try {
            Integer line = userDao.del(15);

            System.out.println("del 执行后受影响的行数：" + line);
        
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void insert() {
        SqlSession sqlSession = MyBatisUtils.createSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        try {
            User user = new User();
            user.setId(17);
            user.setUserCode("ali");
            user.setUserName("阿李");

            Integer line = userDao.insert(user);

            System.out.println("insert 执行后受影响的函数：" + line);
        
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}


