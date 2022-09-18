package com.salt.cms.team.service;


import com.salt.cms.entity.SaltStaffEntity;
import com.salt.cms.entity.SaltWordEntity;
import com.salt.cms.team.form.SaltTeamForm;
import com.salt.cms.vo.DeletedVO;
import com.salt.cms.vo.UpdatedVO;

import java.util.List;

public interface SaltTeamService {

    List<SaltTeamForm> getTeam();
    List<SaltStaffEntity> getStaff();
    SaltStaffEntity getStaffOne(String id);
    SaltStaffEntity addStaff(SaltTeamForm saltTeamForm);
    UpdatedVO modifyStaff(SaltTeamForm saltTeamForm);
    DeletedVO deleteStaff(String id);
    SaltWordEntity teamWord();

}
