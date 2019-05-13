package top.cfish.basicjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.cfish.basicjpa.entity.UserDetail;
import top.cfish.basicjpa.entity.UserInfo;

import java.util.List;

/**
 * @author: isisiwish
 * @date: 2019/5/13
 * @time: 16:00
 */
public interface UserDetailRepository extends JpaRepository<UserDetail, Long>
{
	@Query("select u.userName as userName, u.email as email, d.address as address , d.hobby as hobby " +
			"from User u, UserDetail d " +
			"where u.id = d.userId and d.hobby = ?1")
	List<UserInfo> findUserInfo(String hobby);
}
