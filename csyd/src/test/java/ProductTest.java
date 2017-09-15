
import com.csyd.core.service.ProductService;
import com.csyd.core.util.Pager;
import com.csyd.pojo.Product;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class ProductTest {
    private ProductService productService;

    @Before
    public void init(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        productService=ctx.getBean("productService",ProductService.class);
    }

    @Test
    public void add(){
        Product product=new Product();
        product.setProName("11");
        product.setProType("22");
        product.setProCost("5元/月");
        product.setProFirst(1d);
        product.setProMonth(0.2);
        product.setProStatus("1");
        product.setProDate(new Date());
        int count= productService.add(product);
        System.out.println(count);
    }

    @Test
    public void findById(){
        Product product=productService.findById(2);
        System.out.println(product.getProName());
    }

    @Test
    public void list(){
        for (Product product:productService.find()){
            System.out.println(product.getProName()+"\t");
        }
    }

    @Test
    public void modify(){
        Product product=new Product();
        product.setProId(9);
        product.setProName("22");
        product.setProType("22");
        product.setProCost("5元/月");
        product.setProFirst(1d);
        product.setProMonth(0.2);
        product.setProStatus("1");
        product.setProDate(new Date());
        int count =productService.modify(product);
        System.out.println(count);
    }

    @Test
    public void remove(){
        int count =productService.remove(9);
        System.out.println(count);
    }

    @Test
    public  void findByParam(){
        String proName=null;
        proName="漫";
        String proStatus=null;
        for (Product product:productService.find(proName,proStatus)){
            System.out.println(product.getProName()+"\t");
        }
    }

    @Test
    public  void pager(){
        Integer page = 1;
        Integer rows = 5;
        String sort = "pro_id";
        String order = "asc";

        String proName=null;
        String proStatus=null;

        page=(page-1)*rows;
        Pager<Product> pager=productService.find(page, rows, sort, order,proName,proStatus);
        System.out.println(pager.getTotal());
        for (Product product:pager.getRows()){
            System.out.println(product.getProName()+"\t");
        }
    }


}
