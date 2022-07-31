package com.salt.cms.menu.service;

import com.salt.cms.entity.SaltPortalMenuEntity;
import com.salt.cms.menu.form.SPMenuForm;
import com.salt.cms.utils.R;
import com.salt.cms.vo.UpdatedVO;

import java.util.List;


public interface SaltPortalMenuService {

    List<SPMenuForm> getMenu();
    List<SaltPortalMenuEntity> listMenu();
    SaltPortalMenuEntity menuById(String id);
    R addMenu(SPMenuForm spMenuForm);
    UpdatedVO modifyMenu(SPMenuForm spMenuForm);
    R deleteMenu(String id);
}
