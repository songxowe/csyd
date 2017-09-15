import com.csyd.joiner.service.MyJoinerService;
import com.csyd.pojo.Joiner1;
import com.csyd.pojo.SysUser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class JoinerTest {
    private MyJoinerService myJoinerService;

    @Test
    public void add(){
        Joiner1 joiner=new Joiner1();
        joiner.setOrganId(1);
        joiner.setJoinerName("张三");
        joiner.setJoinerPhone("123456456");
        joiner.setJoinerLoc("长沙市");
        joiner.setJoinerBank("中国银行");
        joiner.setJoinerHolder("李四");
        joiner.setJoinerBanknum("123456");
        joiner.setJoHeigherId(1);
        joiner.setJoinerDate(new Date());
        joiner.setJoLevelId(2);
        joiner.setUserId(25);

        int count=myJoinerService.addJoienr(joiner);
        System.out.println(count);
    }

    @Test
    public void  findById(){
        Joiner1 joiner1 = myJoinerService.findByUserId(25);
        System.out.println(joiner1.toString());
    }

    @Before
    public void init(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        myJoinerService = ctx.getBean("myJoinerService",MyJoinerService.class);
    }
}
