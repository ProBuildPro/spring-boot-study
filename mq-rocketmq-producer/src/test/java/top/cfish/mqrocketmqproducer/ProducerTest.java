package top.cfish.mqrocketmqproducer;

import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;

/**
 * @author: isisiwish
 * @date: 2019/5/28
 * @time: 15:20
 */
@Slf4j
public class ProducerTest extends MqRocketmqProducerApplicationTests
{
	@Getter
	@Setter
	@AllArgsConstructor
	static class StockChangeMessage
	{
		private Long productId;
		private Integer warehouseId;
	}
	
	@Autowired
	private Producer producer;
	
	@Test
	public void test()
	{
		StockChangeMessage msg = new StockChangeMessage(25286635L, 31);
		String rs = pushMsg(JSON.toJSONString(msg));
		log.info("rs : {}", rs);
	}
	
	private String pushMsg(String msg)
	{
		try
		{
			return producer.send("STOCK_CHANGE_EVENT_TOPIC", "TAG_DANGDANG", msg);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		catch (RemotingException e)
		{
			e.printStackTrace();
		}
		catch (MQClientException e)
		{
			e.printStackTrace();
		}
		catch (MQBrokerException e)
		{
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return "ERROR";
	}
}
