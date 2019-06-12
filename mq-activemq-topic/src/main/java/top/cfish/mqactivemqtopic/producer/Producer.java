package top.cfish.mqactivemqtopic.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

/**
 * @author: isisiwish
 * @date: 2019/5/27
 * @time: 20:19
 */
@Slf4j
@Component
public class Producer
{
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    
    @Autowired
    private Topic topic;
    
    public void sendTopic(String msg)
    {
        log.info("send queue msg : {}", msg);
        this.jmsMessagingTemplate.convertAndSend(this.topic, msg);
    }
}
