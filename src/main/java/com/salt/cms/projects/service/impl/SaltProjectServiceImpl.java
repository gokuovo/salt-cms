package com.salt.cms.projects.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.salt.cms.entity.SaltAlbumEntity;
import com.salt.cms.entity.SaltListEntity;
import com.salt.cms.entity.SaltMusicVideoEntity;
import com.salt.cms.projects.dao.SaltAlbumDao;
import com.salt.cms.projects.dao.SaltListDao;
import com.salt.cms.projects.dao.SaltMusicVideoDao;
import com.salt.cms.projects.form.SaltListForm;
import com.salt.cms.projects.form.SaltMusicVideoForm;
import com.salt.cms.projects.service.SaltProjectService;
import com.salt.cms.utils.R;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SaltProjectServiceImpl implements SaltProjectService {

    @Autowired
    private SaltMusicVideoDao saltMusicVideoDao;

    @Autowired
    private SaltAlbumDao saltAlbumDao;

    @Autowired
    private SaltListDao saltListDao;

    @Override
    public List<SaltMusicVideoEntity> getProject(String album) {
        QueryWrapper<SaltMusicVideoEntity> qw = new QueryWrapper<>();
        qw.eq("album",album);
        List<SaltMusicVideoEntity> list = saltMusicVideoDao.selectList(qw);
        return list;
    }

    @Override
    public List<SaltAlbumEntity> getAlbum() {
        return saltAlbumDao.getAlbum();
    }

    @Override
    public List<SaltListEntity> getList() {
        return saltAlbumDao.getList();
    }

    @Override
    public R addFile(SaltMusicVideoForm saltMusicVideoForm) {
        SaltMusicVideoEntity saltMusicVideoEntity = new SaltMusicVideoEntity();
        BeanUtils.copyProperties(saltMusicVideoForm,saltMusicVideoEntity);
        saltMusicVideoEntity.setId(UUID.randomUUID().toString());
        saltMusicVideoDao.insert(saltMusicVideoEntity);
        return R.ok("成功");
    }

    @Override
    public R modifyFile(SaltMusicVideoForm saltMusicVideoForm) {
        SaltMusicVideoEntity saltMusicVideoEntity = new SaltMusicVideoEntity();
        BeanUtils.copyProperties(saltMusicVideoForm,saltMusicVideoEntity);
        saltMusicVideoDao.updateById(saltMusicVideoEntity);
        return R.ok("成功");
    }

    @Override
    public R deleteFile(String id) {
        saltMusicVideoDao.deleteById(id);
        return R.ok("成功");
    }

    @Override
    public R addList(SaltListForm saltListForm) {
        SaltListEntity saltListEntity = new SaltListEntity();
        BeanUtils.copyProperties(saltListForm,saltListEntity);
        saltListEntity.setId(UUID.randomUUID().toString());
        saltListDao.insert(saltListEntity);
        return R.ok("成功");
    }

    @Override
    public R modifyList(SaltListForm saltListForm) {
        SaltListEntity saltListEntity = new SaltListEntity();
        BeanUtils.copyProperties(saltListForm,saltListEntity);
        saltListDao.updateById(saltListEntity);
        return R.ok("成功");
    }

    @Override
    public R deleteList(String id) {
        saltListDao.deleteById(id);
        return R.ok("成功");
    }
}
