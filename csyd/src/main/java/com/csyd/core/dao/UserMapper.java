package com.csyd.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.csyd.pojo.SysUser;

/**
 * 用户管理以及登录注销
 */
@Repository("userMapper")
public interface UserMapper {
    @Select("SELECT user_id userId,user_name userName,user_password userPassword,user_flag userFlag from sys_user WHERE user_name=#{userName} AND user_password=#{userPassword} AND user_flag='1'")
    SysUser login(@Param("userName") String username, @Param("userPassword") String password);

    @Update("UPDATE SYS_USER SET user_password=#{password} WHERE user_id=#{id}")
    int changePassword(@Param("id") Integer id, @Param("password") String password);

    // ** CRUD *********************************************************
    @Insert("insert into sys_user(user_name,user_password,user_flag) values(#{userName},#{userPassword},#{userFlag})")
    int add(SysUser user);

    @Update("update SYS_USER set user_name=#{userName},user_password=#{userPassword},user_flag=#{userFlag} where user_id=#{userId}")
    int modify(SysUser user);

    @Delete("delete from SYS_USER where user_id=#{id}")
    int remove(Integer id);

    @Select("SELECT user_id userId,user_name userName,user_password userPassword,user_flag userFlag from sys_user WHERE user_id=#{id}")
    SysUser findById(Integer id);

    List<SysUser> findPager(@Param("pageno") Integer pageno, @Param("pagesize") Integer pagesize, @Param("sort") String sort,
                         @Param("order") String order, @Param("userName") String username, @Param("userFlag") String userFlag);

    long findPagerTotal(@Param("userName") String username, @Param("userFlag") String userFlag);

    @Delete("delete from SYS_USER_ROLE where USER_ID=#{userId} and ROLE_ID=#{roleId}")
    void removeUserRole(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

    @Insert("insert into SYS_USER_ROLE(USER_ID,ROLE_ID) values(#{userId},#{roleId})")
    void addUserRole(@Param("userId") Integer userId, @Param("roleId") Integer roleId);
}
