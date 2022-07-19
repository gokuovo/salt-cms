package com.salt.cms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("salt_Video")
@Data
@EqualsAndHashCode(callSuper = false)
public class SaltVideoEntity {
    private String id;
    private String VideoNameEn;
    private String VideoNameChi;
    private String VideoNameJap;
    private String VideoNameSpa;
    private String VideoUrl;
}
