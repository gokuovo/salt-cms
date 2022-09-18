package com.salt.cms.file.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.salt.cms.bo.FileBO;
import com.salt.cms.contactus.dao.SaltSocialDao;
import com.salt.cms.entity.*;
import com.salt.cms.file.FileUploadHandler;
import com.salt.cms.file.FileUploader;
import com.salt.cms.file.service.SaltFileService;
import com.salt.cms.homepage.dao.SaltImagesDao;
import com.salt.cms.mapper.FileMapper;
import com.salt.cms.model.FileDO;
import com.salt.cms.module.file.*;
import com.salt.cms.news.dao.SaltNewsDao;
import com.salt.cms.news.dao.SaltWorklogDao;
import com.salt.cms.ourservice.dao.SaltVideoDao;
import com.salt.cms.partners.dao.SaltPartnersDao;
import com.salt.cms.projects.dao.SaltAlbumDao;
import com.salt.cms.projects.dao.SaltListDao;
import com.salt.cms.projects.dao.SaltMusicVideoDao;
import com.salt.cms.team.dao.SaltStaffDao;
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
public class SaltFileServiceImpl extends ServiceImpl<FileMapper, FileDO> implements SaltFileService {

    @Autowired(required = false)
    public FileUploader fileUploader;

    /**
     * 文件上传配置信息
     */
    @Autowired
    private FileProperties fileProperties;

    @Autowired
    private SaltImagesDao saltImagesDao;

    @Autowired
    private SaltPartnersDao saltPartnersDao;

    @Autowired
    private SaltSocialDao saltSocialDao;

    @Autowired
    private SaltNewsDao saltNewsDao;

    @Autowired
    private SaltWorklogDao saltWorklogDao;

    @Autowired
    private SaltStaffDao saltStaffDao;

    @Autowired
    private SaltVideoDao saltVideoDao;

    @Autowired
    private SaltAlbumDao saltAlbumDao;

    @Autowired
    private SaltListDao saltListDao;

    @Autowired
    private SaltMusicVideoDao saltMusicVideoDao;

    @Autowired
    private SaltFileService saltFileService;

