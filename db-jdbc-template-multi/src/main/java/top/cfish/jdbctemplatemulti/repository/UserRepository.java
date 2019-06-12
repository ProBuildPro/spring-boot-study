package top.cfish.jdbctemplatemulti.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import top.cfish.jdbctemplatemulti.entity.User;

import java.util.List;

/**
 * @author: isisiwish
 * @date: 2019/5/24
 * @time: 10:58
 */
public interface UserRepository
{
    int save(User user, JdbcTemplate jdbcTemplate);
    
    int update(User user, JdbcTemplate jdbcTemplate);
    
    int delete(Long id, JdbcTemplate jdbcTemplate);
    
    List<User> findALL(JdbcTemplate jdbcTemplate);
    
    User findById(Long id, JdbcTemplate jdbcTemplate);
}
