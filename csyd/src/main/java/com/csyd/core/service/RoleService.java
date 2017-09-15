package com.csyd.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.csyd.core.dao.RoleMapper;
import com.csyd.core.util.Pager;
import com.csyd.pojo.SysRole;

@Service("roleService")
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
public class RoleService {
  @Resource(name = "roleMapper")
  private RoleMapper roleMapper;

  @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public int add(SysRole role) {
    return roleMapper.add(role);
  }

  @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public int modify(SysRole role) {
    return roleMapper.modify(role);
  }

  @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public int remove(Integer id) {
    return roleMapper.remove(id);
  }

  public SysRole findById(Integer id) {
    return roleMapper.findById(id);
  }

  public List<SysRole> find() {
    return roleMapper.find();
  }

  public Pager<SysRole> findPager(Integer pageno, Integer pagesize, String sort, String order, String name, String code,
      String descn) {
    Pager<SysRole> pager = new Pager<SysRole>();
    pager.setRows(roleMapper.findPager(pageno, pagesize, sort, order, name, code, descn));
    pager.setTotal(roleMapper.findPagerTotal(name, code, descn));
    return pager;
  }

  /**
   * 根据选中的角色id查询显示对应的menu
   * 
   * @param roleId
   * @return
   */
  public List<Integer> findMenuRole(Integer roleId) {
    return roleMapper.findMenuRole(roleId);
  }
}
