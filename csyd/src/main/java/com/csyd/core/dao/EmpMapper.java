package com.csyd.core.dao;


import java.util.List;



import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.csyd.pojo.Employee;
import com.csyd.pojo.Organ;
import com.csyd.pojo.SysMenu;
import com.csyd.pojo.SysMenuRole;
import com.csyd.pojo.SysRole;
import com.csyd.pojo.SysUser;
import com.csyd.pojo.SysUserRole;


/**
 * 员工信息（CRUD）
         */
@Repository("empMapper")
public interface EmpMapper {



    //新增员工信息
    @Insert("insert into employee(organ_id, job, name, sex, phone, doc_type, doc_number, agent_name, loc, bank_name, bank_number, user_id) "
            + " VALUES (#{organId},#{job},#{name},#{sex},#{phone},#{docType},#{docNumber},#{agentName},#{loc},#{bankName},#{bankNumber},#{userId})")
    int add(Employee employee);
    //根据organ_id查询组织名字
    @Select("select organ_name organName from organ where organ_id=#{organId}")
    String findOrganName(Integer organId);
    //查询所有组织的名字
    @Select("select distinct(organ_name) organName,organ_id organId from organ")
    List<Organ> findOrgan();

    @Insert("insert into sys_user_role values(#{userId},#{roleId})")
    int addUR(SysUserRole ur);
    //修改ur
    @Update("update sys_user_role set role_id=#{roleId} where user_id=#{userId}")
    int updateUR(SysUserRole ur);


    @Insert("insert into sys_menu_role(menu_id,role_id) values(#{menuId},#{roleId})")
    int addMR(SysMenuRole sysMenuRole);
    //根据组织名字查询organ_id
    @Select("select organ_id organId from organ where organ_name=#{organName}")
    String findOrganId(String organName);

    //查询所有角色
    @Select("select role_id roleId,role_name roleName from sys_role")
    List<SysRole> findRole();

    //根据用户id查询角色
    @Select("select r.role_id roleId ,r.role_name roleName from sys_user_role u ,sys_role r where u.role_id=r.role_id and u.user_id=#{userId};")
    SysRole findByRole(Integer userId);


    //根据id查询状态

    //根据角色id查询角色的权限
    @Select("select distinct(menu_name) menuName,m.menu_id menuId from sys_menu_role r,sys_menu m where r.menu_id=m.menu_id and r.role_id=#{roleId}")
    List<SysMenu> findRight(Integer roleId);

    //新增用户

    @Insert("insert into sys_user(user_name,user_password,user_flag)values(#{userName},#{userPassword},#{userFlag})")
    int addUser(SysUser sysUser);

    //新增ur

    //修改员工信息
    @Update("update employee set organ_id=#{organId},name=#{name},job=#{job},sex=#{sex},phone=#{phone},doc_type=#{docType},doc_number=#{docNumber},"
            + "agent_name=#{agentName},loc=#{loc},bank_name=#{bankName},bank_number=#{bankNumber} where id=#{id}")
    int updateEmp(Employee employee);


    //删除员工信息


    @Delete("delete from employee where id=#{id}")
    int removeEmp(Integer id);

    //根据id查用户名
    @Select("select user_name userName,user_flag userFlag  from sys_user where user_id=#{userId}")
    SysUser name(Integer userId);

    //根据用户名查id
    @Select("select user_id userId from  sys_user where user_name=#{userName}")
    Integer userId(String userName);

    //根据userId修改状态
    @Update("update sys_user set user_flag=#{userFlag} where user_id=#{userId}")
    int updateFlag(SysUser sysUser);

    //查询员工信息(员工id 或者员工姓名 手机号码)
    List<Employee> findEmps( @Param("page") Integer page,
                             @Param("rows") Integer rows,
                             @Param("sort")  String sort,
                             @Param("order") String order,
                             @Param("id") Integer id,
                             @Param("name")String name,
                             @Param("phone")String phone

    );
    //总记录数
    int getTotal(@Param("id") Integer id,
                 @Param("name")String name,
                 @Param("phone")String phone);

    Employee findById(@Param("id")Integer id);
}
