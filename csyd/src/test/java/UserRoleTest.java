import com.csyd.core.service.MenuService;
import com.csyd.core.service.UserRoleService;
import com.csyd.core.util.Pager;
import com.csyd.pojo.SysRole;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserRoleTest {
    private UserRoleService userRoleService;

    @Test
    public void findPager(){
        Pager<SysRole> roles = userRoleService.findPager(0,5,"userId","asc",null,null,null,null,1);
        for(SysRole role:roles.getRows()){
            System.out.println(role.getRoleName());
        }
    }

    @Before
    public void init(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        userRoleService = ctx.getBean("userRoleService",UserRoleService.class);
    }
}
