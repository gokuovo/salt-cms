package com.salt.cms.homepage.service.impl;


import com.salt.cms.homepage.dao.SaltImagesDao;
import com.salt.cms.homepage.service.SaltHomepageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public String getBackgroundUnder() {
        return saltImagesDao.getBackgroundUnder();
    }

    @Override
    public String getBackgroundUp() {
        return saltImagesDao.getBackgroundUp();
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
//        saltPortalMenuEntity.setId(ID.id());
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
