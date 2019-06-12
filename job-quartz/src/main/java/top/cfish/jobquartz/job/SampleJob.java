package top.cfish.jobquartz.job;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author: isisiwish
 * @date: 2019/5/20
 * @time: 8:39
 */
@Slf4j
@Getter
@Setter
public class SampleJob extends QuartzJobBean
{
    private String name;
    
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException
    {
        log.info("Hello {}", this.name);
    }
}
