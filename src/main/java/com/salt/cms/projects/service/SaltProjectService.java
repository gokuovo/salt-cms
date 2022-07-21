package com.salt.cms.projects.service;

import com.salt.cms.entity.SaltAlbumEntity;
import com.salt.cms.entity.SaltListEntity;
import com.salt.cms.entity.SaltMusicVideoEntity;
import com.salt.cms.menu.form.SPMenuForm;
import com.salt.cms.projects.form.SaltMusicVideoForm;

import java.util.List;

public interface SaltProjectService {

    List<SaltMusicVideoEntity> getProject(String album);

    List<SaltAlbumEntity> getAlbum();

    List<SaltListEntity> getList();
}
