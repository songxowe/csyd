package com.csyd.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csyd.core.dao.EmpMapper;
import com.csyd.pojo.Employee;
import com.csyd.pojo.Organ;
import com.csyd.pojo.SysMenu;
import com.csyd.pojo.SysMenuRole;
import com.csyd.pojo.SysRole;
import com.csyd.pojo.SysUser;
import com.csyd.pojo.SysUserRole;
import com.csyd.core.util.Pager;

@Service("empService")
public class EmpService {
    @Resource(name="empMapper")
    private EmpMapper empMapper;

    //查询所有角色
    public List<SysRole> findRole(){
        return empMapper.findRole();
    }
    //根据userid修改状态
    public int updateFlag(SysUser sysUser){
        return empMapper.updateFlag(sysUser);
    }

    //根据角色id查询角色的权限
    public List<SysMenu> findRight(Integer roleId){
        return empMapper.findRight(roleId);
    }

    //新增用户
    public int addUser(SysUser sysUser){
        return empMapper.addUser(sysUser);
    }
    //新增员工信息
    public int addEmp(Employee employee){
        return empMapper.add(employee);
    }
    //多条件查询员工表
    public Pager<Employee> findEmps(Integer page, Integer rows, String sort, String order,Integer id,String name,String phone){
        Pager<Employee> pager=new Pager<Employee>();
        pager.setRows(empMapper.findEmps(page, rows, sort, order, id, name, phone));
        pager.setTotal(empMapper.getTotal(id, name, phone));

        return pager;
    }
    //修改员工信息
    public int updateEmp(Employee employee){
        return empMapper.updateEmp(employee);
    }


    //删除员工信息
    public int removeEmp(Integer id){
        return empMapper.removeEmp(id);
    }

    //查询用户名
    public SysUser findName(Integer userId){
        return empMapper.name(userId);
    }
    //查询所有组织
    public List<Organ> findOrgan(){
        return empMapper.findOrgan();
    }
    //新增mr表
    public int addMR(SysMenuRole sysMenuRole){
        return empMapper.addMR(sysMenuRole);
    }
    //新增ur表
    public int addUr(SysUserRole ur){
        return empMapper.addUR(ur);
    }
    //修改
    public int updateUR(SysUserRole ur){
        return empMapper.updateUR(ur);
    }

    //根据用户名查到id
    public int findId(String userName){
        return empMapper.userId(userName);
    }
    //根据id查询emp
    public Employee findById(Integer id){

        return empMapper.findById(id);
    }

    //根据用户id查询角色
    public SysRole findByRole(Integer userId){
        return empMapper.findByRole(userId);
    }

}
