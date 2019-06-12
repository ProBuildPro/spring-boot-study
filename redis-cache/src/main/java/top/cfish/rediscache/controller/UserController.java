package top.cfish.rediscache.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.cfish.rediscache.entity.UserEntity;
import top.cfish.rediscache.mapper.UserMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: isisiwish
 * @date: 2019/5/14
 * @time: 16:04
 */
@Slf4j
@RestController
public class UserController
{
    @Autowired
    private UserMapper userMapper;
    
    @RequestMapping("/getUser")
    @Cacheable(value = "userCache")
    public UserEntity getUser(Integer id)
    {
        UserEntity user = userMapper.getOne(id);
        log.info("noCache - {}", JSON.toJSONString(user));
        return user;
    }
    
    @RequestMapping("/getUserByUsername")
    @Cacheable(value = "userCache", key = "#username")
    public UserEntity getUserByUsernameAndPassword(String username)
    {
        UserEntity user = userMapper.getUserByUsername(username);
        log.info("noCache - {}", JSON.toJSONString(user));
        return user;
    }
    
    @RequestMapping("/getUserByUsernameAndPassword")
    @Cacheable(value = "userCache", key = "#username", condition = "#username.length() >= 8")
    public UserEntity getUserByUsernameAndPassword(String username, String password)
    {
        Map paramMap = new HashMap();
        paramMap.put("username", username);
        paramMap.put("password", password);
        UserEntity user = userMapper.getUser(paramMap);
        log.info("noCache - {}", JSON.toJSONString(user));
        return user;
    }
    
    @RequestMapping("/add")
    @CachePut(value = "userCache", key = "#user.username")
    public UserEntity save(@RequestBody UserEntity user)
    {
        userMapper.insert(user);
        int id = user.getId();
        UserEntity save = userMapper.getOne(id);
        return save;
    }
    
    @RequestMapping("/delete")
    @CacheEvict(value = "userCache", beforeInvocation = true, allEntries = true)
    public Integer delete(Integer id)
    {
        int rs = userMapper.delete(id);
        if (rs != 1)
        {
            throw new RuntimeException("delete user exception");
        }
        return rs;
    }
}
