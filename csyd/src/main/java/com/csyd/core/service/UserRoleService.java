package com.csyd.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.csyd.core.dao.UserRoleMapper;
import com.csyd.core.util.Constants;
import com.csyd.core.util.Pager;
import com.csyd.pojo.SysRole;

@Service("userRoleService")
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
public class UserRoleService {
  @Resource(name = "userRoleMapper")
  private UserRoleMapper userRoleMapper;

  public Pager<SysRole> findPager(Integer pageno, Integer pagesize, String sort, String order, String name, String code,
      String descn, String authorize, Integer userId) {
    Pager<SysRole> pager = new Pager<SysRole>();
    pager.setRows(userRoleMapper.findPager(pageno, pagesize, sort, order, name, code, descn, authorize, userId));
    pager.setTotal(userRoleMapper.findPagerTotal(name, code, descn, authorize, userId));

    List<SysRole> userRoles = userRoleMapper.findRole(userId);

    for (SysRole role : pager.getRows()) {
      for (SysRole r : userRoles) {
        // 判断是否授权
        if (role.getRoleId() == r.getRoleId()) {
          role.setAuthorize(Constants.STATUS_AUTH);
        } else {
          role.setAuthorize(Constants.STATUS_UNAUTH);
        }
      }
    }
    return pager;
  }

  /**
   * 用户角色管理操作
   * 
   * @param userId
   * @param isAuth
   */
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public void addUserRoles(Integer userId, String[] roleIds, boolean isAuth) {

    if (roleIds != null) {
      // 取消授权:删除原用户/角色
      List<SysRole> userRoles = userRoleMapper.findRole(userId);
      if (userRoles.size() > 0) {
        for (SysRole role : userRoles) {
          userRoleMapper.removeUserRole(userId, role.getRoleId());
        }
      }

      if (isAuth) {
        // 授权:保存新用户/角色
        for (int i = 0; i < roleIds.length; i++) {
          userRoleMapper.addUserRole(userId, NumberUtils.createInteger(roleIds[i]));
        }
      }
    }

  }
}
