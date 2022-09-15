package com.salt.cms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("salt_word")
@Data
@EqualsAndHashCode(callSuper = false)
public class SaltWordEntity {
    private String id;
    private String wordType;//标题
    private String wordTextEn;
    private String wordTextChi;
    private String wordTextJap;
    private String wordTextSpa;
    private String wordSign;//作者
    private String noti;
    private int useWhere;//0非文章，1文章
    private int sortNo;//排序

    public String[] getArrWordTextEn(){
        if(null != wordTextEn && !wordTextEn.equals("")){
            return wordTextEn.split("\n");
        }
        return new String[0];
    }

    public String[] getArrWordTextChi(){
        if(null != wordTextChi && !wordTextChi.equals("")){
            return wordTextChi.split("\n");
        }
        return new String[0];
    }

    public String[] getArrWordTextJap(){
        if(null != wordTextJap && !wordTextJap.equals("")){
            return wordTextJap.split("\n");
        }
        return new String[0];
    }

    public String[] getArrWordTextSpa(){
        if(null != wordTextSpa && !wordTextSpa.equals("")){
            return wordTextSpa.split("\n");
        }
        return new String[0];
    }
}
