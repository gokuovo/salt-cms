package com.salt.cms.homepage.service;


import com.salt.cms.entity.SaltImagesEntity;
import com.salt.cms.homepage.form.SaltImagesForm;

import java.util.List;

public interface SaltHomepageService {

    String getLogo();

    List<SaltImagesForm> getBackground();

    List<SaltImagesEntity> getImagesByImageCode(String imageCode);
//    R addMenu(SPMenuForm spMenuForm);
//    R modifyMenu(SPMenuForm spMenuForm);
//    R deleteMenu(String id);
}
