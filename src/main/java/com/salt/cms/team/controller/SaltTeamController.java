package com.salt.cms.team.controller;

import com.salt.cms.entity.SaltStaffEntity;
import com.salt.cms.entity.SaltWordEntity;
import com.salt.cms.team.form.SaltTeamForm;
import com.salt.cms.team.service.SaltTeamService;
import com.salt.cms.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @GetMapping("/getStaff")
    public R getStaff(){
        log.info("开始获取staff信息");
        List<SaltStaffEntity> saltStaffEntity = saltTeamervice.getStaff();
        return R.ok().put("list",saltStaffEntity);
    }

    @PostMapping("/addStaff")
    public R addStaff(@RequestBody SaltTeamForm staffForm){
        return saltTeamervice.addStaff(staffForm);
    }

    @PostMapping("modifyStaff")
    public R modifyStaff(@RequestBody SaltTeamForm staffForm){
        return saltTeamervice.modifyStaff(staffForm);
    }

    @PostMapping("deleteStaff")
    public R deleteStaff(@RequestBody String id){
        return saltTeamervice.deleteStaff(id);
    }
}
