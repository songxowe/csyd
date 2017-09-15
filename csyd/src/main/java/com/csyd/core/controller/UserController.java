package com.csyd.core.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csyd.core.service.UserService;
import com.csyd.core.util.Constants;
import com.csyd.core.util.MD5;
import com.csyd.core.util.Pager;
import com.csyd.pojo.SysUser;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

@Controller
public class UserController {
    @Resource(name = "userService")
    private UserService userService;

    /**
     * 用户登录
     */
    @RequestMapping("/userController_login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        @RequestParam("verifyCode") String verifyCode, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String securityCode = (String) session.getAttribute("securityCode");
        String url = "redirect:/login.jsp";
        String message = "";

        if (verifyCode.equals(securityCode)) {
            SysUser user = userService.login(username, MD5.getInstance().getMD5ofStr(password));
            if (user != null) {
                session.setAttribute(Constants.USER_IN_SESSION, user);
                url = "redirect:/index.jsp";
            } else {
                message = "?message=1";
            }
        } else {
            message = "?message=0";
        }
        return url + message;
    }

    /**
     * 用户退出系统
     */
    @RequestMapping("/userController_logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(Constants.USER_IN_SESSION);
        session.invalidate();
        return "redirect:/login.jsp";
    }

    /**
     * 修改密码
     *
     * @return
     */
    @RequestMapping("/userController_changePassword")
    public String changePassword(@RequestParam("password") String password,
                                 @RequestParam("newpassword") String newpassword, @RequestParam("confirmnewpassword") String confirmnewpassword,
                                 HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");

        SysUser user = (SysUser) request.getSession().getAttribute(Constants.USER_IN_SESSION);
        String mess = "";

        if (user == null) {
            mess = "";
        } else if (StringUtils.isBlank(password)) {
            mess = "请输入您的原密码";
        } else if (StringUtils.isBlank(newpassword)) {
            mess = "请输入您的新密码";
        } else if (!newpassword.equals(confirmnewpassword)) {
            mess = "您输入的新密码与确认密码不匹配";
        } else if (!user.getUserPassword().equals(MD5.getInstance().getMD5ofStr(password))) {
            mess = "您输入的原密码不正确";
        } else {
            userService.changePassword(user.getUserId(), MD5.getInstance().getMD5ofStr(newpassword));
            mess = "密码修改成功,请重新登录";
        }
        try {
            response.getWriter().println(mess);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ** CRUD *********************************************************
    @RequestMapping("/userController")
    public void list(@RequestParam(required = true, value = "page") Integer page,
                     @RequestParam(required = true, value = "rows") Integer rows,
                     @RequestParam(required = true, value = "sort") String sort,
                     @RequestParam(required = true, value = "order") String order,
                     @RequestParam(required = false, value = "userName") String username,
                     @RequestParam(required = false, value = "userFlag") String userFlag, HttpServletResponse response) {

        if (!StringUtils.isEmpty(username)) {
            username = "%" + username + "%";
        }
        if (!StringUtils.isEmpty(userFlag)) {
            userFlag = "%" + userFlag + "%";
        }

        int pageno = (page - 1) * rows; // 开始页
        int pagesize = rows; // 结束页

        Pager<SysUser> pager = userService.findPager(pageno, pagesize, sort, order, username, userFlag);
        JsonConfig jsonConfig = new JsonConfig();
        try {
            PrintWriter out = response.getWriter();
            JSONObject json = (JSONObject) JSONSerializer.toJSON(pager, jsonConfig);
            out.println(json.toString());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/userController_findById")
    public String findById(@RequestParam(required = false, value = "id") Integer id, ModelMap modelMap) {
        if (id != null) {
            SysUser user = userService.findById(id);
            modelMap.put("user", user);
        }
        return "useredit";
    }

    @RequestMapping("/userController_save")
    public void save(SysUser user, HttpServletResponse response) {
        int count = 0;

        if (user != null && user.getUserPassword() != null) {
            // 加密
            user.setUserPassword(MD5.getInstance().getMD5ofStr(user.getUserPassword()));
        }

        if (user != null && user.getUserId() != null) {
            count = userService.modify(user);
        } else {
            count = userService.add(user);
        }
        try {
            PrintWriter out = response.getWriter();
            out.println(count);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/userController_remove")
    public void remove(@RequestParam(required = true, value = "ids") String ids, HttpServletResponse response) {
        int count = 0;
        String[] userIds = ids.split(",");
        for (int i = 0; i < userIds.length; i++) {
            Integer id = NumberUtils.createInteger(userIds[i]);
            count += userService.remove(id);
        }

        try {
            PrintWriter out = response.getWriter();
            out.println(count);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
