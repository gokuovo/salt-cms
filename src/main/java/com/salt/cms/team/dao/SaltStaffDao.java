package com.salt.cms.team.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.salt.cms.entity.SaltStaffEntity;
import com.salt.cms.entity.SaltVideoEntity;
import com.salt.cms.team.form.SaltTeamForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SaltStaffDao extends BaseMapper<SaltStaffEntity> {


    @Select("select * from salt_video order by sort ")
    List<SaltTeamForm> getTeam();
    @Select("select * from salt_video order by sort ")
    List<SaltStaffEntity> getStaff();


}
