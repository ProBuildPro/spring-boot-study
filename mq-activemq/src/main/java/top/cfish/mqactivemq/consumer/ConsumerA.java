package top.cfish.mqactivemq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author: isisiwish
 * @date: 2019/5/27
 * @time: 20:18
 */
@Slf4j
@Component
public class ConsumerA
{
	@JmsListener(destination = "isisiwish.test.queue", containerFactory = "queueListenerFactory")
	public void receiveQueue(String text)
	{
		log.info("ConsumerA queue msg : {}", text);
	}
	
	@JmsListener(destination = "isisiwish.test.topic", containerFactory = "topicListenerFactory")
	public void receiveTopic(String text)
	{
		log.info("ConsumerA topic msg : {}", text);
	}
}
