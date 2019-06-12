package top.cfish.mybatisannotationmulti.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author: isisiwish
 * @date: 2019/5/24
 * @time: 15:07
 */

@Configuration
@MapperScan(basePackages = "top.cfish.mybatisannotationmulti.mapper.two", sqlSessionTemplateRef = "testTwoSqlSessionTemplate")
public class DataSourceTwoConfig
{
    @Bean(name = "testTwoDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.two")
    public DataSource testDataSource()
    {
        return DataSourceBuilder.create().build();
    }
    
    @Bean(name = "testTwoSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("testTwoDataSource") DataSource dataSource) throws Exception
    {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }
    
    @Bean(name = "testTwoTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("testTwoDataSource") DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }
    
    @Bean(name = "testTwoSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("testTwoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception
    {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
