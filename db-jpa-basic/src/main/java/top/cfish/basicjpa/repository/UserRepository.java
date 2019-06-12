package top.cfish.basicjpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import top.cfish.basicjpa.entity.User;

import java.util.List;

/**
 * @author: isisiwish
 * @date: 2019/5/13
 * @time: 14:47
 */
public interface UserRepository extends JpaRepository<User, Long>
{
    User findByUserName(String userName);
    
    User findByUserNameOrEmail(String username, String email);
    
    @Query("select u from User u")
    Page<User> findALL(Pageable pageable);
    
    Page<User> findByNickNameContaining(String nickName, Pageable pageable);
    
    User findFirstByOrderByLastnameAsc();
    
    User findTopByOrderByAgeDesc();
    
    Page<User> queryFirst10ByLastname(String lastname, Pageable pageable);
    
    List<User> findFirst10ByLastname(String lastname, Sort sort);
    
    List<User> findTop10ByLastname(String lastname, Pageable pageable);
    
    @Transactional(timeout = 10)
    @Modifying
    @Query("update User set userName = ?1 where id = ?2")
    int modifyById(String userName, Long id);
    
    @Override
    @Transactional
    @Modifying
    @Query("delete from User where id = ?1")
    void deleteById(Long id);
    
    @Query("select u from User u where u.email = ?1")
    User findByEmail(String email);
}
