package com.salt.cms.partners.service;

import com.salt.cms.entity.SaltPartnerEntity;
import com.salt.cms.partners.form.SaltPartnersForm;
import com.salt.cms.utils.R;

import java.util.List;

public interface SaltPartnersService {
    List<SaltPartnerEntity> getPartners();
    SaltPartnerEntity selectPartner(String id);
    R addPartners(SaltPartnersForm partnersForm);
    R modifyPartners(SaltPartnersForm partnersForm);
    R deletePartners(String id);
}
