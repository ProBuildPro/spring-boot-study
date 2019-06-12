package top.cfish.basicjpa.repository;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import top.cfish.basicjpa.BasicJpaApplicationTests;
import top.cfish.basicjpa.entity.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: isisiwish
 * @date: 2019/5/13
 * @time: 14:48
 */
@Slf4j
public class UserRepositoryTest extends BasicJpaApplicationTests
{
    @Autowired
    private UserRepository userRepository;
    
    @Before
    public void setUp() throws Exception
    {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(date);
        
        userRepository.save(new User("aa", "aa", "aa@gmail.com", "aa123456", formattedDate));
        userRepository.save(new User("bb", "bb", "bb@gmail.com", "bb123456", formattedDate));
        userRepository.save(new User("cc", "cc", "cc@gmail.com", "cc123456", formattedDate));
    }
    
    @Test
    public void jpaTest()
    {
        User user = userRepository.findByUserNameOrEmail("bb", "bb@gmail.com");
        Assert.assertEquals("bb", user.getUserName());
        Assert.assertEquals(3, userRepository.findAll().size());
    }
    
    @Test
    public void pageQueryTest()
    {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(date);
        
        userRepository.save(new User("a1", "aa", "a1@gmail.com", "a1", formattedDate));
        userRepository.save(new User("a2", "aa", "a2@gmail.com", "a2", formattedDate));
        userRepository.save(new User("a3", "aa", "a3@gmail.com", "a3", formattedDate));
        userRepository.save(new User("a4", "aa", "a4@gmail.com", "a4", formattedDate));
        userRepository.save(new User("a5", "aa", "a5@gmail.com", "a5", formattedDate));
        
        int page = 1;
        int size = 2;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        
        Page<User> users = userRepository.findALL(pageable);
        if (users == null)
        {
            return;
        }
        List<User> userList = users.getContent();
        log.info("{}", JSON.toJSONString(userList));
        
        users = userRepository.findByNickNameContaining("a", pageable);
        if (users == null)
        {
            return;
        }
        userList = users.getContent();
        log.info("{}", JSON.toJSONString(userList));
    }
    
    @After
    public void tearDown() throws Exception
    {
        userRepository.deleteAll();
    }
}
