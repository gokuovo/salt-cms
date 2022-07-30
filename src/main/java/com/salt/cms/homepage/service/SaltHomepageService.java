package com.salt.cms.homepage.service;


import com.salt.cms.entity.SaltImagesEntity;
import com.salt.cms.homepage.form.SaltImagesForm;
import com.salt.cms.utils.R;

import java.util.List;

public interface SaltHomepageService {

    String getLogo();

    List<SaltImagesEntity> getBackground();

    List<SaltImagesEntity> getImagesByImageCode(String imageCode);

    R addImage(SaltImagesForm saltImagesForm);

    R modifyImage(SaltImagesForm saltImagesForm);

    R deleteImage(String id);

    SaltImagesEntity getBackgroundById(String id);
}
