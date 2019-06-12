package top.cfish.mongodbmulti;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.cfish.mongodbmulti.entity.User;
import top.cfish.mongodbmulti.repository.primary.UserPrimaryRepository;
import top.cfish.mongodbmulti.repository.secondary.UserSecondaryRepository;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbMultiApplicationTests
{
    @Autowired
    UserPrimaryRepository userPrimaryRepository;
    
    @Autowired
    UserSecondaryRepository userSecondaryRepository;
    
    @Test
    public void TestMulti()
    {
        this.userPrimaryRepository.save(new User(1L, "isisiwish-frist", "123456"));
        this.userSecondaryRepository.save(new User(1L, "isisiwish-sec", "654321"));
        
        List<User> primaries = this.userPrimaryRepository.findAll();
        for (User primary : primaries)
        {
            log.info("{}", JSON.toJSONString(primary));
        }
        
        List<User> secondaries = this.userSecondaryRepository.findAll();
        for (User secondary : secondaries)
        {
            log.info("{}", JSON.toJSONString(secondary));
        }
    }
}
