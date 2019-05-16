package top.cfish.redissession;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.cfish.redissession.mapper")
public class RedisSessionApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(RedisSessionApplication.class, args);
	}
}
