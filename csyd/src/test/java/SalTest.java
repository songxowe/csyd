import com.csyd.core.util.Pager;
import com.csyd.joiner.service.SalService;
import com.csyd.pojo.Business;
import com.csyd.pojo.SalTotal;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SalTest {
    private SalService salService;

    @Test
    public void findPager(){
        Pager<Business> pager = salService.findPager(0,5,"cusPhone","asc",null,null,null,null,1);
        for (Business business:pager.getRows()){
            System.out.println(business.getCusPhone());
        }
    }

    @Test
    public void find(){
        List<SalTotal> totals = salService.total(1,"2017");
        for(SalTotal total:totals){
            System.out.println(total.getSal()+" "+total.getMonth());
        }
    }

    @Before
    public void init(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        salService = ctx.getBean("salService",SalService.class);
    }
}
