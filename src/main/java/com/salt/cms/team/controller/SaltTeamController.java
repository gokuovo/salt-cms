package com.salt.cms.team.controller;

import com.salt.cms.team.form.SaltTeamForm;
import com.salt.cms.team.service.SaltTeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/SaltTeam")
public class SaltTeamController {
    @Autowired
    private SaltTeamService saltTeamervice;


    @GetMapping("/getTeam")
    public List<SaltTeamForm> getTeam(){
        log.info("开始获取team信息");
        return saltTeamervice.getTeam();
    }
//    @PostMapping("/addStaff")
//    public R addStaff(@RequestBody SaltTeamForm staffForm){
//        return null;
//    }
//
//    @PostMapping("modifyStaff")
//    public R modifyStaff(@RequestBody SaltTeamForm staffForm){
//        return null;
//    }
//
//    @PostMapping("deleteStaff")
//    public R deleteStaff(@RequestBody String id){
//        return null;
//    }
}
