package com.salt.cms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("salt_music_video")
@Data
@EqualsAndHashCode(callSuper = false)
public class SaltMusicVideoEntity {
    @TableId(value = "id",type = IdType.INPUT)
    private String id;
    private String title;
    private String url;
    private String album;
    private String type; //0表示音乐,1表示视频
}
