package top.cfish.mybatis.mapper;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import top.cfish.mybatis.MybatisApplicationTests;
import top.cfish.mybatis.entity.UserEntity;
import top.cfish.mybatis.param.PageParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author: isisiwish
 * @date: 2019/5/14
 * @time: 9:32
 */
@Slf4j
public class UserMapperTest extends MybatisApplicationTests
{
	@Resource
	private UserMapper userMapper;
	
	@Test
	public void getOne()
	{
		UserEntity user = userMapper.getOne(1);
		log.info("{}", JSON.toJSONString(user));
	}
	
	@Test
	public void getAll()
	{
		List<UserEntity> userList = userMapper.getAll();
		log.info("{}", JSON.toJSONString(userList));
	}
	
	@Test
	public void insert()
	{
		UserEntity user = new UserEntity("isisiwish-mybatis", "pass", "isisiwish#qq.com", "1008611", "question", "answer");
		userMapper.insert(user);
	}
	
	@Test
	public void update()
	{
		UserEntity user = userMapper.getOne(1);
		user.setUsername(user.getUsername() + "+mybatis");
		int rs = userMapper.update(user);
		log.info("{}", rs);
	}
	
	@Test
	public void delete()
	{
		userMapper.delete(2);
	}
	
	private String randomUsername()
	{
		UUID uuid = UUID.randomUUID();
		String[] split = uuid.toString().split("-");
		StringBuilder sb = new StringBuilder();
		sb.append("isisiwish-").append(split[0]);
		return sb.toString();
	}
	
	@Test
	public void insertTest()
	{
		UserEntity user = new UserEntity("isisiwish", "pass", "isisiwish#qq.com", "1008611", "question", "answer");
		for (int i = 0; i < 100; i++)
		{
			user.setUsername(randomUsername());
			userMapper.insert(user);
		}
	}
	
	@Test
	public void getCount()
	{
		int count = userMapper.getCount();
		log.info("{}", count);
	}
	
	@Test
	public void getList()
	{
		List<UserEntity> userList = userMapper.getList(new PageParam(0, 10));
		for (UserEntity user : userList)
		{
			log.info("id:{} username:{}", user.getId(), user.getUsername());
		}
	}
	
	@Test
	public void getUserTest()
	{
		UserEntity user = userMapper.getUser("isisiwish", "5411C919B8BF4B9F27D6C624DDF8F160");
		log.info("{}", JSON.toJSONString(user));
	}
}
