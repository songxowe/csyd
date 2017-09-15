package com.csyd.joiner.dao;

import com.csyd.pojo.Joiner;
import com.csyd.pojo.Seller;
import com.csyd.pojo.SysUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 直销员管理
 */
@Repository("sellerMapper")
public interface SellerMapper {

    List<Seller> findPager(@Param("sellerName") String sellerName,
                           @Param("sellerPhone") String sellerPhone,
                           @Param("userFlag") String userFlag,
                           @Param("userId") Integer userId,
                           @Param("sort") String sort,
                           @Param("order") String order,
                           @Param("page") Integer page,
                           @Param("rows") Integer rows);


    int getTotal(@Param("sellerName") String sellerName, @Param("sellerPhone") String sellerPhone,
                 @Param("userFlag") String userFlag,@Param("userId") Integer userId);

    //添加
    @Insert({"insert into seller(seller_id,Seller_name, Seller_phone, joiner_id, user_id, Seller_sex, Seller_card, Seller_cardnum, Seller_remark, Seller_date, Seller_loc)" +
            "values(#{sellerId},#{sellerName},#{sellerPhone},#{joinerId},#{userId},#{sellerSex},#{sellerCard},#{sellerCardnum},#{sellerRemark},now(),#{sellerLoc})"})
    int add(Seller seller);

    //根据ID查询
    Seller findById(Integer sellerId);

    //修改
    @Update({"update seller set seller_name=#{sellerName},seller_phone =#{sellerPhone},seller_sex=#{sellerSex},seller_cardnum = #{sellerCardnum} where seller_id=#{sellerId}"})
    int updateSeller(Seller seller);

    //删除
    @Delete("delete from seller where user_id =#{userId}")
    int deleteSeller(Integer userId);






    /*
    * Sys_user 表的操作
    * */
    //根据用户名查询
    @Select("select user_id userId,user_name userName from sys_user where user_name =#{userName}")
    SysUser findParamId(String userName);

    //添加
    @Insert({"insert into sys_user(user_id,user_name,user_password,user_flag) values(#{userId},#{userName},#{userPassword},#{userFlag})"})
    int addUser(SysUser sysUser);

    //修改
    @Update({"update sys_user set user_name = #{userName},user_password = #{userPassword} where user_id =#{userId} "})
    int updateUser(SysUser sysUser);

    //删除
    @Delete("delete from sys_user where user_id =#{userId}")
    int deleteUser(Integer userId);

    //根据Id 查询
    @Select("select user_id userId,user_name userName from sys_user where user_id =#{userId}")
    SysUser findByUserId(Integer userId);

    //获取用户名
    SysUser findSysUser(Integer userId);


    /*
    * 操作joiner
    * */
//  @Select({"select joiner_id from joiner where joiner_name = #{joinerName}"})
//  int findJoiner(String joinerName);

    @Select({"select joiner_id joinerId from joiner where user_id=#{userId}"})
    int findJoiner(Integer userId);

    //获取代理商
    @Select("select joiner_name joinerName from joiner where user_id=#{userId}")
    String findJoinerName(Integer userId);
}
