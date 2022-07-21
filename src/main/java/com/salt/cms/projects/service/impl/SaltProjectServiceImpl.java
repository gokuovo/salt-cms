package com.salt.cms.projects.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.salt.cms.entity.SaltAlbumEntity;
import com.salt.cms.entity.SaltListEntity;
import com.salt.cms.entity.SaltMusicVideoEntity;
import com.salt.cms.projects.dao.SaltAlbumDao;
import com.salt.cms.projects.dao.SaltMusicVideoDao;
import com.salt.cms.projects.form.SaltMusicVideoForm;
import com.salt.cms.projects.service.SaltProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaltProjectServiceImpl implements SaltProjectService {

    @Autowired
    private SaltMusicVideoDao saltMusicVideoDao;

    @Autowired
    private SaltAlbumDao saltAlbumDao;

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
        return null;
    }
}
