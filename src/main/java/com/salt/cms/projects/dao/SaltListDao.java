package com.salt.cms.projects.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.salt.cms.entity.SaltAlbumEntity;
import com.salt.cms.entity.SaltListEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SaltListDao extends BaseMapper<SaltListEntity> {

    @Select("select * from salt_List order by sort")
    List<SaltListEntity> getList();
}
