package com.salt.cms.news.service;

import com.salt.cms.news.form.SaltNewsLinkForm;
import com.salt.cms.news.form.SaltNewsLinkImgForm;
import com.salt.cms.news.form.SaltNewsLinkPageForm;
import com.salt.cms.vo.UpdatedVO;

import java.util.List;

public interface SaltNewsLinkService {

    List<SaltNewsLinkForm> getNewsLink();

    List<SaltNewsLinkPageForm> getNewsLinkPage(String id);

    UpdatedVO modifyNewsLink(SaltNewsLinkPageForm saltNewsLinkPageForm);

    SaltNewsLinkImgForm getImg(String id,String code);
}
