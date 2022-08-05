package com.salt.cms.partners.service;

import com.salt.cms.entity.SaltPartnerEntity;
import com.salt.cms.partners.form.SaltPartnersForm;
import com.salt.cms.vo.DeletedVO;
import com.salt.cms.vo.UpdatedVO;

import java.util.List;

public interface SaltPartnersService {
    List<SaltPartnerEntity> getPartners();
    SaltPartnerEntity selectPartner(String id);
    SaltPartnerEntity addPartners(SaltPartnersForm partnersForm);
    UpdatedVO modifyPartners(SaltPartnersForm partnersForm);
    DeletedVO deletePartners(String id);
}
