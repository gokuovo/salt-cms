package com.salt.cms.contactus.controller;

import com.salt.cms.contactus.form.SaltContactForm;
import com.salt.cms.contactus.form.SaltSocialForm;
import com.salt.cms.contactus.service.SaltContactUsService;
import com.salt.cms.entity.SaltContactEntity;
import com.salt.cms.entity.SaltSocialEntity;
import com.salt.cms.utils.R;
import com.salt.cms.vo.CreatedVO;
import com.salt.cms.vo.DeletedVO;
import com.salt.cms.vo.UpdatedVO;
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
    //cms
    @GetMapping("/getContactList")
    public List<SaltContactEntity> getContactList(){
        log.info("开始获取联系信息");
        return contactUsService.getContactList();
    }
    //cms
    @PostMapping("/modifyContact")
    public UpdatedVO modifyContact(@RequestBody SaltContactForm contactUsForm){
        contactUsService.modifyContact(contactUsForm);
        return new UpdatedVO(13);
    }
//    //-------------------------------------------contactus联系方式-------------------------------------------
//
//
//
//    //-------------------------------------------联系图标-------------------------------------------
    @GetMapping("/getSocialSix")
    public List<SaltSocialEntity> getSocialSix(){
        List<SaltSocialEntity> list = contactUsService.getSocialSix();
        return list;
    }

    @GetMapping("/getSocialFour")
    public List<SaltSocialEntity> getSocialFour(){
        List<SaltSocialEntity> list = contactUsService.getSocialFour();
        return list;
    }

    //cms
    @GetMapping("/getSocial")
    public List<SaltSocialEntity> getSocial(){
        List<SaltSocialEntity> list = contactUsService.getSocial();
        return list;
    }
    //cms
    @GetMapping("/getSocialOne")
    public SaltSocialEntity getSocialOne(@RequestParam("id") String id){
        return contactUsService.getSocialOne(id);
    }


    @PostMapping("/addSocial")
    public CreatedVO addSocial(@RequestBody SaltSocialForm saltSocialForm){
        contactUsService.addSocial(saltSocialForm);
        return new CreatedVO(12);
    }

    @PostMapping("/deleteSocial")
    public DeletedVO deleteSocial(@RequestParam("id") String id){
        contactUsService.deleteSocial(id);
        return new DeletedVO(14);
    }

    @PostMapping("/modifySocial")
    public UpdatedVO modifySocial(@RequestBody SaltSocialForm saltSocialForm){
        contactUsService.modifySocial(saltSocialForm);
        return new UpdatedVO(13);
    }
//    //-------------------------------------------联系图标-------------------------------------------

}
