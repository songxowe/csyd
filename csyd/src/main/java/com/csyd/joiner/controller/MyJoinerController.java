package com.csyd.joiner.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.csyd.pojo.Joiner1;
import com.csyd.pojo.SysUser;
import com.csyd.core.util.Constants;
import com.csyd.core.util.JsonDateValueProcessor;
import com.csyd.core.util.MD5;
import com.csyd.core.util.Pager;
import com.csyd.joiner.service.MyJoinerService;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

@Controller
public class MyJoinerController {
    @Resource(name="myJoinerService")
    private MyJoinerService myJoinerService;

    //查询我的下级代理商
    @RequestMapping(value = "joinerList", produces = "application/json;charset=utf-8")
    public @ResponseBody String findJoiner(
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "rows") Integer rows,
            @RequestParam(value = "sort") String sort,
            @RequestParam(value = "order") String order,
            @RequestParam(value = "userFlag", required = false) String userFlag,
            @RequestParam(value = "joinerName", required = false) String joinerName,
            HttpServletRequest request
    ){
        if("-1".equals(userFlag)){
            userFlag=null;
        }
        System.out.println(page + "--" + rows + "--" + sort + "   " + order + "  " + userFlag + " " + joinerName);
        SysUser user=(SysUser) request.getSession().getAttribute(Constants.USER_IN_SESSION);
        Integer userId=user.getUserId();

        Pager<Joiner1> pager=myJoinerService.findJoiner((page-1)*rows, rows, sort, order,userId, joinerName, userFlag);

        for(Joiner1 j:pager.getRows()){
            if ("1".equals(j.getUserFlag())) {
                j.setUserFlag("正常");
            } else {
                j.setUserFlag("已冻结");
            }
        }
        JsonConfig jc = new JsonConfig();
        jc.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSON json = JSONSerializer.toJSON(pager, jc);
        System.out.println(json.toString());
        return json.toString();

    }
    //根据id查询代理商
    @RequestMapping("findJoiner")
    public ModelAndView findById(Integer joinerId){
        System.out.println(joinerId);
        ModelAndView mv=new ModelAndView();
        Joiner1 joiner=myJoinerService.findById(joinerId);
        mv.setViewName("myJoiner");
        mv.addObject("joiner",joiner);
        System.out.println(joiner.toString());
        return mv;
    }
    //根据id查询代理商
    @RequestMapping("findByJoiner")
    public ModelAndView findByUserId(Integer joinerId){
        System.out.println(joinerId+"-----");
        ModelAndView mv=new ModelAndView();
        Joiner1 joiner=myJoinerService.findById(joinerId);
        mv.setViewName("joinerEdit");
        mv.addObject("joiner",joiner);
        return mv;
    }


    //新增修改 下级代理商
    @RequestMapping(value="save",produces = "application/json;charset=utf-8")
    public @ResponseBody int saveJoiner(Joiner1 joiner,SysUser sysUser,HttpServletRequest request){

        int count=0;

        if(joiner.getJoinerId()==null){
            SysUser user1=(SysUser) request.getSession().getAttribute(Constants.USER_IN_SESSION);
            //System.out.println(user1.getUserName()+"   "+user1.getUserId());
            sysUser.setUserPassword(MD5.getInstance().getMD5ofStr(sysUser.getUserPassword()));
            count=myJoinerService.addUser(sysUser);


            Joiner1 joiner1=myJoinerService.findByUserId(user1.getUserId());
            joiner.setJoHeigherId(joiner1.getJoinerId());
            joiner.setJoinerDate(new Date());
            joiner.setJoLevelId(joiner1.getJoLevelId()+1);
            joiner.setUserId(myJoinerService.findId(sysUser.getUserName()));
            //System.out.println(joiner.toString());
            count=myJoinerService.addJoienr(joiner);
        }else if(joiner.getJoinerId()!=null){


            int c = myJoinerService.updateUser(sysUser);
            int s = myJoinerService.updateJoiner(joiner);


        }


        return 1;
    }
    //查询代理商的下级用户数量

    @RequestMapping(value="count",produces = "application/json;charset=utf-8")
    public @ResponseBody String count(Integer joinerId){
        System.out.println(joinerId);
        int count=myJoinerService.count(joinerId);

        return String.valueOf(count);

    }

}
