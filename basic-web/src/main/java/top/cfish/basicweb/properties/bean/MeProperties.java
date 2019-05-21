package top.cfish.basicweb.properties.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: isisiwish
 * @date: 2019/5/21
 * @time: 8:30
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "top.cfish")
public class MeProperties
{
	private String title;
	private String description;
}
