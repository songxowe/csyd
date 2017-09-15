package com.csyd.core.controller;

import com.csyd.core.service.ProductService;
import com.csyd.core.util.JsonDateValueProcessor;
import com.csyd.core.util.Pager;
import com.csyd.pojo.Product;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProductController {
    @Resource(name = "productService")
    private ProductService productService;

    @RequestMapping(value = "productController_save", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Product product){
        int count =0;
        if(product!=null && product.getProId()!=null){
            count=productService.modify(product);
        }else {
            count=productService.add(product);
        }
        return String.valueOf(count);
    }

    @RequestMapping(value = "productController_remove", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String remove(@RequestParam(value = "ids", required = true) String ids){
        int count =0;
        String [] proIds=ids.split(",");
        for (int i=0;i<proIds.length;i++){
            Integer proId= NumberUtils.createInteger(proIds[i]);
            count+=productService.remove(proId);
        }
        return String.valueOf(count);
    }

    @RequestMapping("/productController_view")
    public String view(@RequestParam(required = true,value = "proId") Integer proId, ModelMap modelMap){
        if(proId!=null){
            Product product=productService.findById(proId);
            modelMap.put("product",product);
        }
        return "productview";
    }

    @RequestMapping("/productController_findById")
    public String findById(@RequestParam(required = false,value = "proId") Integer proId, ModelMap modelMap){
        if(proId!=null){
            Product product=productService.findById(proId);
            modelMap.put("product",product);
        }
        return "productedit";
    }

    @RequestMapping(value="productController_list", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String list(@RequestParam(required = true, value = "page") Integer page,
                       @RequestParam(required = true, value = "rows") Integer rows,
                       @RequestParam(required = true, value = "sort") String sort,
                       @RequestParam(required = true, value = "order") String order,
                       @RequestParam(value = "proName",required = false)String proName,
                       @RequestParam(value = "proStatus",required = false)String proStatus
    ){
        int pageno = (page - 1) * rows;
        int pagesize = page * rows;

        Pager<Product> pager=productService.find(pageno,pagesize,sort,order,proName,proStatus);
        JsonConfig jsonConfig = new JsonConfig();

        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONObject json = (JSONObject) JSONSerializer.toJSON(pager, jsonConfig);

        return json.toString();
    }

    @RequestMapping(value="productController_find", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String find(@RequestParam(value = "proId",required = false)Integer proId){
        List<Product> products=productService.findByIdNo(proId);
        JsonConfig jsonConfig = new JsonConfig();

        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONObject json = (JSONObject) JSONSerializer.toJSON(products, jsonConfig);
        return json.toString();
    }

    @RequestMapping(value="productController_findAll", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String find(){
        List<Product> products=productService.find();
        JsonConfig jsonConfig = new JsonConfig();

        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONObject json = (JSONObject) JSONSerializer.toJSON(products, jsonConfig);
        return json.toString();
    }

}
