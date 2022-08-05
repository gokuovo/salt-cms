package com.salt.cms.projects.controller;


import com.salt.cms.entity.SaltAlbumEntity;
import com.salt.cms.entity.SaltListEntity;
import com.salt.cms.entity.SaltMusicVideoEntity;
import com.salt.cms.menu.form.SPMenuForm;
import com.salt.cms.menu.service.SaltPortalMenuService;
import com.salt.cms.news.form.SaltNewsForm;
import com.salt.cms.projects.dao.SaltAlbumDao;
import com.salt.cms.projects.form.SaltListForm;
import com.salt.cms.projects.form.SaltMusicVideoForm;
import com.salt.cms.projects.service.SaltProjectService;
import com.salt.cms.utils.R;
import com.salt.cms.vo.CreatedVO;
import com.salt.cms.vo.DeletedVO;
import com.salt.cms.vo.UpdatedVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/SaltProject")
public class SaltProjectController {
    @Autowired
    private SaltProjectService saltProjectService;

    @GetMapping("/getProject/{album}")
    public List<SaltMusicVideoEntity> getProject(@PathVariable("album")String album){
        log.info("开始获取project媒体信息");
        return saltProjectService.getProject(album);
    }

    @GetMapping("/getAlbum")
    public List<SaltAlbumEntity> getAlbum(){
        log.info("开始获取专辑信息");
        return saltProjectService.getAlbum();
    }

    @GetMapping("/getAlbumOne")
    public SaltAlbumEntity getAlbumOne(@RequestParam("id")String id){
        log.info("开始获取专辑信息");
        return saltProjectService.getAlbumOne(id);
    }

    @PostMapping("/addAlbum")
    public SaltAlbumEntity addAlbum(@RequestBody SaltAlbumEntity saltAlbumEntity){
        return saltProjectService.addAlbum(saltAlbumEntity);
    }

    @PostMapping("/modifyAlbum")
    public UpdatedVO modifyAlbum(@RequestBody SaltAlbumEntity saltAlbumEntity){
        return saltProjectService.modifyAlbum(saltAlbumEntity);
    }

    @PostMapping("/deleteAlbum")
    public DeletedVO deleteAlbum(@RequestParam("id") String id){
        return saltProjectService.deleteAlbum(id);
    }



    @GetMapping("/getList")
    public List<SaltListEntity> getList(){
        log.info("开始获取project页面list信息");
        return saltProjectService.getList();
    }

    @GetMapping("/getListOne")
    public SaltListEntity getListOne(@RequestParam("id")String id){
        log.info("开始获取project页面list信息");
        return saltProjectService.getListOne(id);
    }

    @GetMapping("/getProjectPage/{album}")
    public R getProjectPage(@PathVariable("album")String album){
        log.info("开始获取project媒体信息");
        return R.ok().put("list",saltProjectService.getProject(album));
    }

    //根据type获取媒体
    @GetMapping("/getProjectByType")
    public List<SaltMusicVideoEntity> getProjectByType(@RequestParam("type") String type){
        log.info("开始获取project媒体信息");
        return saltProjectService.getProjectByType(type);
    }

    //cms
    @GetMapping("/getProjecteByAlbum")
    public List<SaltMusicVideoEntity> getProjecteByAlbum(@RequestParam("album")String album){
        log.info("开始获取project媒体信息");
        return saltProjectService.getProject(album);
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

    @GetMapping("/getMusicOne")
    public SaltMusicVideoEntity getMusicOne(@RequestParam("id")String id){
        log.info("开始获取专辑信息");
        return saltProjectService.getMusicOne(id);
    }

    @PostMapping("/addList")
    public SaltListEntity addList(@RequestBody SaltListForm saltListForm){
        return saltProjectService.addList(saltListForm);
    }

    @PostMapping("modifyList")
    public UpdatedVO modifyList(@RequestBody SaltListForm saltListForm){
        return saltProjectService.modifyList(saltListForm);
    }

    @PostMapping("deleteList")
    public DeletedVO deleteList(@RequestParam("id") String id){
        return saltProjectService.deleteList(id);
    }



    @PostMapping("deleteMusic")
    public DeletedVO deleteMusic(@RequestParam("id") String id){
        return saltProjectService.deleteMusic(id);
    }

    @PostMapping("/addMusic")
    public SaltMusicVideoEntity addMusic(@RequestBody SaltMusicVideoEntity saltMusicVideoEntity){
        return saltProjectService.addMusic(saltMusicVideoEntity);
    }

    @PostMapping("modifyMusic")
    public UpdatedVO modifyMusic(@RequestBody SaltMusicVideoEntity saltMusicVideoEntity){
        return saltProjectService.modifyMusic(saltMusicVideoEntity);
    }

    @PostMapping("deleteVideo")
    public DeletedVO deleteVideo(@RequestParam("id") String id){
        return saltProjectService.deleteVideo(id);
    }

    @PostMapping("/addVideo")
    public SaltMusicVideoEntity addVideo(@RequestBody SaltMusicVideoEntity saltMusicVideoEntity){
        return saltProjectService.addVideo(saltMusicVideoEntity);
    }

    @PostMapping("modifyVideo")
    public UpdatedVO modifyVideo(@RequestBody SaltMusicVideoEntity saltMusicVideoEntity){
        return saltProjectService.modifyVideo(saltMusicVideoEntity);
    }




}
