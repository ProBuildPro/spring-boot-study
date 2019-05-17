package top.cfish.mongodbmulti.repository.primary;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.cfish.mongodbmulti.entity.User;

/**
 * @author: isisiwish
 * @date: 2019/5/17
 * @time: 14:05
 */
public interface UserPrimaryRepository extends MongoRepository<User, Long>
{
}
