package com.salt.cms.ourservice.controller;


import com.salt.cms.entity.SaltWordEntity;
import com.salt.cms.ourservice.form.SaltVideoForm;
import com.salt.cms.ourservice.form.SaltWordForm;
import com.salt.cms.ourservice.service.SaltOurServiceService;
import com.salt.cms.utils.R;
import com.salt.cms.vo.DeletedVO;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/SaltOurService")
public class SaltOurServiceController {
    @Autowired(required=false)
    private SaltOurServiceService ourService;

    //获取ourservice视频 cms、门户
    @GetMapping("/getVideo")
    public String getVideo(@RequestParam("videoType")String videoType){
        return ourService.getVideo(videoType);
    }

    //获得文字段list cms已对接、门户
    @GetMapping("/getWord")
    public List<SaltWordEntity> getWord(){
        List<SaltWordEntity> list = ourService.getWord();
        return list;
    }

    //获得轮播图 cms、门户
    @GetMapping("/getRotation")
    public List<String> getRotation(@RequestParam("code")String code){
        return ourService.getRotation(code);
    }

    //获得文字段详细信息 cms已对接
    @GetMapping("/getWordOne")
    public SaltWordEntity getWordEntity(@RequestParam("id") String id){
        SaltWordEntity list = ourService.getWordEntity(id);
        return list;
    }

    //修改文字段 cms已对接
    @PostMapping("/modifyWord")
    public R modifyWord(@RequestBody SaltWordForm saltWordForm){
        return ourService.modifyWord(saltWordForm);
    }

//    @PostMapping("/getVideoList")
//    public R getVideo(){
//        return R.ok().put("list",ourService.getVideo());
//    }

    @PostMapping("/addVideo")
    public R addVideo(@RequestBody SaltVideoForm saltVideoForm){
        return ourService.addVideo(saltVideoForm);
    }

    @PostMapping("/modifyVideo")
    public R modifyVideo(@RequestBody SaltVideoForm saltVideoForm){
        return ourService.modifyVideo(saltVideoForm);
    }

    @PostMapping("/deleteVideo")
    public R deleteVideo(@RequestBody String id){
        return ourService.deleteVideo(id);
    }


}
