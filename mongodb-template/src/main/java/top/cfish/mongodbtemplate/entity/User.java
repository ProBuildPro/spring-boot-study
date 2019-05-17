package top.cfish.mongodbtemplate.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: isisiwish
 * @date: 2019/5/17
 * @time: 11:21
 */
@Getter
@Setter
public class User
{
	private Long id;
	private String username;
	private String password;
}
