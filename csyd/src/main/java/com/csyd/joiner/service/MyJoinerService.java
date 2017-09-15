package com.csyd.joiner.service;




import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import com.csyd.core.dao.EmpMapper;
import com.csyd.pojo.Joiner1;
import com.csyd.pojo.SysUser;
import com.csyd.core.util.Pager;
import com.csyd.joiner.dao.MyJoinerMapper;

@Service("myJoinerService")
public class MyJoinerService {

    @Resource(name="myJoinerMapper")
    private MyJoinerMapper myJoinerMapper;
    @Resource(name="empMapper")
    private EmpMapper empMapper;

    public Pager<Joiner1> findJoiner(Integer page, Integer rows, String sort, String order,Integer userId ,String joinerName,String userFlag	){
        Pager<Joiner1> pager=new Pager<Joiner1>();
        pager.setRows(myJoinerMapper.findJoiner(page, rows, sort, order,userId, joinerName, userFlag));
        pager.setTotal(myJoinerMapper.getTotal(userId,joinerName, userFlag));
        return pager;
    }

    public Joiner1 findById(Integer joinerId){
        return myJoinerMapper.findById(joinerId);
    }
    //新增
    public int addJoienr(Joiner1 joiner){
        return myJoinerMapper.addJoiner(joiner);
    }
    //修改
    public int updateJoiner(Joiner1 joiner){
        return myJoinerMapper.updateJoiner(joiner);
    }
    public Joiner1 findByUserId(Integer userId){
        return myJoinerMapper.findBuUserId(userId);
    }
    //新增用户
    public int addUser(SysUser sysUser){
        return empMapper.addUser(sysUser);
    }

    //根据userName查询userId
    public int findId(String userName){
        return empMapper.userId(userName);
    }
    //根据userId修改用户状态
    public int updateUser(SysUser sysUser){
        return empMapper.updateFlag(sysUser);
    }
    //查询代理商的下级用户
    public int count(Integer joinerId){
        return myJoinerMapper.count(joinerId);
    }
}
