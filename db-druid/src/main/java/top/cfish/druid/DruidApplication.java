package top.cfish.druid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.cfish.druid.mapper")
public class DruidApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(DruidApplication.class, args);
    }
}
