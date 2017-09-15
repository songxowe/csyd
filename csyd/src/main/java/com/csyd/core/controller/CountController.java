package com.csyd.core.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csyd.pojo.Business;
import com.csyd.pojo.EchartsData;
import com.csyd.core.service.CountService;
import com.csyd.core.util.JsonDateValueProcessor;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

@Controller
public class CountController {

    @Resource(name="countService")
    private CountService  countService;


    @RequestMapping(value="findProduct",produces="application/json;charset=utf-8")
    public @ResponseBody String findProduct(){
        System.out.println("find");
        List<Business> list=countService.findAll();
        List<String> category=new ArrayList<String>();
        List<Integer> y=new ArrayList<Integer>();

        for (Business b : list) {
            category.add(b.getProName());
            y.add(b.getSellerId());
            System.out.println(b.getSellerId()+" "+b.getProName()+" "+b.getBusType());
        }
        EchartsData echartsData=new EchartsData();
        echartsData.setCategory(category);
        echartsData.setY(y);

        JsonConfig jc = new JsonConfig();
        jc.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSON json = JSONSerializer.toJSON(echartsData, jc);
        System.out.println(json.toString());

        return json.toString();

    }


    //查询业务营销记录




}
