package com.salt.cms.projects.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.salt.cms.entity.SaltAlbumEntity;
import com.salt.cms.entity.SaltListEntity;
import com.salt.cms.entity.SaltMusicVideoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SaltAlbumDao extends BaseMapper<SaltAlbumEntity> {
    @Select("select * from salt_album order by sort")
    List<SaltAlbumEntity> getAlbum();

    @Select("select * from salt_list order by sort")
    List<SaltListEntity> getList();
}
