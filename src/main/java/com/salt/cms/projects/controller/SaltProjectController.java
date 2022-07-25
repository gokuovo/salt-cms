package com.salt.cms.projects.controller;


import com.salt.cms.entity.SaltAlbumEntity;
import com.salt.cms.entity.SaltListEntity;
import com.salt.cms.entity.SaltMusicVideoEntity;
import com.salt.cms.menu.form.SPMenuForm;
import com.salt.cms.menu.service.SaltPortalMenuService;
import com.salt.cms.news.form.SaltNewsForm;
import com.salt.cms.projects.form.SaltListForm;
import com.salt.cms.projects.form.SaltMusicVideoForm;
import com.salt.cms.projects.service.SaltProjectService;
import com.salt.cms.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getProjectPage")
    public R getProjectPage(@PathVariable("album")String album){
        log.info("开始获取project媒体信息");
        return R.ok().put("list",saltProjectService.getProject(album));
    }

    @GetMapping("/getAlbumPage")
    public R getAlbumPage(){
        log.info("开始获取专辑信息");
        return R.ok().put("list",saltProjectService.getAlbum());
    }

    @GetMapping("/getListPage")
    public R getListPage(){
        log.info("开始获取project页面list信息");
        return R.ok().put("list",saltProjectService.getList());
    }


    @PostMapping("/addFile")
    public R addFile(@RequestBody SaltMusicVideoForm saltMusicVideoForm){
        return saltProjectService.addFile(saltMusicVideoForm);
    }

    @PostMapping("/modifyFile")
    public R amodifyFile(@RequestBody SaltMusicVideoForm saltMusicVideoForm){
        return saltProjectService.modifyFile(saltMusicVideoForm);
    }

    @PostMapping("/deleteFile")
    public R deleteFile(@RequestBody String id){
        return saltProjectService.deleteFile(id);
    }



    @PostMapping("/addList")
    public R addList(@RequestBody SaltListForm saltListForm){
        return saltProjectService.addList(saltListForm);
    }

    @PostMapping("modifyList")
    public R modifyList(@RequestBody SaltListForm saltListForm){
        return saltProjectService.modifyList(saltListForm);
    }

    @PostMapping("deleteList")
    public R deleteList(@RequestBody String id){
        return saltProjectService.deleteList(id);
    }


}
