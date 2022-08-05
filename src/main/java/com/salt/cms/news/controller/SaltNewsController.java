package com.salt.cms.news.controller;

import com.salt.cms.entity.SaltNewsEntity;
import com.salt.cms.entity.SaltWorklogEntity;
import com.salt.cms.news.form.SaltNewsForm;
import com.salt.cms.news.form.SaltWorklogForm;
import com.salt.cms.news.service.SaltNewsService;
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
@RequestMapping("/SaltNews")
public class SaltNewsController {
    @Autowired
    private SaltNewsService saltNewsService;

    @GetMapping("/getNews")
    public List<SaltNewsForm> getNews(){
        log.info("开始news信息");
        return saltNewsService.getNews();
    }
    @GetMapping("/getWorklog")
    public List<SaltWorklogForm> getWorklog(){
        log.info("开始news信息");
        return saltNewsService.getWorklog();
    }

    @GetMapping("/getNewsOne")
    public SaltNewsEntity getNewsOne(@RequestParam("id")String id){
        log.info("开始news信息");
        return saltNewsService.getNewsOne(id);
    }
    @GetMapping("/getWorklogOne")
    public SaltWorklogEntity getWorklogOne(@RequestParam("id")String id){
        log.info("开始news信息");
        return saltNewsService.getWorklogOne(id);
    }

    @PostMapping("/addNews")
    public SaltNewsEntity addNews(@RequestBody SaltNewsForm saltNewsForm){
        return saltNewsService.addNews(saltNewsForm);
    }

    @PostMapping("modifyNews")
    public UpdatedVO modifyNews(@RequestBody SaltNewsForm saltNewsForm){
        return saltNewsService.modifyNews(saltNewsForm);
    }

    @PostMapping("deleteNews")
    public DeletedVO deleteNews(@RequestParam("id") String id){
        return saltNewsService.deleteNews(id);
    }

    @PostMapping("/addWorklog")
    public SaltWorklogEntity addWorklog(@RequestBody SaltWorklogForm saltWorklogForm){
        return saltNewsService.addWorklog(saltWorklogForm);
    }

    @PostMapping("modifyWorklog")
    public UpdatedVO modifyWorklog(@RequestBody SaltWorklogForm saltWorklogForm){
        return saltNewsService.modifyWorklog(saltWorklogForm);
    }

    @PostMapping("deleteWorklog")
    public DeletedVO deleteWorklog(@RequestParam String id){
        return saltNewsService.deleteWorklog(id);
    }
}
