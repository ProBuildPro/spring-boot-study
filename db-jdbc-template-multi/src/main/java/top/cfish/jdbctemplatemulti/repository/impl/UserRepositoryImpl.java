package top.cfish.jdbctemplatemulti.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import top.cfish.jdbctemplatemulti.entity.User;
import top.cfish.jdbctemplatemulti.repository.UserRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: isisiwish
 * @date: 2019/5/24
 * @time: 10:58
 */
@Repository
public class UserRepositoryImpl implements UserRepository
{
    @Autowired
    private JdbcTemplate primaryJdbcTemplate;
    
    
    @Override
    public int save(User user, JdbcTemplate jdbcTemplate)
    {
        if (jdbcTemplate == null)
        {
            jdbcTemplate = primaryJdbcTemplate;
        }
        
        return jdbcTemplate.update("INSERT INTO user(name, password, age) values(?, ?, ?)", user.getName(), user.getPassword(), user.getAge());
    }
    
    @Override
    public int update(User user, JdbcTemplate jdbcTemplate)
    {
        if (jdbcTemplate == null)
        {
            jdbcTemplate = primaryJdbcTemplate;
        }
        
        return jdbcTemplate.update("UPDATE user SET name = ? , password = ? , age = ? WHERE id=?", user.getName(), user.getPassword(), user.getAge(), user.getId());
    }
    
    @Override
    public int delete(Long id, JdbcTemplate jdbcTemplate)
    {
        if (jdbcTemplate == null)
        {
            jdbcTemplate = primaryJdbcTemplate;
        }
        
        return jdbcTemplate.update("DELETE FROM user where id = ? ", id);
    }
    
    @Override
    public User findById(Long id, JdbcTemplate jdbcTemplate)
    {
        if (jdbcTemplate == null)
        {
            jdbcTemplate = primaryJdbcTemplate;
        }
        
        return jdbcTemplate.queryForObject("SELECT * FROM user WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<User>(User.class));
    }
    
    @Override
    public List<User> findALL(JdbcTemplate jdbcTemplate)
    {
        if (jdbcTemplate == null)
        {
            jdbcTemplate = primaryJdbcTemplate;
        }
        
        return jdbcTemplate.query("SELECT * FROM user", new UserRowMapper());
    }
    
    class UserRowMapper implements RowMapper<User>
    {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException
        {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setAge(rs.getInt("age"));
            return user;
        }
    }
}
