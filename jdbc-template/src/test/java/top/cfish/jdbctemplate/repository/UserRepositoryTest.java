package top.cfish.jdbctemplate.repository;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.cfish.jdbctemplate.JdbcTemplateApplicationTests;
import top.cfish.jdbctemplate.entity.User;

import java.util.List;


/**
 * @author: isisiwish
 * @date: 2019/5/24
 * @time: 11:01
 */
@Slf4j
public class UserRepositoryTest extends JdbcTemplateApplicationTests
{
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testSave()
	{
		User user = new User("isisiwish", "pass", 18);
		userRepository.save(user);
	}
	
	@Test
	public void testUpdate()
	{
		User user = new User("cfish", "pass", 12);
		user.setId(1L);
		userRepository.update(user);
	}
	
	@Test
	public void testDetele()
	{
		userRepository.delete(1L);
	}
	
	@Test
	public void testQueryOne()
	{
		User user = userRepository.findById(2L);
		log.info("{}", JSON.toJSONString(user));
	}
	
	@Test
	public void testQueryAll()
	{
		List<User> users = userRepository.findALL();
		for (User user : users)
		{
			log.info("{}", JSON.toJSONString(user));
		}
	}
}
