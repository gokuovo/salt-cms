package com.salt.cms.homepage.controller;

import com.salt.cms.entity.SaltImagesEntity;
import com.salt.cms.homepage.form.SaltImagesForm;
import com.salt.cms.service.FileService;
import com.salt.cms.utils.R;
import com.salt.cms.homepage.service.SaltHomepageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/SaltHomepage")
public class SaltHomepageController {
    @Autowired
    private SaltHomepageService saltHomepageService;

    @Autowired
    private FileService fileService;


    @GetMapping("/getLogo")
    public String getLogo(){
        log.info("开始获取门户工作室图标");
        return saltHomepageService.getLogo();
    }

    @GetMapping("/getBackgroundUnder")
    public List<SaltImagesEntity> getBackground(){
        log.info("开始获取背景");
        return saltHomepageService.getBackground();
    }

    /**
     * 根据imageCode获取不同图片
     * @param imageCode
     * @return
     */
    @GetMapping("/getImagesByImageCode")
    public List<SaltImagesEntity> getImagesByImageCode(String imageCode){
        return saltHomepageService.getImagesByImageCode(imageCode);
    }


    @PostMapping("addImage")
    public R addImage(@RequestBody SaltImagesForm saltImagesForm){
        return saltHomepageService.addImage(saltImagesForm);
    }

    @PostMapping("deleteImage")
    public R deleteImage(@RequestBody String id){
        return saltHomepageService.deleteImage(id);
    }

    @PostMapping("modifyImage")
    public R modifyImage(@RequestBody SaltImagesForm saltImagesForm){
        return saltHomepageService.modifyImage(saltImagesForm);
    }

    @GetMapping("/getBackgroundById")
    public SaltImagesEntity getBackgroundById(@RequestParam("id")String id){
        return saltHomepageService.getBackgroundById(id);
    }
}
