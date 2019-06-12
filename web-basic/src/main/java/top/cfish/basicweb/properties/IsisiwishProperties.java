package top.cfish.basicweb.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: isisiwish
 * @date: 2019/5/10
 * @time: 20:10
 */
@Getter
@Setter
@Component
public class IsisiwishProperties
{
    @Value("${top.cfish.title}")
    private String title;
    
    @Value("${top.cfish.description}")
    private String description;
}
