package com.csyd.seller.dao;

import com.csyd.pojo.Business;
import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 直销员佣金
 */
@Repository("sellerSalMapper")
public interface SellerSalMapper {

    List<Business> findPager(@Param("pageno") Integer pageno, @Param("pagesize") Integer pagesize, @Param("sort") String sort,
                             @Param("order") String order, @Param("proName") String proName,@Param("beginDate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
                              @Param("endDate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate, @Param("busStatus") String busStatus );

    long findPagerTotal(@Param("proName") String proName,@Param("beginDate") Date beginDate,@Param("endDate") Date endDate,@Param("busStatus") String busStatus);
}
