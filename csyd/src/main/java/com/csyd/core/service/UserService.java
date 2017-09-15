package com.csyd.core.service;

import com.csyd.core.dao.UserMapper;
import com.csyd.pojo.SysUser;
import com.csyd.core.util.Pager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("userService")
@Transactional(readOnly = true,propagation = Propagation.NOT_SUPPORTED)
public class UserService {
    @Resource(name = "userMapper")
    private UserMapper userMapper;

    //登陆方法
    public SysUser login(String username,String password){
        return userMapper.login(username,password);
    }

    //修改密码
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int changePassword(Integer id, String password) {
        return userMapper.changePassword(id, password);
    }

    // ** CRUD *********************************************************
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int add(SysUser user) {
        return userMapper.add(user);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int modify(SysUser user) {
        return userMapper.modify(user);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int remove(Integer id) {
        return userMapper.remove(id);
    }

    public SysUser findById(Integer id) {
        return userMapper.findById(id);
    }

    public Pager<SysUser> findPager(Integer pageno, Integer pagesize, String sort, String order, String username,
                                 String userFlag) {
        Pager<SysUser> pager = new Pager<SysUser>();
        pager.setRows(userMapper.findPager(pageno, pagesize, sort, order, username, userFlag));
        pager.setTotal(userMapper.findPagerTotal(username, userFlag));
        return pager;
    }
}
