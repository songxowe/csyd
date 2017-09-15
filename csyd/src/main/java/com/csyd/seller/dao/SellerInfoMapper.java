package com.csyd.seller.dao;

import com.csyd.pojo.Seller;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * 操作用户个人信息管理
 */
@Repository("sellerInfoMapper")
public interface SellerInfoMapper {

    @Select("select seller_id sellerId,seller_name sellerName,seller_phone sellerPhone,seller_sex sellerSex,seller_card sellerCard," +
            "seller_cardnum sellerCardnum,seller_remark sellerRemark,seller_loc sellerLoc from seller where user_id=#{userId}")
    Seller findById(Integer userId);

    @Update("update seller set seller_name=#{sellerName},seller_phone=#{sellerPhone},seller_sex=#{sellerSex},seller_card=#{sellerCard}," +
            "seller_cardnum=#{sellerCardnum},seller_remark=#{sellerRemark},seller_loc=#{sellerLoc} where seller_id=#{sellerId}")
    int mofidy(Seller seller);
}
