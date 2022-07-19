package com.salt.cms.homepage.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.salt.cms.entity.SaltImagesEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface SaltImagesDao extends BaseMapper<SaltImagesEntity> {

//    @Select("select menu_name from salt_portal_menu")
//    List<String> getMenuName();
    @Select("select image_url from salt_iamges where image_code = '01' ")
    String getLogo();

    @Select("select image_url from salt_iamges where image_code = '02' ")
    String getBackgroundUnder();

    @Select("select image_url from salt_iamges where image_code = '03' ")
    String getBackgroundUp();
}
