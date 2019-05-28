package top.cfish.mqactivemqtopic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.cfish.mqactivemqtopic.producer.Producer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MqActivemqTopicApplicationTests
{
	@Autowired
	private Producer producer;
	
	@Test
	public void sendSimpleTopicMessage() throws InterruptedException
	{
		this.producer.sendTopic("Test Topic message");
		Thread.sleep(1000L);
	}
}
