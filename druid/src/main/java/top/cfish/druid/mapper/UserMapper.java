package top.cfish.druid.mapper;

import org.apache.ibatis.annotations.Param;
import top.cfish.druid.entity.UserEntity;
import top.cfish.druid.param.PageParam;

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
	
	List<UserEntity> getList(PageParam page);
	
	int getCount();
	
	UserEntity getUser(@Param("username") String username, @Param("password") String password);

	// for test
	List<UserEntity> testSlowSql();
}
