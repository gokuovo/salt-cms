package com.salt.cms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("salt_music_video")
@Data
@EqualsAndHashCode(callSuper = false)
public class SaltMusicVideoEntity {
    private String id;
    private String title;
    private String url;
    private String album;
}
