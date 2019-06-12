package top.cfish.mybatismulti;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.cfish.mybatismulti.entity.UserEntity;
import top.cfish.mybatismulti.mapper.one.UserOneMapper;
import top.cfish.mybatismulti.mapper.two.UserTwoMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisMultiApplicationTests
{
    @Autowired
    private UserOneMapper userOneMapper;
    
    @Autowired
    private UserTwoMapper userTwoMapper;
    
    @Test
    public void testInsert() throws Exception
    {
        userOneMapper.insert(new UserEntity("cfish-a", "pass-a", "isisiwish#qq.com", "10086", "question", "answer"));
        userOneMapper.insert(new UserEntity("cfish-b", "pass-b", "isisiwish#qq.com", "10086", "question", "answer"));
        userTwoMapper.insert(new UserEntity("cfish-a", "pass-a", "isisiwish#qq.com", "10086", "question", "answer"));
    }
}
