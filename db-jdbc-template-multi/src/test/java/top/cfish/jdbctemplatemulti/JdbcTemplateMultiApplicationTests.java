package top.cfish.jdbctemplatemulti;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import top.cfish.jdbctemplatemulti.entity.User;
import top.cfish.jdbctemplatemulti.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTemplateMultiApplicationTests
{
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private JdbcTemplate primaryJdbcTemplate;
    
    @Autowired
    private JdbcTemplate secondaryJdbcTemplate;
    
    @Test
    public void testSave()
    {
        User user = new User("isisiwish", "password", 18);
        userRepository.save(user, primaryJdbcTemplate);
        userRepository.save(user, secondaryJdbcTemplate);
    }
}
