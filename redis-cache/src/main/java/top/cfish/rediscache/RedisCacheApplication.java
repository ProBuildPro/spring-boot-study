package top.cfish.rediscache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.cfish.rediscache.mapper")
public class RedisCacheApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(RedisCacheApplication.class, args);
	}
}
