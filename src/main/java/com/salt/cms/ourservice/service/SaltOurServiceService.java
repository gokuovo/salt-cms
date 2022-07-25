package com.salt.cms.ourservice.service;

import com.salt.cms.entity.SaltVideoEntity;
import com.salt.cms.entity.SaltWordEntity;
import com.salt.cms.ourservice.form.SaltVideoForm;
import com.salt.cms.ourservice.form.SaltWordForm;
import com.salt.cms.utils.R;

import java.util.List;

public interface SaltOurServiceService {
    String getMusic();
    String getSoundDesign();
    String getVoiceActing();
    String getGameAudioPipeline();
    SaltWordForm getWhatWeDo();
    SaltWordForm getWhatWeDoText();
    SaltWordForm getRotation();
    List<SaltWordEntity> getWord();
    R addWord(SaltWordForm saltWordForm);
    R deleteWord(String id);
    R modifyWord(SaltWordForm saltWordForm);
    List<SaltVideoEntity> getVideo();
    R addVideo(SaltVideoForm saltVideoForm);
    R modifyVideo(SaltVideoForm saltVideoForm);
    R deleteVideo(String id);
}
