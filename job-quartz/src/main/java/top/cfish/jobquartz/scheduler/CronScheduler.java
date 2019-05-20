package top.cfish.jobquartz.scheduler;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;
import top.cfish.jobquartz.job.SchedulerAJob;
import top.cfish.jobquartz.job.SchedulerBJob;

/**
 * @author: isisiwish
 * @date: 2019/5/20
 * @time: 8:48
 */
@Component
public class CronScheduler
{
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	
	public void scheduleJobs() throws SchedulerException
	{
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		scheduleJobA(scheduler);
		scheduleJobB(scheduler);
	}
	
	private void scheduleJobA(Scheduler scheduler) throws SchedulerException
	{
		JobDetail jobDetail = JobBuilder.newJob(SchedulerAJob.class).withIdentity("JobA", "group1").build();
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
		CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withSchedule(scheduleBuilder).build();
		scheduler.scheduleJob(jobDetail, cronTrigger);
	}
	
	private void scheduleJobB(Scheduler scheduler) throws SchedulerException
	{
		JobDetail jobDetail = JobBuilder.newJob(SchedulerBJob.class).withIdentity("JobB", "group2").build();
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/3 * * * * ?");
		CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group2").withSchedule(scheduleBuilder).build();
		scheduler.scheduleJob(jobDetail, cronTrigger);
	}
}
