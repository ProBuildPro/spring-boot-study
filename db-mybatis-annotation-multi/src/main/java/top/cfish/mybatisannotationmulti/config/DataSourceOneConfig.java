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
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author: isisiwish
 * @date: 2019/5/24
 * @time: 15:07
 */
@Configuration
@MapperScan(basePackages = "top.cfish.mybatisannotationmulti.mapper.one", sqlSessionTemplateRef = "testOneSqlSessionTemplate")
public class DataSourceOneConfig
{
    @Bean(name = "testOneDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.one")
    @Primary
    public DataSource testDataSource()
    {
        return DataSourceBuilder.create().build();
    }
    
    @Bean(name = "testOneSqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("testOneDataSource") DataSource dataSource) throws Exception
    {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }
    
    @Bean(name = "testOneTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("testOneDataSource") DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }
    
    @Bean(name = "testOneSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("testOneSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception
    {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
