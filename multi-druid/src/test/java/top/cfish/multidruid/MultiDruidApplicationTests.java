package top.cfish.multidruid;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.cfish.multidruid.entity.UserEntity;
import top.cfish.multidruid.mapper.one.UserOneMapper;
import top.cfish.multidruid.mapper.two.UserTwoMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiDruidApplicationTests
{
	@Autowired
	private UserOneMapper userOneMapper;
	
	@Autowired
	private UserTwoMapper userTwoMapper;
	
	@Test
	public void testInsert() throws Exception
	{
		UserEntity user1 = new UserEntity("isisiwish-1", "pass", "isisiwish#qq.com", "1008611", "question", "answer");
		UserEntity user2 = new UserEntity("isisiwish-2", "pass", "isisiwish#qq.com", "1008611", "question", "answer");
		UserEntity user3 = new UserEntity("isisiwish-3", "pass", "isisiwish#qq.com", "1008611", "question", "answer");
		
		userOneMapper.insert(user1);
		userOneMapper.insert(user2);
		userTwoMapper.insert(user3);
		
		Assert.assertEquals(2, userOneMapper.getAll().size());
		Assert.assertEquals(1, userTwoMapper.getAll().size());
	}
}
