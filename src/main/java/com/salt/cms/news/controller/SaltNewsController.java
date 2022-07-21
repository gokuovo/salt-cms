package com.salt.cms.news.controller;

import com.salt.cms.news.form.SaltNewsForm;
import com.salt.cms.news.form.SaltWorklogForm;
import com.salt.cms.news.service.SaltNewsService;
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

//    @PostMapping("/addNews")
//    public R addNews(@RequestBody SaltNewsForm saltNewsForm){
//        return saltNewsService.addNews(saltNewsForm);
//    }
//
//    @PostMapping("modifyNews")
//    public R modifyNews(@RequestBody SaltNewsForm saltNewsForm){
//        return saltNewsService.modifyNews(saltNewsForm);
//    }
//
//    @PostMapping("deleteNews")
//    public R deleteNews(@RequestBody String id){
//        return saltNewsService.deleteNews(id);
//    }
}
