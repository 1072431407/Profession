package cn.stylefeng.guns.modular.system.controller;

import java.io.File;
import java.net.InetAddress;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import cn.stylefeng.guns.config.properties.GunsProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.stylefeng.guns.core.common.exception.BizExceptionEnum;
import cn.stylefeng.guns.modular.system.model.UploadStatus;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;

/**
 *  图片文件上传器
 * @author Mike
 *
 */
@RestController
@RequestMapping("/utils")
public class ImageFileUploader {
	@Autowired
    private GunsProperties gunsProperties;

	private String host;
	@Value("${com.urlPort}")
	private String port;
//	private String rootPath
	
	
	@RequestMapping(method = RequestMethod.POST, path = "/upload")
    @ResponseBody
    public UploadStatus upload(@RequestPart("file") MultipartFile picture,HttpServletRequest request) {
        String pictureName = UUID.randomUUID().toString() + "." + ToolUtil.getFileSuffix(picture.getOriginalFilename());
        UploadStatus uploadStatus = new UploadStatus();
        try {
            String fileSavePath = gunsProperties.getFileUploadPath();
            host = InetAddress.getLocalHost().getHostName();
            picture.transferTo(new File(fileSavePath + pictureName));
            System.out.println("---存储的路径--"+(fileSavePath + pictureName));
            String imageUrl = (request.getScheme()+"://"+ request.getServerName() + ":" + port + "/tmp/"+pictureName).toString();
            System.out.println("--访问的路径--"+imageUrl);
            uploadStatus.setImageUrl(imageUrl);
            uploadStatus.setCode(0);
        } catch (Exception e) {
        	uploadStatus.setCode(1);
            throw new ServiceException(BizExceptionEnum.UPLOAD_ERROR);
        }
        
        return uploadStatus;
    }
}
