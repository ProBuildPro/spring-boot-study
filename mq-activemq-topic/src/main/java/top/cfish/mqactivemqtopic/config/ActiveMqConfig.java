package top.cfish.mqactivemqtopic.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author: isisiwish
 * @date: 2019/5/27
 * @time: 20:17
 */

@Configuration
public class ActiveMqConfig
{
	@Bean
	public Topic topic()
	{
		return new ActiveMQTopic("isisiwish.test.topic");
	}
}
