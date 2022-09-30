import com.beanoung.mybatis.mapper.EmpMapper;
import com.beanoung.mybatis.pojo.Emp;
import com.beanoung.mybatis.utils.SqlSessionUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class PageTest {

    @Test
    public void testPage(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询之前开启分页,本质是拦截器
        Page<Object> page = PageHelper.startPage(2, 4);
        //条件为空即查询所有
        List<Emp> list = mapper.selectByExample(null);
        //查询之后可以获取分页相关所有数据,比page的信息多      navigate: 导航
        PageInfo<Emp> pageInfo=new PageInfo<>(list,5);
        System.out.println(page);
        System.out.println(pageInfo);
        list.forEach(System.out::println);
        sqlSession.close();
    }
}
/**
 * Page{
 * count=true, pageNum=2, pageSize=4, startRow=4, endRow=8, total=6, pages=2,
 * reasonable=false, pageSizeZero=false}
 * [Emp{empId=5, empName='a', age=1, gender='男', deptId=null},
 * Emp{empId=8, empName='小黑', age=25, gender='男', deptId=null}]
 */


/**
 * PageInfo{
 * pageNum=2, pageSize=4, size=2, startRow=5, endRow=6, total=6, pages=2,
 * list=Page{count=true, pageNum=2, pageSize=4, startRow=4, endRow=8, total=6, pages=2,reasonable=false, pageSizeZero=false}
 * [Emp{empId=5, empName='a', age=1, gender='男', deptId=null},
 * Emp{empId=8, empName='小黑', age=25, gender='男', deptId=null}],
 * prePage=1, nextPage=0, isFirstPage=false, isLastPage=true, hasPreviousPage=true,hasNextPage=false,
 * navigatePages=2, navigateFirstPage=1, navigateLastPage=2, navigatepageNums=[1, 2]}
 */