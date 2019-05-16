package top.cfish.rediscache.mapper;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.cfish.rediscache.RedisCacheApplicationTests;
import top.cfish.rediscache.entity.UserEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author: isisiwish
 * @date: 2019/5/15
 * @time: 21:05
 */
@Slf4j
public class UserMapperTest extends RedisCacheApplicationTests
{
	@Autowired
	UserMapper userMapper;
	
	@Test
	public void test()
	{
		Map paramMap=new HashMap();
		paramMap.put("username", "isisiwish");
		paramMap.put("password", "5411C919B8BF4B9F27D6C624DDF8F160");
		UserEntity user = userMapper.getUser(paramMap);
		log.info("{}", JSON.toJSONString(user));
	}
}
