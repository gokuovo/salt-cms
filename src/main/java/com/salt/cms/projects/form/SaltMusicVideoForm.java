package com.salt.cms.projects.form;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
public class SaltMusicVideoForm {
    private String id;
    private String title;
    private String url;
    private String album;
}
