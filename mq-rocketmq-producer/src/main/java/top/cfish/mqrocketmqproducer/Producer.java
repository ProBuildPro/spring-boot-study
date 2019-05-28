package top.cfish.mqrocketmqproducer;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.common.RemotingHelper;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;

/**
 * @author: isisiwish
 * @date: 2019/5/28
 * @time: 15:12
 */

@Component
public class Producer
{
	@Value("${rocketmq.producer.groupName}")
	private String producerGroup;
	
	@Value("${rocketmq.nameServer}")
	private String namesrvAddr;
	
	private DefaultMQProducer producer;
	
	@PostConstruct
	public void defaultMQProducer()
	{
		//生产者的组名
		producer = new DefaultMQProducer(producerGroup);
		//指定NameServer地址，多个地址以 ; 隔开
		producer.setNamesrvAddr(namesrvAddr);
		producer.setVipChannelEnabled(false);
		try
		{
			producer.start();
			System.out.println("-------->:producer启动了");
		}
		catch (MQClientException e)
		{
			e.printStackTrace();
		}
	}
	
	public String send(String topic, String tags, String body) throws InterruptedException, RemotingException, MQClientException, MQBrokerException, UnsupportedEncodingException
	{
		Message message = new Message(topic, tags, body.getBytes(RemotingHelper.DEFAULT_CHARSET));
		StopWatch stop = new StopWatch();
		stop.start();
		SendResult result = producer.send(message);
		System.out.println("发送响应：MsgId:" + result.getMsgId() + "，发送状态:" + result.getSendStatus());
		stop.stop();
		return "{\"MsgId\":\"" + result.getMsgId() + "\"}";
	}
}
