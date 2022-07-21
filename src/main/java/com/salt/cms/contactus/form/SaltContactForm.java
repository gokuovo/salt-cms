package com.salt.cms.contactus.form;

import lombok.Data;

@Data
public class SaltContactForm {
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
