import com.beanoung.mybatis.mapper.DeptMapper;
import com.beanoung.mybatis.mapper.EmpMapper;
import com.beanoung.mybatis.pojo.Dept;
import com.beanoung.mybatis.pojo.Emp;
import com.beanoung.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ResultMapTest {
    @Test
    public void testGetEmpById(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpById(1);
        System.out.println(emp);
        sqlSession.close();
    }

    @Test
    public void testGetEmpAndDept(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDept(1);
        System.out.println(emp);
        sqlSession.close();
    }

    @Test
    public void testGetEmpAndDeptByStep(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStep(2);
        System.out.println(emp.getEmpName());
        sqlSession.close();
    }

    @Test
    public void testGetDeptAndEmp(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmp(1);
        System.out.println(dept);
        sqlSession.close();
    }

    @Test
    public void testGetDeptAndEmpByStep(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStep(1);
        System.out.println(dept);
        sqlSession.close();
    }
}
