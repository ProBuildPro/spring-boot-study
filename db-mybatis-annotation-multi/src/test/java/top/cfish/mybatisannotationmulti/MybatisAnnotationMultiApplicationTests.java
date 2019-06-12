package top.cfish.mybatisannotationmulti;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.cfish.mybatisannotationmulti.entity.UserEntity;
import top.cfish.mybatisannotationmulti.mapper.one.UserOneMapper;
import top.cfish.mybatisannotationmulti.mapper.two.UserTwoMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisAnnotationMultiApplicationTests
{
    @Autowired
    private UserOneMapper userOneMapper;
    
    @Autowired
    private UserTwoMapper userTwoMapper;
    
    @Test
    public void testInsert() throws Exception
    {
        userOneMapper.insert(new UserEntity("isisiwish-A", "pass-A", "isisiwish#qq.com", "10086", "question", "answer"));
        userOneMapper.insert(new UserEntity("isisiwish-B", "pass-B", "isisiwish#qq.com", "10086", "question", "answer"));
        userTwoMapper.insert(new UserEntity("isisiwish-A", "pass-A", "isisiwish#qq.com", "10086", "question", "answer"));
    }
}
