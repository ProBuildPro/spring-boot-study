package top.cfish.mybatismulti.mapper.two;

import org.apache.ibatis.annotations.Param;
import top.cfish.mybatismulti.entity.UserEntity;
import top.cfish.mybatismulti.param.PageParam;

import java.util.List;

/**
 * @author: isisiwish
 * @date: 2019/5/14
 * @time: 9:29
 */
public interface UserTwoMapper
{
    UserEntity getOne(Integer id);
    
    List<UserEntity> getAll();
    
    void insert(UserEntity user);
    
    int update(UserEntity user);
    
    int delete(Integer id);
    
    List<UserEntity> getList(PageParam page);
    
    int getCount();
    
    UserEntity getUser(@Param("username") String username, @Param("password") String password);
}
