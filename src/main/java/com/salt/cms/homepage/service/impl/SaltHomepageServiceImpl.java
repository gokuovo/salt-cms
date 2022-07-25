package com.salt.cms.homepage.service.impl;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.salt.cms.entity.SaltImagesEntity;
import com.salt.cms.homepage.dao.SaltImagesDao;
import com.salt.cms.homepage.form.SaltImagesForm;
import com.salt.cms.homepage.service.SaltHomepageService;
import com.salt.cms.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class SaltHomepageServiceImpl implements SaltHomepageService {

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
