package top.cfish.mongodbmulti.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: isisiwish
 * @date: 2019/5/17
 * @time: 14:30
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "mongodb")
public class MultipleMongoProperties
{
    private MongoProperties primary = new MongoProperties();
    private MongoProperties secondary = new MongoProperties();
    
}
