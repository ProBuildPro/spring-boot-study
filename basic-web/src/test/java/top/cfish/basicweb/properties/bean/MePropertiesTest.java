package top.cfish.basicweb.properties.bean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import top.cfish.basicweb.BasicWebApplicationTests;

import javax.annotation.Resource;

/**
 * @author: isisiwish
 * @date: 2019/5/21
 * @time: 8:32
 */
@Slf4j
public class MePropertiesTest extends BasicWebApplicationTests
{
	@Resource
	private MeProperties properties;
	
	@Test
	public void test() throws Exception
	{
		log.info("title : {}", properties.getTitle());
		log.info("description : {}", properties.getDescription());
	}
}
