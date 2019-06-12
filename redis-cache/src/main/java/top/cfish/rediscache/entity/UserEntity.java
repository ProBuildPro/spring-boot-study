package top.cfish.rediscache.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: isisiwish
 * @date: 2019/5/14
 * @time: 9:21
 */
@Getter
@Setter
public class UserEntity implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String question;
    private String answer;
    private Integer role;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    
    public UserEntity()
    {
        super();
    }
    
    public UserEntity(String username, String password, String email, String phone, String question, String answer, Integer role, Date createTime, Date updateTime)
    {
        super();
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.question = question;
        this.answer = answer;
        this.role = role;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
    
    public UserEntity(String username, String password, String email, String phone, String question, String answer, Integer role)
    {
        this(username, password, email, phone, question, answer, role, new Date(), new Date());
    }
    
    public UserEntity(String username, String password, String email, String phone, String question, String answer)
    {
        this(username, password, email, phone, question, answer, 1, new Date(), new Date());
    }
}
