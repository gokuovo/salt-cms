package com.salt.cms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("salt_word")
@Data
@EqualsAndHashCode(callSuper = false)
public class SaltWordEntity {
    private String id;
    private String wordType;
    private String wordTextEn;
    private String wordTextChi;
    private String wordTextJap;
    private String wordTextSpa;
    private String wordSign;
    private String noti;

}
