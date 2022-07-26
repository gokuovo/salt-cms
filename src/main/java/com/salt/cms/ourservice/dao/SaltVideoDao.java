package com.salt.cms.ourservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.salt.cms.entity.SaltVideoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface SaltVideoDao extends BaseMapper<SaltVideoEntity> {

    @Select("select * from salt_video")
    List<SaltVideoEntity> getVideoList();
}
