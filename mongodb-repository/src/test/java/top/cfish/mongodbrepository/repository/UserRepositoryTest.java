package top.cfish.mongodbrepository.repository;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import top.cfish.mongodbrepository.MongodbRepositoryApplicationTests;
import top.cfish.mongodbrepository.entity.User;

import java.util.List;

/**
 * @author: isisiwish
 * @date: 2019/5/17
 * @time: 14:08
 */
@Slf4j
public class UserRepositoryTest extends MongodbRepositoryApplicationTests
{
    @Autowired
    private UserRepository userRepository;
    
    @Test
    public void save()
    {
        User user = new User();
        user.setId(2L);
        user.setUsername("isisiwish");
        user.setPassword("pass");
        userRepository.save(user);
    }
    
    @Test
    public void findUserByUsername()
    {
        User user = userRepository.findByUsername("isisiwish");
        log.info("{}", JSON.toJSONString(user));
    }
    
    @Test
    public void update()
    {
        User user = new User();
        user.setId(2L);
        user.setUsername("isisiwish");
        user.setPassword("password");
        userRepository.save(user);
    }
    
    @Test
    public void deleteById()
    {
        userRepository.deleteById(2L);
    }
    
    @Test
    public void testPage()
    {
        for (long i = 0; i < 100; i++)
        {
            User user = new User();
            user.setId(i);
            user.setUsername("isisiwish:" + i);
            user.setPassword("pass");
            userRepository.save(user);
        }
        
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(0, 5, sort);
        Page<User> page = userRepository.findAll(pageable);
        List<User> userList = page.getContent();
        for (User user : userList)
        {
            log.info("{}", JSON.toJSONString(user));
        }
    }
}
