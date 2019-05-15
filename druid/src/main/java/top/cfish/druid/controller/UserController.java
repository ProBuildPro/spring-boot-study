package top.cfish.druid.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.cfish.druid.entity.UserEntity;
import top.cfish.druid.mapper.UserMapper;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: isisiwish
 * @date: 2019/5/14
 * @time: 16:04
 */
@Slf4j
@RestController
public class UserController
{
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/getUserList")
	public List<UserEntity> getUsers()
	{
		List<UserEntity> userList = userMapper.getAll();
		return userList;
	}
	
	@RequestMapping("/getUser")
	public UserEntity getUser(Integer id)
	{
		UserEntity user = userMapper.getOne(id);
		return user;
	}
	
	@RequestMapping("/add")
	public void save(UserEntity user)
	{
		userMapper.insert(user);
	}
	
	@RequestMapping(value = "update")
	public void update(UserEntity user)
	{
		userMapper.update(user);
	}
	
	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") Integer id)
	{
		userMapper.delete(id);
	}
	
	@RequestMapping(value = "/count")
	public Integer count()
	{
		return userMapper.getCount();
	}
	
	// for test
	private String random(String prefix)
	{
		UUID uuid = UUID.randomUUID();
		String[] split = uuid.toString().split("-");
		StringBuilder sb = new StringBuilder();
		sb.append(prefix).append("-").append(split[0]);
		return sb.toString();
	}
	
	// for test
	private void insertUser()
	{
		MDC.put("traceLogId", UUID.randomUUID().toString());
		UserEntity user = new UserEntity("isisiwish", "pass", "isisiwish#qq.com", "1008611", "question", "answer");
		for (int i = 0; i < 100000; i++)
		{
			user.setUsername(random("isisiwish"));
			user.setPassword(random("pass"));
			user.setEmail(random("mail"));
			user.setPhone(random("1008611"));
			userMapper.insert(user);
			log.info("MDC {}", user.getUsername());
		}
		MDC.remove("traceLogId");
	}
	
	// for test
	@RequestMapping(value = "/test/insert/{count}")
	public void insertTest(@PathVariable("count") Integer count)
	{
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		for (int i = 0; i < count; i++)
		{
			executorService.execute(()->{
				insertUser();
			});
		}
		
		executorService.shutdown();
	}
	
	// for test
	@RequestMapping(value = "/test/slowSql")
	public List<UserEntity> slowSqlTest()
	{
		List<UserEntity> userList = userMapper.testSlowSql();
		return userList;
	}
	
}
