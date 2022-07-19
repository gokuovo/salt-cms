package com.salt.cms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("salt_partner")
@Data
@EqualsAndHashCode(callSuper = false)
public class SaltPartnerEntity {
    private String id;
    private String partnerName;
    private String partnerUrl;
    private String partnerLink;
    private String sort;
}
