package com.csyd.seller.dao;

import com.csyd.pojo.Business;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 业务办理
 */
@Repository("businessMapper")
public interface BusinessMapper {

    @Insert("insert into business(cus_phone,pro_name,bus_type,bus_open,seller_id) " +
            "values(#{cusPhone},#{proName},#{busType},#{busOpen},#{sellerId})")
    int addBus(Business business);

    @Select("select pro_name proName from product where pro_status=1")
    List<String> findProName();
}
