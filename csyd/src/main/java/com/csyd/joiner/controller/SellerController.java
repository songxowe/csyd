package com.csyd.joiner.controller;

import com.csyd.core.util.*;
import com.csyd.joiner.service.SellerService;
import com.csyd.pojo.Joiner;
import com.csyd.pojo.Seller;
import com.csyd.pojo.SysUser;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class SellerController {

    @Resource(name="sellerService")
    private SellerService sellerService;
    @RequestMapping(value = "sellerController", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String list(@RequestParam(required = true, value = "page") Integer page,
                       @RequestParam(required = true, value = "rows") Integer rows,
                       @RequestParam(required = true, value = "sort") String sort,
                       @RequestParam(required = true, value = "order") String order,
                       @RequestParam(required = false, value = "sellerName") String sellerName,
                       @RequestParam(required = false,value = "sellerPhone")String sellerPhone,
                       @RequestParam(required = false,value="userFlag")String userFlag,HttpServletRequest request){
        Integer pageno = (page -1) * rows;
        Integer pagesize = rows;
        SysUser user = (SysUser)request.getSession().getAttribute(Constants.USER_IN_SESSION);
        System.out.println("1111111111");
        System.out.println(user.getUserId());
        Integer userId = user.getUserId();
        Pager<Seller> pager = sellerService.findPager(sellerName,sellerPhone,userFlag,userId,sort,order,pageno,pagesize);
        System.out.println("222222222222");
        JsonConfig jc = new JsonConfig();

        jc.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        jc.registerJsonValueProcessor(SysUser.class,new SysUserValueProcessor());
        jc.registerJsonValueProcessor(Joiner.class,new JoinerValueProcessor());
        JSONObject json = (JSONObject) JSONSerializer.toJSON(pager,jc);
        System.out.println(json.toString());
        return json.toString();
    }

    // 修改和增加
    @RequestMapping(value = "sellerController_save", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(SysUser sysUser, Seller seller , HttpServletRequest request) {

        int count = 0 ;
        if(seller != null && seller.getSellerId() != null ){
            count = sellerService.update(seller,sysUser);
            return String.valueOf(count+"个直销员修改成功!");
        }else{
            sysUser.setUserFlag("1");
            if (sellerService.addUser(sysUser) > 0) {
                SysUser user = sellerService.findParamId(sysUser.getUserName());
                seller.setUserId(user.getUserId());

                SysUser user2 = (SysUser) request.getSession().getAttribute(Constants.USER_IN_SESSION);

                Integer joinerId = sellerService.findJoiner(user2.getUserId());
                seller.setJoinerId(joinerId);
                count = sellerService.add(seller);
            }
        }
        return String.valueOf(count + "个直销员保存成功!");

    }

    // 删除
    @RequestMapping(value = "sellerController_remove", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public  String remove(@RequestParam(value = "ids", required = true) String ids) {

        int count = 0;
        String[] userIds = ids.split(",");
        for (int i = 0; i < userIds.length; i++) {
            Integer userId = NumberUtils.createInteger(userIds[i]);
            System.out.println(userId);
            count += sellerService.delete(userId);
        }
        return String.valueOf(count);
    }

    @RequestMapping("/sellerController_findById")
    public String findById(@RequestParam(required = false, value = "sellerId") Integer sellerId, ModelMap modelMap,HttpServletRequest request) {
        System.out.println("--------------------id");
        SysUser user1 = (SysUser) request.getSession().getAttribute(Constants.USER_IN_SESSION);
        String joinerName = sellerService.findJoinerName(user1.getUserId());
        modelMap.put("joinerName",joinerName);
        System.out.println(joinerName);
        if (sellerId != null) {
            System.out.println(sellerId+"-----------if");
            Seller seller = sellerService.findById(sellerId);
            modelMap.put("seller", seller);
            SysUser sysUser = sellerService.findSysUser(seller.getUserId());
            modelMap.put("sysUser",sysUser);
            System.out.println(seller.getSellerName());
        }
        return "selleredit";
    }

    @RequestMapping("/sellerController_view")
    public String view(@RequestParam(value = "sellerId",required = true) Integer sellerId ,ModelMap modelMap,HttpServletRequest request){
        System.out.println("-------------1");
        if(sellerId != null){
            Seller seller = sellerService.findById(sellerId);
            System.out.println(seller.getSellerName()+"1----------1");
            SysUser sysUser = sellerService.findSysUser(seller.getUserId());
            System.out.println(sysUser.getUserName()+"-----------2");
            modelMap.put("seller",seller);
            modelMap.put("sysUser",sysUser);
        }
        return "sellerview";
    }

}
