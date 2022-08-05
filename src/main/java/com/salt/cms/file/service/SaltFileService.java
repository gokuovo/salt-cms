package com.salt.cms.file.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.salt.cms.bo.FileBO;
import com.salt.cms.model.FileDO;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author pedro@TaleLin
 */
public interface SaltFileService extends IService<FileDO> {

    /**
     * 上传文件
     *
     * @param fileMap 文件map
     * @param fileType
     * @param id
     * @return 文件数据
     */
    List<FileBO> upload(MultiValueMap<String, MultipartFile> fileMap,String fileType,String id);

    /**
     * 通过md5检查文件是否存在
     *
     * @param md5 md5
     * @return true 表示已存在
     */
    boolean checkFileExistByMd5(String md5);
}
