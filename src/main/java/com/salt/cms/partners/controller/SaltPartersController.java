package com.salt.cms.partners.controller;

import com.salt.cms.entity.SaltPartnerEntity;
import com.salt.cms.partners.form.SaltPartnersForm;
import com.salt.cms.partners.service.SaltPartnersService;
import com.salt.cms.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/SaltPartners")
public class SaltPartersController {
    @Autowired
    private SaltPartnersService partnersService;


    @GetMapping("/getPartners")
    public List<Map<String, Object>> getPartners(){
        log.info("开始获取所有合作商图标信息");
        return partnersService.getPartners();
    }

    @PostMapping("/addPartners")
    public R addMenu(@RequestBody SaltPartnersForm partnersForm){
        return partnersService.addPartners(partnersForm);
    }

    @PostMapping("modifyPartners")
    public R modifyMenu(@RequestBody SaltPartnersForm partnersForm){
        return partnersService.modifyPartners(partnersForm);
    }

    @PostMapping("deletePartners")
    public R deleteMenu(@RequestBody String id){
        return partnersService.deletePartners(id);
    }

    @GetMapping("selectPartner")
    public R selectPartner(){
        List<SaltPartnerEntity> list = partnersService.selectPartner();
        return R.ok().put("list",list);
    }
}
