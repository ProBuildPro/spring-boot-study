package top.cfish.jobscheduler.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author: isisiwish
 * @date: 2019/5/20
 * @time: 8:12
 */
@Slf4j
@Component
public class CronSchedulerJob
{
	private int count = 0;
	
	@Scheduled(cron = "*/5 * * * * ?")
	private void process()
	{
		log.info("CronSchedulerJob runing @{} - {}", TimeUtil.nowDate(), count++);
	}
}
