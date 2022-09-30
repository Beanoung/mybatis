package com.beanoung.mybatis.test;

import com.beanoung.mybatis.mapper.UserMapper;
import com.beanoung.mybatis.pojo.User;
import com.beanoung.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    public void testInsert() throws IOException {

        // 获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取sqlSessionFactorBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取sqlSessionFactor对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        // 获取sql的会话对象sqlSession()不会自动提交事务,是mybatis提供的操作数据库的对象
        // SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取sql的会话对象sqlSession(true)会自动提交事务,就不需要后面的commit了,是mybatis提供的操作数据库的对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 法1:(推荐)  获取UserMapper的代理实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 调用mapper接口中的方法
        int i = userMapper.insertUser();
        System.out.println("结果:" + i);

        // 法2:  通过sql语句的唯一标识找到sql并执行,唯一标识:映射文件的 namespace.id
        // int result=sqlSession.insert("com.beanoung.mybatis.mapper.UserMapper.insertUser");
        // System.out.println("结果:"+result);

        // 输出正常,但是数据库并没有数据,因为没有设置事务,默认回滚(并且占用了id,如果从数据库新增会发现id自动是2,说明1被占用了)
        // sqlSession.commit();
        // 现在设置事务提交后(或者上面设置的true),运行之后变为了3(2是在数据库那边手动新增的)

        // 关闭会话
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.updateUser();
        System.out.println("结果:" + i);
        sqlSession.close();
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.deleteUser();
        System.out.println("结果:" + i);
        sqlSession.close();
    }

    @Test
    public void testSelect() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUser();
        System.out.println("结果:" + user);
        sqlSession.close();
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.selectAllUser();
        list.forEach(System.out::println);
        sqlSession.close();
    }

}
