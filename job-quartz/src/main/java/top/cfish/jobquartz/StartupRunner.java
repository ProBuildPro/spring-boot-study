package top.cfish.jobquartz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import top.cfish.jobquartz.scheduler.CronScheduler;

/**
 * @author: isisiwish
 * @date: 2019/5/20
 * @time: 8:53
 */
@Slf4j
@Component
public class StartupRunner implements CommandLineRunner
{
    @Autowired
    public CronScheduler cronScheduler;
    
    @Override
    public void run(String... args) throws Exception
    {
        cronScheduler.scheduleJobs();
        log.info("定时任务开始执行");
    }
}
