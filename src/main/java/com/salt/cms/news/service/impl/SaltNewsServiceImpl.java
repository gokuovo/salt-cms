package com.salt.cms.news.service.impl;


import com.salt.cms.entity.SaltNewsEntity;
import com.salt.cms.entity.SaltWorklogEntity;
import com.salt.cms.news.dao.SaltNewsDao;
import com.salt.cms.news.dao.SaltWorklogDao;
import com.salt.cms.news.form.SaltNewsForm;
import com.salt.cms.news.form.SaltWorklogForm;
import com.salt.cms.news.service.SaltNewsService;
import com.salt.cms.utils.R;
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
    public R addNews(SaltNewsForm saltNewsForm) {
        SaltNewsEntity saltNewsEntity = new SaltNewsEntity();
        BeanUtils.copyProperties(saltNewsForm,saltNewsEntity);
        saltNewsEntity.setId(UUID.randomUUID().toString());
        saltNewsDao.insert(saltNewsEntity);
        return R.ok("添加成功");
    }

    @Override
    public R deleteNews(String id) {
        saltNewsDao.deleteById(id);
        return R.ok("成功");
    }

    @Override
    public R modifyNews(SaltNewsForm saltNewsForm) {
        SaltNewsEntity saltNewsEntity = new SaltNewsEntity();
        BeanUtils.copyProperties(saltNewsForm,saltNewsEntity);
        saltNewsDao.updateById(saltNewsEntity);
        return R.ok("修改成功");
    }

    @Override
    public R addWorklog(SaltWorklogForm saltWorklogForm) {
        SaltWorklogEntity saltWorklogEntity = new SaltWorklogEntity();
        BeanUtils.copyProperties(saltWorklogForm,saltWorklogEntity);
        saltWorklogEntity.setId(UUID.randomUUID().toString());
        saltWorklogDao.insert(saltWorklogEntity);
        return R.ok("成功");
    }

    @Override
    public R deleteWorklog(String id) {
        saltWorklogDao.deleteById(id);
        return R.ok("成功");
    }

    @Override
    public R modifyWorklog(SaltWorklogForm saltWorklogForm) {
        SaltWorklogEntity saltWorklogEntity = new SaltWorklogEntity();
        BeanUtils.copyProperties(saltWorklogForm,saltWorklogEntity);
        saltWorklogEntity.setId(UUID.randomUUID().toString());
        saltWorklogDao.updateById(saltWorklogEntity);
        return R.ok("成功");
    }

}
