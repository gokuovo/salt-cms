package com.salt.cms.extension.file;

import com.salt.cms.file.FileLocalUploader;
import com.salt.cms.file.FileUploader;
import com.salt.cms.module.file.File;
import com.salt.cms.module.file.Uploader;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * 文件上传配置类
 *
 * @author Juzi@TaleLin
 * @author colorful@TaleLin
 */
@Configuration(proxyBeanMethods = false)
public class UploaderConfiguration {
    /**
     * @return 本地文件上传实现类
     */
    @Bean
    @Order
    @ConditionalOnMissingBean
    public Uploader uploader(){
        return new LocalUploader();
    }

    @Bean
    @Order
    @ConditionalOnMissingBean
    public FileUploader fileUploader(){
        return new FileLocalUploader();
    }
}
