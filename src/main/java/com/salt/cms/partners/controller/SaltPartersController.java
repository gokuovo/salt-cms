package com.salt.cms.partners.controller;

import com.salt.cms.entity.SaltPartnerEntity;
import com.salt.cms.partners.form.SaltPartnersForm;
import com.salt.cms.partners.service.SaltPartnersService;
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
@RequestMapping("/SaltPartners")
public class SaltPartersController {
    @Autowired
    private SaltPartnersService partnersService;


    //获取友商图标 cms已对接、门户
    @GetMapping("/getPartners")
    public List<SaltPartnerEntity> getPartners(){
        log.info("开始获取所有合作商图标信息");
        return partnersService.getPartners();
    }

    @PostMapping("/addPartners")
    public CreatedVO addMenu(@RequestBody SaltPartnersForm partnersForm){
        return partnersService.addPartners(partnersForm);
    }

    @PostMapping("/modifyPartners")
    public UpdatedVO modifyMenu(@RequestBody SaltPartnersForm partnersForm){
        return partnersService.modifyPartners(partnersForm);
    }

    //已对接
    @PostMapping("/deletePartners")
    public DeletedVO deleteMenu(@RequestParam("id") String id){
        return partnersService.deletePartners(id);
    }

    //已对接
    @GetMapping("/selectPartner")
    public SaltPartnerEntity selectPartner(@RequestParam("id") String id){
        SaltPartnerEntity partner = partnersService.selectPartner(id);
        return partner;
    }
}
