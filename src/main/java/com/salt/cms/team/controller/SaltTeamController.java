package com.salt.cms.team.controller;

import com.salt.cms.entity.SaltStaffEntity;
import com.salt.cms.entity.SaltWordEntity;
import com.salt.cms.ourservice.service.SaltOurServiceService;
import com.salt.cms.team.form.SaltTeamForm;
import com.salt.cms.team.service.SaltTeamService;
import com.salt.cms.utils.R;
import com.salt.cms.vo.CreatedVO;
import com.salt.cms.vo.DeletedVO;
import com.salt.cms.vo.UpdatedVO;
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

    @Autowired
    private SaltOurServiceService saltOurServiceService;


    @GetMapping("/getTeam")
    public List<SaltTeamForm> getTeam(){
        log.info("开始获取team信息");
        return saltTeamervice.getTeam();
    }

    @GetMapping("/getStaff")
    public List<SaltStaffEntity> getStaff(){
        log.info("开始获取staff信息");
        return saltTeamervice.getStaff();
    }

    @GetMapping("/getStaffOne")
    public SaltStaffEntity getStaffOne(@RequestParam("id")String id){
        log.info("开始获取staff信息");
        return saltTeamervice.getStaffOne(id);
    }

    @PostMapping("/addStaff")
    public SaltStaffEntity addStaff(@RequestBody SaltTeamForm staffForm){
        return saltTeamervice.addStaff(staffForm);
    }

    @PostMapping("/modifyStaff")
    public UpdatedVO modifyStaff(@RequestBody SaltTeamForm staffForm){
        return saltTeamervice.modifyStaff(staffForm);
    }

    @PostMapping("/deleteStaff")
    public DeletedVO deleteStaff(@RequestParam("id") String id){
        saltTeamervice.deleteStaff(id);
        return new DeletedVO("删除成功");
    }

    @GetMapping("/teamWord")
    public SaltWordEntity teamWord(){
        return saltTeamervice.teamWord();
    }

    @PostMapping("/modifyTeamWord")
    public UpdatedVO modifyTeamWord(@RequestBody SaltWordEntity saltWordEntity){
        saltOurServiceService.modifyWord(saltWordEntity);
        return new UpdatedVO("更新成功");
    }
}
