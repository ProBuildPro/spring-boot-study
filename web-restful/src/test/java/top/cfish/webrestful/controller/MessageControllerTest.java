package top.cfish.webrestful.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import top.cfish.webrestful.WebRestfulApplicationTests;

/**
 * @author: isisiwish
 * @date: 2019/5/23
 * @time: 16:28
 */
@Slf4j
public class MessageControllerTest extends WebRestfulApplicationTests
{
	@Autowired
	private WebApplicationContext applicationContext;
	
	private MockMvc mockMvc;
	
	private void saveMessages()
	{
		for (int i = 1; i < 10; i++)
		{
			final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
			params.add("text", "text" + i);
			params.add("summary", "summary" + i);
			try
			{
				MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/message").params(params)).andReturn();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	@Before
	public void setup()
	{
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.applicationContext).build();
		saveMessages();
	}
	
	@Test
	public void saveMessage() throws Exception
	{
		final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("text", "text");
		params.add("summary", "summary");
		String mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/message").params(params)).andReturn().getResponse().getContentAsString();
		log.info("{}", mvcResult);
	}
	
	@Test
	public void getAllMessages() throws Exception
	{
		String mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/messages")).andReturn().getResponse().getContentAsString();
		log.info("{}", mvcResult);
	}
	
	@Test
	public void getMessage() throws Exception
	{
		String mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/message/6")).andReturn().getResponse().getContentAsString();
		log.info("{}", mvcResult);
	}
	
	@Test
	public void modifyMessage() throws Exception
	{
		final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("id", "6");
		params.add("text", "text");
		params.add("summary", "summary");
		String mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/message").params(params)).andReturn().getResponse().getContentAsString();
		log.info("{}", mvcResult);
	}
	
	@Test
	public void patchMessage() throws Exception
	{
		final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("id", "6");
		params.add("text", "text");
		String mvcResult = mockMvc.perform(MockMvcRequestBuilders.patch("/message/text").params(params)).andReturn().getResponse().getContentAsString();
		log.info("{}", mvcResult);
	}
	
	@Test
	public void deleteMessage() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.delete("/message/6")).andReturn();
		String mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/messages")).andReturn().getResponse().getContentAsString();
		log.info("{}", mvcResult);
	}
}
