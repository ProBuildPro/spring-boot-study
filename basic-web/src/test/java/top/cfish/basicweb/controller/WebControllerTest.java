package top.cfish.basicweb.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.cfish.basicweb.BasicWebApplicationTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author: isisiwish
 * @date: 2019/5/9
 * @time: 11:00
 */
public class WebControllerTest extends BasicWebApplicationTests
{
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception
	{
		mockMvc = MockMvcBuilders.standaloneSetup(new WebController()).build();
	}
	
	@Test
	public void getUser() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/getUser")).andDo(print());
	}
	
	@Test
	public void getUsers() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/getUsers")).andDo(print());
	}
	
	@Test
	public void setUserForm() throws Exception
	{
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
													.post("/setUserForm")
													.param("name", "isisiwish")
													.param("age", "18")
													.param("pass", "password");
		mockMvc.perform(builder).andDo(print());
	}
	
	@Test
	public void setUserJson() throws Exception
	{
		String json = "{\n" + "  \"name\": \"isisiwish\",\n" + "  \"age\": 18,\n" + "  \"pass\": \"password\"\n" + "}";
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/setUserJson")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json);
		
		mockMvc.perform(builder).andDo(print());
	}
	
	
	@Test
	public void setUserPath() throws Exception
	{
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/set/{name}", "isisiwish");
		mockMvc.perform(builder).andDo(print());
	}
	
	@Test
	public void saveValidUser() throws Exception
	{
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/saveValidUser")
				.param("name", "isisiwish")
				.param("age", "16")
				.param("pass", "password");
		
		mockMvc.perform(builder).andDo(print());
	}
}
