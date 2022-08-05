package com.salt.cms.partners.service.impl;

import com.salt.cms.entity.SaltPartnerEntity;
import com.salt.cms.partners.dao.SaltPartnersDao;
import com.salt.cms.partners.form.SaltPartnersForm;
import com.salt.cms.partners.service.SaltPartnersService;
import com.salt.cms.vo.CreatedVO;
import com.salt.cms.vo.DeletedVO;
import com.salt.cms.vo.UpdatedVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class SaltPartnersServiceImpl implements SaltPartnersService {
    @Autowired
    private SaltPartnersDao saltPartnersDao;


    @Override
    public List<SaltPartnerEntity> getPartners() {
        return saltPartnersDao.getPartners();
    }

    @Override
    public SaltPartnerEntity selectPartner(String id) {
        return saltPartnersDao.selectById(id);
    }

    @Override
    public SaltPartnerEntity addPartners(SaltPartnersForm partnersForm) {
        SaltPartnerEntity partnerEntity = new SaltPartnerEntity();
        partnerEntity.setId(partnersForm.getId());
        partnerEntity.setPartnerName(partnersForm.getPartnerName());
        partnerEntity.setPartnerUrl(partnersForm.getPartnerUrl());
        partnerEntity.setPartnerLink(partnersForm.getPartnerLink());
        partnerEntity.setSort(partnersForm.getSort());
        saltPartnersDao.insert(partnerEntity);
        return partnerEntity;
    }

    @Override
    public UpdatedVO modifyPartners(SaltPartnersForm partnersForm) {
        SaltPartnerEntity partnerEntity = new SaltPartnerEntity();
        partnerEntity.setId(partnersForm.getId());
        partnerEntity.setPartnerName(partnersForm.getPartnerName());
        partnerEntity.setPartnerUrl(partnersForm.getPartnerUrl());
        partnerEntity.setPartnerLink(partnersForm.getPartnerLink());
        partnerEntity.setSort(partnersForm.getSort());
        saltPartnersDao.updateById(partnerEntity);
        return new UpdatedVO("修改成功");
    }

    @Override
    public DeletedVO deletePartners(String id) {
        saltPartnersDao.deleteById(id);
        return new DeletedVO("删除成功");
    }
}
