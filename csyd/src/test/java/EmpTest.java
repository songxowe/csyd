import com.csyd.core.service.EmpService;
import com.csyd.core.service.RoleService;
import com.csyd.core.util.MD5;
import com.csyd.pojo.Employee;
import com.csyd.pojo.SysUser;
import com.csyd.pojo.SysUserRole;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpTest {
    private EmpService empService;

    @Test
    public void add(){
        SysUser sysUser=new SysUser();
        sysUser.setUserName("1214");
        sysUser.setUserPassword(MD5.getInstance().getMD5ofStr("1213"));
        int countsys = empService.addUser(sysUser);
        //拿到账户的user_id
        Integer userId=empService.findId(sysUser.getUserName());
        SysUserRole ur=new SysUserRole();
        ur.setRoleId(5);
        ur.setUserId(userId);
        int coun = empService.addUr(ur);


        Employee e=new Employee();
        e.setJob("员工");
        e.setName("李坤");
        e.setSex("女");
        e.setPhone("5555");
        e.setOrganId("1");
        e.setUserId(userId);
        int countAdd = empService.addEmp(e);
        System.out.println(countAdd + "+++" + "+++" + countsys + "+++" + coun);
    }
    @Before
    public void init(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        empService = ctx.getBean("empService",EmpService.class);
    }
}
