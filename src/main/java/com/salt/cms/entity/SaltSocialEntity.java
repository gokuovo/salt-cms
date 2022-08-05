package com.salt.cms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("salt_social")
@Data
@EqualsAndHashCode(callSuper = false)
public class SaltSocialEntity {
    private String id;
    private String connectType;
    private String imageUrl;
    private String contactUrl;
    private int sort;
    private String isValid;
}
