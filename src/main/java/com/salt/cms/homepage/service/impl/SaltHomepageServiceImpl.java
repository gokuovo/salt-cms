package com.salt.cms.homepage.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
    public List<SaltImagesForm> getBackground() {
        return saltImagesDao.getBackground();
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
    public List<SaltImagesEntity> listImage() {
        return saltImagesDao.listImage();
    }


}
