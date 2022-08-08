package com.salt.cms.homepage.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.salt.cms.entity.SaltImagesEntity;
import com.salt.cms.homepage.dao.SaltImagesDao;
import com.salt.cms.homepage.form.SaltImagesForm;
import com.salt.cms.homepage.service.SaltHomepageService;
import com.salt.cms.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class SaltHomepageServiceImpl extends ServiceImpl<SaltImagesDao,SaltImagesEntity> implements SaltHomepageService {

    @Autowired(required=false)
    private SaltImagesDao saltImagesDao;


    @Override
    public String getLogo() {
        return saltImagesDao.getLogo();
    }

    @Override
    public List<SaltImagesEntity> getBackground() {
        QueryWrapper<SaltImagesEntity> qw = new QueryWrapper<>();
        List<String> list = new ArrayList<>();
        list.add("02");
        list.add("03");
        list.add("04");
        list.add("05");
        list.add("06");
        list.add("07");
        list.add("08");
        list.add("09");
        list.add("10");
        list.add("16");
        qw.in("image_code",list);
        List<SaltImagesEntity> saltImagesEntities = saltImagesDao.getBackground(qw);
        return saltImagesEntities;
    }

    @Override
    public List<SaltImagesEntity> getImagesByImageCode(String imageCode) {
        List<SaltImagesEntity> list = new ArrayList<>();
        if(null == imageCode || imageCode.equals("")){
            return list;
        }
        LambdaQueryWrapper<SaltImagesEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(SaltImagesEntity::getImageCode,imageCode);
        list = list(wrapper);
        return list;
    }

    @Override
    public R addImage(SaltImagesForm saltImagesForm) {
        SaltImagesEntity saltImagesEntity = new SaltImagesEntity();
        BeanUtils.copyProperties(saltImagesForm,saltImagesEntity);
        saltImagesEntity.setId(UUID.randomUUID().toString());
        saltImagesDao.insert(saltImagesEntity);
        return R.ok("成功");
    }

    @Override
    public R modifyImage(SaltImagesForm saltImagesForm) {
        SaltImagesEntity saltImagesEntity = new SaltImagesEntity();
        BeanUtils.copyProperties(saltImagesForm,saltImagesEntity);
        saltImagesDao.updateById(saltImagesEntity);
        return R.ok("成功");
    }

    @Override
    public R deleteImage(String id) {
        saltImagesDao.deleteById(id);
        return R.ok("成功");
    }

    @Override
    public SaltImagesEntity getBackgroundById(String id) {
//        QueryWrapper<SaltImagesEntity> qw = new QueryWrapper<>();
//        if ("首页背景底图".equals(id)){
//            qw.eq("image_code","02");
//        }else if ("首页背景顶图".equals(id)){
//            qw.eq("image_code","03");
//        }else if ("ourservice背景".equals(id)){
//            qw.eq("image_code","04");
//        }else if ("project背景".equals(id)){
//            qw.eq("image_code","05");
//        }else if ("contactus背景".equals(id)){
//            qw.eq("image_code","06");
//        }else if ("team背景".equals(id)){
//            qw.eq("image_code","07");
//        }else if ("news背景".equals(id)){
//            qw.eq("image_code","08");
//        }else if ("partner背景".equals(id)){
//            qw.eq("image_code","09");
//        }else if ("contactUs移动背景图".equals(id)){
//            qw.eq("image_code","10");
//        }
        return saltImagesDao.selectById(id);
    }
}
