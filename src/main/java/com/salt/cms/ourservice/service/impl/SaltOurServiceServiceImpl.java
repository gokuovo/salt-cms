package com.salt.cms.ourservice.service.impl;


import com.salt.cms.ourservice.dao.SaltVideoDao;
import com.salt.cms.ourservice.dao.SaltWordDao;
import com.salt.cms.ourservice.form.SaltWordForm;
import com.salt.cms.ourservice.service.SaltOurServiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SaltOurServiceServiceImpl implements SaltOurServiceService {

    @Autowired(required=false)
    private SaltWordDao saltWordDao;
    @Autowired(required=false)
    private SaltVideoDao saltVideoDao;


    @Override
    public String getMusic() {
        return saltVideoDao.getMusic();
    }

    @Override
    public String getSoundDesign() {
        return saltVideoDao.getSoundDesign();
    }

    @Override
    public String getVoiceActing() {
        return saltVideoDao.getVoiceActing();
    }

    @Override
    public String getGameAudioPipeline() {
        return saltVideoDao.getGameAudioPipeline();
    }

    @Override
    public SaltWordForm getWhatWeDo() {
        log.info(saltWordDao.getWhatWeDo().toString());
        return saltWordDao.getWhatWeDo();
    }

    @Override
    public SaltWordForm getWhatWeDoText() {
        return saltWordDao.getWhatWeDoText();
    }

    @Override
    public SaltWordForm getRotation() {
        return saltWordDao.getRotation();
    }
}
