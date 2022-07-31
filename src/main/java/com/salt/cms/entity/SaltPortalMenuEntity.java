package com.salt.cms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("salt_portal_menu")
@Data
@EqualsAndHashCode(callSuper = false)
public class SaltPortalMenuEntity {
    private String id;
    private String menuNameEn;
    private String menuNameChi;
    private String menuNameJap;
    private String menuNameSpa;
    private String url;
    private int sort;
}
