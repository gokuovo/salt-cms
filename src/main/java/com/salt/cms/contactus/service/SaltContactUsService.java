package com.salt.cms.contactus.service;


import com.salt.cms.contactus.form.SaltContactForm;
import com.salt.cms.contactus.form.SaltSocialForm;
import com.salt.cms.entity.SaltContactEntity;
import com.salt.cms.entity.SaltSocialEntity;
import com.salt.cms.utils.R;

import java.util.List;

public interface SaltContactUsService {
    SaltContactForm getContact();
    List<SaltContactEntity> getContactList();
    R modifyContact(SaltContactForm contactUsForm);
    List<SaltSocialEntity> getSocialSix();
    List<SaltSocialEntity> getSocialFour();
    List<SaltSocialEntity> getSocial();
    SaltSocialEntity getSocialOne(String id);
    R addSocial(SaltSocialForm saltSocialForm);
    R deleteSocial(String id);
    R modifySocial(SaltSocialForm saltSocialForm);



}
