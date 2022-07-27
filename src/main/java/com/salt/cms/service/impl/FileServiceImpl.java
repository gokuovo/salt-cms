package com.salt.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.salt.cms.bo.FileBO;
import com.salt.cms.entity.SaltImagesEntity;
import com.salt.cms.homepage.dao.SaltImagesDao;
import com.salt.cms.mapper.FileMapper;
import com.salt.cms.model.FileDO;
import com.salt.cms.module.file.*;
import com.salt.cms.service.FileService;
import com.salt.cms.module.file.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author pedro@TaleLin
 * @author Juzi@TaleLin
 * @author colorful@TaleLin
 */
@Slf4j
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, FileDO> implements FileService {

    @Autowired
    private Uploader uploader;

    /**
     * 文件上传配置信息
     */
    @Autowired
    private FileProperties fileProperties;

    @Autowired
    private SaltImagesDao saltImagesDao;

    /**
     * 为什么不做批量插入
     * 1. 文件上传的数量一般不多，3个左右
     * 2. 批量插入不能得到数据的id字段，不利于直接返回数据
     * 3. 批量插入也仅仅只是一条sql语句的事情，如果真的需要，可以自行尝试一下
     */
    @Override
    public List<FileBO> upload(MultiValueMap<String, MultipartFile> fileMap,String imageType) {
        List<FileBO> res = new ArrayList<>();

        uploader.upload(fileMap,imageType, new UploadHandler() {
            @Override
            public boolean preHandle(File file) {
                FileDO found = baseMapper.selectByMd5(file.getMd5());
                // 数据库中不存在，存储操作放在上传到本地或云上之后，
                // 修复issue131：https://github.com/TaleLin/lin-cms-spring-boot/issues/131
                if (found == null) {
                    return true;
                }
                // 已存在，则直接转化返回
                res.add(transformDoToBo(found, file.getKey()));
                return false;
            }


            @Override
            @Transactional
            public void afterHandle(File file,String imageType) {
                // 保存到数据库, 修复issue131：https://github.com/TaleLin/lin-cms-spring-boot/issues/131
                try{
                    FileDO fileDO = new FileDO();
                    BeanUtils.copyProperties(file, fileDO);
                    getBaseMapper().insert(fileDO);
                    if(!StringUtils.isEmpty(imageType)){
                        QueryWrapper<SaltImagesEntity> qw = new QueryWrapper<>();
                        qw.eq("image_code",imageType);
                        if (!ObjectUtils.isEmpty(saltImagesDao.selectList(qw))){
                            saltImagesDao.delete(qw);
                        }
                        SaltImagesEntity saltImagesEntity = new SaltImagesEntity();
                        saltImagesEntity.setId(UUID.randomUUID().toString());
                        saltImagesEntity.setImageCode(imageType);
                        saltImagesEntity.setImageUrl("localhost:5000/assets/"+file.getPath());
                        saltImagesDao.insert(saltImagesEntity);
                    }

                    res.add(transformDoToBo(fileDO, file.getKey()));
                }catch (Exception e){
                    log.info("插入图片失败");
                }

            }
        });
        return res;
    }

    @Override
    public boolean checkFileExistByMd5(String md5) {
        return this.getBaseMapper().selectCountByMd5(md5) > 0;
    }

    private FileBO transformDoToBo(FileDO file, String key) {
        FileBO bo = new FileBO();
        BeanUtils.copyProperties(file, bo);
        if (file.getType().equals(FileConstant.LOCAL)) {
            String s = fileProperties.getServePath().split("/")[0];

            // replaceAll 是将 windows 平台下的 \ 替换为 /
            if(System.getProperties().getProperty("os.name").toUpperCase().contains("WINDOWS")){
                bo.setUrl(fileProperties.getDomain() + s + "/" + file.getPath().replaceAll("\\\\","/"));
            }else {
                bo.setUrl(fileProperties.getDomain() + s + "/" + file.getPath());
            }
        } else {
            bo.setUrl(file.getPath());
        }
        bo.setKey(key);
        return bo;
    }
}
