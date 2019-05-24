package top.cfish.mybatisannotationmulti.mapper.one;

import org.apache.ibatis.annotations.*;
import top.cfish.mybatisannotationmulti.entity.UserEntity;
import top.cfish.mybatisannotationmulti.mapper.UserSql;
import top.cfish.mybatisannotationmulti.param.PageParam;

import java.util.List;

/**
 * @author: isisiwish
 * @date: 2019/5/14
 * @time: 9:29
 */
public interface UserOneMapper
{
	@Select("SELECT * FROM user WHERE id = #{id}")
	@Results({@Result(property = "createTime", column = "creat_time"), @Result(property = "updateTime", column = "update_time")})
	UserEntity getOne(Integer id);
	
	@Select("SELECT * FROM user")
	@Results({@Result(property = "createTime", column = "create_time"), @Result(property = "updateTime", column = "update_time")})
	List<UserEntity> getAll();
	
	@Insert("INSERT INTO user (username,password,email,phone,question,answer,role,create_time,update_time) VALUES (#{username}, #{password}, #{email}, #{phone}, #{question}, #{answer}, #{role}, now(), now())")
	void insert(UserEntity user);
	
	@Update("UPDATE user SET username = #{username},password = #{password},email = #{email},phone = #{phone},question = #{question},answer = #{answer},update_time = now() WHERE id =#{id}")
	int update(UserEntity user);
	
	@Delete("DELETE FROM user WHERE id =#{id}")
	int delete(Integer id);
	
	@SelectProvider(type = UserSql.class, method = "getUser")
	UserEntity getUser(@Param("username") String username, @Param("password") String password);
	
	@SelectProvider(type = UserSql.class, method = "getList")
	List<UserEntity> getList(PageParam page);
	
	@SelectProvider(type = UserSql.class, method = "getCount")
	int getCount();
}
