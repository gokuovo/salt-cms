package com.salt.cms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("salt_album")
@Data
@EqualsAndHashCode(callSuper = false)
public class SaltAlbumEntity {
    private String id;
    private String titleEn;
    private String titleChi;
    private String titleJap;
    private String titleSpa;
    private String releaseEn;
    private String releaseChi;
    private String releaseJap;
    private String releaseSpa;
    private String developerEn;
    private String developerChi;
    private String developerJap;
    private String developerSpa;
    private String publisherEn;
    private String publisherChi;
    private String publisherJap;
    private String publisherSpa;
    private String platformEn;
    private String platformChi;
    private String platformJap;
    private String platformSpa;
    private String imgSrc;
}
