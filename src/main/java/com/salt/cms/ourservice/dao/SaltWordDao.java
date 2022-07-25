package com.salt.cms.ourservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.salt.cms.entity.SaltWordEntity;
import com.salt.cms.ourservice.form.SaltWordForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SaltWordDao extends BaseMapper<SaltWordEntity> {

    SaltWordForm getWhatWeDo();
    SaltWordForm getWhatWeDoText();
    SaltWordForm getRotation();
    List<SaltWordEntity> getWord();
}
