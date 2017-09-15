package com.csyd.seller.service;

import com.csyd.core.util.Pager;
import com.csyd.pojo.Business;
import com.csyd.seller.dao.SellerSalMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service("sellerSalService")
public class SellerSalService {
    @Resource(name = "sellerSalMapper")
    private SellerSalMapper sellerSalMapper;

    public Pager<Business> findPager(Integer pageno, Integer pagesize, String sort, String order,
                                     String proName, Date beginDate, Date endDate, String cusStatus){
        Pager<Business> pager = new Pager<Business>();
        pager.setRows(sellerSalMapper.findPager(pageno,pagesize,sort,order,proName,beginDate,endDate,cusStatus));
        pager.setTotal(sellerSalMapper.findPagerTotal(proName,beginDate,endDate,cusStatus));
        return pager;
    }
}
