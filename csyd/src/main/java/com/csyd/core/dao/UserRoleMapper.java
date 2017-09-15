package com.csyd.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.csyd.pojo.SysRole;

@Repository("userRoleMapper")
public interface UserRoleMapper {

  List<SysRole> findPager(@Param("pageno") Integer pageno, @Param("pagesize") Integer pagesize, @Param("sort") String sort,
                       @Param("order") String order, @Param("name") String name, @Param("code") String code,
                       @Param("descn") String descn, @Param("authorize") String authorize, @Param("userId") Integer userId);

  long findPagerTotal(@Param("name") String name, @Param("code") String code, @Param("descn") String descn,
                      @Param("authorize") String authorize, @Param("userId") Integer userId);

  @Select("select role_ID roleId,role_NAME roleName,role_CODE roleCode,role_DESC roleDesc from SYS_ROLE where role_ID in (select ROLE_ID from SYS_USER_ROLE where USER_ID=#{userId})")
  List<SysRole> findRole(@Param("userId") Integer userId);

  @Delete("delete from SYS_USER_ROLE where USER_ID=#{userId} and ROLE_ID=#{roleId}")
  void removeUserRole(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

  @Insert("insert into SYS_USER_ROLE(USER_ID,ROLE_ID) values(#{userId},#{roleId})")
  void addUserRole(@Param("userId") Integer userId, @Param("roleId") Integer roleId);
}
