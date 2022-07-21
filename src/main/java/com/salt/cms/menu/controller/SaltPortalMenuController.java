package com.salt.cms.menu.controller;


import com.salt.cms.menu.form.SPMenuForm;
import com.salt.cms.menu.service.SaltPortalMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/SaltPortalMenu")
public class SaltPortalMenuController {
    @Autowired
    private SaltPortalMenuService saltPortalMenuService;

    @GetMapping("/getMenu")
    public List<SPMenuForm> getMenu(){
        log.info("开始获取门户菜单信息");
        return saltPortalMenuService.getMenu();
    }

//    @PostMapping("/addMenu")
//    public R addMenu(@RequestBody SPMenuForm spMenuForm){
//        return saltPortalMenuService.addMenu(spMenuForm);
//    }
//
//    @PostMapping("modifyMenu")
//    public R modifyMenu(@RequestBody SPMenuForm spMenuForm){
//        return saltPortalMenuService.modifyMenu(spMenuForm);
//    }
//
//    @PostMapping("deleteMenu")
//    public R deleteMenu(@RequestBody String id){
//        return saltPortalMenuService.deleteMenu(id);
//    }
}
