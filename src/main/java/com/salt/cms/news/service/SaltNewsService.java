package com.salt.cms.news.service;

import com.salt.cms.entity.SaltNewsEntity;
import com.salt.cms.entity.SaltWorklogEntity;
import com.salt.cms.news.form.SaltNewsForm;
import com.salt.cms.news.form.SaltWorklogForm;
import com.salt.cms.vo.DeletedVO;
import com.salt.cms.vo.UpdatedVO;

import java.util.List;

public interface SaltNewsService {
    List<SaltNewsForm> getNews();
    List<SaltWorklogForm> getWorklog();

    SaltNewsEntity getNewsOne(String id);
    SaltWorklogEntity getWorklogOne(String id);

    SaltNewsEntity addNews(SaltNewsForm saltNewsForm);
    DeletedVO deleteNews(String id);
    UpdatedVO modifyNews(SaltNewsForm saltNewsForm);


    SaltWorklogEntity addWorklog(SaltWorklogForm saltWorklogForm);
    DeletedVO deleteWorklog(String id);
    UpdatedVO modifyWorklog(SaltWorklogForm saltWorklogForm);

}
