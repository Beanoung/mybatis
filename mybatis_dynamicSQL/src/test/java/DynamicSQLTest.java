import com.beanoung.mybatis.mapper.DynamicSQLMapper;
import com.beanoung.mybatis.pojo.Emp;
import com.beanoung.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class DynamicSQLTest {

    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp=new Emp(null,"张三",20,"");
        List<Emp> list = mapper.getEmpByCondition(emp);
        list.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp=new Emp(null,"张三",20,"男");
        List<Emp> list = mapper.getEmpByChoose(emp);
        list.forEach(System.out::println);
        sqlSession.close();
    }

    /* insertMoreEmp */
    @Test
    public void testInsertMoreEmp(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1=new Emp(null,"a",1,"男");
        Emp emp2=new Emp(null,"b",2,"男");
        Emp emp3=new Emp(null,"c",3,"男");
        List<Emp> list = Arrays.asList(emp1, emp2, emp3);
        mapper.insertMoreEmp(list);
        sqlSession.close();
    }

    /* deleteMoreEmp */
    @Test
    public void testDeleteMoreEmp(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[] empIds=new Integer[]{6,7};
        mapper.deleteMoreEmp(empIds);
        sqlSession.close();
    }
}
