package com.salt.cms.news.service;

import com.salt.cms.news.form.SaltNewsForm;
import com.salt.cms.news.form.SaltWorklogForm;

import java.util.List;

public interface SaltNewsService {
    List<SaltNewsForm> getNews();
    List<SaltWorklogForm> getWorklog();
//    R addNews(SaltNewsForm saltNewsForm);
//    R deleteNews(String id);
//    R modifyNews(SaltNewsForm saltNewsForm);
}
