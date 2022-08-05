package com.salt.cms.file;

import com.salt.cms.module.file.File;

/**
 * 文件前预处理器
 *
 * @author pedro@TaleLin
 */
public interface FileUploadHandler {

    /**
     * 在文件写入本地或者上传到云之前调用此方法
     *
     * @return 是否上传，若返回false，则不上传
     */
    boolean preHandle(File file);

    /**
     * 在文件写入本地或者上传到云之后调用此方法
     */
    void afterHandle(File file,String fileType,String id);
}
