package com.salt.cms.contactus.controller;

import com.salt.cms.contactus.form.SaltContactForm;
import com.salt.cms.contactus.service.SaltContactUsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/SaltContactUs")
public class SaltContactUsController {
    @Autowired
    private SaltContactUsService contactUservice;
    //-------------------------------------------contactus联系方式-------------------------------------------
    @GetMapping("/getContact")
    public SaltContactForm getContact(){
        log.info("开始获取联系信息");
        return contactUservice.getContact();
    }



//    @PostMapping("/addContact")
//    public R addMenu(@RequestBody SaltContactForm contactUsForm){
//        return contactUservice.addContact(contactUsForm);
//    }
//
//    @PostMapping("modifyContact")
//    public R modifyContact(@RequestBody SaltContactForm contactUsForm){
//        return contactUservice.modifyContact(contactUsForm);
//    }
//
//    @PostMapping("deleteContact")
//    public R deleteContact(@RequestBody String id){
//        return contactUservice.deleteContact(id);
//    }
//    //-------------------------------------------contactus联系方式-------------------------------------------
//
//
//    //-------------------------------------------下层背景图-------------------------------------------
//    @GetMapping("getBackGroundUnder")
//    public R getBackGroundUnder(){
//        return null;
//    }
//    @PostMapping("addBackGroundUnder")
//    public R addBackGroundUnder(){
//        return null;
//    }
//    @PostMapping("deleteBackGroundUnder")
//    public R deleteBackGroundUnder(){
//        return null;
//    }
//    @PostMapping("modifyBackGroundUnder")
//    public R modifyBackGroundUnder(){
//        return null;
//    }
//    //-------------------------------------------下层背景图-------------------------------------------
//
//    //-------------------------------------------上层背景图-------------------------------------------
//    @GetMapping("getBackGroundUp")
//    public R getBackGroundUp(){
//        return null;
//    }
//    @PostMapping("addBackGroundp")
//    public R addBackGroundp(){
//        return null;
//    }
//    @PostMapping("deleteBackGroundUp")
//    public R deleteBackGroundUp(){
//        return null;
//    }
//    @PostMapping("modifyBackGroundUp")
//    public R modifyBackGroundUp(){
//        return null;
//    }
//    //-------------------------------------------上层背景图-------------------------------------------
//
//
//    //-------------------------------------------联系图标-------------------------------------------
//    @GetMapping("getSocialSix")
//    public R getSocialSix(){
//        return null;
//    }
//
//    @GetMapping("getSocialFour")
//    public R getSocialFour(){
//        return null;
//    }
//
//    @PostMapping("addSocial")
//    public R addSocialSix(){
//        return null;
//    }
//
//    @PostMapping("deleteSocial")
//    public R deleteSocial(){
//        return null;
//    }
//
//    @PostMapping("modifySocial")
//    public R modifySocial(){
//        return null;
//    }
//    //-------------------------------------------联系图标-------------------------------------------

}
