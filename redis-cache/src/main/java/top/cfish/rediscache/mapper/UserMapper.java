package top.cfish.rediscache.mapper;

import top.cfish.rediscache.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * @author: isisiwish
 * @date: 2019/5/14
 * @time: 9:29
 */
public interface UserMapper
{
	UserEntity getOne(Integer id);
	
	List<UserEntity> getAll();
	
	int insert(UserEntity user);
	
	int update(UserEntity user);
	
	int delete(Integer id);
	
	int getCount();
	
	UserEntity getUser(Map paramMap);
	
	UserEntity getUserByUsername(String username);
}
