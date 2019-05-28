package top.cfish.mqactivemqqueue.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * @author: isisiwish
 * @date: 2019/5/27
 * @time: 20:17
 */

@Configuration
public class ActiveMqConfig
{
	@Bean
	public Queue queue()
	{
		return new ActiveMQQueue("isisiwish.test.queue");
	}
}
