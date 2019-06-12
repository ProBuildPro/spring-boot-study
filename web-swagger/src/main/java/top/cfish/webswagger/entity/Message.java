package top.cfish.webswagger.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

/**
 * @author: isisiwish
 * @date: 2019/5/23
 * @time: 14:46
 */
@Getter
@Setter
public class Message
{
    private Long id;
    @ApiModelProperty(value = "消息体")
    private String text;
    @ApiModelProperty(value = "消息总结")
    private String summary;
    private Calendar created = Calendar.getInstance();
}
