import com.csyd.core.util.Pager;
import com.csyd.joiner.service.SellerService;
import com.csyd.pojo.Seller;
import com.csyd.seller.service.SellerInfoService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SellerTest {
    private SellerService sellerService;


    @Test
    public void findById(){
        Pager<Seller> pager = sellerService.findPager(null,null,"1",39,"sellerId","asc",0,5);
        for(Seller seller:pager.getRows()){
            System.out.println(seller.getSellerName());
        }
    }

    @Before
    public void init(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        sellerService = ctx.getBean("sellerService",SellerService.class);
    }
}
