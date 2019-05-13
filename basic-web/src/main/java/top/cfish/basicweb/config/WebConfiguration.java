package top.cfish.basicweb.config;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.cfish.basicweb.filter.MyFilter;

/**
 * @author: isisiwish
 * @date: 2019/5/10
 * @time: 20:04
 */
@Configuration
public class WebConfiguration
{
	@Bean
	public RemoteIpFilter remoteIpFilter()
	{
		return new RemoteIpFilter();
	}
	
	@Bean
	public FilterRegistrationBean filterregistration()
	{
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new MyFilter());
		registration.addUrlPatterns("/*");
		registration.addInitParameter("paramName", "paramValue");
		registration.setName("MyFilter");
		registration.setOrder(1);
		return registration;
	}
}
