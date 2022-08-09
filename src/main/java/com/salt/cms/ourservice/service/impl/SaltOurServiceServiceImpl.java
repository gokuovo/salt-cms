package com.salt.cms.ourservice.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.salt.cms.entity.SaltImagesEntity;
import com.salt.cms.entity.SaltVideoEntity;
import com.salt.cms.entity.SaltWordEntity;
import com.salt.cms.homepage.dao.SaltImagesDao;
import com.salt.cms.ourservice.dao.SaltCodeDao;
import com.salt.cms.ourservice.dao.SaltVideoDao;
import com.salt.cms.ourservice.dao.SaltWordDao;
import com.salt.cms.ourservice.form.SaltVideoForm;
import com.salt.cms.ourservice.form.SaltWordForm;
import com.salt.cms.ourservice.service.SaltOurServiceService;
import com.salt.cms.utils.R;
import com.salt.cms.vo.DeletedVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class SaltOurServiceServiceImpl implements SaltOurServiceService {

    @Autowired(required=false)
    private SaltWordDao saltWordDao;
    @Autowired(required=false)
    private SaltVideoDao saltVideoDao;
    @Autowired
    private SaltCodeDao saltCodeDao;
    @Autowired
    private SaltImagesDao saltImagesDao;


    @Override
    public List<SaltWordEntity> getWord() {
        return saltWordDao.getWord();
    }

    @Override
    public List<String> getRotation(String code) {
        QueryWrapper<SaltImagesEntity> qw = new QueryWrapper<>();
        String image_code;
        if(code.equals("0")){
            image_code = "12";
        }else if(code.equals("1")){
            image_code = "13";
        }else if(code.equals("2")){
            image_code = "14";
        }else{
            image_code = "15";
        }
        qw.eq("image_code",image_code);
        List<SaltImagesEntity> imagesEntityList = saltImagesDao.selectList(qw);
        List<String> list = new ArrayList<>();
        for(SaltImagesEntity saltImagesEntity : imagesEntityList){
            list.add(saltImagesEntity.getImageUrl());
        }
        return list;
    }

    @Override
    public List<SaltImagesEntity> getRotationList() {
        List<String> list = new ArrayList<>();
        list.add("15");
        list.add("12");
        list.add("13");
        list.add("14");
        QueryWrapper<SaltImagesEntity> qw = new QueryWrapper<>();
        qw.in("image_code",list);
        return saltImagesDao.getBackground(qw);
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
    public SaltWordEntity getWordId(String id) {
        return saltWordDao.selectById(id);
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
    public List<SaltVideoEntity> getVideoList() {
        return saltVideoDao.getVideoList();
    }

    @Override
    public SaltVideoEntity getVideoOne(String id) {
        return saltVideoDao.selectById(id);
    }

    @Override
    public String getVideo(String videoType) {
        QueryWrapper<SaltVideoEntity> qw = new QueryWrapper<>();
        qw.eq("video_type",videoType);
        SaltVideoEntity saltVideoEntity = new SaltVideoEntity();
        saltVideoEntity = saltVideoDao.selectOne(qw);
        String url = (null == saltVideoEntity) ? "" : saltVideoEntity.getVideoUrl();
        return url;
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

    @Override
    public SaltWordEntity getWordEntity(String id) {
        return saltWordDao.selectById(id);
    }

    @Override
    public List<SaltImagesEntity> getRotationByType(String type) {
        if (StringUtils.isEmpty(type)){
            return getRotationList();
        }else{
            QueryWrapper<SaltImagesEntity> qw = new QueryWrapper<>();
            qw.eq("image_code",type);
            return saltImagesDao.selectList(qw);
        }

    }

    @Override
    public DeletedVO deleteRotation(String id) {
        saltImagesDao.deleteById(id);
        return new DeletedVO("删除成功");
    }

}
