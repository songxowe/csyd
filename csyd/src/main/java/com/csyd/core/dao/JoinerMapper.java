package com.csyd.core.dao;

import com.csyd.pojo.Joiner;
import com.csyd.pojo.Organ;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 代理商个人信息管理
 */
@Repository("joinerMapper")
public interface JoinerMapper {
    @Insert("Insert into joiner" +
            "(user_id,joiner_name,organ_id,joiner_loc,joiner_linkname,joiner_phone,joiner_email,joiner_address," +
            "joiner_bank,joiner_holder,joiner_banknum,joiner_explain ,jo_level_id ,joiner_date,joiner_status,joiner_Remark)values" +
            "(#{userId},#{joinerName},#{organ.organId},#{joinerLoc},#{joinerLinkname},#{joinerPhone},#{joinerEmail},#{joinerAddress}" +
            ",#{joinerBank},#{joinerHolder},#{joinerBanknum},#{joinerExplain},#{joLevelId},now(),#{joinerStatus},#{joinerRemark})")
    Integer add(Joiner Joiner);
    @Update("update joiner set joiner_Status=#{joinerStatus},joiner_Remark=#{joinerRemark} where joiner_Id=#{joinerId} ")
    Integer modify(Joiner joiner);

    Joiner findById(Integer joinerId);
    @Update("update joiner set joiner_name=#{joinerName},organ_id=#{organ.organId},joiner_loc=#{joinerLoc}," +
            "joiner_linkname=#{joinerLinkname},joiner_phone=#{joinerPhone},joiner_email=#{joinerEmail},joiner_address=#{joinerAddress},"+
            "joiner_bank=#{joinerBank},joiner_holder=#{joinerHolder},joiner_banknum=#{joinerBanknum},joiner_explain=#{joinerExplain} where joiner_Id=#{joinerId} ")
    Integer edit(Joiner joiner);

    /**
     * 分页查询+条件查询
     * @param pageno
     * @param pagesize
     * @param sort
     * @param order
     * @param joinerName  代理商名称
     * @param joinerStatus  状态
     * @param joinerDate    申请日期
     * @return
     */
    List<Joiner> findPager(@Param("pageno") Integer pageno,
                           @Param("pagesize") Integer pagesize,
                           @Param("sort") String sort,
                           @Param("order") String order,
                           @Param("joinerName")String joinerName,
                           @Param("joinerStatus")String joinerStatus,
                           @Param("beginDate")Date beginDate,
                           @Param("endDate")Date endDate
    );

    /**
     * 查询分页记录总数+条件查询
     * @param joinerName
     * @param joinerStatus
     * @param joinerDate
     * @return
     */
    long findPagerTotal(@Param("joinerName")String joinerName,
                        @Param("joinerStatus")String joinerStatus,
                        @Param("beginDate")Date beginDate,
                        @Param("endDate")Date endDate);

    @Select("select organ_id organId ,organ_name organName from organ")
    List<Organ> findOrgan();

    @Delete("delete from joiner where joiner_Id=#{joinerId} ")
    Integer remove(Integer joinerId);

    @Insert("insert into SYS_USER_ROLE(USER_ID,ROLE_ID) values(#{userId},#{roleId})")
    void addUserRole(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

    @Update("update sys_user set user_flag=1 where user_id=#{userId}")
    void updateFlag(@Param("userId")Integer userId);
}
