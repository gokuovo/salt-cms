package com.salt.cms.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @Description:文件上传下载,采用restful风格，会根据请求方式，自动执行对应的方法
 * @Author nanyi
 * @Date 2020/12/30 11:05
 **/
@Controller
public class FileUploadontroller {
    @GetMapping("/index")
    public String index(){
        System.out.println("index.......");
        return "image";
    }
    /**
     * @Description:单个文件上传
     */
    @ResponseBody
    public String upload(MultipartFile file,String imageCode) {
//        获取原始文件名
        String filename = file.getOriginalFilename();
//        获取文件后缀名
        String suffixName = filename.substring(filename.lastIndexOf("."));
//        文件保存路径
        String filePath = "D:/upload/";
//        添加UUID编码，防止文件名重复
        filename = filePath + UUID.randomUUID() + filename;
//        文件对象
        File file1 = new File(filename);
//        判断路径是否存在，如果不存在则创建
        if (!file1.getParentFile().exists()) {
            file1.getParentFile().mkdirs();
        }
        try {
//            保存到服务器中
            file.transferTo(file1);

            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    public void download(HttpServletResponse response) throws Exception {
//        文件地址，真实环境是存放在数据库中的
        File file = new File("D:\\upload\\userimage.jpg");
//        传入输出对象
        FileInputStream fileInputStream = new FileInputStream(file);
//        设置相关格式
        response.setContentType("application/force-download");
//        设置下载后的文件名以及header
        response.addHeader("Content-disposition", "attachment;fileName=" + "南一小宝宝啊.txt");
//       创建输出对象
        ServletOutputStream outputStream = response.getOutputStream();
//        常规操作
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        fileInputStream.close();
    }
}

