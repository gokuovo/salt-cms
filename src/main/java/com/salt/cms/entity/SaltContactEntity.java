package com.salt.cms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("salt_contact")
@Data
@EqualsAndHashCode(callSuper = false)
public class SaltContactEntity {
    private String id;
    private String tel;
    private String addressEn;
    private String addressJap;
    private String addressChi;
    private String addressSpa;
    private String mail;
    private String isValid;
    private String sort;
}
