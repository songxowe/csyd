import com.csyd.core.util.Pager;
import com.csyd.pojo.Business;
import com.csyd.seller.service.BusRecordService;
import com.csyd.seller.service.SellerSalService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BusinessTest {
    private BusRecordService busRecordService;
    private SellerSalService sellerSalService;

    @Test
    public void list(){
        Pager<Business> pager = sellerSalService.findPager(0,5,"busOpen","asc","飞",null,null,"1");
        for(Business business:pager.getRows()){
            System.out.println(business);
        }
    }

    @Before
    public void init(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        sellerSalService = ctx.getBean("sellerSalService",SellerSalService.class);
    }
}
