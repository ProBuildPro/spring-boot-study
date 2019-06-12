package top.cfish.mqrocketmqproducer;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

/**
 * @author: isisiwish
 * @date: 2019/5/28
 * @time: 15:27
 */
@Slf4j
@Component
public class Consumer
{
    private DefaultMQPushConsumer consumer;
    
    @Value("${rocketmq.nameServer}")
    private String nameServer;
    
    @Value("${rocketmq.consumer.groupName}")
    private String groupName;
    
    @Value("${rocketmq.topic}")
    private String topic;
    
    @Value("${rocketmq.tags}")
    private String tags;
    
    @Value("${rocketmq.consumer.max.size}")
    private int stockMaxConsumerSize;
    
    @PostConstruct
    public void init()
    {
        try
        {
            log.info("MQConsumer init start");
            consumer = new DefaultMQPushConsumer(groupName);
            consumer.setNamesrvAddr(nameServer);
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            consumer.subscribe(topic, tags);
            consumer.registerMessageListener(new StockEventListener());
            consumer.start();
            log.info("MQConsumer init end");
        }
        catch (MQClientException e)
        {
            log.error("MQConsumer启动报错", e);
        }
    }
    
    @PreDestroy
    public void destory()
    {
        // 对象销毁时关闭
        consumer.shutdown();
    }
    
    class StockEventListener implements MessageListenerConcurrently
    {
        @Override
        public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext)
        {
            try
            {
                for (MessageExt messageExt : list)
                {
                    String msg = new String(messageExt.getBody(), "UTF-8");
                    log.info("消费消息 : {}", msg);
                    if (msg == null || "".equals(msg))
                    {
                        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                    }
                }
            }
            catch (Exception e)
            {
                log.info("消费消息出现异常", e);
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
    }
}
