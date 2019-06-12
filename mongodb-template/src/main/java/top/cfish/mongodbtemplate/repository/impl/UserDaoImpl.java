package top.cfish.mongodbtemplate.repository.impl;

import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import top.cfish.mongodbtemplate.entity.User;
import top.cfish.mongodbtemplate.repository.UserDao;

/**
 * @author: isisiwish
 * @date: 2019/5/17
 * @time: 11:23
 */
@Service
public class UserDaoImpl implements UserDao
{
    @Autowired
    private MongoTemplate mongoTemplate;
    
    @Override
    public void save(User user)
    {
        mongoTemplate.save(user);
    }
    
    @Override
    public User findUserByUsername(String username)
    {
        Query query = new Query(Criteria.where("username").is(username));
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }
    
    @Override
    public long update(User user)
    {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("username", user.getUsername()).set("password", user.getPassword());
        
        // 更新查询返回结果集的第一条
        UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);
        
        // 更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
        if (result != null)
        {
            return result.getMatchedCount();
        }
        else
        {
            return 0;
        }
    }
    
    @Override
    public void deleteById(Long id)
    {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, User.class);
    }
}
