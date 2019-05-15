package top.cfish.multidruid.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.cfish.multidruid.entity.UserEntity;
import top.cfish.multidruid.mapper.one.UserOneMapper;
import top.cfish.multidruid.mapper.two.UserTwoMapper;

import java.util.List;

/**
 * @author: isisiwish
 * @date: 2019/5/14
 * @time: 16:04
 */
@Slf4j
@RestController
public class UserController
{
	@Autowired
	private UserOneMapper userOneMapper;
	
	@Autowired
	private UserTwoMapper userTwoMapper;
	
	@RequestMapping("/getUserList")
	public List<UserEntity> getUsers()
	{
		List<UserEntity> usersTwo = userTwoMapper.getAll();
		List<UserEntity> usersOne = userOneMapper.getAll();
		
		usersOne.addAll(usersTwo);
		return usersOne;
	}
}
