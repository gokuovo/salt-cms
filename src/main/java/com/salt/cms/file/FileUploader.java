package com.salt.cms.file;

import com.salt.cms.module.file.File;
import com.salt.cms.module.file.UploadHandler;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 文件上传服务接口
 *
 * @author pedro@TaleLin
 */

@Service
public interface FileUploader {

    /**
     * 上传文件
     *
     * @param fileMap 文件map
     * @param fileType
     * @param id
     * @return 文件数据
     */
    List<File> upload(MultiValueMap<String, MultipartFile> fileMap, String fileType,String id);

    /**
     * 上传文件
     *
     * @param fileMap    文件map
     * @param uploadHandler 预处理器
     * @return 文件数据
     */
    List<File> upload(MultiValueMap<String, MultipartFile> fileMap,String fileType,String id, FileUploadHandler uploadHandler);
}
