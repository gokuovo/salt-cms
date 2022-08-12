package com.salt.cms.projects.service;

import com.salt.cms.entity.SaltAlbumEntity;
import com.salt.cms.entity.SaltListEntity;
import com.salt.cms.entity.SaltMusicVideoEntity;
import com.salt.cms.projects.form.SaltListForm;
import com.salt.cms.projects.form.SaltMusicVideoForm;
import com.salt.cms.utils.R;
import com.salt.cms.vo.DeletedVO;
import com.salt.cms.vo.UpdatedVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface SaltProjectService {

    List<SaltMusicVideoEntity> getProject(String album);

    List<SaltMusicVideoEntity> getProjectByType(String type);
    List<SaltAlbumEntity> getAlbum();
    SaltAlbumEntity getAlbumOne(String id);
    SaltAlbumEntity addAlbum(SaltAlbumEntity saltAlbumEntity);
    UpdatedVO modifyAlbum(SaltAlbumEntity saltAlbumEntity);
    DeletedVO deleteAlbum(String id);

    List<SaltListEntity> getList();
    SaltListEntity getListOne(String id);

    R addFile(SaltMusicVideoForm saltMusicVideoForm);

    R modifyFile(SaltMusicVideoForm saltMusicVideoForm);

    R deleteFile(String id);

    SaltListEntity addList(SaltListForm saltListForm);
    UpdatedVO modifyList(SaltListForm saltListForm);
    DeletedVO deleteList(String id);

    SaltMusicVideoEntity getMusicOne(String id);
    DeletedVO deleteMusic(String id);
    SaltMusicVideoEntity addMusic(SaltMusicVideoEntity saltMusicVideoEntity);
    UpdatedVO modifyMusic(SaltMusicVideoEntity saltMusicVideoEntity);

    DeletedVO deleteVideo(String id);
    SaltMusicVideoEntity addVideo(SaltMusicVideoEntity saltMusicVideoEntity);
    UpdatedVO modifyVideo(SaltMusicVideoEntity saltMusicVideoEntity);

    List<Map<String,String>> getAlbumVideoList();

    List<Map<String,String>> getAlbumMusicList();

    List<SaltMusicVideoEntity> getMusicByType(String type);
}
