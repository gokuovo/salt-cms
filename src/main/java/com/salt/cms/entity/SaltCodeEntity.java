package com.salt.cms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("salt_code")
@Data
@EqualsAndHashCode(callSuper = false)
public class SaltCodeEntity {
    private String codeType;
    private String code;
    private String codeName;
    private String noti;
}
