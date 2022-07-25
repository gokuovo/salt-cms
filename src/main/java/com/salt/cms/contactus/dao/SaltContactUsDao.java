package com.salt.cms.contactus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.salt.cms.contactus.form.SaltContactForm;
import com.salt.cms.entity.SaltContactEntity;
import com.salt.cms.entity.SaltSocialEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SaltContactUsDao extends BaseMapper<SaltContactEntity> {


    @Select("select * from salt_contact")
    SaltContactForm getContact();

    @Select("select * from salt_contact limit 6")
    List<SaltSocialEntity> getSocialSix();

    @Select("select * from salt_contact limit 4")
    List<SaltSocialEntity> getSocialFour();

}
