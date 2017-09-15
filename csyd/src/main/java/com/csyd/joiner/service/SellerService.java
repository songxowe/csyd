package com.csyd.joiner.service;

import com.csyd.core.util.Constants;
import com.csyd.core.util.Pager;
import com.csyd.joiner.dao.SellerMapper;
import com.csyd.pojo.Joiner;
import com.csyd.pojo.Seller;
import com.csyd.pojo.SysUser;
import org.omg.CORBA.Request;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class SellerService {

    @Resource(name="sellerMapper")
    private SellerMapper sellerMapper;

    //分页
    public Pager<Seller> findPager(String sellerName,String sellerPhone,String userFlag,Integer userId,
                                   String sort,String order,Integer page,Integer rows){
        Pager<Seller > pager = new Pager<Seller>();
        pager.setRows(sellerMapper.findPager(sellerName,sellerPhone,userFlag,userId,sort,order,page,rows));
        pager.setTotal(sellerMapper.getTotal(sellerName,sellerPhone,userFlag,userId));
        return  pager;
    }


    public int add(Seller seller){
        return sellerMapper.add(seller);
    }

    public int addUser(SysUser sysUser){

        return sellerMapper.addUser(sysUser);
    }

    //表 ： seller 根据Id 查询
    public Seller findById(Integer sellerId){
        return  sellerMapper.findById(sellerId);
    }

    //根据用户名查找表 Sys_user 获取ID
    public SysUser findParamId(String userName){
        return sellerMapper.findParamId(userName);
    }

    //添加 对两张表：seller     sys_user
//    public int add(SysUser sysUser, Seller seller){
//        HttpServletRequest request =
//        int count = 0;
//        if(sellerMapper.addUser(sysUser)>0){
//            SysUser user = sellerMapper.findParamId(sysUser.getUserName());
//            seller.setUserId(user.getUserId());
//            SysUser user2 = (SysUser) request.getSession().getAttribute(Constants.USER_IN_SESSION);
//            Integer joinerId = sellerMapper.findJoiner(user2.getUserId());
//           seller.setJoinerId(joinerId);
//            count = sellerMapper.add(seller);
//        }
//        return count;
//    }

    //修改  对两张表：seller     sys_user
    public int update(Seller seller,SysUser sysUser){
        int count = 0;
        if(sellerMapper.updateSeller(seller)>0){
            count = sellerMapper.updateUser(sysUser);
        }

        return count;
    }

    //根据Id查询 sys_user
    public SysUser findByUserId(Integer userId){
        return  sellerMapper.findByUserId(userId);
    }

    //删除 对两张表：seller     sys_user
    public int delete(Integer userId){
        int count = 0;
        if(sellerMapper.deleteSeller(userId)>0){
            count = sellerMapper.deleteUser(userId);
        }
        return  count;
    }


    public int findJoiner(Integer userId){
        return  sellerMapper.findJoiner(userId);
    }


    public String findJoinerName(Integer userId){
        return  sellerMapper.findJoinerName(userId);
    }

    public SysUser findSysUser(Integer userId){
        return  sellerMapper.findSysUser(userId);
    }

}
