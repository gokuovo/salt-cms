package com.salt.cms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("salt_images")
@Data
@EqualsAndHashCode(callSuper = false)
public class SaltImagesEntity {
    private String id;
    private String imageCode;
    private String imageUrl;
    private String noti;
    private String reserve;
}
