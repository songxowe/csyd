package com.csyd.seller.dao;

import com.csyd.pojo.Business;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 业务销售记录
 */
@Repository("busRecordMapper")
public interface BusRecordMapper {

    List<Business> findPager(@Param("pageno") Integer pageno, @Param("pagesize") Integer pagesize, @Param("sort") String sort,
                             @Param("order") String order,@Param("cusPhone") String cusPhone,@Param("proName") String proName,
                             @Param("beginDate") Date beginDate,@Param("endDate") Date endDate);

    long findPagerTotal(@Param("cusPhone") String cusPhone,@Param("proName") String proName,
                        @Param("beginDate") Date beginDate,@Param("endDate") Date endDate);

    List<Business> findPager1(@Param("pageno") Integer pageno, @Param("pagesize") Integer pagesize, @Param("sort") String sort,
                             @Param("order") String order,@Param("joinerId")Integer joinerId,@Param("sellerPhone") String sellerPhone,@Param("sellerName") String sellerName,
                             @Param("beginDate") Date beginDate,@Param("endDate") Date endDate);

    long findPagerTotal1(@Param("joinerId")Integer joinerId,@Param("sellerPhone") String sellerPhone,@Param("sellerName") String sellerName,
                        @Param("beginDate") Date beginDate,@Param("endDate") Date endDate);
}
