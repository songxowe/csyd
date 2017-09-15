package com.csyd.core.service;

import com.csyd.core.dao.ProductMapper;
import com.csyd.core.util.Pager;
import com.csyd.pojo.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class ProductService {
    @Resource(name = "productMapper")
    private ProductMapper productMapper;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int add(Product product){
        return productMapper.add(product);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int remove(Integer proId){
        return productMapper.remove(proId);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int modify(Product product){
        return productMapper.modify(product);
    }

    public Product findById(Integer proId){
        return  productMapper.findById(proId);
    }

    public List<Product> findByIdNo(Integer proId){
        return  productMapper.findByIdNo(proId);
    }

    public List<Product> find(){
        return productMapper.find();
    }

    public List<Product> find(String proName,String proStatus){
        return productMapper.findByParam(proName,proStatus);
    }

    public Pager<Product> find(Integer page, Integer rows, String sort, String order, String proName, String proStatus){
        Pager<Product> pager=new Pager<Product>();
        pager.setRows(productMapper.findPager(page,rows,sort,order,proName,proStatus));
        pager.setTotal(productMapper.getTotal(proName,proStatus));
        return pager;
    }
}
