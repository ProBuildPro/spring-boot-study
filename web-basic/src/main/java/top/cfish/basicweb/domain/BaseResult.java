package top.cfish.basicweb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: isisiwish
 * @date: 2019/6/25
 * @time: 15:01
 */
@Getter
@Setter
@AllArgsConstructor
public class BaseResult<T>
{
    private Integer code;
    
    private String msg;
    
    private Integer count;
    
    private List<T> data;
}
