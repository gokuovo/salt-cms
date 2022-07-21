package com.salt.cms.news.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.salt.cms.entity.SaltNewsEntity;
import com.salt.cms.news.form.SaltNewsForm;
import com.salt.cms.news.form.SaltWorklogForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SaltNewsDao extends BaseMapper<SaltNewsEntity> {

    @Select("select * from salt_news order by sort")
    List<SaltNewsForm> getNews();

    @Select("select * from salt_worklog order by sort")
    List<SaltWorklogForm> getWorklog();


}
