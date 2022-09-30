import com.beanoung.mybatis.mapper.SelectMapper;
import com.beanoung.mybatis.pojo.User;
import com.beanoung.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {

    @Test
    public void testSelectById() {
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user=mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list=mapper.getAllUser();
        list.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testSelectCount() {
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer integer = mapper.selectCount();
        System.out.println(integer);
        sqlSession.close();
    }

    @Test
    public void testGetUserByIdToMap() {
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getUserByIdToMap(1);
        System.out.println(map);
        sqlSession.close();
    }
    @Test
    public void testGetAllUserToMap() {
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        // List<Map<String, Object>> list = mapper.getAllUserToMap();
        // list.forEach(System.out::println);
        Map<String, Object> map = mapper.getAllUserToMap();
        System.out.println(map);
        sqlSession.close();
    }
}
