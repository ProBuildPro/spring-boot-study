package top.cfish.jdbctemplatemulti.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: isisiwish
 * @date: 2019/5/24
 * @time: 10:57
 */
@Getter
@Setter
public class User
{
    private Long id;
    private String name;
    private String password;
    private int age;
    
    public User()
    {
    }
    
    public User(String name, String password, int age)
    {
        this.name = name;
        this.password = password;
        this.age = age;
    }
    
    public User(String name, String password)
    {
        this.name = name;
        this.password = password;
        this.age = 0;
    }
}
