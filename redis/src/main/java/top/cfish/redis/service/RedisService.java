package top.cfish.redis.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author: isisiwish
 * @date: 2019/5/15
 * @time: 14:22
 */
@Slf4j
@Service
public class RedisService
{
	@Autowired
	private RedisTemplate redisTemplate;
	
	public boolean set(final String key, Object value)
	{
		boolean result = false;
		try
		{
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			operations.set(key, value);
			result = true;
		}
		catch (Exception e)
		{
			log.error("set error: key {}, value {}", key, value, e);
		}
		return result;
	}
	
	public boolean set(final String key, Object value, Long expireTime)
	{
		boolean result = false;
		try
		{
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			operations.set(key, value);
			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			result = true;
		}
		catch (Exception e)
		{
			log.error("set error: key {}, value {},expireTime {}", key, value, expireTime, e);
		}
		return result;
	}
	
	public boolean exists(final String key)
	{
		return redisTemplate.hasKey(key);
	}
	
	public Object get(final String key)
	{
		Object result = null;
		ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
		result = operations.get(key);
		return result;
	}
	
	public void remove(final String key)
	{
		if (exists(key))
		{
			redisTemplate.delete(key);
		}
	}
	
	public void remove(final String...keys)
	{
		for (String key : keys)
		{
			remove(key);
		}
	}
	
	public void removePattern(final String pattern)
	{
		Set<Serializable> keys = redisTemplate.keys(pattern);
		if (keys.size() > 0)
		{
			redisTemplate.delete(keys);
		}
	}
	
	public void hashSet(String key, Object hashKey, Object value)
	{
		HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
		hash.put(key, hashKey, value);
	}
	
	public Object hashGet(String key, Object hashKey)
	{
		HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
		return hash.get(key, hashKey);
	}
	
	public void push(String k, Object v)
	{
		ListOperations<String, Object> list = redisTemplate.opsForList();
		list.rightPush(k, v);
	}
	
	public List<Object> range(String k, long l, long l1)
	{
		ListOperations<String, Object> list = redisTemplate.opsForList();
		return list.range(k, l, l1);
	}
	
	public void setAdd(String key, Object value)
	{
		SetOperations<String, Object> set = redisTemplate.opsForSet();
		set.add(key, value);
	}
	
	public Set<Object> setMembers(String key)
	{
		SetOperations<String, Object> set = redisTemplate.opsForSet();
		return set.members(key);
	}
	
	public void zAdd(String key, Object value, double scoure)
	{
		ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
		zset.add(key, value, scoure);
	}
	
	public Set<Object> rangeByScore(String key, double scoure, double scoure1)
	{
		ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
		return zset.rangeByScore(key, scoure, scoure1);
	}
}
