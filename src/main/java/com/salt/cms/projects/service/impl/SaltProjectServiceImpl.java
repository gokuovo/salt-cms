package com.salt.cms.projects.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.salt.cms.entity.SaltAlbumEntity;
import com.salt.cms.entity.SaltImagesEntity;
import com.salt.cms.entity.SaltListEntity;
import com.salt.cms.entity.SaltMusicVideoEntity;
import com.salt.cms.projects.dao.SaltAlbumDao;
import com.salt.cms.projects.dao.SaltListDao;
import com.salt.cms.projects.dao.SaltMusicVideoDao;
import com.salt.cms.projects.form.SaltListForm;
import com.salt.cms.projects.form.SaltMusicVideoForm;
import com.salt.cms.projects.service.SaltProjectService;
import com.salt.cms.utils.R;
import com.salt.cms.vo.CreatedVO;
import com.salt.cms.vo.DeletedVO;
import com.salt.cms.vo.UpdatedVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Slf4j
@Service
public class SaltProjectServiceImpl implements SaltProjectService {

    @Autowired
    private SaltMusicVideoDao saltMusicVideoDao;

    @Autowired
    private SaltAlbumDao saltAlbumDao;

    @Autowired
    private SaltListDao saltListDao;

    @Override
    public List<SaltMusicVideoEntity> getProject(String album) {
        QueryWrapper<SaltMusicVideoEntity> qw = new QueryWrapper<>();
        qw.eq("album",album);
        List<SaltMusicVideoEntity> list = saltMusicVideoDao.selectList(qw);
        return list;
    }

    @Override
    public List<SaltMusicVideoEntity> getProjectByType(String type) {
        QueryWrapper<SaltMusicVideoEntity> qw = new QueryWrapper<>();
        qw.eq("type",type);
        List<SaltMusicVideoEntity> list = saltMusicVideoDao.selectList(qw);
        List<SaltMusicVideoEntity> saltMusicVideoList = new ArrayList<>();
        for (SaltMusicVideoEntity saltMusicVideoEntity:list){
            if (!ObjectUtils.isEmpty(saltMusicVideoEntity.getAlbum())){
                QueryWrapper<SaltAlbumEntity> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("id",saltMusicVideoEntity.getAlbum());
                log.info(saltMusicVideoEntity.getAlbum());
                System.out.println(saltMusicVideoEntity.getAlbum());
                SaltAlbumEntity saltAlbumEntity = saltAlbumDao.selectOne(queryWrapper);
                saltMusicVideoEntity.setAlbum(saltAlbumEntity.getTitleEn());
                saltMusicVideoList.add(saltMusicVideoEntity);
            }
        }
        return saltMusicVideoList;
    }

    @Override
    public List<SaltAlbumEntity> getAlbum() {
        List<SaltAlbumEntity> albumEntities = saltAlbumDao.getAlbum();
        List<SaltAlbumEntity> albumEntityList = new ArrayList<>();
        for (SaltAlbumEntity albumEntity : albumEntities){
            if ("0".equals(albumEntity.getType())){
                albumEntity.setType("音乐专辑");
            }else if ("1".equals(albumEntity.getType())){
                albumEntity.setType("视频专辑");
            }
            albumEntityList.add(albumEntity);
        }
        return albumEntityList;
    }

    @Override
    public SaltAlbumEntity getAlbumOne(String id) {
        SaltAlbumEntity saltAlbumEntity = saltAlbumDao.selectById(id);
        if ("0".equals(saltAlbumEntity.getType())){
            saltAlbumEntity.setType("音乐专辑");
        }else if ("1".equals(saltAlbumEntity.getType())){
            saltAlbumEntity.setType("视频专辑");
        }
        return saltAlbumEntity;
    }

    @Override
    public SaltAlbumEntity addAlbum(SaltAlbumEntity saltAlbumEntity) {
        SaltAlbumEntity saltAlbum = new SaltAlbumEntity();
        BeanUtils.copyProperties(saltAlbumEntity,saltAlbum);
        saltAlbum.setId(UUID.randomUUID().toString());
        saltAlbumDao.insert(saltAlbum);
        return saltAlbum;
    }

    @Override
    public UpdatedVO modifyAlbum(SaltAlbumEntity saltAlbumEntity) {
        SaltAlbumEntity saltAlbum = new SaltAlbumEntity();
        BeanUtils.copyProperties(saltAlbumEntity,saltAlbum);
        saltAlbumDao.updateById(saltAlbum);
        return new UpdatedVO("更新成功");
    }

    @Override
    public DeletedVO deleteAlbum(String id) {
        saltAlbumDao.deleteById(id);
        return new DeletedVO("删除成功");
    }

    @Override
    public List<SaltListEntity> getList() {
        return saltAlbumDao.getList();
    }

    @Override
    public SaltListEntity getListOne(String id) {
        return saltListDao.selectById(id);
    }

