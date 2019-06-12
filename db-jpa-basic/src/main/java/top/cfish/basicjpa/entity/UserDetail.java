package top.cfish.basicjpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author: isisiwish
 * @date: 2019/5/13
 * @time: 15:56
 */
@Getter
@Setter
public class UserDetail implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String userId;
    
    @Column(nullable = true)
    private String address;
    
    @Column(nullable = true)
    private String hobby;
}
