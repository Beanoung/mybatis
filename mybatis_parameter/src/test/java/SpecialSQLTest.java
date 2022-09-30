import com.beanoung.mybatis.mapper.SpecialSQLMapper;
import com.beanoung.mybatis.pojo.User;
import com.beanoung.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.lang.module.ResolutionException;
import java.util.List;

public class SpecialSQLTest {
    @Test
    public void testGetUserByLike() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> list = mapper.getUserByLike("r");
        list.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testDeleteMoreUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        int i = mapper.deleteMoreUser("4,5");
        System.out.println(i);
        sqlSession.close();
    }

    @Test
    public void testGetUserList() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> list = mapper.getUserList("t_user");
        list.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        User user = new User(null, "abc", "777777", 3, "男", "7777777@qq.com");
        mapper.insertUser(user);
        //这里输出和之前的添加用户输出的User多了一个id的值,之前的为null
        System.out.println(user);
        sqlSession.close();
    }

}
