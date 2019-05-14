package top.cfish.mybatis.annotation.param;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: isisiwish
 * @date: 2019/5/14
 * @time: 10:36
 */
@Setter
@Getter
@AllArgsConstructor
public class PageParam
{
	private Integer pageNum = 0;
	
	private Integer pageSize = 10;
}
