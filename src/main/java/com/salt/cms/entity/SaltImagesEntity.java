package com.salt.cms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@TableName("salt_images")
@Accessors(chain = true)
@Data
@EqualsAndHashCode(callSuper = false)
public class SaltImagesEntity {

    private String id;

    //10.contactUs移动背景图 11.contactUs的ourSocial图标
    private String imageCode;

    private String imageUrl;

    private String noti;

    private String reserve;
}
