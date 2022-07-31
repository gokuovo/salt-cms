package com.salt.cms.projects.service;

import com.salt.cms.entity.SaltAlbumEntity;
import com.salt.cms.entity.SaltListEntity;
import com.salt.cms.entity.SaltMusicVideoEntity;
import com.salt.cms.projects.form.SaltListForm;
import com.salt.cms.projects.form.SaltMusicVideoForm;
import com.salt.cms.utils.R;
import com.salt.cms.vo.CreatedVO;
import com.salt.cms.vo.DeletedVO;
import com.salt.cms.vo.UpdatedVO;

import java.util.List;

public interface SaltProjectService {

    List<SaltMusicVideoEntity> getProject(String album);

    List<SaltAlbumEntity> getAlbum();
    SaltAlbumEntity getAlbumOne(String id);
    CreatedVO addAlbum(SaltAlbumEntity saltAlbumEntity);
    UpdatedVO modifyAlbum(SaltAlbumEntity saltAlbumEntity);
    DeletedVO deleteAlbum(String id);

    List<SaltListEntity> getList();
    SaltListEntity getListOne(String id);

    R addFile(SaltMusicVideoForm saltMusicVideoForm);

    R modifyFile(SaltMusicVideoForm saltMusicVideoForm);

    R deleteFile(String id);

    CreatedVO addList(SaltListForm saltListForm);
    UpdatedVO modifyList(SaltListForm saltListForm);
    DeletedVO deleteList(String id);
}
