package com.salt.cms.mapper;

import com.salt.cms.model.UserIdentityDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author pedro@TaleLin
 */
@Mapper
@Repository
public interface UserIdentityMapper extends BaseMapper<UserIdentityDO> {

}
