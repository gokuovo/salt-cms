package com.salt.cms.ourservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.salt.cms.entity.SaltCodeEntity;
import com.salt.cms.entity.SaltWordEntity;
import com.salt.cms.ourservice.form.SaltWordForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SaltCodeDao extends BaseMapper<SaltCodeEntity> {

    @Select("select code from salt_code where code_type = 'wordType'")
    List<String> getWordType();

}
