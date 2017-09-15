package com.csyd.joiner.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.csyd.pojo.Joiner1;

/**
 * 下级代理商管理
 */
@Repository("myJoinerMapper")
public interface MyJoinerMapper {

    //查询我的所有下级代理商(多条件查询)

    List<Joiner1> findJoiner(
            @Param("page") Integer page,
            @Param("rows") Integer rows,
            @Param("sort")  String sort,
            @Param("order") String order,
            @Param("userId") Integer userId,
            @Param("joinerName") String joinerName,
            @Param("userFlag") String userFlag
    );
    //总记录数
    int getTotal(
            @Param("userId") Integer userId,
            @Param("joinerName") String joinerName,
            @Param("userFlag") String userFlag);
    //根据id查询代理商

    Joiner1 findById(@Param("joinerId") Integer joinerId);

    //根据userId查询用户joinerId joLevelId

    @Select("select joiner_id joinerId,jo_level_id joLevelId from joiner where user_id=#{userId}")
    Joiner1 findBuUserId(Integer userId);

    //新增下级代理商

    int addJoiner(Joiner1 joiner);

    //修改下级代理商
    @Update("update joiner set joiner_name=#{joinerName},joiner_phone=#{joinerPhone},joiner_loc=#{joinerLoc},joiner_bank=#{joinerBank},joiner_banknum=#{joinerBanknum} where joiner_id=#{joinerId}")
    int updateJoiner(Joiner1 joiner);
    //查询代理商自己的下级代理商用户的个数

    @Select("select count(j2.joiner_id)scount from joiner j1,joiner j2 where j1.joiner_id=j2.jo_heigher_id and j1.joiner_id=#{joinerId};")
    int count(Integer joinerId);



}
