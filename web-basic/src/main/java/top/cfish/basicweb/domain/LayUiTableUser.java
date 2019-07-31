package top.cfish.basicweb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: isisiwish
 * @date: 2019/6/25
 * @time: 14:42
 */
@Getter
@Setter
@AllArgsConstructor
public class LayUiTableUser
{
    // ID
    private Long id;
    
    // 用户名
    private String username;
    
    // 性别
    private String sex;
    
    // 城市
    private String city;
    
    // 签名
    private String sign;
    
    // 积分
    private Integer experience;
    
    //评分
    private Double score;
    
    // 职业
    private String classify;
    
    // 财富
    private Integer wealth;
}
