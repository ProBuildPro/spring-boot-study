package top.cfish.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.cfish.mybatis.mapper")
public class MybatisApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(MybatisApplication.class, args);
    }
}
