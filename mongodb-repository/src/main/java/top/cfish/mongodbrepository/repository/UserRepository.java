package top.cfish.mongodbrepository.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import top.cfish.mongodbrepository.entity.User;

/**
 * @author: isisiwish
 * @date: 2019/5/17
 * @time: 14:05
 */
public interface UserRepository extends MongoRepository<User, Long>
{
    User findByUsername(String username);
    
    @Override
    Page<User> findAll(Pageable pageable);
}
