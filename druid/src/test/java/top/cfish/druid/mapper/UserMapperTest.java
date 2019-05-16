package top.cfish.druid.mapper;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.cfish.druid.DruidApplicationTests;
import top.cfish.druid.entity.UserEntity;

import static org.junit.Assert.*;

/**
 * @author: isisiwish
 * @date: 2019/5/15
 * @time: 21:33
 */
@Slf4j
public class UserMapperTest extends DruidApplicationTests
{
	@Autowired
	UserMapper userMapper;
	
	@Test
	public void getUser()
	{
		UserEntity user = userMapper.getUser("isisiwish", "5411C919B8BF4B9F27D6C624DDF8F160");
		log.info("{}", JSON.toJSONString(user));
	}
}
