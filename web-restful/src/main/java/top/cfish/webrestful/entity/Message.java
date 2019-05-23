package top.cfish.webrestful.entity;

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
	private String text;
	private String summary;
	private Calendar created = Calendar.getInstance();
}
