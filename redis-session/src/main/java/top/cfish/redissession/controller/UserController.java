package top.cfish.redissession.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.cfish.redissession.entity.UserEntity;
import top.cfish.redissession.mapper.UserMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: isisiwish
 * @date: 2019/5/16
 * @time: 14:52
 */
@RestController
public class UserController
{
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value = "/setSession")
	public Map<String, Object> setSession(HttpServletRequest request)
	{
		Map<String, Object> map = new HashMap<>();
		request.getSession().setAttribute("message", request.getRequestURL());
		map.put("requestUrl", request.getRequestURL());
		return map;
	}
	
	@RequestMapping(value = "/getSession")
	public Object getSession(HttpServletRequest request)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("sessionId", request.getSession().getId());
		map.put("message", request.getSession().getAttribute("message"));
		return map;
	}
	
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request)
	{
		String msg = "index content";
		Object user = request.getSession().getAttribute("user");
		if (user == null)
		{
			msg = "please login first";
		}
		return msg;
	}
	
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, String username, String password)
	{
		String msg = "logon failure";
		UserEntity user = userMapper.getUserByUsername(username);
		if (user != null && user.getPassword().equals(password))
		{
			request.getSession().setAttribute("user", user);
			msg = "login successful";
		}
		return msg;
	}
	
	@RequestMapping(value = "/loginout")
	public String loginout(HttpServletRequest request)
	{
		request.getSession().removeAttribute("user");
		return "loginout successful";
	}
}
