package com.csyd.core.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.csyd.core.dao.MenuMapper;
import com.csyd.core.util.Pager;
import com.csyd.pojo.SysMenu;

@Service("menuService")
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
public class MenuService {
  @Resource(name = "menuMapper")
  private MenuMapper menuMapper;

  /**
   * 读取用户所有的菜单ID
   * 
   * @param userId
   * @return
   */
  public List<Integer> loadUserMenus(Integer userId) {
    return menuMapper.loadUserMenus(userId);
  }

  /**
   * 读取所有顶层菜单
   * 
   * @return
   */
  public List<SysMenu> loadTopMenus() {
    return menuMapper.loadTopMenus();
  }

  /**
   * 读取指定模块的顶层菜单
   * 
   * @param parentId
   *          模块ID号
   * @return
   */
  public List<SysMenu> loadChileMenus(Integer parentId) {
    return menuMapper.loadChileMenus(parentId);
  }

  @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public int add(SysMenu menu) {
    return menuMapper.add(menu);
  }

  @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public int modify(SysMenu menu) {
    return menuMapper.modify(menu);
  }

  @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public int remove(Integer id) {
    return menuMapper.remove(id);
  }

  public SysMenu findById(Integer id) {
    return menuMapper.findById(id);
  }

  public Pager<SysMenu> findPager(Integer pageno, Integer pagesize, String sort, String order, String menuName, String menuDescn,
      Integer menuParentId) {
    Pager<SysMenu> pager = new Pager<SysMenu>();
    pager.setRows(menuMapper.findPager(pageno, pagesize, sort, order, menuName, menuDescn, menuParentId));
    pager.setTotal(menuMapper.findPagerTotal(menuName, menuDescn, menuParentId));
    return pager;
  }

  /**
   * 保存菜单/角色
   * 
   * @param roleId
   * @param menuIds
   * @param oldMenuIds
   */
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public void addMenuRole(Integer roleId, String menuIds, List<Integer> oldMenuIds) {

    String[] menuIdAry = menuIds.split(",");
    List<String> ids = Arrays.asList(menuIdAry);
    // 去除重复的menuId
    HashSet<String> idsSet = new HashSet<String>(ids);
    String[] itemlist = new String[idsSet.size()];
    idsSet.toArray(itemlist);

    if (itemlist != null) {
      // 删除原有菜单/角色
      if (oldMenuIds.size() > 0) {
        for (Integer menuId : oldMenuIds) {
          // System.out.println(">>>>>> " + menuId + " " + roleId);
          menuMapper.removeMenuRole(menuId, roleId);
        }
      }

      // 保存新菜单/角色
      for (int k = 0; k < itemlist.length; k++) {
        Integer menuId = NumberUtils.createInteger(itemlist[k]);
        // System.out.println("....... " + menuId + " " + roleId);
        menuMapper.addMenuRole(menuId, roleId);
      }
    }
  }
}
