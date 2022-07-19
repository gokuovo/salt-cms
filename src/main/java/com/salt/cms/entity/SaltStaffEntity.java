package com.salt.cms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("salt_staff")
@Data
@EqualsAndHashCode(callSuper = false)
public class SaltStaffEntity {
    private String id;
    private String StaffNameEn;
    private String StaffNameChi;
    private String StaffNameJap;
    private String StaffNameSpa;
    private String StaffPostEn;
    private String StaffPostChi;
    private String StaffPostJap;
    private String StaffPostSpa;
    private String StaffDescEn;
    private String StaffDescChi;
    private String StaffDescJap;
    private String StaffDescSpa;
    private String StaffImage;
    private String sort;
}
