package com.csyd.seller.service;

import com.csyd.pojo.Business;
import com.csyd.seller.dao.BusinessMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("businessService")
public class BusinessService {
    @Resource(name = "businessMapper")
    private BusinessMapper businessMapper;

    public int addBus(Business business){
        return businessMapper.addBus(business);
    }

    public List<String> findProName(){
        return businessMapper.findProName();
    }
}
