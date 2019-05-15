package top.cfish.multidruid.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author: isisiwish
 * @date: 2019/5/14
 * @time: 20:32
 */
@Configuration
public class MultiDataSourceConfig
{
	@Primary
	@Bean(name = "oneDataSource")
	@ConfigurationProperties("spring.datasource.druid.one")
	public DataSource dataSourceOne()
	{
		return DruidDataSourceBuilder.create().build();
	}
	
	@Bean(name = "twoDataSource")
	@ConfigurationProperties("spring.datasource.druid.two")
	public DataSource dataSourceTwo()
	{
		return DruidDataSourceBuilder.create().build();
	}
}
