import com.csyd.core.service.MenuService;
import com.csyd.core.service.RoleService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RoleTest {
    private RoleService roleService;

    @Test
    public void remove(){
        int count = roleService.remove(2);
        System.out.println(count);
    }

    @Before
    public void init(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        roleService = ctx.getBean("roleService",RoleService.class);
    }
}
