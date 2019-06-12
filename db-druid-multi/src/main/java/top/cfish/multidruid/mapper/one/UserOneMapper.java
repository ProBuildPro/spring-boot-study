package top.cfish.multidruid.mapper.one;

import top.cfish.multidruid.entity.UserEntity;

import java.util.List;

/**
 * @author: isisiwish
 * @date: 2019/5/14
 * @time: 9:29
 */
public interface UserOneMapper
{
    UserEntity getOne(Integer id);
    
    List<UserEntity> getAll();
    
    void insert(UserEntity user);
    
    int update(UserEntity user);
    
    int delete(Integer id);
    
    int getCount();
}
