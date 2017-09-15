package com.csyd.core.dao;

import com.csyd.pojo.Organ;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 组织信息（CRUD）
 */
@Repository("organMapper")
public interface OrganMapper {

    @Insert({"insert into organ(organ_id,organ_heigh,organ_name,organ_type,organ_loc,organ_dir" +
            ",organ_linkman,organ_phone,organ_explain) values(#{organId},#{organHeigh},#{organName},#{organType},#{organLoc},#{organDir}," +
            "#{organLinkman},#{organPhone},#{organExplain})"})
    int add(Organ organ);
    @Update({"update organ set organ_heigh=#{organHeigh},organ_name=#{organName},organ_type=#{organType},organ_loc=#{organLoc},organ_dir=#{organDir}," +
            "organ_linkman=#{organLinkman},organ_phone=#{organPhone},organ_explain=#{organExplain} where organ_id=#{organId}"})
    int update(Organ organ);
    @Delete("delete from organ where organ_id=#{organId}")
    int delete(Integer organId);


    // @Select("select organ_id organId,organ_heigh organHeigh, organ_name organName,organ_type organType,organ_loc organLoc ,organ_dir organDir,organ_linkman organLinkman,organ_phone organPhone,organ_explain organExplain from organ")
    List<Organ> find();

    //@Select("select organ_id organId,organ_heigh organHeigh, organ_name organName,organ_type organType,organ_loc organLoc ,organ_dir organDir,organ_linkman organLinkman,organ_phone organPhone,organ_explain organExplain from organ where organ_id=#{organId}")
    Organ findById(Integer organId);

    List<Organ> findPager(@Param("organName") String organName,
                          @Param("sort") String sort,
                          @Param("order") String order,
                          @Param("page") Integer page,
                          @Param("rows") Integer rows);

    int getTotal(@Param("organName")String organName);


    void insertInfoBatch(List<Organ> organs);

    List<Organ> findByParam(@Param("organName") String organName);

    @Select("select organ_heigh from organ where organ_id=#{organId}")
    String findByHeigh(Integer organId);
}