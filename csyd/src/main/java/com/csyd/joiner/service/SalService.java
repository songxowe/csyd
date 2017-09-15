package com.csyd.joiner.service;

import com.csyd.core.util.Pager;
import com.csyd.joiner.dao.SalMapper;
import com.csyd.pojo.Business;
import com.csyd.pojo.SalTotal;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("salService")
public class SalService {
    @Resource(name = "salMapper")
    private SalMapper salMapper;

    public Pager<Business> findPager(Integer pageno, Integer pagesize, String sort, String order,
                                     String proName, Date beginDate, Date endDate, String cusStatus,Integer userId){
        Pager<Business> pager = new Pager<Business>();
        pager.setRows(salMapper.findPager(pageno,pagesize,sort,order,proName,beginDate,endDate,cusStatus,userId));
        pager.setTotal(salMapper.findPagerTotal(proName,beginDate,endDate,cusStatus,userId));
        return pager;
    }

    public List<SalTotal> total(Integer userId,String year){
        return salMapper.total(userId,year);
    }
}
