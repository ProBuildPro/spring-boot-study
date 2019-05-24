package top.cfish.jdbctemplate.repository;

import top.cfish.jdbctemplate.entity.User;

import java.util.List;

/**
 * @author: isisiwish
 * @date: 2019/5/24
 * @time: 10:58
 */
public interface UserRepository
{
	int save(User user);
	
	int update(User user);
	
	int delete(Long id);
	
	List<User> findALL();
	
	User findById(Long id);
}
