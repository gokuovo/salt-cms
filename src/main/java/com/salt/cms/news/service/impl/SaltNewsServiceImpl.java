package com.salt.cms.news.service.impl;


import com.salt.cms.entity.SaltNewsEntity;
import com.salt.cms.news.dao.SaltNewsDao;
import com.salt.cms.news.form.SaltNewsForm;
import com.salt.cms.news.form.SaltWorklogForm;
import com.salt.cms.news.service.SaltNewsService;
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

    @Override
    public List<SaltNewsForm> getNews() {
        return saltNewsDao.getNews();
    }

    @Override
    public List<SaltWorklogForm> getWorklog() {
        return saltNewsDao.getWorklog();
    }

//    @Override
//    public R addNews(SaltNewsForm saltNewsForm) {
//        SaltNewsEntity saltNewsEntity = new SaltNewsEntity();
//        BeanUtils.copyProperties(saltNewsForm,saltNewsEntity);
//        saltNewsEntity.setId(UUID.randomUUID().toString());
//        saltNewsDao.insert(saltNewsEntity);
//        return R.ok("添加成功");
//    }
//
//    @Override
//    public R deleteNews(String id) {
//        saltNewsDao.deleteById(id);
//        return null;
//    }
//
//    @Override
//    public R modifyNews(SaltNewsForm saltNewsForm) {
//        SaltNewsEntity saltNewsEntity = new SaltNewsEntity();
//        BeanUtils.copyProperties(saltNewsForm,saltNewsEntity);
//        saltNewsDao.updateById(saltNewsEntity);
//        return R.ok("修改成功");
//    }

}
