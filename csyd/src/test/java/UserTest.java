import com.csyd.core.service.UserService;
import com.csyd.core.util.MD5;
import com.csyd.pojo.SysUser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    private UserService userService;

    @Test
    public void testAddUser(){
        SysUser user = new SysUser();
        user.setUserName("admin");
        user.setUserFlag("1");
        user.setUserPassword(MD5.getInstance().getMD5ofStr("admin"));
        int count = userService.add(user);
        System.out.println(count);
    }

    @Test
    public void changepwd(){

    }

    @Test
    public void testLogin(){
        SysUser user = userService.login("admin",MD5.getInstance().getMD5ofStr("admin"));
        System.out.println(user.getUserName());
    }

    @Before
    public void init(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = ctx.getBean("userService",UserService.class);
    }
}
