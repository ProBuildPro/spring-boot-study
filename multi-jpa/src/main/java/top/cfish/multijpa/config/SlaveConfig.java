package top.cfish.multijpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @author: isisiwish
 * @date: 2019/5/13
 * @time: 17:01
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "slaveEntityManagerFactory", transactionManagerRef = "slaveTransactionManager", basePackages = {"top.cfish.multijpa.repository.db1"})
public class SlaveConfig
{
	@Autowired
	private JpaProperties jpaProperties;
	
	@Autowired
	private HibernateProperties hibernateProperties;
	
	@Autowired
	@Qualifier("slaveDataSource")
	private DataSource slaveDataSource;
	
	@Bean(name = "slaveEntityManager")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder)
	{
		return slaveEntityManagerFactory(builder).getObject().createEntityManager();
	}
	
	@Bean(name = "slaveTransactionManager")
	PlatformTransactionManager slaveTransactionManager(EntityManagerFactoryBuilder builder)
	{
		return new JpaTransactionManager(slaveEntityManagerFactory(builder).getObject());
	}
	
	@Bean(name = "slaveEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean slaveEntityManagerFactory(EntityManagerFactoryBuilder builder)
	{
		Map<String, Object> properties = hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
		return builder.dataSource(slaveDataSource)
				.packages("top.cfish.multijpa.entity")
				.persistenceUnit("slavePersistenceUnit")
				.properties(properties)
				.build();
	}
}
