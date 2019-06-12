package top.cfish.jobquartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author: isisiwish
 * @date: 2019/5/20
 * @time: 8:45
 */
@Slf4j
public class SchedulerBJob implements Job
{
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException
    {
        log.info("schedule JobA is running ...");
    }
}
