package top.cfish.mqactivemqqueue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.cfish.mqactivemqqueue.producer.Producer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MqActivemqQueueApplicationTests
{
    @Autowired
    private Producer producer;
    
    @Test
    public void sendSimpleQueueMessage() throws InterruptedException
    {
        this.producer.sendQueue("Test queue message");
    }
    
    @Test
    public void send100QueueMessage() throws InterruptedException
    {
        for (int i = 0; i < 100; i++)
        {
            this.producer.sendQueue("Test queue message " + i);
        }
        Thread.sleep(1000L);
    }
}
