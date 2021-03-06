package com.bugly.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bugly.system.model.ServiceTypeUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author no_f
 * @since 2020-07-01
 */
@Repository
public interface ServiceTypeUserDao extends BaseMapper<ServiceTypeUser> {

    @Select("SELECT su.nick_name FROM `service_type_user` stu, `sys_user` su where stu.user_id = su.id and stu.service_type_id =#{serviceTypeId}")
    List<String> findByServiceTypeId(String serviceTypeId);

    @Select("SELECT count(id) FROM `service_type_user`")
    int findAllNum();

    @Delete("delete FROM `service_type_user` where service_type_id =#{serviceTypeId}")
    int deleteByServiceTypeId(String serviceTypeId);

    @Select("SELECT * FROM `service_type_user` where user_id = #{userId} and service_type_id =#{serviceTypeId}")
    ServiceTypeUser findByServiceTypeIdAndUserId(String serviceTypeId, String userId);

    @Select("SELECT su.email FROM `service_type_user` stu, `sys_user` su where stu.user_id = su.id and stu.service_type_id =#{serviceTypeId}")
    List<String> findUserEmailByServiceTypeId(String serviceTypeId);

}
