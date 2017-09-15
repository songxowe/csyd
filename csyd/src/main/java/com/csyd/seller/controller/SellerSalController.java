package com.csyd.seller.controller;

import com.csyd.core.util.JsonDateValueProcessor;
import com.csyd.core.util.Pager;
import com.csyd.pojo.Business;
import com.csyd.seller.service.SellerSalService;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class SellerSalController {
    @Resource(name = "sellerSalService")
    private SellerSalService sellerSalService;

    /**
     * 佣金明细
     * @param page
     * @param rows
     * @param sort
     * @param order
     * @param proName
     * @param busStatus
     * @return
     */
    @RequestMapping(value = "SellerSalController",produces = "application/json;charset=utf-8")
    public @ResponseBody
    String list(@RequestParam(required = true, value = "page") Integer page,
                @RequestParam(required = true, value = "rows") Integer rows,
                @RequestParam(required = true, value = "sort") String sort,
                @RequestParam(required = true, value = "order") String order,
                @RequestParam(required = false, value = "proName") String proName,
                @RequestParam(required = false, value = "beginDate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
                @RequestParam(required = false, value = "endDate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                @RequestParam(required = false, value = "busStatus") String busStatus){
        //System.out.println(proName+" "+beginDate+" "+endDate+" "+busStatus);

        if (!StringUtils.isEmpty(proName)) {
            proName = "%" + proName + "%";
        }
        if("-1".equals(busStatus)){
            busStatus=null;
        }

        int pageno = (page - 1) * rows; // 开始页
        int pagesize = rows; // 结束页

        Pager<Business> pager = sellerSalService.findPager(pageno,pagesize,sort,order,proName,beginDate,endDate,busStatus);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        JSONObject jo = (JSONObject) JSONSerializer.toJSON(pager, jsonConfig);
        //System.out.println(jo.toString());
        return jo.toString();
    }
}
