import com.beanoung.mybatis.mapper.CacheMapper;
import com.beanoung.mybatis.pojo.Emp;
import com.beanoung.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {

    @Test
    public void testGetEmpById() {
        //MyBatis的一级缓存是SqlSession级别的,默认开启
        /**
         * 使一级缓存失效的四种情况
         * 1.不同的SqlSession对应不同的一级缓存
         * 2.同一个SqlSession但是查询条件不同
         * 3.同一个SqlSession两次查询期间执行了任何一次增删改操作
         * 4.同一个SqlSession两次查询期间手动清空了缓存
         */
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);

        //同一个SqlSession两次查询期间执行了任何一次增删改操作
        //mapper1.insertEmp(new Emp(null,"小黑",25,"男"));

        //手动清空缓存
        //sqlSession1.clearCache();

        //和上面是同一个SqlSession,所以从缓存中获取
        Emp emp2 = mapper1.getEmpById(1);
        System.out.println(emp2);

        //和上面不是同一个SqlSession,所以要从数据库查询获取
        SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp3 = mapper2.getEmpById(1);
        System.out.println(emp3);

        sqlSession1.close();
        sqlSession2.close();
    }

    //二级缓存,是SqlSessionFactory级别的,即通过同一个SqlSessionFactory获取的SqlSession
    //因此不能用工具类,工具类每次都是新的SqlSessionFactory
    @Test
    public void testCache() throws IOException {
        /**
         * 二级缓存开启条件:
         * 1.在核心配置文件中,设置全局配置属性cacheEnabled="true",默认为true,不需要设置
         * 2.在映射文件中设置标签<cache/>
         * 3.二级缓存必须在SqlSession关闭或提交后才有效
         * 4.查询的数据所转换的实体类类型必须实现序列化的接口
         *
         * 失效情况:  两次查询期间执行了任何一次增删改操作
         */
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);
        //二级缓存在关闭SqlSession后才开启
        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpById(1);
        System.out.println(emp2);
        sqlSession2.close();
    }
}
