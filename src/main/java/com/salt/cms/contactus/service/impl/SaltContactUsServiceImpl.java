package com.salt.cms.contactus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.salt.cms.contactus.dao.SaltContactUsDao;
import com.salt.cms.contactus.form.SaltContactForm;
import com.salt.cms.contactus.service.SaltContactUsService;
import com.salt.cms.entity.SaltContactEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Slf4j
@Service
public class SaltContactUsServiceImpl implements SaltContactUsService {
    @Autowired
    private SaltContactUsDao saltContactUsDao;


    @Override
    public SaltContactForm getContact() {
        return saltContactUsDao.getContact();
    }

//    @Override
//    public R modifyContact(SaltContactForm contactUsForm) {
//        SaltContactEntity saltContactEntity = new SaltContactEntity();
//        saltContactEntity.setId(contactUsForm.getId());
//        saltContactEntity.setAddressEn(contactUsForm.getAddressEn());
//        saltContactEntity.setAddressChi(contactUsForm.getAddressChi());
//        saltContactEntity.setAddressJap(contactUsForm.getAddressJap());
//        saltContactEntity.setAddressSpa(contactUsForm.getAddressSpa());
//        saltContactEntity.setTel(contactUsForm.getTel());
//        saltContactEntity.setMail(contactUsForm.getMail());
//        saltContactUsDao.updateById(saltContactEntity);
//        return R.ok("修改成功");
//    }
//
//    @Override
//    public R deleteContact(String id) {
//        saltContactUsDao.deleteById(id);
//        return R.ok("删除成功");
//    }
//
//    @Override
//    public R addContact(SaltContactForm contactUsForm) {
//        QueryWrapper<SaltContactEntity> qw = new QueryWrapper<>();
//        qw.eq("is_valid","1");
//        if (!ObjectUtils.isEmpty(saltContactUsDao.selectOne(qw))){
//            R.error("已存在有效地址，请设置失效后再添加");
//        }
//        SaltContactEntity saltContactEntity = new SaltContactEntity();
//        BeanUtils.copyProperties(contactUsForm,saltContactEntity);
//        saltContactUsDao.insert(saltContactEntity);
//        return R.ok("添加成功");
//    }
}
