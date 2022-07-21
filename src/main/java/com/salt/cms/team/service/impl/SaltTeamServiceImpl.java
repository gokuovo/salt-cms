package com.salt.cms.team.service.impl;

import com.salt.cms.team.dao.SaltStaffDao;
import com.salt.cms.team.form.SaltTeamForm;
import com.salt.cms.team.service.SaltTeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class SaltTeamServiceImpl implements SaltTeamService {

    @Autowired
    private SaltStaffDao saltStaffDao;

    @Override
    public List<SaltTeamForm> getTeam() {
        return saltStaffDao.getTeam();
    }
}
