package com.csyd.seller.controller;

import com.csyd.core.util.Constants;
import com.csyd.pojo.Seller;
import com.csyd.pojo.SysUser;
import com.csyd.seller.service.SellerInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class SellerInfoController {
    @Resource(name = "sellerInfoService")
    private SellerInfoService sellerInfoService;

    /**
     * 通过用户ID查询用户信息
     * @param request
     * @return
     */
    @RequestMapping("sellerInfoController")
    public ModelAndView findById(HttpServletRequest request){
        SysUser user = (SysUser) request.getSession().getAttribute(Constants.USER_IN_SESSION);
        Seller seller = (Seller)request.getSession().getAttribute("seller");
        ModelAndView mv = new ModelAndView();
        if (seller==null){
            seller = sellerInfoService.findById(user.getUserId());
            mv.addObject("seller",seller);
        }
        mv.setViewName("seller_info");
        return mv;
    }

    @RequestMapping(value = "sellerInfoController_modify",produces = "application/json;charset=utf-8")
    public @ResponseBody int modify(Seller seller){
        int count = sellerInfoService.modify(seller);
        return count;
    }
}
