package com.salt.cms.contactus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.salt.cms.contactus.form.SaltContactForm;
import com.salt.cms.entity.SaltContactEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SaltContactUsDao extends BaseMapper<SaltContactEntity> {


    @Select("select * from salt_contact")
    SaltContactForm getContact();

}
