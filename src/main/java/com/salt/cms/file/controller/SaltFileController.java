package com.salt.cms.file.controller;

import com.salt.cms.bo.FileBO;
import com.salt.cms.file.service.SaltFileService;
import com.salt.cms.service.FileService;
import io.github.talelin.core.annotation.LoginRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;


@RestController
@RequestMapping("/partnersFile")
public class SaltFileController {
        @Autowired
        private SaltFileService saltFileService;

        /**
         * 文件上传
         *
         * @param multipartHttpServletRequest 携带文件的 request
         * @return 文件信息
         */
        @PostMapping
        @LoginRequired
        public List<FileBO> upload(MultipartHttpServletRequest multipartHttpServletRequest, @RequestParam("fileType") String fileType,
                                   @RequestParam("id") String id) {
            MultiValueMap<String, MultipartFile> fileMap =
                    multipartHttpServletRequest.getMultiFileMap();
            return saltFileService.upload(fileMap,fileType,id);
        }

}
