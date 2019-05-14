package top.cfish.mybatis.annotation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.cfish.mybatis.annotation.mapper")
public class MybatisAnnotationApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(MybatisAnnotationApplication.class, args);
	}
}
