package com.salt.cms.projects.service;

import com.salt.cms.entity.SaltAlbumEntity;
import com.salt.cms.entity.SaltListEntity;
import com.salt.cms.entity.SaltMusicVideoEntity;
import com.salt.cms.menu.form.SPMenuForm;
import com.salt.cms.projects.form.SaltListForm;
import com.salt.cms.projects.form.SaltMusicVideoForm;
import com.salt.cms.utils.R;

import java.util.List;

public interface SaltProjectService {

    List<SaltMusicVideoEntity> getProject(String album);

    List<SaltAlbumEntity> getAlbum();

    List<SaltListEntity> getList();

    R addFile(SaltMusicVideoForm saltMusicVideoForm);

    R modifyFile(SaltMusicVideoForm saltMusicVideoForm);

    R deleteFile(String id);

    R addList(SaltListForm saltListForm);
    R modifyList(SaltListForm saltListForm);
    R deleteList(String id);
}
