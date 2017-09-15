package com.csyd.seller.controller;

import com.csyd.pojo.Business;
import com.csyd.pojo.Seller;
import com.csyd.seller.service.BusinessService;
import com.csyd.seller.service.SellerInfoService;
import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class BusinessController {
    @Resource(name = "businessService")
    private BusinessService businessService;
    @Resource(name = "sellerInfoService")
    private SellerInfoService sellerInfoService;

    @RequestMapping(value = "businessController",produces="application/json;charset=utf-8")
    public @ResponseBody int addBus(Business business,@Param(value = "userId") Integer userId){
        Seller seller = sellerInfoService.findById(userId);
        business.setSellerId(seller.getSellerId());
        business.setBusOpen(new Date());
        business.setBusType("网络客户端");
        int count = businessService.addBus(business);
        return count;
    }

    @RequestMapping(value = "businessController_findProName",produces = "application/json;charset=utf-8")
    public @ResponseBody String findProName(){
        List<String> proNames = businessService.findProName();
        JSON json = JSONSerializer.toJSON(proNames);
        return json.toString();
    }
}
