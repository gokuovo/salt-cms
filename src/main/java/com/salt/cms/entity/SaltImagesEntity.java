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

    //1:联系方式图标，2:首页背景动图，3:首页背景大图片，4首页背景小图片
    private String imageCode;

    private String imageUrl;

    private String noti;

    private String reserve;
}
