package top.cfish.basicweb.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * @author: isisiwish
 * @date: 2019/5/10
 * @time: 17:55
 */
@Getter
@Setter
public class ValidUser
{
	@NotEmpty(message = "姓名不能为空")
	private String name;
	
	@Max(value = 100, message = "年龄不能大于100岁")
	@Min(value = 18, message = "年龄必须超过18岁")
	private int age;
	
	@NotEmpty(message = "密码不能为空")
	@Length(min = 6, message = "密码长度不能小于6位")
	private String pass;
}
