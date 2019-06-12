package top.cfish.redisbasic.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.cfish.redisbasic.RedisBasicApplicationTests;
import top.cfish.redisbasic.entity.User;

import java.util.*;

/**
 * @author: isisiwish
 * @date: 2019/5/15
 * @time: 15:33
 */
@Slf4j
public class RedisServiceTest extends RedisBasicApplicationTests
{
    @Autowired
    private RedisService redisService;
    
    @Test
    public void stringTest() throws Exception
    {
        redisService.set("key", "value");
        Assert.assertEquals("value", redisService.get("key"));
    }
    
    @Test
    public void arrayTest() throws Exception
    {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        redisService.set("arr", arr);
        Object obj = redisService.get("arr");
        log.info("{}", obj);
    }
    
    @Test
    public void listTest() throws Exception
    {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        
        redisService.set("list", list);
        Object obj = redisService.get("list");
        log.info("{}", obj);
    }
    
    @Test
    public void setTest() throws Exception
    {
        Set set = new HashSet();
        set.add(1);
        set.add(2);
        set.add(3);
        
        redisService.set("set", set);
        Object obj = redisService.get("set");
        log.info("{}", obj);
    }
    
    @Test
    public void hashTest() throws Exception
    {
        Map hash = new HashMap();
        hash.put(1, "one");
        hash.put(2, "two");
        hash.put(3, "three");
        
        redisService.set("hash", hash);
        Object obj = redisService.get("hash");
        log.info("{}", obj);
    }
    
    @Test
    public void objTest() throws Exception
    {
        User user = new User("isisiwish", "pass", "isisiwish#qq.com", "1008611", "question", "answer");
        redisService.set("user", user);
        User redisUser = (User)redisService.get("user");
        log.info("{}", JSON.toJSONString(redisUser));
    }
    
    @Test
    public void setExpireTimeTest() throws InterruptedException
    {
        redisService.set("time", "10s", 5L);
        Thread.sleep(3000);
        String time = (String)redisService.get("time");
        Assert.assertEquals("10s", time);
        Thread.sleep(3000);
        time = (String)redisService.get("time");
        Assert.assertEquals(null, time);
    }
    
    @Test
    public void existsTest()
    {
        redisService.set("k1", "v1");
        boolean rs = redisService.exists("k1");
        Assert.assertEquals(true, rs);
        
        rs = redisService.exists("k2");
        Assert.assertEquals(false, rs);
    }
    
    @Test
    public void removeTest()
    {
        redisService.set("k1", "v1");
        redisService.remove("k1");
        boolean rs = redisService.exists("k1");
        Assert.assertEquals(false, rs);
    }
    
    @Test
    public void removeAllTest()
    {
        redisService.set("k10", "v10");
        redisService.set("k20", "v20");
        redisService.remove("k10", "k20");
        boolean rs1 = redisService.exists("k10");
        boolean rs2 = redisService.exists("k20");
        Assert.assertEquals(false, rs1);
        Assert.assertEquals(false, rs2);
    }
    
    @Test
    public void removePatternTest()
    {
        redisService.set("k10", "v10");
        redisService.set("k20", "v20");
        redisService.set("k30", "v10");
        redisService.set("key20", "v20");
        // 不支持正则
        // redisService.removePattern("k\\d+");
        // 支持基本的模式匹配
        redisService.removePattern("key*");
        Assert.assertEquals(true, redisService.exists("k10"));
        Assert.assertEquals(true, redisService.exists("k20"));
        Assert.assertEquals(true, redisService.exists("k30"));
        Assert.assertEquals(false, redisService.exists("key20"));
    }
    
    @Test
    public void hashSetTest()
    {
        Map<Integer, String> hashMap = new HashMap();
        hashMap.put(1, "one");
        hashMap.put(2, "two");
        hashMap.put(3, "three");
        
        for (Integer key : hashMap.keySet())
        {
            redisService.hashSet("hash:key1", key, hashMap.get(key));
        }
    }
    
    @Test
    public void hashGetTest()
    {
        String v1 = (String)redisService.hashGet("hash:key1", 1);
        String v2 = (String)redisService.hashGet("hash:key1", 2);
        String v3 = (String)redisService.hashGet("hash:key1", 3);
        Assert.assertEquals("one", v1);
        Assert.assertEquals("two", v2);
        Assert.assertEquals("three", v3);
    }
    
    @Test
    public void pushTest()
    {
        redisService.push("mq:order", 1);
        redisService.push("mq:order", 2);
        redisService.push("mq:order", 3);
    }
    
    @Test
    public void rangeTest()
    {
        List<Object> list = redisService.range("mq:order", 0, -1);
        log.info("{}", JSON.toJSONString(list));
    }
}
