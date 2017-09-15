package com.csyd.seller.service;

import com.csyd.core.util.Pager;
import com.csyd.joiner.dao.MyJoinerMapper;
import com.csyd.pojo.Business;
import com.csyd.pojo.Joiner;
import com.csyd.pojo.Joiner1;
import com.csyd.seller.dao.BusRecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service("busRecordService")
public class BusRecordService {
    @Resource(name = "busRecordMapper")
    private BusRecordMapper busRecordMapper;
    @Resource(name="myJoinerMapper")
    private MyJoinerMapper myJoinerMapper;

    public Pager<Business> findPager(Integer pageno, Integer pagesize, String sort, String order,String cusPhone,
                                     String proName,Date beginDate,Date endDate){
        Pager<Business> pager = new Pager<Business>();
        pager.setRows(busRecordMapper.findPager(pageno,pagesize,sort,order,cusPhone,proName,beginDate,endDate));
        pager.setTotal(busRecordMapper.findPagerTotal(cusPhone,proName,beginDate,endDate));
        return pager;
    }

    public Pager<Business> findPager1(Integer pageno, Integer pagesize, String sort, String order,Integer joinerId,String sellerPhone,
                                     String sellerName,Date beginDate,Date endDate){
        Pager<Business> pager = new Pager<Business>();
        pager.setRows(busRecordMapper.findPager1(pageno,pagesize,sort,order,joinerId,sellerPhone,sellerName,beginDate,endDate));
        pager.setTotal(busRecordMapper.findPagerTotal1(joinerId,sellerPhone,sellerName,beginDate,endDate));
        return pager;
    }
    public Joiner1 find(Integer userId){
        return myJoinerMapper.findBuUserId(userId);
    }
}
