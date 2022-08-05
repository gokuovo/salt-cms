package com.salt.cms.ourservice.service;

import com.salt.cms.entity.SaltImagesEntity;
import com.salt.cms.entity.SaltVideoEntity;
import com.salt.cms.entity.SaltWordEntity;
import com.salt.cms.ourservice.form.SaltVideoForm;
import com.salt.cms.ourservice.form.SaltWordForm;
import com.salt.cms.utils.R;

import java.util.List;

public interface SaltOurServiceService {

    String getVideo(String videoType);
    List<SaltWordEntity> getWord();
    List<String> getRotation(String code);
    List<SaltImagesEntity> getRotationList();
    R addWord(SaltWordForm saltWordForm);
    SaltWordEntity getWordId(String id);
    R modifyWord(SaltWordForm saltWordForm);
    List<SaltVideoEntity> getVideoList();
    SaltVideoEntity getVideoOne(String id);
    R addVideo(SaltVideoForm saltVideoForm);
    R modifyVideo(SaltVideoForm saltVideoForm);
    R deleteVideo(String id);

    SaltWordEntity getWordEntity(String id);
}
