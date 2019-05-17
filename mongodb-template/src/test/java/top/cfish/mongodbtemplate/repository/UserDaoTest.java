package top.cfish.mongodbtemplate.repository;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.cfish.mongodbtemplate.MongodbTemplateApplicationTests;
import top.cfish.mongodbtemplate.entity.User;

/**
 * @author: isisiwish
 * @date: 2019/5/17
 * @time: 11:27
 */
@Slf4j
public class UserDaoTest extends MongodbTemplateApplicationTests
{
	@Autowired
	private UserDao userDao;
	
	@Test
	public void save()
	{
		User user = new User();
		user.setId(1L);
		user.setUsername("isisiwish");
		user.setPassword("pass");
		userDao.save(user);
	}
	
	@Test
	public void findUserByUsername()
	{
		User user = userDao.findUserByUsername("isisiwish");
		log.info("{}", JSON.toJSONString(user));
	}
	
	@Test
	public void update()
	{
		User user = new User();
		user.setId(1L);
		user.setUsername("isisiwish");
		user.setPassword("password");
		userDao.update(user);
	}
	
	@Test
	public void deleteById()
	{
		userDao.deleteById(1L);
	}
}
