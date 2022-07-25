package com.salt.cms.ourservice.service.impl;


import com.salt.cms.entity.SaltVideoEntity;
import com.salt.cms.entity.SaltWordEntity;
import com.salt.cms.ourservice.dao.SaltVideoDao;
import com.salt.cms.ourservice.dao.SaltWordDao;
import com.salt.cms.ourservice.form.SaltVideoForm;
import com.salt.cms.ourservice.form.SaltWordForm;
import com.salt.cms.ourservice.service.SaltOurServiceService;
import com.salt.cms.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.UUID;

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

    @Override
    public List<SaltWordEntity> getWord() {
        return saltWordDao.getWord();
    }


    @Override
    public R addWord(SaltWordForm saltWordForm) {
        SaltWordEntity saltWordEntity = new SaltWordEntity();
        saltWordEntity.setId(UUID.randomUUID().toString());
        saltWordEntity.setWordTextEn(saltWordForm.getWordTextEn());
        saltWordEntity.setWordTextChi(saltWordForm.getWordTextChi());
        saltWordEntity.setWordTextJap(saltWordForm.getWordTextJap());
        saltWordEntity.setWordTextSpa(saltWordForm.getWordTextSpa());
        saltWordEntity.setWordSign(saltWordForm.getWordSign());
        saltWordEntity.setNoti(saltWordForm.getNoti());
        saltWordDao.insert(saltWordEntity);
        return R.ok("添加成功");
    }

    @Override
    public R deleteWord(String id) {
        if (ObjectUtils.isEmpty(saltWordDao.selectById(id))){
            return R.error("不存在该文本");
        }
        saltWordDao.deleteById(id);
        return R.ok("删除成功");
    }

    @Override
    public R modifyWord(SaltWordForm saltWordForm) {
        SaltWordEntity saltWordEntity = new SaltWordEntity();
        saltWordEntity.setId(saltWordForm.getId());
        saltWordEntity.setWordTextEn(saltWordForm.getWordTextEn());
        saltWordEntity.setWordTextChi(saltWordForm.getWordTextChi());
        saltWordEntity.setWordTextJap(saltWordForm.getWordTextJap());
        saltWordEntity.setWordTextSpa(saltWordForm.getWordTextSpa());
        saltWordEntity.setWordSign(saltWordForm.getWordSign());
        saltWordEntity.setNoti(saltWordForm.getNoti());
        saltWordDao.updateById(saltWordEntity);
        return R.ok("修改成功");
    }

    @Override
    public List<SaltVideoEntity> getVideo() {
        return saltVideoDao.getVideo();
    }

    @Override
    public R addVideo(SaltVideoForm saltVideoForm) {
        SaltVideoEntity saltVideoEntity = new SaltVideoEntity();
        BeanUtils.copyProperties(saltVideoForm,saltVideoEntity);
        saltVideoEntity.setId(UUID.randomUUID().toString());
        saltVideoDao.insert(saltVideoEntity);
        return R.ok("成功");
    }

    @Override
    public R modifyVideo(SaltVideoForm saltVideoForm) {
        SaltVideoEntity saltVideoEntity = new SaltVideoEntity();
        BeanUtils.copyProperties(saltVideoForm,saltVideoEntity);
        saltVideoDao.updateById(saltVideoEntity);
        return R.ok("成功");
    }

    @Override
    public R deleteVideo(String id) {
        saltVideoDao.deleteById(id);
        return R.ok("成功");
    }

}
