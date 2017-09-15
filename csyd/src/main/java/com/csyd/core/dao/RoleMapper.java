package com.csyd.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.csyd.pojo.SysRole;

@Repository("roleMapper")
public interface RoleMapper {

  @Insert("insert into SYS_ROLE(role_NAME,role_CODE,role_DESC) values(#{roleName},#{roleCode},#{roleDesc})")
  int add(SysRole role);

  @Update("update SYS_ROLE set role_NAME=#{roleName},role_CODE=#{roleCode},role_DESC=#{roleDesc} where role_ID=#{roleId}")
  int modify(SysRole role);

  @Delete("delete from SYS_ROLE where role_ID=#{roleId}")
  int remove(Integer roleId);

  @Select("select role_ID roleId,role_NAME roleName,role_CODE roleCode,role_DESC roleDesc from SYS_ROLE where role_ID=#{id}")
  SysRole findById(Integer id);

  @Select("select role_ID roleId,role_NAME roleName,role_CODE roleCode,role_DESC roleDesc from SYS_ROLE order by role_ID")
  List<SysRole> find();

  List<SysRole> findPager(@Param("pageno") Integer pageno, @Param("pagesize") Integer pagesize, @Param("sort") String sort,
                       @Param("order") String order, @Param("name") String name, @Param("code") String code,
                       @Param("descn") String descn);

  long findPagerTotal(@Param("name") String name, @Param("code") String code, @Param("descn") String descn);

  /**
   * 根据选中的角色id查询显示对应的menu
   * 
   * @param roleId
   * @return
   */
  @Select("select MENU_ID from SYS_MENU_ROLE where ROLE_ID=#{roleId} order by MENU_ID")
  List<Integer> findMenuRole(@Param("roleId") Integer roleId);
}
