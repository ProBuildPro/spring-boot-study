package top.cfish.multijpa.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.cfish.multijpa.MultiJpaApplicationTests;
import top.cfish.multijpa.entity.User;
import top.cfish.multijpa.repository.db0.User0Repository;
import top.cfish.multijpa.repository.db1.User1Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: isisiwish
 * @date: 2019/5/13
 * @time: 16:18
 */

public class MultiRepositoryTest extends MultiJpaApplicationTests
{
	@Autowired
	private User0Repository user0Repository;
	
	@Autowired
	private User1Repository user1Repository;
	
	@Test
	public void testMultiSave() throws Exception
	{
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = dateFormat.format(date);
		
		user0Repository.save(new User("a", "a", "a@gmail.com", "a123456", formattedDate));
		user0Repository.save(new User("b", "b", "b@gmail.com", "b123456", formattedDate));
		user1Repository.save(new User("c", "c", "c@gmail.com", "c123456", formattedDate));
	}
}
