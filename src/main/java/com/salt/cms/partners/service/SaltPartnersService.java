package com.salt.cms.partners.service;

import com.salt.cms.entity.SaltPartnerEntity;
import com.salt.cms.partners.form.SaltPartnersForm;
import com.salt.cms.utils.R;

import java.util.List;
import java.util.Map;

public interface SaltPartnersService {
    List<Map<String, Object>> getPartners();
    List<SaltPartnerEntity> selectPartner();
    R addPartners(SaltPartnersForm partnersForm);
    R modifyPartners(SaltPartnersForm partnersForm);
    R deletePartners(String id);
}
