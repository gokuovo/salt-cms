package com.salt.cms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("salt_news_link")
@Data
@EqualsAndHashCode(callSuper = false)
public class SaltNewsLinkEntity {
    private String id;
    private String title;
    private String img01;
    private String img02;
    private String img03;
    private String textEn01;
    private String textChi01;
    private String textJap01;
    private String textSpa01;
    private String textEn02;
    private String textChi02;
    private String textJap02;
    private String textSpa02;
}
