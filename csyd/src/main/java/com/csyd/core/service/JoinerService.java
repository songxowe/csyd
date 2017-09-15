package com.csyd.core.service;

import com.csyd.core.dao.JoinerMapper;
import com.csyd.core.util.Pager;
import com.csyd.pojo.Joiner;
import com.csyd.pojo.Organ;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("joinerService")
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
public class JoinerService {

    @Resource(name = "joinerMapper")
    private JoinerMapper joinerMapper;
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer modify(Joiner joiner){
        return joinerMapper.modify(joiner);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer add(Joiner joiner){
        return joinerMapper.add(joiner);
    }

    public Joiner findById(Integer joinerId){
        return joinerMapper.findById(joinerId);
    }

    public Pager<Joiner> findPager(Integer pageno, Integer pagesize, String sort, String order,String joinerName,String joinerStatus,
                                   Date beginDate,Date endDate){
        Pager<Joiner> pager=new Pager<>();
        pager.setRows(joinerMapper.findPager(pageno, pagesize, sort, order,joinerName,joinerStatus,beginDate,endDate));
        pager.setTotal(joinerMapper.findPagerTotal(joinerName,joinerStatus,beginDate,endDate));
        return pager;
    }

    public List<Organ> findOrgan(){
        return joinerMapper.findOrgan();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer edit(Joiner joiner){
        return joinerMapper.edit(joiner);
    }
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer remove(Integer joinerId){
        return  joinerMapper.remove(joinerId);
    }

    public void addUserRole(Integer userId,Integer roleId){
        joinerMapper.addUserRole(userId,roleId);
    }

    public void updateFlag(Integer userId){
        joinerMapper.updateFlag(userId);
    }

}
