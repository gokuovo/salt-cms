package com.salt.cms.ourservice.controller;


import com.salt.cms.ourservice.form.SaltWordForm;
import com.salt.cms.ourservice.service.SaltOurServiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/SaltOurService")
public class SaltOurServiceController {
    @Autowired(required=false)
    private SaltOurServiceService ourService;

    @GetMapping("/getMusic")
    public String getMusic(){
        log.info("开始获取Music视频");
        return ourService.getMusic();
    }

    @GetMapping("/getSoundDesign")
    public String getSoundDesign(){
        log.info("开始获取SoundDesign视频");
        return ourService.getSoundDesign();
    }

    @GetMapping("/getVoiceActing")
    public String getVoiceActing(){
        log.info("开始获取VoiceActing视频");
        return ourService.getVoiceActing();
    }

    @GetMapping("/getGameAudioPipeline")
    public String getGameAudioPipeline(){
        log.info("开始获取GameAudioPipeline视频");
        return ourService.getGameAudioPipeline();
    }

    @GetMapping("/getWhatWeDo")
    public SaltWordForm getWhatWeDo(){
        log.info("开始获取WhatWeDo");
        return ourService.getWhatWeDo();
    }

    @GetMapping("/getWhatWeDoText")
    public SaltWordForm getWhatWeDoText(){
        log.info("开始获取WhatWeDoText");
        return ourService.getWhatWeDoText();
    }

    @GetMapping("/getRotation")
    public SaltWordForm getRotation(){
        log.info("开始获取Rotation");
        return ourService.getRotation();
    }

}
