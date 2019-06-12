package top.cfish.elasticsearch.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author: isisiwish
 * @date: 2019/5/24
 * @time: 16:29
 */
@Getter
@Setter
@Document(indexName = "customer", type = "customer", shards = 1, replicas = 0, refreshInterval = "-1")
public class Customer
{
    // @Id注解，在ElasticSearch里相当于该列是主键了，在查询时可以直接用主键查询
    @Id
    private String id;
    
    private String username;
    
    private String address;
    
    private int age;
    
    public Customer()
    {
    }
    
    public Customer(String username, String address, int age)
    {
        this.username = username;
        this.address = address;
        this.age = age;
    }
}
