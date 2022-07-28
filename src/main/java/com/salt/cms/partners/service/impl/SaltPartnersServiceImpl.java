package com.salt.cms.partners.service.impl;

import com.salt.cms.entity.SaltPartnerEntity;
import com.salt.cms.partners.dao.SaltPartnersDao;
import com.salt.cms.partners.form.SaltPartnersForm;
import com.salt.cms.partners.service.SaltPartnersService;
import com.salt.cms.utils.R;
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
    public R addPartners(SaltPartnersForm partnersForm) {
        SaltPartnerEntity partnerEntity = new SaltPartnerEntity();
        partnerEntity.setId(partnersForm.getId());
        partnerEntity.setPartnerName(partnersForm.getPartnerName());
        partnerEntity.setPartnerUrl(partnersForm.getPartnerUrl());
        partnerEntity.setPartnerLink(partnersForm.getPartnerLink());
        partnerEntity.setSort(partnersForm.getSort());
        saltPartnersDao.insert(partnerEntity);
        return R.ok("添加成功");
    }

    @Override
    public R modifyPartners(SaltPartnersForm partnersForm) {
        SaltPartnerEntity partnerEntity = new SaltPartnerEntity();
        partnerEntity.setId(partnersForm.getId());
        partnerEntity.setPartnerName(partnersForm.getPartnerName());
        partnerEntity.setPartnerUrl(partnersForm.getPartnerUrl());
        partnerEntity.setPartnerLink(partnersForm.getPartnerLink());
        partnerEntity.setSort(partnersForm.getSort());
        saltPartnersDao.updateById(partnerEntity);
        return R.ok("修改成功");
    }

    @Override
    public R deletePartners(String id) {
        saltPartnersDao.deleteById(id);
        return R.ok("删除成功");
    }
}
