package com.salt.cms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("salt_news")
@Data
@EqualsAndHashCode(callSuper = false)
public class SaltNewsEntity {
    private String id;
    private String titleEn;
    private String titleChi;
    private String titleJap;
    private String titleSpa;
    private String dateEn;
    private String dateChi;
    private String dateJap;
    private String dateSpa;
    private String url;
    private String link;
    private String sort;
}
