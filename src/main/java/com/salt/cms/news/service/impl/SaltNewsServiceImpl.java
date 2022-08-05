package com.salt.cms.news.service.impl;


import com.salt.cms.entity.SaltNewsEntity;
import com.salt.cms.entity.SaltWorklogEntity;
import com.salt.cms.news.dao.SaltNewsDao;
import com.salt.cms.news.dao.SaltWorklogDao;
import com.salt.cms.news.form.SaltNewsForm;
import com.salt.cms.news.form.SaltWorklogForm;
import com.salt.cms.news.service.SaltNewsService;
import com.salt.cms.vo.CreatedVO;
import com.salt.cms.vo.DeletedVO;
import com.salt.cms.vo.UpdatedVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class SaltNewsServiceImpl implements SaltNewsService {
    @Autowired
    private SaltNewsDao saltNewsDao;
    @Autowired
    private SaltWorklogDao saltWorklogDao;

    @Override
    public List<SaltNewsForm> getNews() {
        return saltNewsDao.getNews();
    }

    @Override
    public List<SaltWorklogForm> getWorklog() {
        return saltNewsDao.getWorklog();
    }

    @Override
    public SaltNewsEntity getNewsOne(String id) {
        return saltNewsDao.selectById(id);
    }

    @Override
    public SaltWorklogEntity getWorklogOne(String id) {
        return saltWorklogDao.selectById(id);
    }

    @Override
    public SaltNewsEntity addNews(SaltNewsForm saltNewsForm) {
        SaltNewsEntity saltNewsEntity = new SaltNewsEntity();
        BeanUtils.copyProperties(saltNewsForm,saltNewsEntity);
        saltNewsEntity.setId(UUID.randomUUID().toString());
        saltNewsDao.insert(saltNewsEntity);
        return saltNewsEntity;
    }

    @Override
    public DeletedVO deleteNews(String id) {
        saltNewsDao.deleteById(id);
        return new DeletedVO("删除成功");
    }

    @Override
    public UpdatedVO modifyNews(SaltNewsForm saltNewsForm) {
        SaltNewsEntity saltNewsEntity = new SaltNewsEntity();
        BeanUtils.copyProperties(saltNewsForm,saltNewsEntity);
        saltNewsDao.updateById(saltNewsEntity);
        return new UpdatedVO("修改成功");
    }

    @Override
    public SaltWorklogEntity addWorklog(SaltWorklogForm saltWorklogForm) {
        SaltWorklogEntity saltWorklogEntity = new SaltWorklogEntity();
        BeanUtils.copyProperties(saltWorklogForm,saltWorklogEntity);
        saltWorklogEntity.setId(UUID.randomUUID().toString());
        saltWorklogDao.insert(saltWorklogEntity);
        return saltWorklogEntity;
    }

    @Override
    public DeletedVO deleteWorklog(String id) {
        saltWorklogDao.deleteById(id);
        return new DeletedVO("成功");
    }

    @Override
    public UpdatedVO modifyWorklog(SaltWorklogForm saltWorklogForm) {
        SaltWorklogEntity saltWorklogEntity = new SaltWorklogEntity();
        BeanUtils.copyProperties(saltWorklogForm,saltWorklogEntity);
        saltWorklogEntity.setId(saltWorklogForm.getId());
        saltWorklogDao.updateById(saltWorklogEntity);
        return new UpdatedVO("成功");
    }

}
