package com.salt.cms.contactus.service.impl;

import com.salt.cms.contactus.dao.SaltContactUsDao;
import com.salt.cms.contactus.dao.SaltSocialDao;
import com.salt.cms.contactus.form.SaltContactForm;
import com.salt.cms.contactus.form.SaltSocialForm;
import com.salt.cms.contactus.service.SaltContactUsService;
import com.salt.cms.entity.SaltContactEntity;
import com.salt.cms.entity.SaltSocialEntity;
import com.salt.cms.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class SaltContactUsServiceImpl implements SaltContactUsService {
    @Autowired
    private SaltContactUsDao saltContactUsDao;

    @Autowired
    private SaltSocialDao saltSocialDao;


    @Override
    public SaltContactForm getContact() {
        return saltContactUsDao.getContact();
    }

    @Override
    public List<SaltContactEntity> getContactList() {
        return saltContactUsDao.getContactList();
    }

    @Override
    public R modifyContact(SaltContactForm contactUsForm) {
        SaltContactEntity saltContactEntity = new SaltContactEntity();
        saltContactEntity.setId(contactUsForm.getId());
        saltContactEntity.setAddressEn(contactUsForm.getAddressEn());
        saltContactEntity.setAddressChi(contactUsForm.getAddressChi());
        saltContactEntity.setAddressJap(contactUsForm.getAddressJap());
        saltContactEntity.setAddressSpa(contactUsForm.getAddressSpa());
        saltContactEntity.setTel(contactUsForm.getTel());
        saltContactEntity.setMail(contactUsForm.getMail());
        saltContactUsDao.updateById(saltContactEntity);
        return R.ok("修改成功");
    }


    @Override
    public List<SaltSocialEntity> getSocialSix() {
        return saltContactUsDao.getSocialSix();
    }

    @Override
    public List<SaltSocialEntity> getSocialFour() {
        return saltContactUsDao.getSocialFour();
    }

    @Override
    public List<SaltSocialEntity> getSocial() {
        return saltContactUsDao.getSocial();
    }

    @Override
    public SaltSocialEntity getSocialOne(String id) {
        return saltSocialDao.selectById(id);
    }

    @Override
    public SaltSocialEntity addSocial(SaltSocialForm saltSocialForm) {
        SaltSocialEntity saltSocialEntity = new SaltSocialEntity();
        BeanUtils.copyProperties(saltSocialForm,saltSocialEntity);
        saltSocialEntity.setId(UUID.randomUUID().toString());
        saltSocialDao.insert(saltSocialEntity);
        return saltSocialEntity;
    }

    @Override
    public R deleteSocial(String id) {
        saltSocialDao.deleteById(id);
        return R.ok("完成");
    }

    @Override
    public R modifySocial(SaltSocialForm saltSocialForm) {
        SaltSocialEntity saltSocialEntity = new SaltSocialEntity();
        BeanUtils.copyProperties(saltSocialForm,saltSocialEntity);
        saltSocialDao.updateById(saltSocialEntity);
        return R.ok("完成");
    }
}
