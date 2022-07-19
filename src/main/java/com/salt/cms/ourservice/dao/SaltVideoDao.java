package com.salt.cms.ourservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.salt.cms.entity.SaltVideoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SaltVideoDao extends BaseMapper<SaltVideoEntity> {


    @Select("select video_url from salt_video where video_type = '01' ")
    String getMusic();

    @Select("select video_url from salt_video where video_type = '02' ")
    String getSoundDesign();

    @Select("select video_url from salt_video where video_type = '03' ")
    String getVoiceActing();

    @Select("select video_url from salt_video where video_type = '04' ")
    String getGameAudioPipeline();

}
