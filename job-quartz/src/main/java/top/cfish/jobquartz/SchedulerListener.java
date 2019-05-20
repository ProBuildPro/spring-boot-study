package top.cfish.jobquartz;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.cfish.jobquartz.scheduler.CronScheduler;

/**
 * @author: isisiwish
 * @date: 2019/5/20
 * @time: 8:51
 */

@Component
@Configuration
@EnableScheduling
public class SchedulerListener
{
	@Autowired
	public CronScheduler cronScheduler;
	
	@Scheduled(cron = "0 30 11 25 11 ?")
	public void schedule() throws SchedulerException
	{
		cronScheduler.scheduleJobs();
	}
}
