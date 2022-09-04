package com.salt.cms.news.controller;

import com.salt.cms.news.form.SaltNewsForm;
import com.salt.cms.news.form.SaltNewsLinkForm;
import com.salt.cms.news.form.SaltNewsLinkPageForm;
import com.salt.cms.news.service.SaltNewsLinkService;
import com.salt.cms.vo.UpdatedVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/SaltNewsLink")
public class SaltNewsLinkController {

    @Autowired
    SaltNewsLinkService saltNewsLinkService;
    @GetMapping("/getNewsLink")
    public List<SaltNewsLinkForm> getNewsLink(){
        return saltNewsLinkService.getNewsLink();
    }

    @GetMapping("/getNewsLinkOne")
    public List<SaltNewsLinkPageForm> getNewsLinkPage(@RequestParam("id") String id){
        return saltNewsLinkService.getNewsLinkPage(id);
    }

    @PostMapping("modifyNewsLink")
    public UpdatedVO modifyNewsLink(@RequestBody SaltNewsLinkPageForm saltNewsLinkPageForm){
        return saltNewsLinkService.modifyNewsLink(saltNewsLinkPageForm);
    }
}
