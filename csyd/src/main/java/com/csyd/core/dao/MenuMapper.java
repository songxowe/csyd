package com.csyd.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.csyd.pojo.SysMenu;

@Repository("menuMapper")
public interface MenuMapper {

  @Select("SELECT DISTINCT MR.MENU_ID FROM SYS_MENU_ROLE MR,SYS_ROLE R,SYS_USER_ROLE UR WHERE MR.ROLE_ID=R.role_id AND R.role_id=UR.ROLE_ID AND UR.USER_ID=#{userId}")
  List<Integer> loadUserMenus(@Param("userId") Integer userId);

  @Select("SELECT menu_ID menuId,menu_PARENT_ID menuParentId,SEQ,menu_NAME menuName,menu_DESCN menuDescn,menu_LINK_URL menuLinkUrl,menu_STATUS menuStatus FROM SYS_MENU WHERE menu_PARENT_ID IS NULL ORDER BY SEQ")
  List<SysMenu> loadTopMenus();

  @Select("SELECT menu_ID menuId,menu_PARENT_ID menuParentId,SEQ,menu_NAME menuName,menu_DESCN menuDescn,menu_LINK_URL menuLinkUrl,menu_STATUS menuStatus FROM SYS_MENU WHERE menu_PARENT_ID=#{menuParentId} ORDER BY SEQ")
  List<SysMenu> loadChileMenus(@Param("menuParentId") Integer menuParentId);

  // ** CRUD *************************************************************
  @Insert("insert into SYS_MENU(MENU_PARENT_ID,SEQ,MENU_NAME,MENU_DESCN,MENU_LINK_URL,MENU_STATUS) values(#{menuParentId,jdbcType=INTEGER},#{seq},#{menuName},#{menuDescn},#{menuLinkUrl},#{menuStatus})")
  int add(SysMenu menu);

  @Update("update SYS_MENU set MENU_PARENT_ID=#{menuParentId,jdbcType=INTEGER},SEQ=#{seq},MENU_NAME=#{menuName},MENU_DESCN=#{menuDescn},MENU_LINK_URL=#{menuLinkUrl},MENU_STATUS=#{menuStatus} where MENU_ID=#{menuId}")
  int modify(SysMenu menu);

  @Delete("delete from SYS_MENU where MENU_ID=#{menuId}")
  int remove(Integer id);

  @Select("SELECT MENU_ID menuId,MENU_PARENT_ID menuParentId,SEQ,MENU_NAME menuName,MENU_DESCN menuDescn,MENU_LINK_URL menuLinkUrl,MENU_STATUS menuStatus FROM SYS_MENU WHERE MENU_ID=#{menuId}")
  SysMenu findById(Integer id);

  List<SysMenu> findPager(@Param("pageno") Integer pageno, @Param("pagesize") Integer pagesize, @Param("sort") String sort,
                       @Param("order") String order, @Param("menuName") String menuName, @Param("menuDescn") String menuDescn,
                       @Param("menuParentId") Integer menuParentId);

  long findPagerTotal(@Param("menuName") String ename, @Param("menuDescn") String descn, @Param("menuParentId") Integer parentId);

  @Delete("delete from SYS_MENU_ROLE where MENU_ID=#{menuId} and ROLE_ID=#{roleId}")
  void removeMenuRole(@Param("menuId") Integer menuId, @Param("roleId") Integer roleId);

  @Insert("insert into SYS_MENU_ROLE(MENU_ID,ROLE_ID) values(#{menuId},#{roleId})")
  void addMenuRole(@Param("menuId") Integer menuId, @Param("roleId") Integer roleId);
}