    @Override
    public R addFile(SaltMusicVideoForm saltMusicVideoForm) {
        SaltMusicVideoEntity saltMusicVideoEntity = new SaltMusicVideoEntity();
        BeanUtils.copyProperties(saltMusicVideoForm,saltMusicVideoEntity);
        saltMusicVideoEntity.setId(UUID.randomUUID().toString());
        saltMusicVideoDao.insert(saltMusicVideoEntity);
        return R.ok("成功");
    }

    @Override
    public R modifyFile(SaltMusicVideoForm saltMusicVideoForm) {
        SaltMusicVideoEntity saltMusicVideoEntity = new SaltMusicVideoEntity();
        BeanUtils.copyProperties(saltMusicVideoForm,saltMusicVideoEntity);
        saltMusicVideoDao.updateById(saltMusicVideoEntity);
        return R.ok("成功");
    }

    @Override
    public R deleteFile(String id) {
        saltMusicVideoDao.deleteById(id);
        return R.ok("成功");
    }

    @Override
    public SaltListEntity addList(SaltListForm saltListForm) {
        SaltListEntity saltListEntity = new SaltListEntity();
        BeanUtils.copyProperties(saltListForm,saltListEntity);
        saltListEntity.setId(UUID.randomUUID().toString());
        saltListDao.insert(saltListEntity);
        return saltListEntity;
    }

    @Override
    public UpdatedVO modifyList(SaltListForm saltListForm) {
        SaltListEntity saltListEntity = new SaltListEntity();
        BeanUtils.copyProperties(saltListForm,saltListEntity);
        saltListDao.updateById(saltListEntity);
        return new UpdatedVO("成功");
    }

    @Override
    public DeletedVO deleteList(String id) {
        saltListDao.deleteById(id);
        return new DeletedVO("成功");
    }

    @Override
    public SaltMusicVideoEntity getMusicOne(String id) {
        return saltMusicVideoDao.selectById(id);
    }

    @Override
    public DeletedVO deleteMusic(String id) {
        saltMusicVideoDao.deleteById(id);
        return new DeletedVO("删除完成");
    }

    @Override
    public SaltMusicVideoEntity addMusic(SaltMusicVideoEntity saltMusicVideoEntity) {
        saltMusicVideoEntity.setId(UUID.randomUUID().toString());
        saltMusicVideoEntity.setType("0");
        saltMusicVideoDao.insert(saltMusicVideoEntity);
        return saltMusicVideoEntity;
    }

    @Override
    public UpdatedVO modifyMusic(SaltMusicVideoEntity saltMusicVideoEntity) {
        saltMusicVideoDao.updateById(saltMusicVideoEntity);
        return new UpdatedVO("更新完成");
    }

    @Override
    public DeletedVO deleteVideo(String id) {
        saltMusicVideoDao.deleteById(id);
        return new DeletedVO("删除完成");
    }

    @Override
    public SaltMusicVideoEntity addVideo(SaltMusicVideoEntity saltMusicVideoEntity) {
        saltMusicVideoEntity.setId(UUID.randomUUID().toString());
        saltMusicVideoEntity.setType("1");
        saltMusicVideoDao.insert(saltMusicVideoEntity);
        return saltMusicVideoEntity;
    }

    @Override
    public UpdatedVO modifyVideo(SaltMusicVideoEntity saltMusicVideoEntity) {
        saltMusicVideoDao.updateById(saltMusicVideoEntity);
        return new UpdatedVO("更新完成");
    }

    @Override
    public List<Map<String, String>> getAlbumVideoList() {
        QueryWrapper<SaltAlbumEntity> qw = new QueryWrapper<>();
        qw.eq("type","1");
        List<SaltAlbumEntity> saltAlbumEntity = saltAlbumDao.selectList(qw);

        List<Map<String, String>> list = new ArrayList<>();
        for (SaltAlbumEntity saltAlbumEntity1 : saltAlbumEntity){
            Map<String, String> map = new HashMap<>();
            map.put("value",saltAlbumEntity1.getId());
            map.put("label",saltAlbumEntity1.getTitleEn());
            list.add(map);
        }
        return list;
    }

    @Override
    public List<Map<String, String>> getAlbumMusicList() {
        QueryWrapper<SaltAlbumEntity> qw = new QueryWrapper<>();
        qw.eq("type","0");
        List<SaltAlbumEntity> saltAlbumEntity = saltAlbumDao.selectList(qw);

        List<Map<String, String>> list = new ArrayList<>();
        for (SaltAlbumEntity saltAlbumEntity1 : saltAlbumEntity){
            Map<String, String> map = new HashMap<>();
            map.put("value",saltAlbumEntity1.getId());
            map.put("label",saltAlbumEntity1.getTitleEn());
            list.add(map);
        }
        return list;
    }

    @Override
    public List<SaltMusicVideoEntity> getMusicByType(String type) {
        if (StringUtils.isEmpty(type)){
            return saltMusicVideoDao.getMusicList();
        }else{
            QueryWrapper<SaltMusicVideoEntity> qw = new QueryWrapper<>();
            qw.eq("album",type);
            return saltMusicVideoDao.selectList(qw);
        }
    }
}
