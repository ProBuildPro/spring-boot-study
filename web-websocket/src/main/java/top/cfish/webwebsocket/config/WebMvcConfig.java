package top.cfish.webwebsocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: isisiwish
 * @date: 2019/5/21
 * @time: 10:49
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer
{
	/**
	 * 静态资源加载配置
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}
}
