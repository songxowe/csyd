package com.csyd.joiner.dao;

import com.csyd.pojo.Business;
import com.csyd.pojo.SalTotal;
import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 佣金查询以及业务营销记录
 */
@Repository("salMapper")
public interface SalMapper {

    List<Business> findPager(@Param("pageno") Integer pageno, @Param("pagesize") Integer pagesize, @Param("sort") String sort,
                        @Param("order") String order,@Param("proName") String proName,@Param("beginDate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
                        @Param("endDate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate, @Param("busStatus") String busStatus,@Param("userId") Integer userId);

    List<SalTotal> total(@Param("userId")Integer userId, @Param("year")String year);

    long findPagerTotal(@Param("proName") String proName,@Param("beginDate") Date beginDate,@Param("endDate") Date endDate,@Param("busStatus") String busStatus,@Param("userId") Integer userId);
}
