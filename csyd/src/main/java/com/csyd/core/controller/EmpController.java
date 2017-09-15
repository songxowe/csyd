package com.csyd.core.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.csyd.pojo.Employee;
import com.csyd.pojo.Organ;
import com.csyd.pojo.SysMenu;
import com.csyd.pojo.SysMenuRole;
import com.csyd.pojo.SysRole;
import com.csyd.pojo.SysUser;
import com.csyd.pojo.SysUserRole;
import com.csyd.core.service.EmpService;
import com.csyd.core.util.JsonDateValueProcessor;
import com.csyd.core.util.MD5;
import com.csyd.core.util.Pager;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

@Controller
public class EmpController {
    @Resource(name = "empService")
    private EmpService empService;

    @RequestMapping(value = "empList", produces = "application/json;charset=utf-8")
    public @ResponseBody String findAll(@RequestParam(value = "page") Integer page,
                                        @RequestParam(value = "rows") Integer rows, @RequestParam(value = "sort") String sort,
                                        @RequestParam(value = "order") String order, @RequestParam(value = "name", required = false) String name,
                                        @RequestParam(value = "phone", required = false) String phone,
                                        @RequestParam(value = "agentName", required = false) String agentName) {
        Integer id = null;
        System.out.println(agentName);
        if (agentName == "") {
            agentName = null;
        }
        if (agentName != null) {
            id = empService.findId(agentName);
            System.out.println(id);
        }
        System.out.println(page + "--" + rows + "--" + sort + "   " + order + "  " + id + "  " + name + " " + phone);
        Pager<Employee> pager = empService.findEmps((page - 1) * rows, rows, sort, order, id, name, phone);
        Pager<Employee> pager1 = new Pager<Employee>();
        List<Employee> e1 = new ArrayList<Employee>();
        for (Employee e : pager.getRows()) {
            SysUser user = empService.findName(e.getUserId());

            e.setAgentName(user.getUserName());
            if ("1".equals(user.getUserFlag())) {
                e.setBankName("开通");
            } else {
                e.setBankName("冻结");
            }
            e1.add(e);

        }
        pager1.setTotal(pager.getTotal());
        pager1.setRows(e1);

        JsonConfig jc = new JsonConfig();
        jc.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSON json = JSONSerializer.toJSON(pager1, jc);
        System.out.println(json.toString());

        return json.toString();
    }

    // 查询所有角色
    @RequestMapping(value = "findRole", produces = "application/json;charset=utf-8")
    public @ResponseBody String findRole() {
        System.out.println(1);
        List<SysRole> roles = empService.findRole();
        JsonConfig jc = new JsonConfig();
        jc.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSON json = JSONSerializer.toJSON(roles, jc);
        System.out.println(json.toString());
        return json.toString();

    }

    // 根据roleId查询所有的权限
    @RequestMapping(value = "findRight", produces = "application/json;charset=utf-8")
    public @ResponseBody String findRight(@RequestParam(value = "roleId") Integer roleId) {
        List<SysMenu> rights = empService.findRight(roleId);
        JsonConfig jc = new JsonConfig();
        jc.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSON json = JSONSerializer.toJSON(rights, jc);
        System.out.println(json.toString());
        return json.toString();
    }

    // 查询所有组织
    @RequestMapping(value = "findOrgan", produces = "application/json;charset=utf-8")
    public @ResponseBody String findOrgan() {
        List<Organ> organs = empService.findOrgan();
        JsonConfig jc = new JsonConfig();
        jc.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSON json = JSONSerializer.toJSON(organs, jc);
        System.out.println(json.toString());
        return json.toString();
    }


    // 新增员工
    @RequestMapping(value="addEmp",produces = "application/json;charset=utf-8")
    public @ResponseBody  Integer addEmp(Employee employee, SysUser sysUser , @Param(value="roleId")Integer roleId) {
        System.out.println("111111111111111");
        System.out.println("----------"+employee.toString());
        SysUserRole ur = new SysUserRole();
        if (employee.getId()!= null) {
            sysUser.setUserId(employee.getUserId());
            ur.setRoleId(roleId);
            ur.setUserId(employee.getUserId());
            int c = empService.updateFlag(sysUser);
            int s = empService.updateEmp(employee);
            int h = empService.updateUR(ur);

        } else if (employee.getId() == null) {
            System.out.println(employee.toString());
            System.out.println("---------------");
            System.out.println(sysUser.toString());
            sysUser.setUserPassword(MD5.getInstance().getMD5ofStr(sysUser.getUserPassword()));
            int countsys = empService.addUser(sysUser);
            //拿到账户的user_id
            Integer userId=empService.findId(sysUser.getUserName());
            //给用户新增角色
            ur.setRoleId(roleId);
            ur.setUserId(userId);
            int coun = empService.addUr(ur);
            employee.setUserId(userId);

            int countAdd = empService.addEmp(employee);
            System.out.println(countAdd + "+++"  + "+++" + countsys + "+++" + coun);
        }
        return 1;
    }

    // 修改员工信息 根据empid查询
    @RequestMapping("findById")
    public ModelAndView findById(Integer id) {
        System.out.println(id + "hhhhh");

        Employee employee = empService.findById(id);
        System.out.println(employee.toString());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("empEdit");
        mv.addObject("employee", employee);
        mv.addObject("sysRole", empService.findByRole(employee.getUserId()));
        return mv;
    }

    // 删除员工信息

    @RequestMapping("removeEmp")
    public @ResponseBody String remove(@Param(value = "ids") String ids) {
        String[] idsArray = ids.split(",");
        int count = 0;
        for (String s : idsArray) {
            Integer id = Integer.parseInt(s);
            empService.removeEmp(id);
            count++;
        }

        JsonConfig jc = new JsonConfig();
        jc.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSON json = JSONSerializer.toJSON(count, jc);
        return json.toString();
    }

}
