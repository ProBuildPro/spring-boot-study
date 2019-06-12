package top.cfish.jobquartz.scheduler;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.cfish.jobquartz.job.SampleJob;

/**
 * @author: isisiwish
 * @date: 2019/5/20
 * @time: 8:42
 */
@Configuration
public class SampleScheduler
{
    @Bean
    public JobDetail sampleJobDetail()
    {
        return JobBuilder.newJob(SampleJob.class).withIdentity("sampleJob").usingJobData("name", "isisiwish").storeDurably().build();
    }
    
    @Bean
    public Trigger sampleJobTrigger()
    {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();
        
        return TriggerBuilder.newTrigger().forJob(sampleJobDetail()).withIdentity("sampleTrigger").withSchedule(scheduleBuilder).build();
    }
}
