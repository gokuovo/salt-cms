package com.salt.cms.contactus.controller;

import com.salt.cms.contactus.form.SaltContactForm;
import com.salt.cms.contactus.form.SaltSocialForm;
import com.salt.cms.contactus.service.SaltContactUsService;
import com.salt.cms.entity.SaltSocialEntity;
import com.salt.cms.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/SaltContactUs")
public class SaltContactUsController {
    @Autowired
    private SaltContactUsService contactUsService;
    //-------------------------------------------contactus联系方式-------------------------------------------
    @GetMapping("/getContact")
    public SaltContactForm getContact(){
        log.info("开始获取联系信息");
        return contactUsService.getContact();
    }

    @PostMapping("/addContact")
    public R addMenu(@RequestBody SaltContactForm contactUsForm){
        return contactUservice.addContact(contactUsForm);
    }

    @PostMapping("modifyContact")
    public R modifyContact(@RequestBody SaltContactForm contactUsForm){
        return contactUservice.modifyContact(contactUsForm);
    }

    @PostMapping("deleteContact")
    public R deleteContact(@RequestBody String id){
        return contactUservice.deleteContact(id);
    }
//    //-------------------------------------------contactus联系方式-------------------------------------------
//
//
//
//    //-------------------------------------------联系图标-------------------------------------------
    @GetMapping("getSocialSix")
    public R getSocialSix(){
        List<SaltSocialEntity> list = contactUservice.getSocialSix();
        return R.ok().put("list",list);
    }

    @GetMapping("getSocialFour")
    public R getSocialFour(){
        List<SaltSocialEntity> list = contactUservice.getSocialFour();
        return R.ok().put("list",list);
    }

    @PostMapping("addSocial")
    public R addSocial(@RequestBody SaltSocialForm saltSocialForm){
        return contactUservice.addSocial(saltSocialForm);
    }

    @PostMapping("deleteSocial")
    public R deleteSocial(@RequestBody String id){
        return contactUservice.deleteSocial(id);
    }

    @PostMapping("modifySocial")
    public R modifySocial(@RequestBody SaltSocialForm saltSocialForm){
        return contactUservice.modifySocial(saltSocialForm);
    }
//    //-------------------------------------------联系图标-------------------------------------------

}
