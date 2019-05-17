package top.cfish.mongodbmulti.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * @author: isisiwish
 * @date: 2019/5/17
 * @time: 14:33
 */
@Configuration
public class MultipleMongoConfig
{
	@Autowired
	private MultipleMongoProperties mongoProperties;
	
	@Primary
	@Bean(name = "primaryMongoTemplate")
	public MongoTemplate primaryMongoTemplate() throws Exception
	{
		return new MongoTemplate(primaryFactory(this.mongoProperties.getPrimary()));
	}
	
	@Bean
	@Qualifier("secondaryMongoTemplate")
	public MongoTemplate secondaryMongoTemplate() throws Exception
	{
		return new MongoTemplate(secondaryFactory(this.mongoProperties.getSecondary()));
	}
	
	@Bean
	@Primary
	public MongoDbFactory primaryFactory(MongoProperties mongo) throws Exception
	{
		MongoClient client = new MongoClient(new MongoClientURI(mongoProperties.getPrimary().getUri()));
		return new SimpleMongoDbFactory(client, mongoProperties.getPrimary().getDatabase());
	}
	
	@Bean
	public MongoDbFactory secondaryFactory(MongoProperties mongo) throws Exception
	{
		MongoClient client = new MongoClient(new MongoClientURI(mongoProperties.getSecondary().getUri()));
		return new SimpleMongoDbFactory(client, mongoProperties.getSecondary().getDatabase());
	}
}
