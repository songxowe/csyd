import com.csyd.core.service.OrganService;
import com.csyd.core.util.Pager;
import com.csyd.pojo.Organ;
import org.aspectj.weaver.ast.Or;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class OrganTest {
    private OrganService organService;
    @Before
    public void init(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        organService = ctx.getBean("organService",OrganService.class);
    }

    @Test
    public void add(){
        Organ organ = new Organ();
        organ.setOrganId(6);
        organ.setOrganDir("三猫");
        organ.setOrganExplain("小人");
        organ.setOrganHeigh("老板");
        organ.setOrganLinkman("小七");
        organ.setOrganLoc("长沙");
        organ.setOrganName("遗迹");
        organ.setOrganPhone("13666723872");
        organ.setOrganType("有钱");
        int count = organService.add(organ);
        System.out.print(count);
    }



    @Test
    public void find(){
        List<Organ> organs = organService.find();
        for(Organ organ : organs){
            System.out.println(organ.getOrganId());
        }
    }

    @Test
    public void update(){
        Organ organ = new Organ();
        organ.setOrganId(2);
        organ.setOrganPhone("15279950879");
        int count = organService.update(organ);
    }

    @Test
    public void delete(){
        int count = organService.delete(6);
        System.out.println(count);
    }

    @Test
    public void findPager(){
        String organName="天";
        String order = "asc";
        String sort="organId";
        int page = 0;
        int rows = 11;
        Pager<Organ> organs = organService.findPager(organName,order,sort,page,rows);
        System.out.println(organs.getTotal());
        for(Organ organ : organs.getRows()){
            System.out.println(organ.getOrganDir());
        }

    }

    @Test
    public void findById(){
        Organ organ = organService.findById(2);
        System.out.println(organ.getOrganDir());
    }

}
