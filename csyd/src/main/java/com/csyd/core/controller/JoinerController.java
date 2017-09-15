package com.csyd.core.controller;

import com.csyd.core.service.EmpService;
import com.csyd.core.service.JoinerService;
import com.csyd.core.service.UserRoleService;
import com.csyd.core.util.JsonDateValueProcessor;
import com.csyd.core.util.MD5;
import com.csyd.core.util.Pager;
import com.csyd.joiner.service.MyJoinerService;
import com.csyd.pojo.Joiner;
import com.csyd.pojo.Joiner1;
import com.csyd.pojo.Organ;
import com.csyd.core.util.OrganValueProcessor;
import com.csyd.pojo.SysUser;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
public class JoinerController {
    @Resource(name = "joinerService")
    private JoinerService joinerService;
    @Resource(name="myJoinerService")
    private MyJoinerService myJoinerService;

    @RequestMapping(value = "joinerRemove",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String remove(@RequestParam(required = true, value = "ids") String ids) {
        int count = 0;
        String[] joinerIds = ids.split(",");
        for (int i = 0; i < joinerIds.length; i++) {
            Integer joinerId = NumberUtils.createInteger(joinerIds[i]);
            count += joinerService.remove(joinerId);
        }
        return String.valueOf(count);
    }

    @RequestMapping(value = "findOrgan", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findOrgan() {
        // System.out.println("进来了");
        List<Organ> organs = joinerService.findOrgan();
        Organ organ = new Organ();
        organ.setOrganId(0);
        organ.setOrganName("请选择");
        organs.add(0, organ);
        //System.out.println(organs.size());

        JsonConfig jsonConfig = new JsonConfig();
        // 设置指定属性不在 json 格式数据中显示
        jsonConfig.setExcludes(new String[]{"loc"});
        JSON json = JSONSerializer.toJSON(organs, jsonConfig);

        return json.toString();
    }
    @RequestMapping(value = "joinerEdit", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String edit(Joiner joiner,SysUser sysUser,Integer roleId) {
        int count = 0;
        if (joiner != null && joiner.getJoinerId() != null) {
            System.out.println("修改");
            count = joinerService.edit(joiner);
        } else {
            System.out.println("新增");
            sysUser.setUserPassword(MD5.getInstance().getMD5ofStr(sysUser.getUserPassword()));
            myJoinerService.addUser(sysUser);
            joinerService.addUserRole(myJoinerService.findId(sysUser.getUserName()),roleId);
            joiner.setUserId(myJoinerService.findId(sysUser.getUserName()));
            joiner.setJoLevelId(1);
            count = joinerService.add(joiner);
        }

        return String.valueOf(count);
    }
    @RequestMapping(value = "joinerSave", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Joiner joiner) {
        int count = 0;
        if (joiner != null && joiner.getJoinerId() != null) {
            System.out.println("修改1");
            if ("1".equals(joiner.getJoinerStatus())){
                joinerService.updateFlag(joiner.getUserId());
            }
            count = joinerService.modify(joiner);

        } else {
            System.out.println("新增");
            count = joinerService.add(joiner);
        }

        return String.valueOf(count);
    }

    @RequestMapping("/joinerFindId")
    public String findId(@RequestParam(required = false, value = "joinerId") Integer joinerId, ModelMap modelMap) {
        System.out.println(joinerId);
        if (joinerId != null) {
            Joiner joiner = joinerService.findById(joinerId);
            modelMap.put("joiner",joiner);
            modelMap.put("organ",joiner.getOrgan());
        }
        return "addJoiner";
    }
    //测试http://localhost:8080/csyd/joinerSet/1
    @RequestMapping(value = "/joinerSet/{joinerId}", method = RequestMethod.GET)
    public String findById(@PathVariable("joinerId") Integer joinerId,ModelMap modelMap) {
        Joiner joiner = joinerService.findById(joinerId);
        System.out.println(joiner.getOrgan().getOrganName());
        modelMap.put("joiner",joiner);
        modelMap.put("organ",joiner.getOrgan());
        return "auditJoiner";
    }
    //测试http://localhost:8080/csyd/joiner/1
    @RequestMapping(value = "/joiner/{joinerId}", method = RequestMethod.GET)
    public String itemsView(@PathVariable("joinerId") Integer joinerId,ModelMap modelMap) {
        Joiner joiner = joinerService.findById(joinerId);
        modelMap.put("joiner",joiner);
        modelMap.put("organ",joiner.getOrgan());
        return "editJoiner";
    }

    //测试http://localhost:8080/csyd/joiner?page=1&rows=2&sort=joinerId&order=asc
    @RequestMapping(value = "joiner", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String list(@RequestParam(required = true, value = "page") Integer page,
                       @RequestParam(required = true, value = "rows") Integer rows,
                       @RequestParam(required = true, value = "sort") String sort,
                       @RequestParam(required = true, value = "order") String order,
                       @RequestParam(required = false, value = "joinerName") String joinerName,
                       @RequestParam(required = false, value = "joinerStatus") String joinerStatus,
                       @RequestParam(required = false, value = "beginDate")
                       @DateTimeFormat(pattern = "yyyy-MM-dd")
                               Date beginDate,
                       @RequestParam(required = false, value = "endDate")
                       @DateTimeFormat(pattern = "yyyy-MM-dd")
                               Date endDate) {
        System.out.println(joinerName+joinerStatus);
        System.out.println(beginDate+""+endDate);
        if (!StringUtils.isEmpty(joinerName)) {
            joinerName = "%" + joinerName + "%";
        }

        Integer pageno = (page - 1) * rows;
        Integer pagesize = page * rows;

        Pager<Joiner> pager = joinerService.findPager(pageno, pagesize, sort, order, joinerName, joinerStatus,beginDate,endDate);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        jsonConfig.registerJsonValueProcessor(Organ.class, new OrganValueProcessor());
        JSONObject json = (JSONObject) JSONSerializer.toJSON(pager, jsonConfig);

        return json.toString();
    }


}
