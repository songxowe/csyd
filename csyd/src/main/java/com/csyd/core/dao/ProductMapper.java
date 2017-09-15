package com.csyd.core.dao;

import com.csyd.pojo.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品管理(CRUD)
 */
@Repository("productMapper")
public interface ProductMapper {
    @Insert("insert into product(pro_name,pro_type,pro_cost,pro_loc,pro_img,pro_first,pro_month,pro_link,pro_out,pro_status,pro_date)" +
            "values(#{proName},#{proType},#{proCost},#{proLoc,jdbcType=VARCHAR},#{proImg,jdbcType=VARCHAR},#{proFirst}," +
            "#{proMonth,jdbcType=DOUBLE},#{proLink,jdbcType=VARCHAR},#{proOut,jdbcType=VARCHAR},#{proStatus},#{proDate})")
    int add(Product product);

    @Delete("delete from product where pro_id=#{proId}")
    int remove(Integer proId);

    @Update("update product set pro_name=#{proName},pro_type=#{proType},pro_cost=#{proCost},pro_loc=#{proLoc,jdbcType=VARCHAR}," +
            "pro_img=#{proImg,jdbcType=VARCHAR},pro_first=#{proFirst},pro_month=#{proMonth,jdbcType=DOUBLE},pro_link=#{proLink,jdbcType=VARCHAR}" +
            ",pro_out=#{proOut,jdbcType=VARCHAR},pro_status=#{proStatus},pro_date=#{proDate} where pro_id=#{proId}")
    int modify(Product product);

    @Select("select pro_id proId,pro_name proName,pro_type proType,pro_cost proCost,pro_loc proLoc,pro_img proImg,pro_first proFirst," +
            "pro_month proMonth,pro_link proLink,pro_out proOut,pro_status proStatus,pro_date proDate from product where 1=1 and pro_id=#{proId}")
    Product findById(Integer proId);

    @Select("select pro_id proId,pro_name proName,pro_type proType,pro_cost proCost,pro_loc proLoc,pro_img proImg,pro_first proFirst," +
            "pro_month proMonth,pro_link proLink,pro_out proOut,pro_status proStatus,pro_date proDate from product")
    List<Product> find();

    List<Product> findByParam(
            @Param("proName") String proName,
            @Param("proStatus") String proStatus
    );

    int getTotal(
            @Param("proName") String proName,
            @Param("proStatus") String proStatus
    );

    List<Product> findPager(
            @Param("page") Integer page,
            @Param("rows") Integer rows,
            @Param("sort") String sort,
            @Param("order") String order,
            @Param("proName") String proName,
            @Param("proStatus") String proStatus
    );

    @Select("select pro_id proId,pro_name proName,pro_type proType,pro_cost proCost,pro_loc proLoc,pro_img proImg,pro_first proFirst," +
            "pro_month proMonth,pro_link proLink,pro_out proOut,pro_status proStatus,pro_date proDate from product where pro_id !=#{proId}")
    List<Product> findByIdNo(Integer proId);
}
