package com.salt.cms.homepage.service;


import com.salt.cms.homepage.form.SaltImagesForm;

import java.util.List;

public interface SaltHomepageService {

    String getLogo();
    List<SaltImagesForm> getBackground();
//    R addMenu(SPMenuForm spMenuForm);
//    R modifyMenu(SPMenuForm spMenuForm);
//    R deleteMenu(String id);
}
