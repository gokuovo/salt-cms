package com.salt.cms.team.service.impl;

import com.salt.cms.entity.SaltStaffEntity;
import com.salt.cms.team.dao.SaltStaffDao;
import com.salt.cms.team.form.SaltTeamForm;
import com.salt.cms.team.service.SaltTeamService;
import com.salt.cms.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Slf4j
@Service
public class SaltTeamServiceImpl implements SaltTeamService {

    @Autowired
    private SaltStaffDao saltStaffDao;

    @Override
    public List<SaltTeamForm> getTeam() {
        return saltStaffDao.getTeam();
    }

    @Override
    public List<SaltStaffEntity> getStaff() {
        return saltStaffDao.getStaff();
    }

    @Override
    public R addStaff(SaltTeamForm saltTeamForm) {
        SaltStaffEntity saltStaffEntity = new SaltStaffEntity();
        saltStaffEntity.setId(UUID.randomUUID().toString());
        saltStaffEntity.setStaffDescChi(saltTeamForm.getStaffDescChi());
        saltStaffEntity.setStaffDescEn(saltTeamForm.getStaffDescEn());
        saltStaffEntity.setStaffDescJap(saltTeamForm.getStaffDescJap());
        saltStaffEntity.setStaffDescSpa(saltTeamForm.getStaffDescSpa());
        saltStaffEntity.setStaffNameChi(saltTeamForm.getStaffNameChi());
        saltStaffEntity.setStaffNameEn(saltTeamForm.getStaffNameEn());
        saltStaffEntity.setStaffNameJap(saltTeamForm.getStaffNameJap());
        saltStaffEntity.setStaffNameSpa(saltTeamForm.getStaffNameSpa());
        saltStaffEntity.setStaffPostChi(saltTeamForm.getStaffPostChi());
        saltStaffEntity.setStaffPostEn(saltTeamForm.getStaffPostEn());
        saltStaffEntity.setStaffPostJap(saltTeamForm.getStaffPostJap());
        saltStaffEntity.setStaffPostSpa(saltTeamForm.getStaffPostSpa());
        saltStaffDao.insert(saltStaffEntity);
        return R.ok("成功");
    }

    @Override
    public R modifyStaff(SaltTeamForm saltTeamForm) {
        SaltStaffEntity saltStaffEntity = new SaltStaffEntity();
        saltStaffEntity.setId(saltTeamForm.getId());
        saltStaffEntity.setStaffDescChi(saltTeamForm.getStaffDescChi());
        saltStaffEntity.setStaffDescEn(saltTeamForm.getStaffDescEn());
        saltStaffEntity.setStaffDescJap(saltTeamForm.getStaffDescJap());
        saltStaffEntity.setStaffDescSpa(saltTeamForm.getStaffDescSpa());
        saltStaffEntity.setStaffNameChi(saltTeamForm.getStaffNameChi());
        saltStaffEntity.setStaffNameEn(saltTeamForm.getStaffNameEn());
        saltStaffEntity.setStaffNameJap(saltTeamForm.getStaffNameJap());
        saltStaffEntity.setStaffNameSpa(saltTeamForm.getStaffNameSpa());
        saltStaffEntity.setStaffPostChi(saltTeamForm.getStaffPostChi());
        saltStaffEntity.setStaffPostEn(saltTeamForm.getStaffPostEn());
        saltStaffEntity.setStaffPostJap(saltTeamForm.getStaffPostJap());
        saltStaffEntity.setStaffPostSpa(saltTeamForm.getStaffPostSpa());
        saltStaffDao.updateById(saltStaffEntity);
        return null;
    }

    @Override
    public R deleteStaff(String id) {
        saltStaffDao.deleteById(id);
        return null;
    }
}
