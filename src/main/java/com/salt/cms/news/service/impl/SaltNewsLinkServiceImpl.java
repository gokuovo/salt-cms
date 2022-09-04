package com.salt.cms.news.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.salt.cms.entity.SaltNewsEntity;
import com.salt.cms.entity.SaltNewsLinkEntity;
import com.salt.cms.news.dao.SaltNewsDao;
import com.salt.cms.news.dao.SaltNewsLinkDao;
import com.salt.cms.news.form.SaltNewsLinkForm;
import com.salt.cms.news.form.SaltNewsLinkPageForm;
import com.salt.cms.news.service.SaltNewsLinkService;
import com.salt.cms.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaltNewsLinkServiceImpl implements SaltNewsLinkService {
    @Autowired
    SaltNewsDao saltNewsDao;
    @Autowired
    SaltNewsLinkDao saltNewsLinkDao;

    @Override
    public List<SaltNewsLinkForm> getNewsLink() {
        return saltNewsDao.getNewsLink();
    }

    @Override
    public List<SaltNewsLinkPageForm> getNewsLinkPage(String id) {
        QueryWrapper<SaltNewsLinkEntity> qw = new QueryWrapper<>();
        qw.eq("id",id);
        return saltNewsDao.getNewsLinkPage(qw);
    }

    @Override
    public UpdatedVO modifyNewsLink(SaltNewsLinkPageForm saltNewsLinkPageForm) {
        SaltNewsLinkEntity saltNewsLinkEntity = new SaltNewsLinkEntity();
        saltNewsLinkEntity.setId(saltNewsLinkPageForm.getId());
        saltNewsLinkEntity.setTextEn01(saltNewsLinkPageForm.getTextEn01());
        saltNewsLinkEntity.setTextChi01(saltNewsLinkPageForm.getTextChi01());
        saltNewsLinkEntity.setTextJap01(saltNewsLinkPageForm.getTextJap01());
        saltNewsLinkEntity.setTextSpa01(saltNewsLinkPageForm.getTextSpa01());
        saltNewsLinkEntity.setTextEn02(saltNewsLinkPageForm.getTextEn02());
        saltNewsLinkEntity.setTextChi02(saltNewsLinkPageForm.getTextChi02());
        saltNewsLinkEntity.setTextJap02(saltNewsLinkPageForm.getTextJap02());
        saltNewsLinkEntity.setTextSpa02(saltNewsLinkPageForm.getTextSpa02());
        saltNewsLinkDao.updateById(saltNewsLinkEntity);
        SaltNewsEntity saltNewsEntity = new SaltNewsEntity();
        saltNewsEntity.setId(saltNewsLinkPageForm.getId());
        saltNewsEntity.setTitleEn(saltNewsLinkPageForm.getTitle());
        saltNewsEntity.setDateEn(saltNewsLinkPageForm.getDate());
        saltNewsDao.updateById(saltNewsEntity);
        return new UpdatedVO("更新成功");
    }
}
