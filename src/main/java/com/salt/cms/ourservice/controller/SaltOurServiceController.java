package com.salt.cms.ourservice.controller;


import com.salt.cms.entity.SaltWordEntity;
import com.salt.cms.ourservice.form.SaltVideoForm;
import com.salt.cms.ourservice.form.SaltWordForm;
import com.salt.cms.ourservice.service.SaltOurServiceService;
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

    @GetMapping("/getWord")
    public R getWord(){
        List<SaltWordEntity> list = ourService.getWord();
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        if (!list.isEmpty()) {
            for (SaltWordEntity word : list) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("wordType", word.getWordType());
                map.put("wordTextEN", word.getWordTextEn());
                map.put("wordTextChi", word.getWordTextChi());
                map.put("wordTextJap", word.getWordTextJap());
                map.put("wordTextSpa", word.getWordTextSpa());
                listMap.add(map);
            }
        }
        return R.ok().put("list", listMap);
    }


    @PostMapping("/addWord")
    public R addWord(@RequestBody SaltWordForm saltWordForm){
        return ourService.addWord(saltWordForm);
    }

    @PostMapping("/modifyWord")
    public R modifyWord(@RequestBody SaltWordForm saltWordForm){
        return ourService.modifyWord(saltWordForm);
    }

    @PostMapping("/deleteWord")
    public R deleteWord(@RequestBody String id){
        return ourService.deleteWord(id);
    }

    @PostMapping("/getVideo")
    public R getVideo(){
        return R.ok().put("list",ourService.getVideo());
    }

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
