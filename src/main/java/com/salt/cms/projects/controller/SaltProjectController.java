package com.salt.cms.projects.controller;


import com.salt.cms.entity.SaltAlbumEntity;
import com.salt.cms.entity.SaltListEntity;
import com.salt.cms.entity.SaltMusicVideoEntity;
import com.salt.cms.menu.form.SPMenuForm;
import com.salt.cms.menu.service.SaltPortalMenuService;
import com.salt.cms.projects.form.SaltMusicVideoForm;
import com.salt.cms.projects.service.SaltProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/SaltProject")
public class SaltProjectController {
    @Autowired
    private SaltProjectService saltProjectService;

    @GetMapping("/getProject")
    public List<SaltMusicVideoEntity> getProject(@PathVariable("album")String album){
        log.info("开始获取project媒体信息");
        return saltProjectService.getProject(album);
    }

    @GetMapping("/getAlbum")
    public List<SaltAlbumEntity> getAlbum(){
        log.info("开始获取专辑信息");
        return saltProjectService.getAlbum();
    }

    @GetMapping("/getList")
    public List<SaltListEntity> getList(){
        log.info("开始获取project页面list信息");
        return saltProjectService.getList();
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
