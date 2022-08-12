package com.salt.cms.projects.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.salt.cms.entity.SaltListEntity;
import com.salt.cms.entity.SaltMusicVideoEntity;
import com.salt.cms.entity.SaltPortalMenuEntity;
import com.salt.cms.menu.form.SPMenuForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SaltMusicVideoDao extends BaseMapper<SaltMusicVideoEntity> {

    @Select("select * from salt_music_video where type = '0' order by sort")
    List<SaltMusicVideoEntity> getMusicList();
}
