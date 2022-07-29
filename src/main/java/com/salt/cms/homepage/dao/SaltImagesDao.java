package com.salt.cms.homepage.dao;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.salt.cms.entity.SaltImagesEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface SaltImagesDao extends BaseMapper<SaltImagesEntity> {

//    @Select("select menu_name from salt_portal_menu")
//    List<String> getMenuName();
    @Select("select image_url from salt_images where image_code = '01' ")
    String getLogo();

    List<SaltImagesEntity> getBackground(@Param(Constants.WRAPPER) QueryWrapper<SaltImagesEntity> qw);

    @Select("select * from salt_images")
    List<SaltImagesEntity> listImage();

}
