package com.salt.cms.partners.service.impl;

import com.salt.cms.entity.SaltPartnerEntity;
import com.salt.cms.entity.SaltWordEntity;
import com.salt.cms.partners.dao.SaltPartnersDao;
import com.salt.cms.partners.form.SaltPartnersForm;
import com.salt.cms.partners.service.SaltPartnersService;
import com.salt.cms.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class SaltPartnersServiceImpl implements SaltPartnersService {
    @Autowired
    private SaltPartnersDao saltPartnersDao;


    @Override
    public List<Map<String, Object>> getPartners() {
        List<SaltPartnerEntity> list = saltPartnersDao.getPartners();
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        if (!list.isEmpty()) {
            for (SaltPartnerEntity partner : list) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", partner.getId());
                map.put("partnerUrl", partner.getPartnerUrl());
                map.put("partnerLink", partner.getPartnerLink());
                listMap.add(map);
            }
        }
        return listMap;
    }

    @Override
    public List<SaltPartnerEntity> selectPartner() {
        return saltPartnersDao.selectPartner();
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
