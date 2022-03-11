package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    // static 修饰的变量可以作用于全局 【静态方法用类名进行调用】
    private static SqlSessionFactory factory;

    static {
        // 在静态代码块下factory只会被创建一次
        try {
            // 读取 mybatis.xml 文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
            // 把流对象送到工厂加工 变成工厂对象
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 创建数据库连接对象 sqlSession 【静态方法作用于全局】
    public static SqlSession createSqlSession() {
        return factory.openSession(true); // 自动提交
    }

    // 关闭数据库连接对象 sqlSession 【静态方法作用于全局】
    public static void closeSqlSession(SqlSession sqlSession) {
        // 连接对象存在，则关闭连接
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

}