    private String albumId;
    /**
     * 为什么不做批量插入
     * 1. 文件上传的数量一般不多，3个左右
     * 2. 批量插入不能得到数据的id字段，不利于直接返回数据
     * 3. 批量插入也仅仅只是一条sql语句的事情，如果真的需要，可以自行尝试一下
     */
    @Override
    public List<FileBO> upload(MultiValueMap<String, MultipartFile> fileMap,String fileType,String id) {
        List<FileBO> res = new ArrayList<>();

        fileUploader.upload(fileMap,fileType,id ,new FileUploadHandler() {
            @Override
            public boolean preHandle(File file) {
//                FileDO found = baseMapper.selectByMd5(file.getMd5());
//                // 数据库中不存在，存储操作放在上传到本地或云上之后，
//                // 修复issue131：https://github.com/TaleLin/lin-cms-spring-boot/issues/131
//                if (found == null) {
//                    return true;
//                }
                // 已存在，则直接转化返回
//                res.add(transformDoToBo(found, file.getKey()));
                QueryWrapper<FileDO> qw = new QueryWrapper<>();
                qw.eq("md5",file.getMd5());
                baseMapper.delete(qw);
                return true;
            }


            @Override
            @Transactional
            public void afterHandle(File file, String fileType, String id,String originalName) {
                // 保存到数据库, 修复issue131：https://github.com/TaleLin/lin-cms-spring-boot/issues/131
                try{
                    FileDO fileDO = new FileDO();
                    String relativeId = null;
                    BeanUtils.copyProperties(file, fileDO);
                    getBaseMapper().insert(fileDO);
                    List<String> list = new ArrayList<>();
                    list.add("12");
                    list.add("13");
                    list.add("14");
                    list.add("15");
                    //处理合作商配图
                    if ("partners".equals(fileType)){
                        if (StringUtils.isEmpty(id)){
                            SaltPartnerEntity saltPartnerEntity = new SaltPartnerEntity();
                            saltPartnerEntity.setId(UUID.randomUUID().toString());
                            saltPartnerEntity.setPartnerUrl(path(file.getPath()));
                            saltPartnersDao.insert(saltPartnerEntity);
                            relativeId = saltPartnerEntity.getId();
                        }else {
                            SaltPartnerEntity saltPartnerEntity = new SaltPartnerEntity();
                            saltPartnerEntity.setId(id);
                            saltPartnerEntity.setPartnerUrl(path(file.getPath()));
                            saltPartnersDao.updateById(saltPartnerEntity);
                        }
                    }else if ("social".equals(fileType)){//处理展示0联系图标
                        if (StringUtils.isEmpty(id)){
                            SaltSocialEntity saltSocialEntity = new SaltSocialEntity();
                            saltSocialEntity.setId(UUID.randomUUID().toString());
                            saltSocialEntity.setImageUrl(path(file.getPath()));
                            saltSocialDao.insert(saltSocialEntity);
                            relativeId = saltSocialEntity.getId();
                        }else {
                            SaltSocialEntity saltSocialEntity = new SaltSocialEntity();
                            saltSocialEntity.setId(id);
                            saltSocialEntity.setImageUrl(path(file.getPath()));
                            saltSocialDao.updateById(saltSocialEntity);
                        }
                    }else if ("news".equals(fileType)){
                        if (StringUtils.isEmpty(id)){
                            SaltNewsEntity saltNewsEntity = new SaltNewsEntity();
                            saltNewsEntity.setId(UUID.randomUUID().toString());
                            saltNewsEntity.setUrl(path(file.getPath()));
                            saltNewsDao.insert(saltNewsEntity);
                        }else{
                            SaltNewsEntity saltNewsEntity = new SaltNewsEntity();
                            saltNewsEntity.setId(id);
                            saltNewsEntity.setUrl(path(file.getPath()));
                            saltNewsDao.updateById(saltNewsEntity);
                        }
                    }else if ("worklog".equals(fileType)){
                        if (StringUtils.isEmpty(id)){
                            SaltWorklogEntity saltWorklogEntity = new SaltWorklogEntity();
                            saltWorklogEntity.setId(UUID.randomUUID().toString());
                            saltWorklogEntity.setUrl(path(file.getPath()));
                            saltWorklogDao.insert(saltWorklogEntity);
                        }else{
                            SaltWorklogEntity saltWorklogEntity = new SaltWorklogEntity();
                            saltWorklogEntity.setId(id);
                            saltWorklogEntity.setUrl(path(file.getPath()));
                            saltWorklogDao.updateById(saltWorklogEntity);
                        }
                    }else if ("staff".equals(fileType)){
                        if (StringUtils.isEmpty(id)){
                            SaltStaffEntity saltStaffEntity = new SaltStaffEntity();
                            saltStaffEntity.setId(UUID.randomUUID().toString());
                            saltStaffEntity.setStaffImage(path(file.getPath()));
                            saltStaffDao.insert(saltStaffEntity);
                        }else{
                            SaltStaffEntity saltStaffEntity = new SaltStaffEntity();
                            saltStaffEntity.setId(id);
                            saltStaffEntity.setStaffImage(path(file.getPath()));
                            saltStaffDao.updateById(saltStaffEntity);
                        }
                    }else if ("video".equals(fileType)){
                        if (StringUtils.isEmpty(id)){
                            SaltVideoEntity saltVideoEntity = new SaltVideoEntity();
                            saltVideoEntity.setId(UUID.randomUUID().toString());
                            saltVideoEntity.setVideoUrl(path(file.getPath()));
                            saltVideoDao.insert(saltVideoEntity);
                        }else{
                            SaltVideoEntity saltVideoEntity = new SaltVideoEntity();
                            saltVideoEntity.setId(id);
                            saltVideoEntity.setVideoUrl(path(file.getPath()));
                            saltVideoDao.updateById(saltVideoEntity);
                        }
                    }else if ("album".equals(fileType)){
                        if (StringUtils.isEmpty(id)){
                            SaltAlbumEntity saltAlbumEntity = new SaltAlbumEntity();
                            saltAlbumEntity.setId(UUID.randomUUID().toString());
                            saltAlbumEntity.setImgSrc(path(file.getPath()));
                            saltAlbumDao.insert(saltAlbumEntity);
                        }else{
                            SaltAlbumEntity saltAlbumEntity = new SaltAlbumEntity();
                            saltAlbumEntity.setId(id);
                            saltAlbumEntity.setImgSrc(path(file.getPath()));
                            saltAlbumDao.updateById(saltAlbumEntity);
                        }
                    }else if ("list".equals(fileType)){
                        if (StringUtils.isEmpty(id)){
                            SaltListEntity saltListEntity = new SaltListEntity();
                            saltListEntity.setId(UUID.randomUUID().toString());
                            saltListEntity.setUrl(path(file.getPath()));
                            saltListDao.insert(saltListEntity);
                        }else{
                            SaltListEntity saltListEntity = new SaltListEntity();
                            saltListEntity.setId(id);
                            saltListEntity.setUrl(path(file.getPath()));
                            saltListDao.updateById(saltListEntity);
                        }
                    }else if ("albumMusic".equals(fileType)){
                        if (StringUtils.isEmpty(id)){
                            SaltMusicVideoEntity saltMusicVideoEntity = new SaltMusicVideoEntity();
                            saltMusicVideoEntity.setId(UUID.randomUUID().toString());
                            saltMusicVideoEntity.setUrl(path(file.getPath()));
                            saltMusicVideoDao.insert(saltMusicVideoEntity);
                        }else{
                            SaltMusicVideoEntity saltMusicVideoEntity = new SaltMusicVideoEntity();
                            saltMusicVideoEntity.setId(id);
                            saltMusicVideoEntity.setUrl(path(file.getPath()));
                            saltMusicVideoDao.updateById(saltMusicVideoEntity);
                        }
                    }else if ("albumVideo".equals(fileType)){
                        if (StringUtils.isEmpty(id)){
                            SaltMusicVideoEntity saltMusicVideoEntity = new SaltMusicVideoEntity();
                            saltMusicVideoEntity.setId(UUID.randomUUID().toString());
                            saltMusicVideoEntity.setUrl(path(file.getPath()));
                            saltMusicVideoDao.insert(saltMusicVideoEntity);
                        }else{
                            SaltMusicVideoEntity saltMusicVideoEntity = new SaltMusicVideoEntity();
                            saltMusicVideoEntity.setId(id);
                            saltMusicVideoEntity.setUrl(path(file.getPath()));
                            saltMusicVideoDao.updateById(saltMusicVideoEntity);
                        }
                    }else if (list.contains(fileType)){
                        if (StringUtils.isEmpty(id)){
                            SaltImagesEntity saltImagesEntity = new SaltImagesEntity();
                            saltImagesEntity.setId(UUID.randomUUID().toString());
                            saltImagesEntity.setImageCode(fileType);
                            saltImagesEntity.setImageUrl(path(file.getPath()));
                            saltImagesDao.insert(saltImagesEntity);
                        }else{
                            SaltImagesEntity saltImagesEntity = new SaltImagesEntity();
                            saltImagesEntity.setId(id);
                            saltImagesEntity.setImageUrl(path(file.getPath()));
                            saltImagesDao.updateById(saltImagesEntity);
                        }
                    }else if ("newslink".equals(fileType)){
                        if (StringUtils.isEmpty(id)){
                            SaltImagesEntity saltImagesEntity = new SaltImagesEntity();
                            saltImagesEntity.setId(UUID.randomUUID().toString());
                            saltImagesEntity.setImageCode(fileType);
                            saltImagesEntity.setImageUrl(path(file.getPath()));
                            saltImagesDao.insert(saltImagesEntity);
                        }else{
                            SaltImagesEntity saltImagesEntity = new SaltImagesEntity();
                            saltImagesEntity.setId(id);
                            saltImagesEntity.setImageUrl(path(file.getPath()));
                            saltImagesDao.updateById(saltImagesEntity);
                        }
                    } else if (fileType.startsWith("musics")){
                        SaltMusicVideoEntity saltMusicVideoEntity = new SaltMusicVideoEntity();
                        saltMusicVideoEntity.setId(UUID.randomUUID().toString());
                        saltMusicVideoEntity.setTitle(originalName);
                        saltMusicVideoEntity.setUrl(path(file.getPath()));
                        saltMusicVideoEntity.setAlbum(albumId);
                        saltMusicVideoEntity.setType("0");
                        saltFileService.insertMusic(saltMusicVideoEntity);
                    }

                    res.add(transformDoToBo(fileDO, file.getKey(),relativeId));
                    log.info("上传成功");
                }catch (Exception e){
                    log.info("插入图片失败");
                }

            }
        });
        return res;
    }

    @Override
    @Transactional
    public void insertMusic(SaltMusicVideoEntity saltMusicVideoEntity ){
        Integer nums = saltMusicVideoDao.insert(saltMusicVideoEntity);
        System.out.println(nums);
    }

    @Override
    public boolean checkFileExistByMd5(String md5) {
        return this.getBaseMapper().selectCountByMd5(md5) > 0;
    }

    @Override
    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    private FileBO transformDoToBo(FileDO file, String key,String relativeId) {
        FileBO bo = new FileBO();
        BeanUtils.copyProperties(file, bo);
        bo.setRelativeId(relativeId);
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
    private String path(String filePath){
        return "http://101.43.132.47:5000/assets/"+filePath;
    }
}
