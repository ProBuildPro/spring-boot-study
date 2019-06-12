package top.cfish.jobscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JobSchedulerApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(JobSchedulerApplication.class, args);
    }
}
