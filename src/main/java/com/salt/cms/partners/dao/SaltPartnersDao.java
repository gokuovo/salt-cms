package com.salt.cms.partners.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.salt.cms.entity.SaltPartnerEntity;
import com.salt.cms.partners.form.SaltPartnersForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SaltPartnersDao extends BaseMapper<SaltPartnerEntity> {

//    @Select("select menu_name from salt_portal_menu")
//    List<String> getMenuName();
//    @Select("select * from salt_partner order by sort")
//    List<SaltPartnersForm> getAllPartners();

    @Select("select partner_url from salt_partner order by sort")
    List<String> getPartners();
    @Select("select * from salt_partner order by sort")
    List<SaltPartnerEntity> selectPartner();
}
