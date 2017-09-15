package com.csyd.joiner.controller;

import com.csyd.core.util.Constants;
import com.csyd.core.util.JsonDateValueProcessor;
import com.csyd.core.util.Pager;
import com.csyd.joiner.service.SalService;
import com.csyd.pojo.Business;
import com.csyd.pojo.SalTotal;
import com.csyd.pojo.SysUser;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class SalController {
    @Resource(name = "salService")
    private SalService salService;

    /**
     * 代理商佣金明细
     * @param page
     * @param rows
     * @param sort
     * @param order
     * @param proName
     * @param beginDate
     * @param endDate
     * @param busStatus
     * @param request
     * @return
     */
    @RequestMapping(value = "salController",produces = "application/json;charset=utf-8")
    public @ResponseBody
    String list(@RequestParam(required = true, value = "page") Integer page,
                @RequestParam(required = true, value = "rows") Integer rows,
                @RequestParam(required = true, value = "sort") String sort,
                @RequestParam(required = true, value = "order") String order,
                @RequestParam(required = false, value = "proName") String proName,
                @RequestParam(required = false, value = "beginDate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
                @RequestParam(required = false, value = "endDate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                @RequestParam(required = false, value = "busStatus") String busStatus, HttpServletRequest request){
        //System.out.println(proName+" "+beginDate+" "+endDate+" "+busStatus);

        if (!StringUtils.isEmpty(proName)) {
            proName = "%" + proName + "%";
        }
        if("-1".equals(busStatus)){
            busStatus=null;
        }

        int pageno = (page - 1) * rows; // 开始页
        int pagesize = rows; // 结束页

        SysUser user = (SysUser) request.getSession().getAttribute(Constants.USER_IN_SESSION);
        Integer userId = user.getUserId();

        Pager<Business> pager = salService.findPager(pageno,pagesize,sort,order,proName,beginDate,endDate,busStatus,userId);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        JSONObject jo = (JSONObject) JSONSerializer.toJSON(pager, jsonConfig);
        //System.out.println(jo.toString());
        return jo.toString();
    }

    @RequestMapping(value = "salController_total",produces = "application/json;charset=utf-8")
    public@ResponseBody String total(@RequestParam(required = false,value = "year")String year,HttpServletRequest request){
        SysUser user = (SysUser) request.getSession().getAttribute(Constants.USER_IN_SESSION);
        Integer userId = user.getUserId();
        if(year==null||year==""){
            year="2017";
        }
        //System.out.println(userId+" "+ year);
        List<SalTotal> totals = salService.total(userId,year);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        JSON jo = JSONSerializer.toJSON(totals, jsonConfig);
        //System.out.println(jo.toString());
        return jo.toString();
    }
}
