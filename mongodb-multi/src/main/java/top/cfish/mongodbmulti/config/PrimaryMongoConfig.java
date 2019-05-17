package top.cfish.mongodbmulti.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author: isisiwish
 * @date: 2019/5/17
 * @time: 14:31
 */
@Configuration
@EnableConfigurationProperties(MultipleMongoProperties.class)
@EnableMongoRepositories(basePackages = "top.cfish.mongodbmulti.repository.primary", mongoTemplateRef = "primaryMongoTemplate")
public class PrimaryMongoConfig
{}
