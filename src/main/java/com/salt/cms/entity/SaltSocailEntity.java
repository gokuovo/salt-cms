package com.salt.cms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("salt_social")
@Data
@EqualsAndHashCode(callSuper = false)
public class SaltSocailEntity {
    private String id;
    private String connectCode;
    private String imageUrl;
    private String contactUrl;
}
