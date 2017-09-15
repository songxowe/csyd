package com.csyd.core.controller;

import com.csyd.core.service.OrganService;
import com.csyd.core.util.Pager;
import com.csyd.pojo.Organ;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;
import java.beans.IntrospectionException;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrganController {

    @Resource(name = "organService")
    private OrganService organService;

    // 查询所有
    @RequestMapping(value = "organController", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String list(@RequestParam(required = true, value = "page") Integer page,
                       @RequestParam(required = true, value = "rows") Integer rows,
                       @RequestParam(required = true, value = "sort") String sort,
                       @RequestParam(required = true, value = "order") String order,
                       @RequestParam(required = false, value = "organName") String organName) {
        Integer pageno = (page - 1) * rows;
        Integer pagesize = page * rows;
        Pager<Organ> pager = organService.findPager(organName, sort, order, pageno, pagesize);
        JSONObject json = (JSONObject) JSONSerializer.toJSON(pager);
        return json.toString();
    }

    // 修改和增加
    @RequestMapping(value = "organController_save", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Organ organ) {

        int count = 0;
        if(organ !=null && organ.getOrganId() !=null){
            count = organService.update(organ);
            return String.valueOf(count+"个组织修改成功!");
        }
        count = organService.add(organ);

        return String.valueOf(count+"个组织保存修改成功!");
    }



    // 删除
    @RequestMapping(value = "organController_remove", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public  String remove(@RequestParam(value = "ids", required = true) String ids) {
        int count = 0;
        String[] organIds = ids.split(",");
        for (int i = 0; i < organIds.length; i++) {
            Integer organId = NumberUtils.createInteger(organIds[i]);
            count += organService.delete(organId);
        }
        return String.valueOf(count);
    }

    // 根据Id查询(查看)
    @RequestMapping("/organController_view")
    public  String view(@RequestParam(value = "organId",required = true) Integer organId, ModelMap modelMap) {
        System.out.println("-------------");
        if(organId != null){
            Organ organ = organService.findById(organId);
            modelMap.put("organ", organ);
            System.out.println(organ.getOrganId());
        }
        return "organview";
    }

    /**
     * 根据组织编号查找指定组织
     *
     * @return
     */
    @RequestMapping("/organController_findById")
    public String findById(@RequestParam(required = false, value = "organId") Integer organId, ModelMap modelMap) {
        if (organId != null) {
            Organ organ = organService.findById(organId);
            modelMap.put("organ", organ);
        }
        return "organedit";
    }
    /**
     * 组织类型
     *
     * @return
     */
    @RequestMapping(value = "organController_find", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String find(){
        List<Organ> organs = organService.find();
        Organ organ = new Organ();
        organ.setOrganId(0);
        organ.setOrganType("");
        organ.setOrganPhone("");
        organ.setOrganName("");
        organ.setOrganLoc("");
        organ.setOrganLinkman("");
        organ.setOrganHeigh("");
        organ.setOrganExplain("");
        organ.setOrganDir("");
        organs.add(0,organ);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new
                String[]{"organHeigh,organName,organLoc,organDir,organLinkman,organPhone,organExplain"});
        JSON json = JSONSerializer.toJSON(organs,jsonConfig);
        return  json.toString();
    }

    /**
     * 所属地区
     *
     * @return
     */
    @RequestMapping(value = "organController_findLoc", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findLoc(){
        List<Organ> organs = organService.find();
        Organ organ = new Organ();
        organ.setOrganId(0);
        organ.setOrganType("");
        organ.setOrganPhone("");
        organ.setOrganName("");
        organ.setOrganLoc("");
        organ.setOrganLinkman("");
        organ.setOrganHeigh("");
        organ.setOrganExplain("");
        organ.setOrganDir("");
        organs.add(0,organ);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new
                String[]{"organHeigh,organName,organDir,organLinkman,organPhone,organExplain,organType"});
        JSON json = JSONSerializer.toJSON(organs,jsonConfig);
        return  json.toString();
    }

    /**
     * 上级组织
     * *
     * @return
     */
    @RequestMapping(value = "organController_findHeigh", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findHeigh(){
        List<Organ> organs = organService.find();
        Organ organ = new Organ();
        organ.setOrganId(0);
        organ.setOrganType("");
        organ.setOrganPhone("");
        organ.setOrganName("");
        organ.setOrganLoc("");
        organ.setOrganLinkman("");
        organ.setOrganHeigh("");
        organ.setOrganExplain("");
        organ.setOrganDir("");
        organs.add(0,organ);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new
                String[]{"organName,organLoc,organDir,organLinkman,organPhone,organExplain,organType"});
        JSON json = JSONSerializer.toJSON(organs,jsonConfig);
        return  json.toString();
    }
    public void find(ModelMap modelMap){
        List<Organ> organs = organService.find();
        modelMap.put("organs",organs);
    }




}
