package top.cfish.jobscheduler.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author: isisiwish
 * @date: 2019/5/20
 * @time: 8:15
 */
@Slf4j
@Component
public class FixedRateSchedulerJob
{
    private int count = 0;
    
    @Scheduled(fixedRate = 5000)
    public void process()
    {
        log.info("FixedRateSchedulerJob runing @{} - {}", TimeUtil.nowDate(), count++);
    }
}
