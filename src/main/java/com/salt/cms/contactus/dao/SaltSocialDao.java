package com.salt.cms.contactus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.salt.cms.contactus.form.SaltContactForm;
import com.salt.cms.entity.SaltSocialEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SaltSocialDao extends BaseMapper<SaltSocialEntity> {


}
