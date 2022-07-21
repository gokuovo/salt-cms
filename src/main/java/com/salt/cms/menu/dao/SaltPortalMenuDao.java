package com.salt.cms.menu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.salt.cms.entity.SaltPortalMenuEntity;
import com.salt.cms.menu.form.SPMenuForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SaltPortalMenuDao extends BaseMapper<SaltPortalMenuEntity> {

//    @Select("select menu_name from salt_portal_menu")
//    List<String> getMenuName();
    @Select("select * from salt_portal_menu order by sort")
    List<SPMenuForm> getMenu();
}
