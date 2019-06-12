package top.cfish.mybatis.annotation.mapper;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.cfish.mybatis.annotation.MybatisAnnotationApplicationTests;
import top.cfish.mybatis.annotation.entity.UserEntity;
import top.cfish.mybatis.annotation.param.PageParam;

import java.util.List;
import java.util.UUID;

/**
 * @author: isisiwish
 * @date: 2019/5/14
 * @time: 15:05
 */
@Slf4j
public class UserMapperTest extends MybatisAnnotationApplicationTests
{
    @Autowired
    UserMapper userMapper;
    
    @Test
    public void getOne()
    {
        UserEntity user = userMapper.getOne(1);
        log.info("{}", JSON.toJSONString(user));
    }
    
    @Test
    public void getAll()
    {
        List<UserEntity> userList = userMapper.getAll();
        log.info("{}", JSON.toJSONString(userList.get(userList.size() - 1)));
    }
    
    @Test
    public void insert()
    {
        UserEntity user = new UserEntity("isisiwish-mybatis-annotation", "pass", "isisiwish#qq.com", "1008611", "question", "answer");
        userMapper.insert(user);
    }
    
    @Test
    public void update()
    {
        UserEntity user = userMapper.getOne(1);
        user.setUsername(user.getUsername() + "-anno");
        int rs = userMapper.update(user);
        log.info("{}", rs);
    }
    
    @Test
    public void delete()
    {
        userMapper.delete(3);
    }
    
    private String randomUsername()
    {
        UUID uuid = UUID.randomUUID();
        String[] split = uuid.toString().split("-");
        StringBuilder sb = new StringBuilder();
        sb.append("isisiwish-").append(split[0]);
        return sb.toString();
    }
    
    @Test
    public void insertTest()
    {
        UserEntity user = new UserEntity("isisiwish-anno-", "pass", "isisiwish#qq.com", "1008611", "question", "answer");
        for (int i = 0; i < 100; i++)
        {
            user.setUsername(randomUsername());
            userMapper.insert(user);
        }
    }
    
    @Test
    public void getUser()
    {
        UserEntity user = userMapper.getUser("isisiwish-mybatis", "pass");
        log.info("{}", JSON.toJSONString(user));
    }
    
    @Test
    public void getList()
    {
        List<UserEntity> userList = userMapper.getList(new PageParam(0, 10));
        for (UserEntity user : userList)
        {
            log.info("id:{} username:{}", user.getId(), user.getUsername());
        }
    }
    
    @Test
    public void getCount()
    {
        int count = userMapper.getCount();
        log.info("{}", count);
    }
}
