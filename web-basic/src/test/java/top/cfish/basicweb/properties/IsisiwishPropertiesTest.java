package top.cfish.basicweb.properties;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import top.cfish.basicweb.BasicWebApplicationTests;

import javax.annotation.Resource;

/**
 * @author: isisiwish
 * @date: 2019/5/10
 * @time: 20:12
 */

@Slf4j
public class IsisiwishPropertiesTest extends BasicWebApplicationTests
{
    @Resource
    private IsisiwishProperties properties;
    
    @Test
    public void testProperties() throws Exception
    {
        log.info("title : {}", properties.getTitle());
        log.info("description : {}", properties.getDescription());
    }
}
