package top.cfish.jobscheduler.job;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: isisiwish
 * @date: 2019/5/20
 * @time: 8:18
 */
public class TimeUtil
{
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    public static String nowDate()
    {
        return dateFormat.format(new Date());
    }
}
