package top.cfish.basicjpa.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.cfish.basicjpa.BasicJpaApplicationTests;
import top.cfish.basicjpa.entity.UserInfo;

import java.util.List;

/**
 * @author: isisiwish
 * @date: 2019/5/13
 * @time: 16:01
 */
public class UserDetailRepositoryTest extends BasicJpaApplicationTests
{
    @Autowired
    UserDetailRepository userDetailRepository;
    
    @Test
    public void testUserInfo()
    {
        List<UserInfo> userInfos = userDetailRepository.findUserInfo("打球");
        for (UserInfo userInfo : userInfos)
        {
            System.out.println("addree " + userInfo.getAddress());
        }
    }
}
