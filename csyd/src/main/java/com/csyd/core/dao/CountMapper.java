package com.csyd.core.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.csyd.pojo.Business;
import com.csyd.pojo.Vaddress;
import com.csyd.pojo.Vbus;
import com.csyd.pojo.Vbusiness;

/**
 * 统计分析
 */
@Repository("countMapper")
public interface CountMapper {
    //查询全省每一种产品的营销总和
    @Select("select count(Pro_name) sellerId,Pro_name proName,bus_type busType from business GROUP BY Pro_name")
    List<Business> findAll();
    //一级代理商地区每种产品的营销量


    List<Vaddress> findAddress(@Param("sellerLoc")String sellerLoc,
                               @Param("proName")String proName,
                               @Param("beginDate")Date beginDate,
                               @Param("endDate")Date endDate);

    //业务发展明细查询
    List<Vbusiness> findBs(
            @Param("page") Integer page,
            @Param("rows") Integer rows,
            @Param("sort")  String sort,
            @Param("order") String order,
            @Param("sellerLoc")String sellerLoc,
            @Param("organName")String organName,
            @Param("proName")String proName,
            @Param("sellerPhone")String sellerPhone,
            @Param("cusPhone")String cusPhone,
            @Param("beginDate")Date beginDate,
            @Param("endDate")Date endDate
    );

    int getTotal(@Param("sellerLoc")String sellerLoc,
                 @Param("organName")String organName,
                 @Param("proName")String proName,
                 @Param("sellerPhone")String sellerPhone,
                 @Param("cusPhone")String cusPhone,
                 @Param("beginDate")Date beginDate,
                 @Param("endDate")Date endDate);

    //业务销售记录分页查询
    List<Vbus> findVbus(
            @Param("page") Integer page,
            @Param("rows") Integer rows,
            @Param("sort")  String sort,
            @Param("order") String order,
            @Param("sellerPhone")String sellerPhone,
            @Param("joinerName") String joinerName,
            @Param("beginDate")Date beginDate,
            @Param("endDate")Date endDate
    );
    int getTotalVbus(
            @Param("sellerPhone")String sellerPhone,
            @Param("joinerName") String joinerName,
            @Param("beginDate")Date beginDate,
            @Param("endDate")Date endDate
    );


}

