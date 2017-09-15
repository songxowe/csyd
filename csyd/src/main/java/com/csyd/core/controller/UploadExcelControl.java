package com.csyd.core.controller;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csyd.core.service.OrganService;
import com.csyd.core.util.ImportExcelUtil;
import com.csyd.pojo.Organ;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;



@Controller
@RequestMapping("/uploadExcel/*")
public class UploadExcelControl {

        @Resource(name="organService")
        private OrganService organService;
    /**
     * 描述：通过传统方式form表单提交方式导入excel文件
     * @param request
     * @throws Exception
     */
@RequestMapping(value="upload",method={RequestMethod.GET,RequestMethod.POST})
        public  String  uploadExcel(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        System.out.println("通过传统方式form表单提交方式导入excel文件！");
        int count = 0;
        InputStream in =null;
                List<List<Object>> listob = null;
        MultipartFile file = multipartRequest.getFile("upfile");
        System.out.println("---------------------1");
        if(file.isEmpty()){
        throw new Exception("文件不存在！");
        }
        System.out.println("---------------------2 "+file.getOriginalFilename());
        in = file.getInputStream();
        listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());

        System.out.println("---------------------3   ---+"+listob.size());
        in.close();


        for (int i = 0; i < listob.size(); i++) {
                System.out.println("---------------------4");
        List<Object> lo = listob.get(i);
        Organ organ = new Organ();
        organ.setOrganHeigh(String.valueOf(lo.get(0)));
        organ.setOrganName(String.valueOf(lo.get(1)));
        organ.setOrganType(String.valueOf(lo.get(2)));
        organ.setOrganLoc(String.valueOf(lo.get(3)));
        organ.setOrganDir(String.valueOf(lo.get(4)));
        organ.setOrganLinkman(String.valueOf(lo.get(5)));
        organ.setOrganPhone(String.valueOf(lo.get(6)));
        organ.setOrganExplain(String.valueOf(lo.get(7)));
         count = organService.add(organ);
        System.out.println("打印信息–>机构:"+organ.getOrganName()+"  名称："+organ.getOrganHeigh());
        }
        return "main";
        }

/**
 * 描述：通过 jquery.form.js 插件提供的ajax方式上传文件
 * @param request
 * @param response
 * @throws Exception
 */
@ResponseBody
@RequestMapping(value="ajaxUpload",method={RequestMethod.GET,RequestMethod.POST})
public  void  ajaxUploadExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        System.out.println("通过 jquery.form.js 提供的ajax方式上传文件！");

        InputStream in =null;
        List<List<Object>> listob = null;
        MultipartFile file = multipartRequest.getFile("upfile");
        if(file.isEmpty()){
        throw new Exception("文件不存在！");
        }

        in = file.getInputStream();
        listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());

        //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
        for (int i = 0; i < listob.size(); i++) {
        List<Object> lo = listob.get(i);
                Organ organ = new Organ();
                organ.setOrganHeigh(String.valueOf(lo.get(0)));
                organ.setOrganName(String.valueOf(lo.get(1)));
                organ.setOrganType(String.valueOf(lo.get(2)));
                organ.setOrganLoc(String.valueOf(lo.get(3)));
                organ.setOrganDir(String.valueOf(lo.get(4)));
                organ.setOrganLinkman(String.valueOf(lo.get(5)));
                organ.setOrganPhone(String.valueOf(lo.get(6)));
                organ.setOrganExplain(String.valueOf(7));

                System.out.println("打印信息–>机构:"+organ.getOrganName()+"  名称："+organ.getOrganHeigh());}

        PrintWriter out = null;
        response.setCharacterEncoding("utf-8");  //防止ajax接受到的中文信息乱码
        out = response.getWriter();
        out.print("文件导入成功！");
        out.flush();
        out.close();
        }


        }
