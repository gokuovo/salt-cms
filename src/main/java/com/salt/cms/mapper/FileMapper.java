package com.salt.cms.mapper;

import com.salt.cms.model.FileDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author pedro@TaleLin
 */
@Mapper
@Repository
public interface FileMapper extends BaseMapper<FileDO> {

    FileDO selectByMd5(@Param("md5") String md5);

    int selectCountByMd5(@Param("md5") String md5);
}
