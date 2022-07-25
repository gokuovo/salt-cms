package com.salt.cms.menu.service;

import com.salt.cms.entity.SaltPortalMenuEntity;
import com.salt.cms.menu.form.SPMenuForm;
import com.salt.cms.utils.R;

import java.util.List;


public interface SaltPortalMenuService {

    List<SPMenuForm> getMenu();
    List<SaltPortalMenuEntity> listMenu();
    R addMenu(SPMenuForm spMenuForm);
    R modifyMenu(SPMenuForm spMenuForm);
    R deleteMenu(String id);
}
