package top.cfish.mongodbtemplate.repository;

import top.cfish.mongodbtemplate.entity.User;

/**
 * @author: isisiwish
 * @date: 2019/5/17
 * @time: 11:22
 */
public interface UserDao
{
    void save(User user);
    
    User findUserByUsername(String username);
    
    long update(User user);
    
    void deleteById(Long id);
}
