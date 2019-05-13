package top.cfish.basicweb.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import top.cfish.basicweb.domain.User;
import top.cfish.basicweb.domain.ValidUser;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * @author: isisiwish
 * @date: 2019/5/9
 * @time: 10:57
 */
@Slf4j
@RestController
public class WebController
{
	@GetMapping("/getUser")
	public User getUser()
	{
		User user = new User();
		user.setName("isisiwish");
		user.setAge(18);
		user.setPass("password");
		return user;
	}
	
	@GetMapping("/getUsers")
	public List<User> getUsers()
	{
		List<User> userList = new ArrayList<User>();
		
		User userA = new User();
		userA.setName("isisiwish");
		userA.setAge(18);
		userA.setPass("password");
		userList.add(userA);
		
		User userB = new User();
		userB.setName("isisiYu");
		userB.setAge(12);
		userB.setPass("password");
		userList.add(userB);
		
		return userList;
	}
	
	@PostMapping(name = "setUserForm")
	public User setUserForm(User user)
	{
		user.setAge(user.getAge() + 10);
		user.setPass(new StringBuilder(user.getPass()).reverse().toString());
		return user;
	}
	
	@PostMapping(name = "setUserJson", consumes = APPLICATION_JSON_VALUE)
	public User setUserJson(@RequestBody User user)
	{
		user.setAge(user.getAge() + 10);
		user.setPass(new StringBuilder(user.getPass()).reverse().toString());
		return user;
	}
	
	@PostMapping(value="set/{name}")
	public User setUserPath(@PathVariable String name)
	{
		User user=new User();
		user.setName(name);
		user.setAge(18);
		user.setPass("password");
		return user;
	}
	
	@RequestMapping("/saveValidUser")
	public ValidUser saveValidUser(@Valid ValidUser user, BindingResult result)
	{
		log.info("user: {}", JSON.toJSONString(user));
		if (result.hasErrors())
		{
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list)
			{
				log.info(error.getCode() + " - " + error.getDefaultMessage());
			}
			return null;
		}
		return user;
	}
}
