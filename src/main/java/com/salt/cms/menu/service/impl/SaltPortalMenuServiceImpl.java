package com.salt.cms.menu.service.impl;


import com.salt.cms.menu.dao.SaltPortalMenuDao;
import com.salt.cms.menu.form.SPMenuForm;
import com.salt.cms.menu.service.SaltPortalMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class SaltPortalMenuServiceImpl implements SaltPortalMenuService {

    @Autowired
    private SaltPortalMenuDao saltPortalMenuDao;


    @Override
    public List<SPMenuForm> getMenu() {
        return saltPortalMenuDao.getMenu();
    }

//    @Override
//    public R addMenu(SPMenuForm spMenuForm) {
//        if (ObjectUtils.isEmpty(spMenuForm.getMenuNameEn())){
//            return R.error("菜单EN名不能为空！");
//        }
//        if (ObjectUtils.isEmpty(spMenuForm.getMenuNameJap())){
//            return R.error("菜单JAP名不能为空！");
//        }
//        if (ObjectUtils.isEmpty(spMenuForm.getMenuNameSpa())){
//            return R.error("菜单SPA名不能为空！");
//        }
//        if (ObjectUtils.isEmpty(spMenuForm.getUrl())){
//            return R.error("URL不能为空！");
//        }
//        if (ObjectUtils.isEmpty(spMenuForm.getSort())){
//            return R.error("排序不能为空！");
//        }
//        if (!Character.isDigit(spMenuForm.getSort())){
//            return R.error("请输入数字");
//        }
//        SaltPortalMenuEntity saltPortalMenuEntity = new SaltPortalMenuEntity();
//        saltPortalMenuEntity.setId(UUID.randomUUID().toString());
//        saltPortalMenuEntity.setMenuNameEn(spMenuForm.getMenuNameEn());
//        saltPortalMenuEntity.setMenuNameJap(spMenuForm.getMenuNameJap());
//        saltPortalMenuEntity.setMenuNameSpa(spMenuForm.getMenuNameJap());
//        saltPortalMenuEntity.setUrl(spMenuForm.getUrl());
//        saltPortalMenuEntity.setSort(spMenuForm.getSort());
//        saltPortalMenuDao.insert(saltPortalMenuEntity);
//        return R.ok();
//    }
//
//    @Override
//    public R modifyMenu(SPMenuForm spMenuForm) {
//        if (!Character.isDigit(spMenuForm.getSort())){
//            return R.error("请输入数字");
//        }
//        SaltPortalMenuEntity saltPortalMenuEntity = new SaltPortalMenuEntity();
//        BeanUtils.copyProperties(spMenuForm,saltPortalMenuEntity);
//        saltPortalMenuDao.updateById(saltPortalMenuEntity);
//        return R.ok();
//    }
//
//    @Override
//    public R deleteMenu(String id) {
//        QueryWrapper<SaltPortalMenuEntity> qw = new QueryWrapper<>();
//        qw.eq("id",id);
//        saltPortalMenuDao.deleteById(qw);
//        return null;
//    }
}
