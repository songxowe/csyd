import com.csyd.core.service.MenuService;
import com.csyd.core.service.UserService;
import com.csyd.core.util.Pager;
import com.csyd.pojo.SysMenu;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MenuTest {
    private MenuService menuService;

    @Test
    public void testLoadUserMenus(){
        List<Integer> list = menuService.loadUserMenus(1);
        System.out.println(list);
    }

    @Test
    public void loadTopMenus(){
        List<SysMenu> menus = menuService.loadTopMenus();
        for(SysMenu menu:menus){
            System.out.println(menu.getMenuName());
        }
    }

    @Test
    public void loadChileMenus(){
        List<SysMenu> menus = menuService.loadChileMenus(1);
        for(SysMenu menu:menus){
            System.out.println(menu.getMenuName());
        }
    }

    @Test
    public void addMenus(){
        SysMenu menu = new SysMenu();
        menu.setMenuName("产品管理");
        menu.setMenuDescn("产品管理");
        menu.setSeq(104);
        menu.setMenuStatus("1");
        int count = menuService.add(menu);
        System.out.println(count);
    }

    @Test
    public void modifyMenus(){
        SysMenu menu = new SysMenu();
        menu.setMenuName("产品管理");
        menu.setMenuDescn("产品管理");
        menu.setSeq(104);
        menu.setMenuStatus("1");
        menu.setMenuId(5);
        int count = menuService.modify(menu);
        System.out.println(count);
    }

    @Test
    public void removeMenus(){
        int count = menuService.remove(5);
        System.out.println(count);
    }

    @Test
    public void findById(){
        SysMenu menu = menuService.findById(1);
        System.out.println(menu.getMenuName());
    }

    @Test
    public void findPager(){
        Pager<SysMenu> menus = menuService.findPager(1,2,"seq","desc",null,null,null);
        for(SysMenu menu:menus.getRows()){
            System.out.println(menu.toString());
        }
        System.out.println(menus.getTotal());
    }

    @Before
    public void init(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        menuService = ctx.getBean("menuService",MenuService.class);
    }
}
