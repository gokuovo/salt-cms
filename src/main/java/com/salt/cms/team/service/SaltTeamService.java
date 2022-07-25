package com.salt.cms.team.service;


import com.salt.cms.entity.SaltStaffEntity;
import com.salt.cms.team.form.SaltTeamForm;
import com.salt.cms.utils.R;

import java.util.List;

public interface SaltTeamService {

    List<SaltTeamForm> getTeam();
    List<SaltStaffEntity> getStaff();
    R addStaff(SaltTeamForm saltTeamForm);
    R modifyStaff(SaltTeamForm saltTeamForm);
    R deleteStaff(String id);

}
