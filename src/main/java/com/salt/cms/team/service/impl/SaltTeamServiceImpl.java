package com.salt.cms.team.service.impl;

import com.salt.cms.entity.SaltStaffEntity;
import com.salt.cms.team.dao.SaltStaffDao;
import com.salt.cms.team.form.SaltTeamForm;
import com.salt.cms.team.service.SaltTeamService;
import com.salt.cms.vo.CreatedVO;
import com.salt.cms.vo.DeletedVO;
import com.salt.cms.vo.UpdatedVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
    public SaltStaffEntity getStaffOne(String id) {
        return saltStaffDao.selectById(id);
    }

    @Override
    public SaltStaffEntity addStaff(SaltTeamForm saltTeamForm) {
        SaltStaffEntity saltStaffEntity = new SaltStaffEntity();
        BeanUtils.copyProperties(saltTeamForm,saltStaffEntity);
        saltStaffEntity.setId(UUID.randomUUID().toString());
        saltStaffDao.insert(saltStaffEntity);
        return saltStaffEntity;
    }

    @Override
    public UpdatedVO modifyStaff(SaltTeamForm saltTeamForm) {
        SaltStaffEntity saltStaffEntity = new SaltStaffEntity();
        BeanUtils.copyProperties(saltTeamForm,saltStaffEntity);
        saltStaffDao.updateById(saltStaffEntity);
        return new UpdatedVO("已更新");
    }

    @Override
    public DeletedVO deleteStaff(String id) {
        saltStaffDao.deleteById(id);
        return new DeletedVO("已删除");
    }
}
