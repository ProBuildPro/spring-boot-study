package top.cfish.redissession.mapper;


import org.springframework.data.repository.query.Param;
import top.cfish.redissession.entity.UserEntity;

import java.util.List;

/**
 * @author: isisiwish
 * @date: 2019/5/14
 * @time: 9:29
 */
public interface UserMapper
{
	UserEntity getOne(Integer id);
	
	List<UserEntity> getAll();
	
	void insert(UserEntity user);
	
	int update(UserEntity user);
	
	int delete(Integer id);
	
	int getCount();
	
	UserEntity getUser(@Param("username") String username, @Param("password") String password);
	
	UserEntity getUserByUsername(String username);
}
