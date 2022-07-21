package com.salt.cms.homepage.controller;

import com.salt.cms.bo.FileBO;
import com.salt.cms.homepage.form.SaltImagesForm;
import com.salt.cms.service.FileService;
import io.github.talelin.core.annotation.LoginRequired;
import com.salt.cms.homepage.service.SaltHomepageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
    public String getMenu(){
        log.info("开始获取门户工作室图标");
        return saltHomepageService.getLogo();
    }

    @GetMapping("/getBackgroundUnder")
    public List<SaltImagesForm> getBackground(){
        log.info("开始获取背景");
        return saltHomepageService.getBackground();
    }

    @PostMapping("/logo")
    @LoginRequired
    public List<FileBO> upload(MultipartHttpServletRequest multipartHttpServletRequest) {
        MultiValueMap<String, MultipartFile> fileMap =
                multipartHttpServletRequest.getMultiFileMap();
        return fileService.upload(fileMap);
    }
//
//    @PostMapping("modifyLogo")
//    public R modifyMenu(@RequestBody SPMenuForm spMenuForm){
//        return saltLogoService.modifyLogo(spMenuForm);
//    }
//
//    @PostMapping("deleteLogo")
//    public R deleteMenu(@RequestBody String id){
//        return saltLogoService.deleteLogo(id);
//    }
}
