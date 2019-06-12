package top.cfish.basicweb.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import top.cfish.basicweb.BasicWebApplicationTests;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author: isisiwish
 * @date: 2019/5/9
 * @time: 10:27
 */
public class HelloWorldControllerTest extends BasicWebApplicationTests
{
    private MockMvc mockMvc;
    
    @Before
    public void setUp() throws Exception
    {
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }
    
    @Test
    public void getHello() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.post("/hello?name=isisiwish").accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }
}
