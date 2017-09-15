package com.csyd.seller.controller;

import com.csyd.core.util.Constants;
import com.csyd.core.util.JsonDateValueProcessor;
import com.csyd.core.util.Pager;
import com.csyd.pojo.Business;
import com.csyd.pojo.SysUser;
import com.csyd.seller.service.BusRecordService;
import net.sf.json.JSON;
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
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class BusRecordController {
    @Resource(name = "busRecordService")
    private BusRecordService busRecordService;

    @RequestMapping(value = "busRecordController",produces = "application/json;charset=utf-8")
    public @ResponseBody String list(@RequestParam(required = true, value = "page") Integer page,
                @RequestParam(required = true, value = "rows") Integer rows,
                @RequestParam(required = true, value = "sort") String sort,
                @RequestParam(required = true, value = "order") String order,
                @RequestParam(required = false, value = "cusPhone") String cusPhone,
                @RequestParam(required = false, value = "proName") String proName,
                @RequestParam(required = false, value = "beginDate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
                    @RequestParam(required = false, value = "endDate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
            //System.out.println(cusPhone+" "+proName+" "+beginDate+" "+endDate);
            if (!StringUtils.isEmpty(cusPhone)) {
                cusPhone = "%" + cusPhone + "%";
            }

            if (!StringUtils.isEmpty(proName)) {
                proName = "%" + proName + "%";
            }

            int pageno = (page - 1) * rows; // 开始页
            int pagesize = rows; // 结束页

            Pager<Business> pager = busRecordService.findPager(pageno,pagesize,sort,order,cusPhone,proName,beginDate,endDate);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
            JSONObject jo = (JSONObject) JSONSerializer.toJSON(pager, jsonConfig);
            //System.out.println(jo.toString());
            return jo.toString();
        }

    @RequestMapping(value = "busRecordController1",produces = "application/json;charset=utf-8")
    public @ResponseBody String list1(@RequestParam(required = true, value = "page") Integer page,
                                     @RequestParam(required = true, value = "rows") Integer rows,
                                     @RequestParam(required = true, value = "sort") String sort,
                                     @RequestParam(required = true, value = "order") String order,

                                     @RequestParam(required = false, value = "sellerPhone") String sellerPhone,
                                     @RequestParam(required = false, value = "sellerName") String sellerName,
                                     @RequestParam(required = false, value = "beginDate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
                                     @RequestParam(required = false, value = "endDate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate
            ,HttpServletRequest request
    ){
        SysUser user=(SysUser) request.getSession().getAttribute(Constants.USER_IN_SESSION);

        System.out.println(sellerPhone+" "+sellerName+" "+beginDate+" "+endDate);
        if (!StringUtils.isEmpty(sellerPhone)) {
            sellerPhone = "%" + sellerPhone + "%";
        }

        if (!StringUtils.isEmpty(sellerName)) {
            sellerName = "%" + sellerName + "%";
        }

        int pageno = (page - 1) * rows; // 开始页
        int pagesize = rows; // 结束页
        Integer joinerId=busRecordService.find(user.getUserId()).getJoinerId();
        Pager<Business> pager = busRecordService.findPager1(pageno,pagesize,sort,order,joinerId,sellerPhone,sellerName,beginDate,endDate);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        JSONObject jo = (JSONObject) JSONSerializer.toJSON(pager, jsonConfig);
        //System.out.println(jo.toString());
        return jo.toString();
    }
}
