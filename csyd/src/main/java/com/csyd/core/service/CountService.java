package com.csyd.core.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csyd.core.dao.CountMapper;
import com.csyd.pojo.Business;
import com.csyd.pojo.Vaddress;
import com.csyd.pojo.Vbus;
import com.csyd.pojo.Vbusiness;
import com.csyd.core.util.Pager;

@Service("countService")
public class CountService {
    @Resource(name="countMapper")
    private CountMapper countMapper;
    //业务统计查询
    public List<Business> findAll() {
        return countMapper.findAll();
    }

    public List<Vaddress> findAddress(String sellerLoc, String proName, Date beginDate, Date endDate) {
        return countMapper.findAddress(sellerLoc, proName, beginDate, endDate);
    }
    //业务发展明细查询
    public Pager<Vbusiness> findBs(Integer page, Integer rows, String sort, String order, String sellerLoc,
                                   String organName, String proName, String sellerPhone, String cusPhone, Date beginDate, Date endDate) {
        Pager<Vbusiness> pager = new Pager<Vbusiness>();
        pager.setRows(countMapper.findBs(page, rows, sort, order, sellerLoc, organName, proName, sellerPhone, cusPhone,
                beginDate, endDate));
        pager.setTotal(countMapper.getTotal(sellerLoc, organName, proName, sellerPhone, cusPhone, beginDate, endDate));
        return pager;
    }
    //业务营销记录
    public Pager<Vbus> findVbus(Integer page, Integer rows, String sort, String order,String sellerPhone,String joinerName,Date beginDate, Date endDate){
        Pager<Vbus> pager=new Pager<Vbus>();
        pager.setRows(countMapper.findVbus(page, rows, sort, order, sellerPhone, joinerName, beginDate, endDate));
        pager.setTotal(countMapper.getTotalVbus(sellerPhone, joinerName, beginDate, endDate));
        return pager;


    }

}
